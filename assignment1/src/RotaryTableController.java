import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class RotaryTableController extends ClockDomain{
  public RotaryTableController(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal bottleToTable = new Signal("bottleToTable", Signal.INPUT);
  public Signal tableAligned = new Signal("tableAligned", Signal.INPUT);
  public Signal bottleAtPos1 = new Signal("bottleAtPos1", Signal.INPUT);
  public Signal bottleAtPos2 = new Signal("bottleAtPos2", Signal.INPUT);
  public Signal bottleAtPos4 = new Signal("bottleAtPos4", Signal.INPUT);
  public Signal bottleAtPos6 = new Signal("bottleAtPos6", Signal.INPUT);
  public Signal fillerDone1 = new Signal("fillerDone1", Signal.INPUT);
  public Signal fillerDone2 = new Signal("fillerDone2", Signal.INPUT);
  public Signal lidDone = new Signal("lidDone", Signal.INPUT);
  public Signal capperDone = new Signal("capperDone", Signal.INPUT);
  public Signal tableReady = new Signal("tableReady", Signal.OUTPUT);
  public Signal bottleFromTable = new Signal("bottleFromTable", Signal.OUTPUT);
  public Signal bottleTaken = new Signal("bottleTaken", Signal.OUTPUT);
  public Signal rotaryTrigger = new Signal("rotaryTrigger", Signal.OUTPUT);
  public Signal loadPos1 = new Signal("loadPos1", Signal.OUTPUT);
  public Signal unloadExit = new Signal("unloadExit", Signal.OUTPUT);
  public Signal enableFiller1 = new Signal("enableFiller1", Signal.OUTPUT);
  public Signal enableFiller2 = new Signal("enableFiller2", Signal.OUTPUT);
  public Signal enableLid = new Signal("enableLid", Signal.OUTPUT);
  public Signal enableCapper = new Signal("enableCapper", Signal.OUTPUT);
  private TableModel m_thread_1;//sysj\turntableController.sysj line: 35, column: 2
  private int OFFERWIN_thread_1;//sysj\turntableController.sysj line: 36, column: 2
  private int w_thread_1;//sysj\turntableController.sysj line: 37, column: 2
  private boolean got_thread_1;//sysj\turntableController.sysj line: 38, column: 2
  private boolean d1_thread_1;//sysj\turntableController.sysj line: 39, column: 2
  private boolean d2_thread_1;//sysj\turntableController.sysj line: 40, column: 2
  private boolean d3_thread_1;//sysj\turntableController.sysj line: 41, column: 2
  private boolean d4_thread_1;//sysj\turntableController.sysj line: 42, column: 2
  private int S56398 = 1;
  private int S4709 = 1;
  private int S4703 = 1;
  private int S4742 = 1;
  private int S4717 = 1;
  private int S4846 = 1;
  
  private int[] ends = new int[2];
  private int[] tdone = new int[2];
  
  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S56398){
        case 0 : 
          S56398=0;
          break RUN;
        
        case 1 : 
          S56398=2;
          S56398=2;
          m_thread_1 = new TableModel();//sysj\turntableController.sysj line: 35, column: 2
          OFFERWIN_thread_1 = 6;//sysj\turntableController.sysj line: 36, column: 2
          w_thread_1 = 0;//sysj\turntableController.sysj line: 37, column: 2
          got_thread_1 = false;//sysj\turntableController.sysj line: 38, column: 2
          d1_thread_1 = false;//sysj\turntableController.sysj line: 39, column: 2
          d2_thread_1 = false;//sysj\turntableController.sysj line: 40, column: 2
          d3_thread_1 = false;//sysj\turntableController.sysj line: 41, column: 2
          d4_thread_1 = false;//sysj\turntableController.sysj line: 42, column: 2
          S4709=0;
          if(tableAligned.getprestatus()){//sysj\turntableController.sysj line: 46, column: 19
            S4709=1;
            if(m_thread_1.exitOccupied()){//sysj\turntableController.sysj line: 49, column: 3
              m_thread_1.sayUnloading();//sysj\turntableController.sysj line: 50, column: 4
              unloadExit.setPresent();//sysj\turntableController.sysj line: 51, column: 4
              currsigs.addElement(unloadExit);
              bottleFromTable.setPresent();//sysj\turntableController.sysj line: 51, column: 21
              currsigs.addElement(bottleFromTable);
              S4703=0;
              active[1]=1;
              ends[1]=1;
              break RUN;
            }
            else {
              got_thread_1 = false;//sysj\turntableController.sysj line: 57, column: 3
              S4709=2;
              if(m_thread_1.loadPointFree()){//sysj\turntableController.sysj line: 58, column: 3
                if(!m_thread_1.anyOccupied()){//sysj\turntableController.sysj line: 59, column: 7
                  S4742=0;
                  tableReady.setPresent();//sysj\turntableController.sysj line: 62, column: 6
                  currsigs.addElement(tableReady);
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
                else {
                  S4742=1;
                  w_thread_1 = OFFERWIN_thread_1;//sysj\turntableController.sysj line: 69, column: 5
                  if(w_thread_1 > 0){//sysj\turntableController.sysj line: 70, column: 11
                    tableReady.setPresent();//sysj\turntableController.sysj line: 71, column: 6
                    currsigs.addElement(tableReady);
                    S4717=0;
                    if(bottleToTable.getprestatus()){//sysj\turntableController.sysj line: 72, column: 14
                      got_thread_1 = true;//sysj\turntableController.sysj line: 72, column: 30
                      if(got_thread_1) {//sysj\turntableController.sysj line: 73, column: 13
                        w_thread_1 = 0;//sysj\turntableController.sysj line: 73, column: 15
                      }
                      else {//sysj\turntableController.sysj line: 73, column: 29
                        w_thread_1 = w_thread_1 - 1;//sysj\turntableController.sysj line: 73, column: 31
                      }
                      S4717=1;
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                    else {
                      if(got_thread_1) {//sysj\turntableController.sysj line: 73, column: 13
                        w_thread_1 = 0;//sysj\turntableController.sysj line: 73, column: 15
                      }
                      else {//sysj\turntableController.sysj line: 73, column: 29
                        w_thread_1 = w_thread_1 - 1;//sysj\turntableController.sysj line: 73, column: 31
                      }
                      S4717=1;
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                  }
                  else {
                    ends[1]=2;
                    ;//sysj\turntableController.sysj line: 70, column: 5
                    S4709=3;
                    if(got_thread_1){//sysj\turntableController.sysj line: 79, column: 3
                      loadPos1.setPresent();//sysj\turntableController.sysj line: 80, column: 4
                      currsigs.addElement(loadPos1);
                      bottleTaken.setPresent();//sysj\turntableController.sysj line: 80, column: 19
                      currsigs.addElement(bottleTaken);
                      S4846=0;
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                    else {
                      d1_thread_1 = !m_thread_1.at(1);//sysj\turntableController.sysj line: 87, column: 3
                      d2_thread_1 = !m_thread_1.at(2);//sysj\turntableController.sysj line: 88, column: 3
                      d3_thread_1 = !m_thread_1.at(3);//sysj\turntableController.sysj line: 89, column: 3
                      d4_thread_1 = !m_thread_1.at(4);//sysj\turntableController.sysj line: 90, column: 3
                      S4709=4;
                      if(!(d1_thread_1 && d2_thread_1 && d3_thread_1 && d4_thread_1)){//sysj\turntableController.sysj line: 92, column: 9
                        if(!d1_thread_1){//sysj\turntableController.sysj line: 93, column: 7
                          enableFiller1.setPresent();//sysj\turntableController.sysj line: 94, column: 5
                          currsigs.addElement(enableFiller1);
                          if(fillerDone1.getprestatus()){//sysj\turntableController.sysj line: 95, column: 13
                            d1_thread_1 = true;//sysj\turntableController.sysj line: 95, column: 27
                            if(!d2_thread_1){//sysj\turntableController.sysj line: 97, column: 7
                              enableFiller2.setPresent();//sysj\turntableController.sysj line: 98, column: 5
                              currsigs.addElement(enableFiller2);
                              if(fillerDone2.getprestatus()){//sysj\turntableController.sysj line: 99, column: 13
                                d2_thread_1 = true;//sysj\turntableController.sysj line: 99, column: 27
                                if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                  enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                  currsigs.addElement(enableLid);
                                  if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                    d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                }
                                else {
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                              }
                              else {
                                if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                  enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                  currsigs.addElement(enableLid);
                                  if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                    d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                }
                                else {
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                              }
                            }
                            else {
                              if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                currsigs.addElement(enableLid);
                                if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                  d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                              }
                              else {
                                if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                  enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                  currsigs.addElement(enableCapper);
                                  if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                    d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                            }
                          }
                          else {
                            if(!d2_thread_1){//sysj\turntableController.sysj line: 97, column: 7
                              enableFiller2.setPresent();//sysj\turntableController.sysj line: 98, column: 5
                              currsigs.addElement(enableFiller2);
                              if(fillerDone2.getprestatus()){//sysj\turntableController.sysj line: 99, column: 13
                                d2_thread_1 = true;//sysj\turntableController.sysj line: 99, column: 27
                                if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                  enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                  currsigs.addElement(enableLid);
                                  if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                    d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                }
                                else {
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                              }
                              else {
                                if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                  enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                  currsigs.addElement(enableLid);
                                  if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                    d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                }
                                else {
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                              }
                            }
                            else {
                              if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                currsigs.addElement(enableLid);
                                if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                  d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                              }
                              else {
                                if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                  enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                  currsigs.addElement(enableCapper);
                                  if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                    d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                            }
                          }
                        }
                        else {
                          if(!d2_thread_1){//sysj\turntableController.sysj line: 97, column: 7
                            enableFiller2.setPresent();//sysj\turntableController.sysj line: 98, column: 5
                            currsigs.addElement(enableFiller2);
                            if(fillerDone2.getprestatus()){//sysj\turntableController.sysj line: 99, column: 13
                              d2_thread_1 = true;//sysj\turntableController.sysj line: 99, column: 27
                              if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                currsigs.addElement(enableLid);
                                if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                  d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                              }
                              else {
                                if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                  enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                  currsigs.addElement(enableCapper);
                                  if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                    d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                            }
                            else {
                              if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                currsigs.addElement(enableLid);
                                if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                  d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                              }
                              else {
                                if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                  enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                  currsigs.addElement(enableCapper);
                                  if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                    d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                            }
                          }
                          else {
                            if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                              enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                              currsigs.addElement(enableLid);
                              if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                  enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                  currsigs.addElement(enableCapper);
                                  if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                    d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                              else {
                                if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                  enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                  currsigs.addElement(enableCapper);
                                  if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                    d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                            }
                            else {
                              if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                currsigs.addElement(enableCapper);
                                if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                  d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                          }
                        }
                      }
                      else {
                        ends[1]=2;
                        ;//sysj\turntableController.sysj line: 92, column: 3
                        rotaryTrigger.setPresent();//sysj\turntableController.sysj line: 113, column: 3
                        currsigs.addElement(rotaryTrigger);
                        S4709=5;
                        active[1]=1;
                        ends[1]=1;
                        break RUN;
                      }
                    }
                  }
                }
              }
              else {
                S4709=3;
                if(got_thread_1){//sysj\turntableController.sysj line: 79, column: 3
                  loadPos1.setPresent();//sysj\turntableController.sysj line: 80, column: 4
                  currsigs.addElement(loadPos1);
                  bottleTaken.setPresent();//sysj\turntableController.sysj line: 80, column: 19
                  currsigs.addElement(bottleTaken);
                  S4846=0;
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
                else {
                  d1_thread_1 = !m_thread_1.at(1);//sysj\turntableController.sysj line: 87, column: 3
                  d2_thread_1 = !m_thread_1.at(2);//sysj\turntableController.sysj line: 88, column: 3
                  d3_thread_1 = !m_thread_1.at(3);//sysj\turntableController.sysj line: 89, column: 3
                  d4_thread_1 = !m_thread_1.at(4);//sysj\turntableController.sysj line: 90, column: 3
                  S4709=4;
                  if(!(d1_thread_1 && d2_thread_1 && d3_thread_1 && d4_thread_1)){//sysj\turntableController.sysj line: 92, column: 9
                    if(!d1_thread_1){//sysj\turntableController.sysj line: 93, column: 7
                      enableFiller1.setPresent();//sysj\turntableController.sysj line: 94, column: 5
                      currsigs.addElement(enableFiller1);
                      if(fillerDone1.getprestatus()){//sysj\turntableController.sysj line: 95, column: 13
                        d1_thread_1 = true;//sysj\turntableController.sysj line: 95, column: 27
                        if(!d2_thread_1){//sysj\turntableController.sysj line: 97, column: 7
                          enableFiller2.setPresent();//sysj\turntableController.sysj line: 98, column: 5
                          currsigs.addElement(enableFiller2);
                          if(fillerDone2.getprestatus()){//sysj\turntableController.sysj line: 99, column: 13
                            d2_thread_1 = true;//sysj\turntableController.sysj line: 99, column: 27
                            if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                              enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                              currsigs.addElement(enableLid);
                              if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                  enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                  currsigs.addElement(enableCapper);
                                  if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                    d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                              else {
                                if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                  enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                  currsigs.addElement(enableCapper);
                                  if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                    d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                            }
                            else {
                              if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                currsigs.addElement(enableCapper);
                                if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                  d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                          }
                          else {
                            if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                              enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                              currsigs.addElement(enableLid);
                              if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                  enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                  currsigs.addElement(enableCapper);
                                  if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                    d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                              else {
                                if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                  enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                  currsigs.addElement(enableCapper);
                                  if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                    d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                            }
                            else {
                              if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                currsigs.addElement(enableCapper);
                                if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                  d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                          }
                        }
                        else {
                          if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                            enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                            currsigs.addElement(enableLid);
                            if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                              d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                              if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                currsigs.addElement(enableCapper);
                                if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                  d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                currsigs.addElement(enableCapper);
                                if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                  d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                          }
                          else {
                            if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                              enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                              currsigs.addElement(enableCapper);
                              if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              active[1]=1;
                              ends[1]=1;
                              break RUN;
                            }
                          }
                        }
                      }
                      else {
                        if(!d2_thread_1){//sysj\turntableController.sysj line: 97, column: 7
                          enableFiller2.setPresent();//sysj\turntableController.sysj line: 98, column: 5
                          currsigs.addElement(enableFiller2);
                          if(fillerDone2.getprestatus()){//sysj\turntableController.sysj line: 99, column: 13
                            d2_thread_1 = true;//sysj\turntableController.sysj line: 99, column: 27
                            if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                              enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                              currsigs.addElement(enableLid);
                              if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                  enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                  currsigs.addElement(enableCapper);
                                  if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                    d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                              else {
                                if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                  enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                  currsigs.addElement(enableCapper);
                                  if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                    d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                            }
                            else {
                              if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                currsigs.addElement(enableCapper);
                                if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                  d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                          }
                          else {
                            if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                              enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                              currsigs.addElement(enableLid);
                              if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                  enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                  currsigs.addElement(enableCapper);
                                  if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                    d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                              else {
                                if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                  enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                  currsigs.addElement(enableCapper);
                                  if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                    d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                            }
                            else {
                              if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                currsigs.addElement(enableCapper);
                                if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                  d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                          }
                        }
                        else {
                          if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                            enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                            currsigs.addElement(enableLid);
                            if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                              d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                              if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                currsigs.addElement(enableCapper);
                                if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                  d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                currsigs.addElement(enableCapper);
                                if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                  d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                          }
                          else {
                            if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                              enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                              currsigs.addElement(enableCapper);
                              if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              active[1]=1;
                              ends[1]=1;
                              break RUN;
                            }
                          }
                        }
                      }
                    }
                    else {
                      if(!d2_thread_1){//sysj\turntableController.sysj line: 97, column: 7
                        enableFiller2.setPresent();//sysj\turntableController.sysj line: 98, column: 5
                        currsigs.addElement(enableFiller2);
                        if(fillerDone2.getprestatus()){//sysj\turntableController.sysj line: 99, column: 13
                          d2_thread_1 = true;//sysj\turntableController.sysj line: 99, column: 27
                          if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                            enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                            currsigs.addElement(enableLid);
                            if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                              d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                              if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                currsigs.addElement(enableCapper);
                                if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                  d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                currsigs.addElement(enableCapper);
                                if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                  d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                          }
                          else {
                            if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                              enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                              currsigs.addElement(enableCapper);
                              if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              active[1]=1;
                              ends[1]=1;
                              break RUN;
                            }
                          }
                        }
                        else {
                          if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                            enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                            currsigs.addElement(enableLid);
                            if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                              d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                              if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                currsigs.addElement(enableCapper);
                                if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                  d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                currsigs.addElement(enableCapper);
                                if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                  d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                          }
                          else {
                            if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                              enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                              currsigs.addElement(enableCapper);
                              if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              active[1]=1;
                              ends[1]=1;
                              break RUN;
                            }
                          }
                        }
                      }
                      else {
                        if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                          enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                          currsigs.addElement(enableLid);
                          if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                            d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                            if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                              enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                              currsigs.addElement(enableCapper);
                              if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              active[1]=1;
                              ends[1]=1;
                              break RUN;
                            }
                          }
                          else {
                            if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                              enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                              currsigs.addElement(enableCapper);
                              if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              active[1]=1;
                              ends[1]=1;
                              break RUN;
                            }
                          }
                        }
                        else {
                          if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                            enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                            currsigs.addElement(enableCapper);
                            if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                              d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                              active[1]=1;
                              ends[1]=1;
                              break RUN;
                            }
                            else {
                              active[1]=1;
                              ends[1]=1;
                              break RUN;
                            }
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                  }
                  else {
                    ends[1]=2;
                    ;//sysj\turntableController.sysj line: 92, column: 3
                    rotaryTrigger.setPresent();//sysj\turntableController.sysj line: 113, column: 3
                    currsigs.addElement(rotaryTrigger);
                    S4709=5;
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                }
              }
            }
          }
          else {
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          switch(S4709){
            case 0 : 
              if(tableAligned.getprestatus()){//sysj\turntableController.sysj line: 46, column: 19
                S4709=1;
                if(m_thread_1.exitOccupied()){//sysj\turntableController.sysj line: 49, column: 3
                  m_thread_1.sayUnloading();//sysj\turntableController.sysj line: 50, column: 4
                  unloadExit.setPresent();//sysj\turntableController.sysj line: 51, column: 4
                  currsigs.addElement(unloadExit);
                  bottleFromTable.setPresent();//sysj\turntableController.sysj line: 51, column: 21
                  currsigs.addElement(bottleFromTable);
                  S4703=0;
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
                else {
                  got_thread_1 = false;//sysj\turntableController.sysj line: 57, column: 3
                  S4709=2;
                  if(m_thread_1.loadPointFree()){//sysj\turntableController.sysj line: 58, column: 3
                    if(!m_thread_1.anyOccupied()){//sysj\turntableController.sysj line: 59, column: 7
                      S4742=0;
                      tableReady.setPresent();//sysj\turntableController.sysj line: 62, column: 6
                      currsigs.addElement(tableReady);
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                    else {
                      S4742=1;
                      w_thread_1 = OFFERWIN_thread_1;//sysj\turntableController.sysj line: 69, column: 5
                      if(w_thread_1 > 0){//sysj\turntableController.sysj line: 70, column: 11
                        tableReady.setPresent();//sysj\turntableController.sysj line: 71, column: 6
                        currsigs.addElement(tableReady);
                        S4717=0;
                        if(bottleToTable.getprestatus()){//sysj\turntableController.sysj line: 72, column: 14
                          got_thread_1 = true;//sysj\turntableController.sysj line: 72, column: 30
                          if(got_thread_1) {//sysj\turntableController.sysj line: 73, column: 13
                            w_thread_1 = 0;//sysj\turntableController.sysj line: 73, column: 15
                          }
                          else {//sysj\turntableController.sysj line: 73, column: 29
                            w_thread_1 = w_thread_1 - 1;//sysj\turntableController.sysj line: 73, column: 31
                          }
                          S4717=1;
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          if(got_thread_1) {//sysj\turntableController.sysj line: 73, column: 13
                            w_thread_1 = 0;//sysj\turntableController.sysj line: 73, column: 15
                          }
                          else {//sysj\turntableController.sysj line: 73, column: 29
                            w_thread_1 = w_thread_1 - 1;//sysj\turntableController.sysj line: 73, column: 31
                          }
                          S4717=1;
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        ends[1]=2;
                        ;//sysj\turntableController.sysj line: 70, column: 5
                        S4709=3;
                        if(got_thread_1){//sysj\turntableController.sysj line: 79, column: 3
                          loadPos1.setPresent();//sysj\turntableController.sysj line: 80, column: 4
                          currsigs.addElement(loadPos1);
                          bottleTaken.setPresent();//sysj\turntableController.sysj line: 80, column: 19
                          currsigs.addElement(bottleTaken);
                          S4846=0;
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          d1_thread_1 = !m_thread_1.at(1);//sysj\turntableController.sysj line: 87, column: 3
                          d2_thread_1 = !m_thread_1.at(2);//sysj\turntableController.sysj line: 88, column: 3
                          d3_thread_1 = !m_thread_1.at(3);//sysj\turntableController.sysj line: 89, column: 3
                          d4_thread_1 = !m_thread_1.at(4);//sysj\turntableController.sysj line: 90, column: 3
                          S4709=4;
                          if(!(d1_thread_1 && d2_thread_1 && d3_thread_1 && d4_thread_1)){//sysj\turntableController.sysj line: 92, column: 9
                            if(!d1_thread_1){//sysj\turntableController.sysj line: 93, column: 7
                              enableFiller1.setPresent();//sysj\turntableController.sysj line: 94, column: 5
                              currsigs.addElement(enableFiller1);
                              if(fillerDone1.getprestatus()){//sysj\turntableController.sysj line: 95, column: 13
                                d1_thread_1 = true;//sysj\turntableController.sysj line: 95, column: 27
                                if(!d2_thread_1){//sysj\turntableController.sysj line: 97, column: 7
                                  enableFiller2.setPresent();//sysj\turntableController.sysj line: 98, column: 5
                                  currsigs.addElement(enableFiller2);
                                  if(fillerDone2.getprestatus()){//sysj\turntableController.sysj line: 99, column: 13
                                    d2_thread_1 = true;//sysj\turntableController.sysj line: 99, column: 27
                                    if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                      enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                      currsigs.addElement(enableLid);
                                      if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                        d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                          currsigs.addElement(enableCapper);
                                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                          currsigs.addElement(enableCapper);
                                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                    }
                                    else {
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                  }
                                  else {
                                    if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                      enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                      currsigs.addElement(enableLid);
                                      if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                        d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                          currsigs.addElement(enableCapper);
                                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                          currsigs.addElement(enableCapper);
                                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                    }
                                    else {
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                  }
                                }
                                else {
                                  if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                    enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                    currsigs.addElement(enableLid);
                                    if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                      d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                  }
                                  else {
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                }
                              }
                              else {
                                if(!d2_thread_1){//sysj\turntableController.sysj line: 97, column: 7
                                  enableFiller2.setPresent();//sysj\turntableController.sysj line: 98, column: 5
                                  currsigs.addElement(enableFiller2);
                                  if(fillerDone2.getprestatus()){//sysj\turntableController.sysj line: 99, column: 13
                                    d2_thread_1 = true;//sysj\turntableController.sysj line: 99, column: 27
                                    if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                      enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                      currsigs.addElement(enableLid);
                                      if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                        d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                          currsigs.addElement(enableCapper);
                                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                          currsigs.addElement(enableCapper);
                                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                    }
                                    else {
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                  }
                                  else {
                                    if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                      enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                      currsigs.addElement(enableLid);
                                      if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                        d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                          currsigs.addElement(enableCapper);
                                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                          currsigs.addElement(enableCapper);
                                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                    }
                                    else {
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                  }
                                }
                                else {
                                  if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                    enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                    currsigs.addElement(enableLid);
                                    if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                      d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                  }
                                  else {
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                }
                              }
                            }
                            else {
                              if(!d2_thread_1){//sysj\turntableController.sysj line: 97, column: 7
                                enableFiller2.setPresent();//sysj\turntableController.sysj line: 98, column: 5
                                currsigs.addElement(enableFiller2);
                                if(fillerDone2.getprestatus()){//sysj\turntableController.sysj line: 99, column: 13
                                  d2_thread_1 = true;//sysj\turntableController.sysj line: 99, column: 27
                                  if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                    enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                    currsigs.addElement(enableLid);
                                    if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                      d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                  }
                                  else {
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                }
                                else {
                                  if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                    enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                    currsigs.addElement(enableLid);
                                    if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                      d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                  }
                                  else {
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                }
                              }
                              else {
                                if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                  enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                  currsigs.addElement(enableLid);
                                  if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                    d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                }
                                else {
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                              }
                            }
                          }
                          else {
                            ends[1]=2;
                            ;//sysj\turntableController.sysj line: 92, column: 3
                            rotaryTrigger.setPresent();//sysj\turntableController.sysj line: 113, column: 3
                            currsigs.addElement(rotaryTrigger);
                            S4709=5;
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                  }
                  else {
                    S4709=3;
                    if(got_thread_1){//sysj\turntableController.sysj line: 79, column: 3
                      loadPos1.setPresent();//sysj\turntableController.sysj line: 80, column: 4
                      currsigs.addElement(loadPos1);
                      bottleTaken.setPresent();//sysj\turntableController.sysj line: 80, column: 19
                      currsigs.addElement(bottleTaken);
                      S4846=0;
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                    else {
                      d1_thread_1 = !m_thread_1.at(1);//sysj\turntableController.sysj line: 87, column: 3
                      d2_thread_1 = !m_thread_1.at(2);//sysj\turntableController.sysj line: 88, column: 3
                      d3_thread_1 = !m_thread_1.at(3);//sysj\turntableController.sysj line: 89, column: 3
                      d4_thread_1 = !m_thread_1.at(4);//sysj\turntableController.sysj line: 90, column: 3
                      S4709=4;
                      if(!(d1_thread_1 && d2_thread_1 && d3_thread_1 && d4_thread_1)){//sysj\turntableController.sysj line: 92, column: 9
                        if(!d1_thread_1){//sysj\turntableController.sysj line: 93, column: 7
                          enableFiller1.setPresent();//sysj\turntableController.sysj line: 94, column: 5
                          currsigs.addElement(enableFiller1);
                          if(fillerDone1.getprestatus()){//sysj\turntableController.sysj line: 95, column: 13
                            d1_thread_1 = true;//sysj\turntableController.sysj line: 95, column: 27
                            if(!d2_thread_1){//sysj\turntableController.sysj line: 97, column: 7
                              enableFiller2.setPresent();//sysj\turntableController.sysj line: 98, column: 5
                              currsigs.addElement(enableFiller2);
                              if(fillerDone2.getprestatus()){//sysj\turntableController.sysj line: 99, column: 13
                                d2_thread_1 = true;//sysj\turntableController.sysj line: 99, column: 27
                                if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                  enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                  currsigs.addElement(enableLid);
                                  if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                    d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                }
                                else {
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                              }
                              else {
                                if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                  enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                  currsigs.addElement(enableLid);
                                  if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                    d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                }
                                else {
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                              }
                            }
                            else {
                              if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                currsigs.addElement(enableLid);
                                if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                  d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                              }
                              else {
                                if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                  enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                  currsigs.addElement(enableCapper);
                                  if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                    d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                            }
                          }
                          else {
                            if(!d2_thread_1){//sysj\turntableController.sysj line: 97, column: 7
                              enableFiller2.setPresent();//sysj\turntableController.sysj line: 98, column: 5
                              currsigs.addElement(enableFiller2);
                              if(fillerDone2.getprestatus()){//sysj\turntableController.sysj line: 99, column: 13
                                d2_thread_1 = true;//sysj\turntableController.sysj line: 99, column: 27
                                if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                  enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                  currsigs.addElement(enableLid);
                                  if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                    d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                }
                                else {
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                              }
                              else {
                                if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                  enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                  currsigs.addElement(enableLid);
                                  if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                    d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                }
                                else {
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                              }
                            }
                            else {
                              if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                currsigs.addElement(enableLid);
                                if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                  d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                              }
                              else {
                                if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                  enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                  currsigs.addElement(enableCapper);
                                  if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                    d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                            }
                          }
                        }
                        else {
                          if(!d2_thread_1){//sysj\turntableController.sysj line: 97, column: 7
                            enableFiller2.setPresent();//sysj\turntableController.sysj line: 98, column: 5
                            currsigs.addElement(enableFiller2);
                            if(fillerDone2.getprestatus()){//sysj\turntableController.sysj line: 99, column: 13
                              d2_thread_1 = true;//sysj\turntableController.sysj line: 99, column: 27
                              if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                currsigs.addElement(enableLid);
                                if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                  d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                              }
                              else {
                                if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                  enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                  currsigs.addElement(enableCapper);
                                  if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                    d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                            }
                            else {
                              if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                currsigs.addElement(enableLid);
                                if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                  d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                              }
                              else {
                                if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                  enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                  currsigs.addElement(enableCapper);
                                  if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                    d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                            }
                          }
                          else {
                            if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                              enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                              currsigs.addElement(enableLid);
                              if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                  enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                  currsigs.addElement(enableCapper);
                                  if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                    d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                              else {
                                if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                  enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                  currsigs.addElement(enableCapper);
                                  if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                    d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                            }
                            else {
                              if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                currsigs.addElement(enableCapper);
                                if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                  d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                          }
                        }
                      }
                      else {
                        ends[1]=2;
                        ;//sysj\turntableController.sysj line: 92, column: 3
                        rotaryTrigger.setPresent();//sysj\turntableController.sysj line: 113, column: 3
                        currsigs.addElement(rotaryTrigger);
                        S4709=5;
                        active[1]=1;
                        ends[1]=1;
                        break RUN;
                      }
                    }
                  }
                }
              }
              else {
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
            
            case 1 : 
              switch(S4703){
                case 0 : 
                  S4703=0;
                  unloadExit.setPresent();//sysj\turntableController.sysj line: 52, column: 4
                  currsigs.addElement(unloadExit);
                  bottleFromTable.setPresent();//sysj\turntableController.sysj line: 52, column: 21
                  currsigs.addElement(bottleFromTable);
                  S4703=1;
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                
                case 1 : 
                  S4703=1;
                  m_thread_1.clearExit();//sysj\turntableController.sysj line: 53, column: 4
                  got_thread_1 = false;//sysj\turntableController.sysj line: 57, column: 3
                  S4709=2;
                  if(m_thread_1.loadPointFree()){//sysj\turntableController.sysj line: 58, column: 3
                    if(!m_thread_1.anyOccupied()){//sysj\turntableController.sysj line: 59, column: 7
                      S4742=0;
                      tableReady.setPresent();//sysj\turntableController.sysj line: 62, column: 6
                      currsigs.addElement(tableReady);
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                    else {
                      S4742=1;
                      w_thread_1 = OFFERWIN_thread_1;//sysj\turntableController.sysj line: 69, column: 5
                      if(w_thread_1 > 0){//sysj\turntableController.sysj line: 70, column: 11
                        tableReady.setPresent();//sysj\turntableController.sysj line: 71, column: 6
                        currsigs.addElement(tableReady);
                        S4717=0;
                        if(bottleToTable.getprestatus()){//sysj\turntableController.sysj line: 72, column: 14
                          got_thread_1 = true;//sysj\turntableController.sysj line: 72, column: 30
                          if(got_thread_1) {//sysj\turntableController.sysj line: 73, column: 13
                            w_thread_1 = 0;//sysj\turntableController.sysj line: 73, column: 15
                          }
                          else {//sysj\turntableController.sysj line: 73, column: 29
                            w_thread_1 = w_thread_1 - 1;//sysj\turntableController.sysj line: 73, column: 31
                          }
                          S4717=1;
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          if(got_thread_1) {//sysj\turntableController.sysj line: 73, column: 13
                            w_thread_1 = 0;//sysj\turntableController.sysj line: 73, column: 15
                          }
                          else {//sysj\turntableController.sysj line: 73, column: 29
                            w_thread_1 = w_thread_1 - 1;//sysj\turntableController.sysj line: 73, column: 31
                          }
                          S4717=1;
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        ends[1]=2;
                        ;//sysj\turntableController.sysj line: 70, column: 5
                        S4709=3;
                        if(got_thread_1){//sysj\turntableController.sysj line: 79, column: 3
                          loadPos1.setPresent();//sysj\turntableController.sysj line: 80, column: 4
                          currsigs.addElement(loadPos1);
                          bottleTaken.setPresent();//sysj\turntableController.sysj line: 80, column: 19
                          currsigs.addElement(bottleTaken);
                          S4846=0;
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          d1_thread_1 = !m_thread_1.at(1);//sysj\turntableController.sysj line: 87, column: 3
                          d2_thread_1 = !m_thread_1.at(2);//sysj\turntableController.sysj line: 88, column: 3
                          d3_thread_1 = !m_thread_1.at(3);//sysj\turntableController.sysj line: 89, column: 3
                          d4_thread_1 = !m_thread_1.at(4);//sysj\turntableController.sysj line: 90, column: 3
                          S4709=4;
                          if(!(d1_thread_1 && d2_thread_1 && d3_thread_1 && d4_thread_1)){//sysj\turntableController.sysj line: 92, column: 9
                            if(!d1_thread_1){//sysj\turntableController.sysj line: 93, column: 7
                              enableFiller1.setPresent();//sysj\turntableController.sysj line: 94, column: 5
                              currsigs.addElement(enableFiller1);
                              if(fillerDone1.getprestatus()){//sysj\turntableController.sysj line: 95, column: 13
                                d1_thread_1 = true;//sysj\turntableController.sysj line: 95, column: 27
                                if(!d2_thread_1){//sysj\turntableController.sysj line: 97, column: 7
                                  enableFiller2.setPresent();//sysj\turntableController.sysj line: 98, column: 5
                                  currsigs.addElement(enableFiller2);
                                  if(fillerDone2.getprestatus()){//sysj\turntableController.sysj line: 99, column: 13
                                    d2_thread_1 = true;//sysj\turntableController.sysj line: 99, column: 27
                                    if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                      enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                      currsigs.addElement(enableLid);
                                      if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                        d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                          currsigs.addElement(enableCapper);
                                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                          currsigs.addElement(enableCapper);
                                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                    }
                                    else {
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                  }
                                  else {
                                    if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                      enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                      currsigs.addElement(enableLid);
                                      if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                        d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                          currsigs.addElement(enableCapper);
                                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                          currsigs.addElement(enableCapper);
                                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                    }
                                    else {
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                  }
                                }
                                else {
                                  if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                    enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                    currsigs.addElement(enableLid);
                                    if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                      d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                  }
                                  else {
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                }
                              }
                              else {
                                if(!d2_thread_1){//sysj\turntableController.sysj line: 97, column: 7
                                  enableFiller2.setPresent();//sysj\turntableController.sysj line: 98, column: 5
                                  currsigs.addElement(enableFiller2);
                                  if(fillerDone2.getprestatus()){//sysj\turntableController.sysj line: 99, column: 13
                                    d2_thread_1 = true;//sysj\turntableController.sysj line: 99, column: 27
                                    if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                      enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                      currsigs.addElement(enableLid);
                                      if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                        d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                          currsigs.addElement(enableCapper);
                                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                          currsigs.addElement(enableCapper);
                                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                    }
                                    else {
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                  }
                                  else {
                                    if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                      enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                      currsigs.addElement(enableLid);
                                      if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                        d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                          currsigs.addElement(enableCapper);
                                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                          currsigs.addElement(enableCapper);
                                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                    }
                                    else {
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                  }
                                }
                                else {
                                  if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                    enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                    currsigs.addElement(enableLid);
                                    if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                      d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                  }
                                  else {
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                }
                              }
                            }
                            else {
                              if(!d2_thread_1){//sysj\turntableController.sysj line: 97, column: 7
                                enableFiller2.setPresent();//sysj\turntableController.sysj line: 98, column: 5
                                currsigs.addElement(enableFiller2);
                                if(fillerDone2.getprestatus()){//sysj\turntableController.sysj line: 99, column: 13
                                  d2_thread_1 = true;//sysj\turntableController.sysj line: 99, column: 27
                                  if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                    enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                    currsigs.addElement(enableLid);
                                    if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                      d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                  }
                                  else {
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                }
                                else {
                                  if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                    enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                    currsigs.addElement(enableLid);
                                    if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                      d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                  }
                                  else {
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                }
                              }
                              else {
                                if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                  enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                  currsigs.addElement(enableLid);
                                  if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                    d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                }
                                else {
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                              }
                            }
                          }
                          else {
                            ends[1]=2;
                            ;//sysj\turntableController.sysj line: 92, column: 3
                            rotaryTrigger.setPresent();//sysj\turntableController.sysj line: 113, column: 3
                            currsigs.addElement(rotaryTrigger);
                            S4709=5;
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                  }
                  else {
                    S4709=3;
                    if(got_thread_1){//sysj\turntableController.sysj line: 79, column: 3
                      loadPos1.setPresent();//sysj\turntableController.sysj line: 80, column: 4
                      currsigs.addElement(loadPos1);
                      bottleTaken.setPresent();//sysj\turntableController.sysj line: 80, column: 19
                      currsigs.addElement(bottleTaken);
                      S4846=0;
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                    else {
                      d1_thread_1 = !m_thread_1.at(1);//sysj\turntableController.sysj line: 87, column: 3
                      d2_thread_1 = !m_thread_1.at(2);//sysj\turntableController.sysj line: 88, column: 3
                      d3_thread_1 = !m_thread_1.at(3);//sysj\turntableController.sysj line: 89, column: 3
                      d4_thread_1 = !m_thread_1.at(4);//sysj\turntableController.sysj line: 90, column: 3
                      S4709=4;
                      if(!(d1_thread_1 && d2_thread_1 && d3_thread_1 && d4_thread_1)){//sysj\turntableController.sysj line: 92, column: 9
                        if(!d1_thread_1){//sysj\turntableController.sysj line: 93, column: 7
                          enableFiller1.setPresent();//sysj\turntableController.sysj line: 94, column: 5
                          currsigs.addElement(enableFiller1);
                          if(fillerDone1.getprestatus()){//sysj\turntableController.sysj line: 95, column: 13
                            d1_thread_1 = true;//sysj\turntableController.sysj line: 95, column: 27
                            if(!d2_thread_1){//sysj\turntableController.sysj line: 97, column: 7
                              enableFiller2.setPresent();//sysj\turntableController.sysj line: 98, column: 5
                              currsigs.addElement(enableFiller2);
                              if(fillerDone2.getprestatus()){//sysj\turntableController.sysj line: 99, column: 13
                                d2_thread_1 = true;//sysj\turntableController.sysj line: 99, column: 27
                                if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                  enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                  currsigs.addElement(enableLid);
                                  if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                    d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                }
                                else {
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                              }
                              else {
                                if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                  enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                  currsigs.addElement(enableLid);
                                  if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                    d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                }
                                else {
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                              }
                            }
                            else {
                              if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                currsigs.addElement(enableLid);
                                if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                  d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                              }
                              else {
                                if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                  enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                  currsigs.addElement(enableCapper);
                                  if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                    d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                            }
                          }
                          else {
                            if(!d2_thread_1){//sysj\turntableController.sysj line: 97, column: 7
                              enableFiller2.setPresent();//sysj\turntableController.sysj line: 98, column: 5
                              currsigs.addElement(enableFiller2);
                              if(fillerDone2.getprestatus()){//sysj\turntableController.sysj line: 99, column: 13
                                d2_thread_1 = true;//sysj\turntableController.sysj line: 99, column: 27
                                if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                  enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                  currsigs.addElement(enableLid);
                                  if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                    d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                }
                                else {
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                              }
                              else {
                                if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                  enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                  currsigs.addElement(enableLid);
                                  if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                    d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                }
                                else {
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                              }
                            }
                            else {
                              if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                currsigs.addElement(enableLid);
                                if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                  d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                              }
                              else {
                                if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                  enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                  currsigs.addElement(enableCapper);
                                  if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                    d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                            }
                          }
                        }
                        else {
                          if(!d2_thread_1){//sysj\turntableController.sysj line: 97, column: 7
                            enableFiller2.setPresent();//sysj\turntableController.sysj line: 98, column: 5
                            currsigs.addElement(enableFiller2);
                            if(fillerDone2.getprestatus()){//sysj\turntableController.sysj line: 99, column: 13
                              d2_thread_1 = true;//sysj\turntableController.sysj line: 99, column: 27
                              if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                currsigs.addElement(enableLid);
                                if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                  d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                              }
                              else {
                                if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                  enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                  currsigs.addElement(enableCapper);
                                  if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                    d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                            }
                            else {
                              if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                currsigs.addElement(enableLid);
                                if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                  d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                              }
                              else {
                                if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                  enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                  currsigs.addElement(enableCapper);
                                  if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                    d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                            }
                          }
                          else {
                            if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                              enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                              currsigs.addElement(enableLid);
                              if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                  enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                  currsigs.addElement(enableCapper);
                                  if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                    d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                              else {
                                if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                  enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                  currsigs.addElement(enableCapper);
                                  if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                    d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                            }
                            else {
                              if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                currsigs.addElement(enableCapper);
                                if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                  d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                          }
                        }
                      }
                      else {
                        ends[1]=2;
                        ;//sysj\turntableController.sysj line: 92, column: 3
                        rotaryTrigger.setPresent();//sysj\turntableController.sysj line: 113, column: 3
                        currsigs.addElement(rotaryTrigger);
                        S4709=5;
                        active[1]=1;
                        ends[1]=1;
                        break RUN;
                      }
                    }
                  }
                
              }
              break;
            
            case 2 : 
              switch(S4742){
                case 0 : 
                  if(bottleToTable.getprestatus()){//sysj\turntableController.sysj line: 61, column: 11
                    got_thread_1 = true;//sysj\turntableController.sysj line: 64, column: 5
                    S4709=3;
                    if(got_thread_1){//sysj\turntableController.sysj line: 79, column: 3
                      loadPos1.setPresent();//sysj\turntableController.sysj line: 80, column: 4
                      currsigs.addElement(loadPos1);
                      bottleTaken.setPresent();//sysj\turntableController.sysj line: 80, column: 19
                      currsigs.addElement(bottleTaken);
                      S4846=0;
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                    else {
                      d1_thread_1 = !m_thread_1.at(1);//sysj\turntableController.sysj line: 87, column: 3
                      d2_thread_1 = !m_thread_1.at(2);//sysj\turntableController.sysj line: 88, column: 3
                      d3_thread_1 = !m_thread_1.at(3);//sysj\turntableController.sysj line: 89, column: 3
                      d4_thread_1 = !m_thread_1.at(4);//sysj\turntableController.sysj line: 90, column: 3
                      S4709=4;
                      if(!(d1_thread_1 && d2_thread_1 && d3_thread_1 && d4_thread_1)){//sysj\turntableController.sysj line: 92, column: 9
                        if(!d1_thread_1){//sysj\turntableController.sysj line: 93, column: 7
                          enableFiller1.setPresent();//sysj\turntableController.sysj line: 94, column: 5
                          currsigs.addElement(enableFiller1);
                          if(fillerDone1.getprestatus()){//sysj\turntableController.sysj line: 95, column: 13
                            d1_thread_1 = true;//sysj\turntableController.sysj line: 95, column: 27
                            if(!d2_thread_1){//sysj\turntableController.sysj line: 97, column: 7
                              enableFiller2.setPresent();//sysj\turntableController.sysj line: 98, column: 5
                              currsigs.addElement(enableFiller2);
                              if(fillerDone2.getprestatus()){//sysj\turntableController.sysj line: 99, column: 13
                                d2_thread_1 = true;//sysj\turntableController.sysj line: 99, column: 27
                                if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                  enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                  currsigs.addElement(enableLid);
                                  if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                    d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                }
                                else {
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                              }
                              else {
                                if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                  enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                  currsigs.addElement(enableLid);
                                  if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                    d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                }
                                else {
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                              }
                            }
                            else {
                              if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                currsigs.addElement(enableLid);
                                if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                  d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                              }
                              else {
                                if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                  enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                  currsigs.addElement(enableCapper);
                                  if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                    d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                            }
                          }
                          else {
                            if(!d2_thread_1){//sysj\turntableController.sysj line: 97, column: 7
                              enableFiller2.setPresent();//sysj\turntableController.sysj line: 98, column: 5
                              currsigs.addElement(enableFiller2);
                              if(fillerDone2.getprestatus()){//sysj\turntableController.sysj line: 99, column: 13
                                d2_thread_1 = true;//sysj\turntableController.sysj line: 99, column: 27
                                if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                  enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                  currsigs.addElement(enableLid);
                                  if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                    d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                }
                                else {
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                              }
                              else {
                                if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                  enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                  currsigs.addElement(enableLid);
                                  if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                    d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                }
                                else {
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                              }
                            }
                            else {
                              if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                currsigs.addElement(enableLid);
                                if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                  d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                              }
                              else {
                                if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                  enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                  currsigs.addElement(enableCapper);
                                  if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                    d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                            }
                          }
                        }
                        else {
                          if(!d2_thread_1){//sysj\turntableController.sysj line: 97, column: 7
                            enableFiller2.setPresent();//sysj\turntableController.sysj line: 98, column: 5
                            currsigs.addElement(enableFiller2);
                            if(fillerDone2.getprestatus()){//sysj\turntableController.sysj line: 99, column: 13
                              d2_thread_1 = true;//sysj\turntableController.sysj line: 99, column: 27
                              if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                currsigs.addElement(enableLid);
                                if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                  d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                              }
                              else {
                                if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                  enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                  currsigs.addElement(enableCapper);
                                  if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                    d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                            }
                            else {
                              if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                currsigs.addElement(enableLid);
                                if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                  d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                              }
                              else {
                                if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                  enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                  currsigs.addElement(enableCapper);
                                  if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                    d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                            }
                          }
                          else {
                            if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                              enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                              currsigs.addElement(enableLid);
                              if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                  enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                  currsigs.addElement(enableCapper);
                                  if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                    d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                              else {
                                if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                  enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                  currsigs.addElement(enableCapper);
                                  if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                    d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                            }
                            else {
                              if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                currsigs.addElement(enableCapper);
                                if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                  d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                          }
                        }
                      }
                      else {
                        ends[1]=2;
                        ;//sysj\turntableController.sysj line: 92, column: 3
                        rotaryTrigger.setPresent();//sysj\turntableController.sysj line: 113, column: 3
                        currsigs.addElement(rotaryTrigger);
                        S4709=5;
                        active[1]=1;
                        ends[1]=1;
                        break RUN;
                      }
                    }
                  }
                  else {
                    tableReady.setPresent();//sysj\turntableController.sysj line: 62, column: 6
                    currsigs.addElement(tableReady);
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                
                case 1 : 
                  switch(S4717){
                    case 0 : 
                      if(w_thread_1 > 0){//sysj\turntableController.sysj line: 70, column: 11
                        tableReady.setPresent();//sysj\turntableController.sysj line: 71, column: 6
                        currsigs.addElement(tableReady);
                        S4717=0;
                        if(bottleToTable.getprestatus()){//sysj\turntableController.sysj line: 72, column: 14
                          got_thread_1 = true;//sysj\turntableController.sysj line: 72, column: 30
                          if(got_thread_1) {//sysj\turntableController.sysj line: 73, column: 13
                            w_thread_1 = 0;//sysj\turntableController.sysj line: 73, column: 15
                          }
                          else {//sysj\turntableController.sysj line: 73, column: 29
                            w_thread_1 = w_thread_1 - 1;//sysj\turntableController.sysj line: 73, column: 31
                          }
                          S4717=1;
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          if(got_thread_1) {//sysj\turntableController.sysj line: 73, column: 13
                            w_thread_1 = 0;//sysj\turntableController.sysj line: 73, column: 15
                          }
                          else {//sysj\turntableController.sysj line: 73, column: 29
                            w_thread_1 = w_thread_1 - 1;//sysj\turntableController.sysj line: 73, column: 31
                          }
                          S4717=1;
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        ends[1]=2;
                        ;//sysj\turntableController.sysj line: 70, column: 5
                        S4709=3;
                        if(got_thread_1){//sysj\turntableController.sysj line: 79, column: 3
                          loadPos1.setPresent();//sysj\turntableController.sysj line: 80, column: 4
                          currsigs.addElement(loadPos1);
                          bottleTaken.setPresent();//sysj\turntableController.sysj line: 80, column: 19
                          currsigs.addElement(bottleTaken);
                          S4846=0;
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          d1_thread_1 = !m_thread_1.at(1);//sysj\turntableController.sysj line: 87, column: 3
                          d2_thread_1 = !m_thread_1.at(2);//sysj\turntableController.sysj line: 88, column: 3
                          d3_thread_1 = !m_thread_1.at(3);//sysj\turntableController.sysj line: 89, column: 3
                          d4_thread_1 = !m_thread_1.at(4);//sysj\turntableController.sysj line: 90, column: 3
                          S4709=4;
                          if(!(d1_thread_1 && d2_thread_1 && d3_thread_1 && d4_thread_1)){//sysj\turntableController.sysj line: 92, column: 9
                            if(!d1_thread_1){//sysj\turntableController.sysj line: 93, column: 7
                              enableFiller1.setPresent();//sysj\turntableController.sysj line: 94, column: 5
                              currsigs.addElement(enableFiller1);
                              if(fillerDone1.getprestatus()){//sysj\turntableController.sysj line: 95, column: 13
                                d1_thread_1 = true;//sysj\turntableController.sysj line: 95, column: 27
                                if(!d2_thread_1){//sysj\turntableController.sysj line: 97, column: 7
                                  enableFiller2.setPresent();//sysj\turntableController.sysj line: 98, column: 5
                                  currsigs.addElement(enableFiller2);
                                  if(fillerDone2.getprestatus()){//sysj\turntableController.sysj line: 99, column: 13
                                    d2_thread_1 = true;//sysj\turntableController.sysj line: 99, column: 27
                                    if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                      enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                      currsigs.addElement(enableLid);
                                      if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                        d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                          currsigs.addElement(enableCapper);
                                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                          currsigs.addElement(enableCapper);
                                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                    }
                                    else {
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                  }
                                  else {
                                    if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                      enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                      currsigs.addElement(enableLid);
                                      if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                        d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                          currsigs.addElement(enableCapper);
                                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                          currsigs.addElement(enableCapper);
                                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                    }
                                    else {
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                  }
                                }
                                else {
                                  if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                    enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                    currsigs.addElement(enableLid);
                                    if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                      d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                  }
                                  else {
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                }
                              }
                              else {
                                if(!d2_thread_1){//sysj\turntableController.sysj line: 97, column: 7
                                  enableFiller2.setPresent();//sysj\turntableController.sysj line: 98, column: 5
                                  currsigs.addElement(enableFiller2);
                                  if(fillerDone2.getprestatus()){//sysj\turntableController.sysj line: 99, column: 13
                                    d2_thread_1 = true;//sysj\turntableController.sysj line: 99, column: 27
                                    if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                      enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                      currsigs.addElement(enableLid);
                                      if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                        d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                          currsigs.addElement(enableCapper);
                                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                          currsigs.addElement(enableCapper);
                                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                    }
                                    else {
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                  }
                                  else {
                                    if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                      enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                      currsigs.addElement(enableLid);
                                      if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                        d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                          currsigs.addElement(enableCapper);
                                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                          currsigs.addElement(enableCapper);
                                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                    }
                                    else {
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                  }
                                }
                                else {
                                  if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                    enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                    currsigs.addElement(enableLid);
                                    if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                      d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                  }
                                  else {
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                }
                              }
                            }
                            else {
                              if(!d2_thread_1){//sysj\turntableController.sysj line: 97, column: 7
                                enableFiller2.setPresent();//sysj\turntableController.sysj line: 98, column: 5
                                currsigs.addElement(enableFiller2);
                                if(fillerDone2.getprestatus()){//sysj\turntableController.sysj line: 99, column: 13
                                  d2_thread_1 = true;//sysj\turntableController.sysj line: 99, column: 27
                                  if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                    enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                    currsigs.addElement(enableLid);
                                    if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                      d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                  }
                                  else {
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                }
                                else {
                                  if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                    enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                    currsigs.addElement(enableLid);
                                    if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                      d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                  }
                                  else {
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                }
                              }
                              else {
                                if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                  enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                  currsigs.addElement(enableLid);
                                  if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                    d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                }
                                else {
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                              }
                            }
                          }
                          else {
                            ends[1]=2;
                            ;//sysj\turntableController.sysj line: 92, column: 3
                            rotaryTrigger.setPresent();//sysj\turntableController.sysj line: 113, column: 3
                            currsigs.addElement(rotaryTrigger);
                            S4709=5;
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    
                    case 1 : 
                      S4717=1;
                      if(w_thread_1 > 0){//sysj\turntableController.sysj line: 70, column: 11
                        tableReady.setPresent();//sysj\turntableController.sysj line: 71, column: 6
                        currsigs.addElement(tableReady);
                        S4717=0;
                        if(bottleToTable.getprestatus()){//sysj\turntableController.sysj line: 72, column: 14
                          got_thread_1 = true;//sysj\turntableController.sysj line: 72, column: 30
                          if(got_thread_1) {//sysj\turntableController.sysj line: 73, column: 13
                            w_thread_1 = 0;//sysj\turntableController.sysj line: 73, column: 15
                          }
                          else {//sysj\turntableController.sysj line: 73, column: 29
                            w_thread_1 = w_thread_1 - 1;//sysj\turntableController.sysj line: 73, column: 31
                          }
                          S4717=1;
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          if(got_thread_1) {//sysj\turntableController.sysj line: 73, column: 13
                            w_thread_1 = 0;//sysj\turntableController.sysj line: 73, column: 15
                          }
                          else {//sysj\turntableController.sysj line: 73, column: 29
                            w_thread_1 = w_thread_1 - 1;//sysj\turntableController.sysj line: 73, column: 31
                          }
                          S4717=1;
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        ends[1]=2;
                        ;//sysj\turntableController.sysj line: 70, column: 5
                        S4709=3;
                        if(got_thread_1){//sysj\turntableController.sysj line: 79, column: 3
                          loadPos1.setPresent();//sysj\turntableController.sysj line: 80, column: 4
                          currsigs.addElement(loadPos1);
                          bottleTaken.setPresent();//sysj\turntableController.sysj line: 80, column: 19
                          currsigs.addElement(bottleTaken);
                          S4846=0;
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          d1_thread_1 = !m_thread_1.at(1);//sysj\turntableController.sysj line: 87, column: 3
                          d2_thread_1 = !m_thread_1.at(2);//sysj\turntableController.sysj line: 88, column: 3
                          d3_thread_1 = !m_thread_1.at(3);//sysj\turntableController.sysj line: 89, column: 3
                          d4_thread_1 = !m_thread_1.at(4);//sysj\turntableController.sysj line: 90, column: 3
                          S4709=4;
                          if(!(d1_thread_1 && d2_thread_1 && d3_thread_1 && d4_thread_1)){//sysj\turntableController.sysj line: 92, column: 9
                            if(!d1_thread_1){//sysj\turntableController.sysj line: 93, column: 7
                              enableFiller1.setPresent();//sysj\turntableController.sysj line: 94, column: 5
                              currsigs.addElement(enableFiller1);
                              if(fillerDone1.getprestatus()){//sysj\turntableController.sysj line: 95, column: 13
                                d1_thread_1 = true;//sysj\turntableController.sysj line: 95, column: 27
                                if(!d2_thread_1){//sysj\turntableController.sysj line: 97, column: 7
                                  enableFiller2.setPresent();//sysj\turntableController.sysj line: 98, column: 5
                                  currsigs.addElement(enableFiller2);
                                  if(fillerDone2.getprestatus()){//sysj\turntableController.sysj line: 99, column: 13
                                    d2_thread_1 = true;//sysj\turntableController.sysj line: 99, column: 27
                                    if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                      enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                      currsigs.addElement(enableLid);
                                      if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                        d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                          currsigs.addElement(enableCapper);
                                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                          currsigs.addElement(enableCapper);
                                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                    }
                                    else {
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                  }
                                  else {
                                    if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                      enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                      currsigs.addElement(enableLid);
                                      if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                        d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                          currsigs.addElement(enableCapper);
                                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                          currsigs.addElement(enableCapper);
                                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                    }
                                    else {
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                  }
                                }
                                else {
                                  if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                    enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                    currsigs.addElement(enableLid);
                                    if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                      d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                  }
                                  else {
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                }
                              }
                              else {
                                if(!d2_thread_1){//sysj\turntableController.sysj line: 97, column: 7
                                  enableFiller2.setPresent();//sysj\turntableController.sysj line: 98, column: 5
                                  currsigs.addElement(enableFiller2);
                                  if(fillerDone2.getprestatus()){//sysj\turntableController.sysj line: 99, column: 13
                                    d2_thread_1 = true;//sysj\turntableController.sysj line: 99, column: 27
                                    if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                      enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                      currsigs.addElement(enableLid);
                                      if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                        d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                          currsigs.addElement(enableCapper);
                                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                          currsigs.addElement(enableCapper);
                                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                    }
                                    else {
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                  }
                                  else {
                                    if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                      enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                      currsigs.addElement(enableLid);
                                      if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                        d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                          currsigs.addElement(enableCapper);
                                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                          currsigs.addElement(enableCapper);
                                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                    }
                                    else {
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                  }
                                }
                                else {
                                  if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                    enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                    currsigs.addElement(enableLid);
                                    if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                      d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                  }
                                  else {
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                }
                              }
                            }
                            else {
                              if(!d2_thread_1){//sysj\turntableController.sysj line: 97, column: 7
                                enableFiller2.setPresent();//sysj\turntableController.sysj line: 98, column: 5
                                currsigs.addElement(enableFiller2);
                                if(fillerDone2.getprestatus()){//sysj\turntableController.sysj line: 99, column: 13
                                  d2_thread_1 = true;//sysj\turntableController.sysj line: 99, column: 27
                                  if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                    enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                    currsigs.addElement(enableLid);
                                    if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                      d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                  }
                                  else {
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                }
                                else {
                                  if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                    enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                    currsigs.addElement(enableLid);
                                    if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                      d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                  }
                                  else {
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                }
                              }
                              else {
                                if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                  enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                  currsigs.addElement(enableLid);
                                  if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                    d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                }
                                else {
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                              }
                            }
                          }
                          else {
                            ends[1]=2;
                            ;//sysj\turntableController.sysj line: 92, column: 3
                            rotaryTrigger.setPresent();//sysj\turntableController.sysj line: 113, column: 3
                            currsigs.addElement(rotaryTrigger);
                            S4709=5;
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    
                  }
                  break;
                
              }
              break;
            
            case 3 : 
              switch(S4846){
                case 0 : 
                  S4846=0;
                  loadPos1.setPresent();//sysj\turntableController.sysj line: 81, column: 4
                  currsigs.addElement(loadPos1);
                  bottleTaken.setPresent();//sysj\turntableController.sysj line: 81, column: 19
                  currsigs.addElement(bottleTaken);
                  S4846=1;
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                
                case 1 : 
                  S4846=1;
                  m_thread_1.load();//sysj\turntableController.sysj line: 82, column: 4
                  S4846=2;
                  if(!bottleToTable.getprestatus()){//sysj\turntableController.sysj line: 83, column: 20
                    d1_thread_1 = !m_thread_1.at(1);//sysj\turntableController.sysj line: 87, column: 3
                    d2_thread_1 = !m_thread_1.at(2);//sysj\turntableController.sysj line: 88, column: 3
                    d3_thread_1 = !m_thread_1.at(3);//sysj\turntableController.sysj line: 89, column: 3
                    d4_thread_1 = !m_thread_1.at(4);//sysj\turntableController.sysj line: 90, column: 3
                    S4709=4;
                    if(!(d1_thread_1 && d2_thread_1 && d3_thread_1 && d4_thread_1)){//sysj\turntableController.sysj line: 92, column: 9
                      if(!d1_thread_1){//sysj\turntableController.sysj line: 93, column: 7
                        enableFiller1.setPresent();//sysj\turntableController.sysj line: 94, column: 5
                        currsigs.addElement(enableFiller1);
                        if(fillerDone1.getprestatus()){//sysj\turntableController.sysj line: 95, column: 13
                          d1_thread_1 = true;//sysj\turntableController.sysj line: 95, column: 27
                          if(!d2_thread_1){//sysj\turntableController.sysj line: 97, column: 7
                            enableFiller2.setPresent();//sysj\turntableController.sysj line: 98, column: 5
                            currsigs.addElement(enableFiller2);
                            if(fillerDone2.getprestatus()){//sysj\turntableController.sysj line: 99, column: 13
                              d2_thread_1 = true;//sysj\turntableController.sysj line: 99, column: 27
                              if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                currsigs.addElement(enableLid);
                                if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                  d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                              }
                              else {
                                if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                  enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                  currsigs.addElement(enableCapper);
                                  if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                    d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                            }
                            else {
                              if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                currsigs.addElement(enableLid);
                                if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                  d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                              }
                              else {
                                if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                  enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                  currsigs.addElement(enableCapper);
                                  if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                    d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                            }
                          }
                          else {
                            if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                              enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                              currsigs.addElement(enableLid);
                              if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                  enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                  currsigs.addElement(enableCapper);
                                  if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                    d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                              else {
                                if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                  enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                  currsigs.addElement(enableCapper);
                                  if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                    d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                            }
                            else {
                              if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                currsigs.addElement(enableCapper);
                                if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                  d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                          }
                        }
                        else {
                          if(!d2_thread_1){//sysj\turntableController.sysj line: 97, column: 7
                            enableFiller2.setPresent();//sysj\turntableController.sysj line: 98, column: 5
                            currsigs.addElement(enableFiller2);
                            if(fillerDone2.getprestatus()){//sysj\turntableController.sysj line: 99, column: 13
                              d2_thread_1 = true;//sysj\turntableController.sysj line: 99, column: 27
                              if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                currsigs.addElement(enableLid);
                                if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                  d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                              }
                              else {
                                if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                  enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                  currsigs.addElement(enableCapper);
                                  if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                    d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                            }
                            else {
                              if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                currsigs.addElement(enableLid);
                                if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                  d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                              }
                              else {
                                if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                  enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                  currsigs.addElement(enableCapper);
                                  if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                    d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                            }
                          }
                          else {
                            if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                              enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                              currsigs.addElement(enableLid);
                              if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                  enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                  currsigs.addElement(enableCapper);
                                  if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                    d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                              else {
                                if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                  enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                  currsigs.addElement(enableCapper);
                                  if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                    d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                            }
                            else {
                              if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                currsigs.addElement(enableCapper);
                                if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                  d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                          }
                        }
                      }
                      else {
                        if(!d2_thread_1){//sysj\turntableController.sysj line: 97, column: 7
                          enableFiller2.setPresent();//sysj\turntableController.sysj line: 98, column: 5
                          currsigs.addElement(enableFiller2);
                          if(fillerDone2.getprestatus()){//sysj\turntableController.sysj line: 99, column: 13
                            d2_thread_1 = true;//sysj\turntableController.sysj line: 99, column: 27
                            if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                              enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                              currsigs.addElement(enableLid);
                              if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                  enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                  currsigs.addElement(enableCapper);
                                  if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                    d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                              else {
                                if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                  enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                  currsigs.addElement(enableCapper);
                                  if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                    d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                            }
                            else {
                              if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                currsigs.addElement(enableCapper);
                                if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                  d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                          }
                          else {
                            if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                              enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                              currsigs.addElement(enableLid);
                              if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                  enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                  currsigs.addElement(enableCapper);
                                  if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                    d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                              else {
                                if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                  enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                  currsigs.addElement(enableCapper);
                                  if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                    d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                            }
                            else {
                              if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                currsigs.addElement(enableCapper);
                                if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                  d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                          }
                        }
                        else {
                          if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                            enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                            currsigs.addElement(enableLid);
                            if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                              d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                              if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                currsigs.addElement(enableCapper);
                                if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                  d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                currsigs.addElement(enableCapper);
                                if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                  d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                          }
                          else {
                            if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                              enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                              currsigs.addElement(enableCapper);
                              if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              active[1]=1;
                              ends[1]=1;
                              break RUN;
                            }
                          }
                        }
                      }
                    }
                    else {
                      ends[1]=2;
                      ;//sysj\turntableController.sysj line: 92, column: 3
                      rotaryTrigger.setPresent();//sysj\turntableController.sysj line: 113, column: 3
                      currsigs.addElement(rotaryTrigger);
                      S4709=5;
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                  }
                  else {
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                
                case 2 : 
                  if(!bottleToTable.getprestatus()){//sysj\turntableController.sysj line: 83, column: 20
                    d1_thread_1 = !m_thread_1.at(1);//sysj\turntableController.sysj line: 87, column: 3
                    d2_thread_1 = !m_thread_1.at(2);//sysj\turntableController.sysj line: 88, column: 3
                    d3_thread_1 = !m_thread_1.at(3);//sysj\turntableController.sysj line: 89, column: 3
                    d4_thread_1 = !m_thread_1.at(4);//sysj\turntableController.sysj line: 90, column: 3
                    S4709=4;
                    if(!(d1_thread_1 && d2_thread_1 && d3_thread_1 && d4_thread_1)){//sysj\turntableController.sysj line: 92, column: 9
                      if(!d1_thread_1){//sysj\turntableController.sysj line: 93, column: 7
                        enableFiller1.setPresent();//sysj\turntableController.sysj line: 94, column: 5
                        currsigs.addElement(enableFiller1);
                        if(fillerDone1.getprestatus()){//sysj\turntableController.sysj line: 95, column: 13
                          d1_thread_1 = true;//sysj\turntableController.sysj line: 95, column: 27
                          if(!d2_thread_1){//sysj\turntableController.sysj line: 97, column: 7
                            enableFiller2.setPresent();//sysj\turntableController.sysj line: 98, column: 5
                            currsigs.addElement(enableFiller2);
                            if(fillerDone2.getprestatus()){//sysj\turntableController.sysj line: 99, column: 13
                              d2_thread_1 = true;//sysj\turntableController.sysj line: 99, column: 27
                              if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                currsigs.addElement(enableLid);
                                if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                  d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                              }
                              else {
                                if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                  enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                  currsigs.addElement(enableCapper);
                                  if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                    d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                            }
                            else {
                              if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                currsigs.addElement(enableLid);
                                if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                  d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                              }
                              else {
                                if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                  enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                  currsigs.addElement(enableCapper);
                                  if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                    d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                            }
                          }
                          else {
                            if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                              enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                              currsigs.addElement(enableLid);
                              if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                  enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                  currsigs.addElement(enableCapper);
                                  if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                    d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                              else {
                                if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                  enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                  currsigs.addElement(enableCapper);
                                  if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                    d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                            }
                            else {
                              if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                currsigs.addElement(enableCapper);
                                if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                  d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                          }
                        }
                        else {
                          if(!d2_thread_1){//sysj\turntableController.sysj line: 97, column: 7
                            enableFiller2.setPresent();//sysj\turntableController.sysj line: 98, column: 5
                            currsigs.addElement(enableFiller2);
                            if(fillerDone2.getprestatus()){//sysj\turntableController.sysj line: 99, column: 13
                              d2_thread_1 = true;//sysj\turntableController.sysj line: 99, column: 27
                              if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                currsigs.addElement(enableLid);
                                if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                  d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                              }
                              else {
                                if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                  enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                  currsigs.addElement(enableCapper);
                                  if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                    d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                            }
                            else {
                              if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                currsigs.addElement(enableLid);
                                if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                  d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                              }
                              else {
                                if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                  enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                  currsigs.addElement(enableCapper);
                                  if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                    d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                            }
                          }
                          else {
                            if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                              enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                              currsigs.addElement(enableLid);
                              if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                  enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                  currsigs.addElement(enableCapper);
                                  if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                    d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                              else {
                                if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                  enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                  currsigs.addElement(enableCapper);
                                  if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                    d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                            }
                            else {
                              if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                currsigs.addElement(enableCapper);
                                if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                  d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                          }
                        }
                      }
                      else {
                        if(!d2_thread_1){//sysj\turntableController.sysj line: 97, column: 7
                          enableFiller2.setPresent();//sysj\turntableController.sysj line: 98, column: 5
                          currsigs.addElement(enableFiller2);
                          if(fillerDone2.getprestatus()){//sysj\turntableController.sysj line: 99, column: 13
                            d2_thread_1 = true;//sysj\turntableController.sysj line: 99, column: 27
                            if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                              enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                              currsigs.addElement(enableLid);
                              if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                  enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                  currsigs.addElement(enableCapper);
                                  if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                    d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                              else {
                                if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                  enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                  currsigs.addElement(enableCapper);
                                  if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                    d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                            }
                            else {
                              if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                currsigs.addElement(enableCapper);
                                if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                  d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                          }
                          else {
                            if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                              enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                              currsigs.addElement(enableLid);
                              if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                  enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                  currsigs.addElement(enableCapper);
                                  if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                    d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                              else {
                                if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                  enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                  currsigs.addElement(enableCapper);
                                  if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                    d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                            }
                            else {
                              if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                currsigs.addElement(enableCapper);
                                if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                  d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                          }
                        }
                        else {
                          if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                            enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                            currsigs.addElement(enableLid);
                            if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                              d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                              if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                currsigs.addElement(enableCapper);
                                if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                  d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                currsigs.addElement(enableCapper);
                                if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                  d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                          }
                          else {
                            if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                              enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                              currsigs.addElement(enableCapper);
                              if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              active[1]=1;
                              ends[1]=1;
                              break RUN;
                            }
                          }
                        }
                      }
                    }
                    else {
                      ends[1]=2;
                      ;//sysj\turntableController.sysj line: 92, column: 3
                      rotaryTrigger.setPresent();//sysj\turntableController.sysj line: 113, column: 3
                      currsigs.addElement(rotaryTrigger);
                      S4709=5;
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                  }
                  else {
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                
              }
              break;
            
            case 4 : 
              if(!(d1_thread_1 && d2_thread_1 && d3_thread_1 && d4_thread_1)){//sysj\turntableController.sysj line: 92, column: 9
                if(!d1_thread_1){//sysj\turntableController.sysj line: 93, column: 7
                  enableFiller1.setPresent();//sysj\turntableController.sysj line: 94, column: 5
                  currsigs.addElement(enableFiller1);
                  if(fillerDone1.getprestatus()){//sysj\turntableController.sysj line: 95, column: 13
                    d1_thread_1 = true;//sysj\turntableController.sysj line: 95, column: 27
                    if(!d2_thread_1){//sysj\turntableController.sysj line: 97, column: 7
                      enableFiller2.setPresent();//sysj\turntableController.sysj line: 98, column: 5
                      currsigs.addElement(enableFiller2);
                      if(fillerDone2.getprestatus()){//sysj\turntableController.sysj line: 99, column: 13
                        d2_thread_1 = true;//sysj\turntableController.sysj line: 99, column: 27
                        if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                          enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                          currsigs.addElement(enableLid);
                          if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                            d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                            if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                              enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                              currsigs.addElement(enableCapper);
                              if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              active[1]=1;
                              ends[1]=1;
                              break RUN;
                            }
                          }
                          else {
                            if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                              enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                              currsigs.addElement(enableCapper);
                              if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              active[1]=1;
                              ends[1]=1;
                              break RUN;
                            }
                          }
                        }
                        else {
                          if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                            enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                            currsigs.addElement(enableCapper);
                            if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                              d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                              active[1]=1;
                              ends[1]=1;
                              break RUN;
                            }
                            else {
                              active[1]=1;
                              ends[1]=1;
                              break RUN;
                            }
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                          enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                          currsigs.addElement(enableLid);
                          if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                            d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                            if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                              enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                              currsigs.addElement(enableCapper);
                              if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              active[1]=1;
                              ends[1]=1;
                              break RUN;
                            }
                          }
                          else {
                            if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                              enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                              currsigs.addElement(enableCapper);
                              if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              active[1]=1;
                              ends[1]=1;
                              break RUN;
                            }
                          }
                        }
                        else {
                          if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                            enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                            currsigs.addElement(enableCapper);
                            if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                              d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                              active[1]=1;
                              ends[1]=1;
                              break RUN;
                            }
                            else {
                              active[1]=1;
                              ends[1]=1;
                              break RUN;
                            }
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                    else {
                      if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                        enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                        currsigs.addElement(enableLid);
                        if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                          d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                          if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                            enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                            currsigs.addElement(enableCapper);
                            if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                              d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                              active[1]=1;
                              ends[1]=1;
                              break RUN;
                            }
                            else {
                              active[1]=1;
                              ends[1]=1;
                              break RUN;
                            }
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                            enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                            currsigs.addElement(enableCapper);
                            if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                              d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                              active[1]=1;
                              ends[1]=1;
                              break RUN;
                            }
                            else {
                              active[1]=1;
                              ends[1]=1;
                              break RUN;
                            }
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                          currsigs.addElement(enableCapper);
                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                  }
                  else {
                    if(!d2_thread_1){//sysj\turntableController.sysj line: 97, column: 7
                      enableFiller2.setPresent();//sysj\turntableController.sysj line: 98, column: 5
                      currsigs.addElement(enableFiller2);
                      if(fillerDone2.getprestatus()){//sysj\turntableController.sysj line: 99, column: 13
                        d2_thread_1 = true;//sysj\turntableController.sysj line: 99, column: 27
                        if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                          enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                          currsigs.addElement(enableLid);
                          if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                            d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                            if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                              enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                              currsigs.addElement(enableCapper);
                              if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              active[1]=1;
                              ends[1]=1;
                              break RUN;
                            }
                          }
                          else {
                            if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                              enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                              currsigs.addElement(enableCapper);
                              if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              active[1]=1;
                              ends[1]=1;
                              break RUN;
                            }
                          }
                        }
                        else {
                          if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                            enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                            currsigs.addElement(enableCapper);
                            if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                              d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                              active[1]=1;
                              ends[1]=1;
                              break RUN;
                            }
                            else {
                              active[1]=1;
                              ends[1]=1;
                              break RUN;
                            }
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                          enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                          currsigs.addElement(enableLid);
                          if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                            d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                            if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                              enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                              currsigs.addElement(enableCapper);
                              if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              active[1]=1;
                              ends[1]=1;
                              break RUN;
                            }
                          }
                          else {
                            if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                              enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                              currsigs.addElement(enableCapper);
                              if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              active[1]=1;
                              ends[1]=1;
                              break RUN;
                            }
                          }
                        }
                        else {
                          if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                            enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                            currsigs.addElement(enableCapper);
                            if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                              d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                              active[1]=1;
                              ends[1]=1;
                              break RUN;
                            }
                            else {
                              active[1]=1;
                              ends[1]=1;
                              break RUN;
                            }
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                    else {
                      if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                        enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                        currsigs.addElement(enableLid);
                        if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                          d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                          if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                            enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                            currsigs.addElement(enableCapper);
                            if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                              d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                              active[1]=1;
                              ends[1]=1;
                              break RUN;
                            }
                            else {
                              active[1]=1;
                              ends[1]=1;
                              break RUN;
                            }
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                            enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                            currsigs.addElement(enableCapper);
                            if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                              d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                              active[1]=1;
                              ends[1]=1;
                              break RUN;
                            }
                            else {
                              active[1]=1;
                              ends[1]=1;
                              break RUN;
                            }
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                          currsigs.addElement(enableCapper);
                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                  }
                }
                else {
                  if(!d2_thread_1){//sysj\turntableController.sysj line: 97, column: 7
                    enableFiller2.setPresent();//sysj\turntableController.sysj line: 98, column: 5
                    currsigs.addElement(enableFiller2);
                    if(fillerDone2.getprestatus()){//sysj\turntableController.sysj line: 99, column: 13
                      d2_thread_1 = true;//sysj\turntableController.sysj line: 99, column: 27
                      if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                        enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                        currsigs.addElement(enableLid);
                        if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                          d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                          if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                            enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                            currsigs.addElement(enableCapper);
                            if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                              d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                              active[1]=1;
                              ends[1]=1;
                              break RUN;
                            }
                            else {
                              active[1]=1;
                              ends[1]=1;
                              break RUN;
                            }
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                            enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                            currsigs.addElement(enableCapper);
                            if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                              d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                              active[1]=1;
                              ends[1]=1;
                              break RUN;
                            }
                            else {
                              active[1]=1;
                              ends[1]=1;
                              break RUN;
                            }
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                          currsigs.addElement(enableCapper);
                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                        enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                        currsigs.addElement(enableLid);
                        if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                          d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                          if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                            enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                            currsigs.addElement(enableCapper);
                            if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                              d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                              active[1]=1;
                              ends[1]=1;
                              break RUN;
                            }
                            else {
                              active[1]=1;
                              ends[1]=1;
                              break RUN;
                            }
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                            enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                            currsigs.addElement(enableCapper);
                            if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                              d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                              active[1]=1;
                              ends[1]=1;
                              break RUN;
                            }
                            else {
                              active[1]=1;
                              ends[1]=1;
                              break RUN;
                            }
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                          currsigs.addElement(enableCapper);
                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                  }
                  else {
                    if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                      enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                      currsigs.addElement(enableLid);
                      if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                        d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                          currsigs.addElement(enableCapper);
                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                          currsigs.addElement(enableCapper);
                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                        currsigs.addElement(enableCapper);
                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        active[1]=1;
                        ends[1]=1;
                        break RUN;
                      }
                    }
                  }
                }
              }
              else {
                ends[1]=2;
                ;//sysj\turntableController.sysj line: 92, column: 3
                rotaryTrigger.setPresent();//sysj\turntableController.sysj line: 113, column: 3
                currsigs.addElement(rotaryTrigger);
                S4709=5;
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
            
            case 5 : 
              S4709=5;
              rotaryTrigger.setPresent();//sysj\turntableController.sysj line: 114, column: 3
              currsigs.addElement(rotaryTrigger);
              S4709=6;
              active[1]=1;
              ends[1]=1;
              break RUN;
            
            case 6 : 
              S4709=6;
              S4709=7;
              if(tableAligned.getprestatus()){//sysj\turntableController.sysj line: 116, column: 19
                m_thread_1.index();//sysj\turntableController.sysj line: 118, column: 3
                m_thread_1.report();//sysj\turntableController.sysj line: 119, column: 3
                S4709=0;
                if(tableAligned.getprestatus()){//sysj\turntableController.sysj line: 46, column: 19
                  S4709=1;
                  if(m_thread_1.exitOccupied()){//sysj\turntableController.sysj line: 49, column: 3
                    m_thread_1.sayUnloading();//sysj\turntableController.sysj line: 50, column: 4
                    unloadExit.setPresent();//sysj\turntableController.sysj line: 51, column: 4
                    currsigs.addElement(unloadExit);
                    bottleFromTable.setPresent();//sysj\turntableController.sysj line: 51, column: 21
                    currsigs.addElement(bottleFromTable);
                    S4703=0;
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                  else {
                    got_thread_1 = false;//sysj\turntableController.sysj line: 57, column: 3
                    S4709=2;
                    if(m_thread_1.loadPointFree()){//sysj\turntableController.sysj line: 58, column: 3
                      if(!m_thread_1.anyOccupied()){//sysj\turntableController.sysj line: 59, column: 7
                        S4742=0;
                        tableReady.setPresent();//sysj\turntableController.sysj line: 62, column: 6
                        currsigs.addElement(tableReady);
                        active[1]=1;
                        ends[1]=1;
                        break RUN;
                      }
                      else {
                        S4742=1;
                        w_thread_1 = OFFERWIN_thread_1;//sysj\turntableController.sysj line: 69, column: 5
                        if(w_thread_1 > 0){//sysj\turntableController.sysj line: 70, column: 11
                          tableReady.setPresent();//sysj\turntableController.sysj line: 71, column: 6
                          currsigs.addElement(tableReady);
                          S4717=0;
                          if(bottleToTable.getprestatus()){//sysj\turntableController.sysj line: 72, column: 14
                            got_thread_1 = true;//sysj\turntableController.sysj line: 72, column: 30
                            if(got_thread_1) {//sysj\turntableController.sysj line: 73, column: 13
                              w_thread_1 = 0;//sysj\turntableController.sysj line: 73, column: 15
                            }
                            else {//sysj\turntableController.sysj line: 73, column: 29
                              w_thread_1 = w_thread_1 - 1;//sysj\turntableController.sysj line: 73, column: 31
                            }
                            S4717=1;
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(got_thread_1) {//sysj\turntableController.sysj line: 73, column: 13
                              w_thread_1 = 0;//sysj\turntableController.sysj line: 73, column: 15
                            }
                            else {//sysj\turntableController.sysj line: 73, column: 29
                              w_thread_1 = w_thread_1 - 1;//sysj\turntableController.sysj line: 73, column: 31
                            }
                            S4717=1;
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          ends[1]=2;
                          ;//sysj\turntableController.sysj line: 70, column: 5
                          S4709=3;
                          if(got_thread_1){//sysj\turntableController.sysj line: 79, column: 3
                            loadPos1.setPresent();//sysj\turntableController.sysj line: 80, column: 4
                            currsigs.addElement(loadPos1);
                            bottleTaken.setPresent();//sysj\turntableController.sysj line: 80, column: 19
                            currsigs.addElement(bottleTaken);
                            S4846=0;
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            d1_thread_1 = !m_thread_1.at(1);//sysj\turntableController.sysj line: 87, column: 3
                            d2_thread_1 = !m_thread_1.at(2);//sysj\turntableController.sysj line: 88, column: 3
                            d3_thread_1 = !m_thread_1.at(3);//sysj\turntableController.sysj line: 89, column: 3
                            d4_thread_1 = !m_thread_1.at(4);//sysj\turntableController.sysj line: 90, column: 3
                            S4709=4;
                            if(!(d1_thread_1 && d2_thread_1 && d3_thread_1 && d4_thread_1)){//sysj\turntableController.sysj line: 92, column: 9
                              if(!d1_thread_1){//sysj\turntableController.sysj line: 93, column: 7
                                enableFiller1.setPresent();//sysj\turntableController.sysj line: 94, column: 5
                                currsigs.addElement(enableFiller1);
                                if(fillerDone1.getprestatus()){//sysj\turntableController.sysj line: 95, column: 13
                                  d1_thread_1 = true;//sysj\turntableController.sysj line: 95, column: 27
                                  if(!d2_thread_1){//sysj\turntableController.sysj line: 97, column: 7
                                    enableFiller2.setPresent();//sysj\turntableController.sysj line: 98, column: 5
                                    currsigs.addElement(enableFiller2);
                                    if(fillerDone2.getprestatus()){//sysj\turntableController.sysj line: 99, column: 13
                                      d2_thread_1 = true;//sysj\turntableController.sysj line: 99, column: 27
                                      if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                        enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                        currsigs.addElement(enableLid);
                                        if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                          d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                          if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                            enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                            currsigs.addElement(enableCapper);
                                            if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                              d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                              active[1]=1;
                                              ends[1]=1;
                                              break RUN;
                                            }
                                            else {
                                              active[1]=1;
                                              ends[1]=1;
                                              break RUN;
                                            }
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                            enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                            currsigs.addElement(enableCapper);
                                            if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                              d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                              active[1]=1;
                                              ends[1]=1;
                                              break RUN;
                                            }
                                            else {
                                              active[1]=1;
                                              ends[1]=1;
                                              break RUN;
                                            }
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                      }
                                      else {
                                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                          currsigs.addElement(enableCapper);
                                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                    }
                                    else {
                                      if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                        enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                        currsigs.addElement(enableLid);
                                        if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                          d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                          if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                            enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                            currsigs.addElement(enableCapper);
                                            if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                              d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                              active[1]=1;
                                              ends[1]=1;
                                              break RUN;
                                            }
                                            else {
                                              active[1]=1;
                                              ends[1]=1;
                                              break RUN;
                                            }
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                            enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                            currsigs.addElement(enableCapper);
                                            if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                              d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                              active[1]=1;
                                              ends[1]=1;
                                              break RUN;
                                            }
                                            else {
                                              active[1]=1;
                                              ends[1]=1;
                                              break RUN;
                                            }
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                      }
                                      else {
                                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                          currsigs.addElement(enableCapper);
                                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                    }
                                  }
                                  else {
                                    if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                      enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                      currsigs.addElement(enableLid);
                                      if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                        d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                          currsigs.addElement(enableCapper);
                                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                          currsigs.addElement(enableCapper);
                                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                    }
                                    else {
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                  }
                                }
                                else {
                                  if(!d2_thread_1){//sysj\turntableController.sysj line: 97, column: 7
                                    enableFiller2.setPresent();//sysj\turntableController.sysj line: 98, column: 5
                                    currsigs.addElement(enableFiller2);
                                    if(fillerDone2.getprestatus()){//sysj\turntableController.sysj line: 99, column: 13
                                      d2_thread_1 = true;//sysj\turntableController.sysj line: 99, column: 27
                                      if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                        enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                        currsigs.addElement(enableLid);
                                        if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                          d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                          if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                            enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                            currsigs.addElement(enableCapper);
                                            if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                              d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                              active[1]=1;
                                              ends[1]=1;
                                              break RUN;
                                            }
                                            else {
                                              active[1]=1;
                                              ends[1]=1;
                                              break RUN;
                                            }
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                            enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                            currsigs.addElement(enableCapper);
                                            if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                              d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                              active[1]=1;
                                              ends[1]=1;
                                              break RUN;
                                            }
                                            else {
                                              active[1]=1;
                                              ends[1]=1;
                                              break RUN;
                                            }
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                      }
                                      else {
                                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                          currsigs.addElement(enableCapper);
                                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                    }
                                    else {
                                      if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                        enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                        currsigs.addElement(enableLid);
                                        if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                          d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                          if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                            enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                            currsigs.addElement(enableCapper);
                                            if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                              d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                              active[1]=1;
                                              ends[1]=1;
                                              break RUN;
                                            }
                                            else {
                                              active[1]=1;
                                              ends[1]=1;
                                              break RUN;
                                            }
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                            enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                            currsigs.addElement(enableCapper);
                                            if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                              d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                              active[1]=1;
                                              ends[1]=1;
                                              break RUN;
                                            }
                                            else {
                                              active[1]=1;
                                              ends[1]=1;
                                              break RUN;
                                            }
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                      }
                                      else {
                                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                          currsigs.addElement(enableCapper);
                                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                    }
                                  }
                                  else {
                                    if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                      enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                      currsigs.addElement(enableLid);
                                      if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                        d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                          currsigs.addElement(enableCapper);
                                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                          currsigs.addElement(enableCapper);
                                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                    }
                                    else {
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                  }
                                }
                              }
                              else {
                                if(!d2_thread_1){//sysj\turntableController.sysj line: 97, column: 7
                                  enableFiller2.setPresent();//sysj\turntableController.sysj line: 98, column: 5
                                  currsigs.addElement(enableFiller2);
                                  if(fillerDone2.getprestatus()){//sysj\turntableController.sysj line: 99, column: 13
                                    d2_thread_1 = true;//sysj\turntableController.sysj line: 99, column: 27
                                    if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                      enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                      currsigs.addElement(enableLid);
                                      if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                        d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                          currsigs.addElement(enableCapper);
                                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                          currsigs.addElement(enableCapper);
                                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                    }
                                    else {
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                  }
                                  else {
                                    if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                      enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                      currsigs.addElement(enableLid);
                                      if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                        d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                          currsigs.addElement(enableCapper);
                                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                          currsigs.addElement(enableCapper);
                                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                    }
                                    else {
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                  }
                                }
                                else {
                                  if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                    enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                    currsigs.addElement(enableLid);
                                    if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                      d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                  }
                                  else {
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                }
                              }
                            }
                            else {
                              ends[1]=2;
                              ;//sysj\turntableController.sysj line: 92, column: 3
                              rotaryTrigger.setPresent();//sysj\turntableController.sysj line: 113, column: 3
                              currsigs.addElement(rotaryTrigger);
                              S4709=5;
                              active[1]=1;
                              ends[1]=1;
                              break RUN;
                            }
                          }
                        }
                      }
                    }
                    else {
                      S4709=3;
                      if(got_thread_1){//sysj\turntableController.sysj line: 79, column: 3
                        loadPos1.setPresent();//sysj\turntableController.sysj line: 80, column: 4
                        currsigs.addElement(loadPos1);
                        bottleTaken.setPresent();//sysj\turntableController.sysj line: 80, column: 19
                        currsigs.addElement(bottleTaken);
                        S4846=0;
                        active[1]=1;
                        ends[1]=1;
                        break RUN;
                      }
                      else {
                        d1_thread_1 = !m_thread_1.at(1);//sysj\turntableController.sysj line: 87, column: 3
                        d2_thread_1 = !m_thread_1.at(2);//sysj\turntableController.sysj line: 88, column: 3
                        d3_thread_1 = !m_thread_1.at(3);//sysj\turntableController.sysj line: 89, column: 3
                        d4_thread_1 = !m_thread_1.at(4);//sysj\turntableController.sysj line: 90, column: 3
                        S4709=4;
                        if(!(d1_thread_1 && d2_thread_1 && d3_thread_1 && d4_thread_1)){//sysj\turntableController.sysj line: 92, column: 9
                          if(!d1_thread_1){//sysj\turntableController.sysj line: 93, column: 7
                            enableFiller1.setPresent();//sysj\turntableController.sysj line: 94, column: 5
                            currsigs.addElement(enableFiller1);
                            if(fillerDone1.getprestatus()){//sysj\turntableController.sysj line: 95, column: 13
                              d1_thread_1 = true;//sysj\turntableController.sysj line: 95, column: 27
                              if(!d2_thread_1){//sysj\turntableController.sysj line: 97, column: 7
                                enableFiller2.setPresent();//sysj\turntableController.sysj line: 98, column: 5
                                currsigs.addElement(enableFiller2);
                                if(fillerDone2.getprestatus()){//sysj\turntableController.sysj line: 99, column: 13
                                  d2_thread_1 = true;//sysj\turntableController.sysj line: 99, column: 27
                                  if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                    enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                    currsigs.addElement(enableLid);
                                    if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                      d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                  }
                                  else {
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                }
                                else {
                                  if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                    enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                    currsigs.addElement(enableLid);
                                    if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                      d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                  }
                                  else {
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                }
                              }
                              else {
                                if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                  enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                  currsigs.addElement(enableLid);
                                  if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                    d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                }
                                else {
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                              }
                            }
                            else {
                              if(!d2_thread_1){//sysj\turntableController.sysj line: 97, column: 7
                                enableFiller2.setPresent();//sysj\turntableController.sysj line: 98, column: 5
                                currsigs.addElement(enableFiller2);
                                if(fillerDone2.getprestatus()){//sysj\turntableController.sysj line: 99, column: 13
                                  d2_thread_1 = true;//sysj\turntableController.sysj line: 99, column: 27
                                  if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                    enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                    currsigs.addElement(enableLid);
                                    if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                      d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                  }
                                  else {
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                }
                                else {
                                  if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                    enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                    currsigs.addElement(enableLid);
                                    if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                      d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                  }
                                  else {
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                }
                              }
                              else {
                                if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                  enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                  currsigs.addElement(enableLid);
                                  if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                    d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                }
                                else {
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                              }
                            }
                          }
                          else {
                            if(!d2_thread_1){//sysj\turntableController.sysj line: 97, column: 7
                              enableFiller2.setPresent();//sysj\turntableController.sysj line: 98, column: 5
                              currsigs.addElement(enableFiller2);
                              if(fillerDone2.getprestatus()){//sysj\turntableController.sysj line: 99, column: 13
                                d2_thread_1 = true;//sysj\turntableController.sysj line: 99, column: 27
                                if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                  enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                  currsigs.addElement(enableLid);
                                  if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                    d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                }
                                else {
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                              }
                              else {
                                if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                  enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                  currsigs.addElement(enableLid);
                                  if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                    d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                }
                                else {
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                              }
                            }
                            else {
                              if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                currsigs.addElement(enableLid);
                                if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                  d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                              }
                              else {
                                if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                  enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                  currsigs.addElement(enableCapper);
                                  if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                    d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                            }
                          }
                        }
                        else {
                          ends[1]=2;
                          ;//sysj\turntableController.sysj line: 92, column: 3
                          rotaryTrigger.setPresent();//sysj\turntableController.sysj line: 113, column: 3
                          currsigs.addElement(rotaryTrigger);
                          S4709=5;
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                  }
                }
                else {
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
              }
              else {
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
            
            case 7 : 
              if(tableAligned.getprestatus()){//sysj\turntableController.sysj line: 116, column: 19
                m_thread_1.index();//sysj\turntableController.sysj line: 118, column: 3
                m_thread_1.report();//sysj\turntableController.sysj line: 119, column: 3
                S4709=0;
                if(tableAligned.getprestatus()){//sysj\turntableController.sysj line: 46, column: 19
                  S4709=1;
                  if(m_thread_1.exitOccupied()){//sysj\turntableController.sysj line: 49, column: 3
                    m_thread_1.sayUnloading();//sysj\turntableController.sysj line: 50, column: 4
                    unloadExit.setPresent();//sysj\turntableController.sysj line: 51, column: 4
                    currsigs.addElement(unloadExit);
                    bottleFromTable.setPresent();//sysj\turntableController.sysj line: 51, column: 21
                    currsigs.addElement(bottleFromTable);
                    S4703=0;
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                  else {
                    got_thread_1 = false;//sysj\turntableController.sysj line: 57, column: 3
                    S4709=2;
                    if(m_thread_1.loadPointFree()){//sysj\turntableController.sysj line: 58, column: 3
                      if(!m_thread_1.anyOccupied()){//sysj\turntableController.sysj line: 59, column: 7
                        S4742=0;
                        tableReady.setPresent();//sysj\turntableController.sysj line: 62, column: 6
                        currsigs.addElement(tableReady);
                        active[1]=1;
                        ends[1]=1;
                        break RUN;
                      }
                      else {
                        S4742=1;
                        w_thread_1 = OFFERWIN_thread_1;//sysj\turntableController.sysj line: 69, column: 5
                        if(w_thread_1 > 0){//sysj\turntableController.sysj line: 70, column: 11
                          tableReady.setPresent();//sysj\turntableController.sysj line: 71, column: 6
                          currsigs.addElement(tableReady);
                          S4717=0;
                          if(bottleToTable.getprestatus()){//sysj\turntableController.sysj line: 72, column: 14
                            got_thread_1 = true;//sysj\turntableController.sysj line: 72, column: 30
                            if(got_thread_1) {//sysj\turntableController.sysj line: 73, column: 13
                              w_thread_1 = 0;//sysj\turntableController.sysj line: 73, column: 15
                            }
                            else {//sysj\turntableController.sysj line: 73, column: 29
                              w_thread_1 = w_thread_1 - 1;//sysj\turntableController.sysj line: 73, column: 31
                            }
                            S4717=1;
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(got_thread_1) {//sysj\turntableController.sysj line: 73, column: 13
                              w_thread_1 = 0;//sysj\turntableController.sysj line: 73, column: 15
                            }
                            else {//sysj\turntableController.sysj line: 73, column: 29
                              w_thread_1 = w_thread_1 - 1;//sysj\turntableController.sysj line: 73, column: 31
                            }
                            S4717=1;
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          ends[1]=2;
                          ;//sysj\turntableController.sysj line: 70, column: 5
                          S4709=3;
                          if(got_thread_1){//sysj\turntableController.sysj line: 79, column: 3
                            loadPos1.setPresent();//sysj\turntableController.sysj line: 80, column: 4
                            currsigs.addElement(loadPos1);
                            bottleTaken.setPresent();//sysj\turntableController.sysj line: 80, column: 19
                            currsigs.addElement(bottleTaken);
                            S4846=0;
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            d1_thread_1 = !m_thread_1.at(1);//sysj\turntableController.sysj line: 87, column: 3
                            d2_thread_1 = !m_thread_1.at(2);//sysj\turntableController.sysj line: 88, column: 3
                            d3_thread_1 = !m_thread_1.at(3);//sysj\turntableController.sysj line: 89, column: 3
                            d4_thread_1 = !m_thread_1.at(4);//sysj\turntableController.sysj line: 90, column: 3
                            S4709=4;
                            if(!(d1_thread_1 && d2_thread_1 && d3_thread_1 && d4_thread_1)){//sysj\turntableController.sysj line: 92, column: 9
                              if(!d1_thread_1){//sysj\turntableController.sysj line: 93, column: 7
                                enableFiller1.setPresent();//sysj\turntableController.sysj line: 94, column: 5
                                currsigs.addElement(enableFiller1);
                                if(fillerDone1.getprestatus()){//sysj\turntableController.sysj line: 95, column: 13
                                  d1_thread_1 = true;//sysj\turntableController.sysj line: 95, column: 27
                                  if(!d2_thread_1){//sysj\turntableController.sysj line: 97, column: 7
                                    enableFiller2.setPresent();//sysj\turntableController.sysj line: 98, column: 5
                                    currsigs.addElement(enableFiller2);
                                    if(fillerDone2.getprestatus()){//sysj\turntableController.sysj line: 99, column: 13
                                      d2_thread_1 = true;//sysj\turntableController.sysj line: 99, column: 27
                                      if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                        enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                        currsigs.addElement(enableLid);
                                        if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                          d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                          if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                            enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                            currsigs.addElement(enableCapper);
                                            if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                              d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                              active[1]=1;
                                              ends[1]=1;
                                              break RUN;
                                            }
                                            else {
                                              active[1]=1;
                                              ends[1]=1;
                                              break RUN;
                                            }
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                            enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                            currsigs.addElement(enableCapper);
                                            if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                              d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                              active[1]=1;
                                              ends[1]=1;
                                              break RUN;
                                            }
                                            else {
                                              active[1]=1;
                                              ends[1]=1;
                                              break RUN;
                                            }
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                      }
                                      else {
                                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                          currsigs.addElement(enableCapper);
                                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                    }
                                    else {
                                      if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                        enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                        currsigs.addElement(enableLid);
                                        if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                          d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                          if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                            enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                            currsigs.addElement(enableCapper);
                                            if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                              d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                              active[1]=1;
                                              ends[1]=1;
                                              break RUN;
                                            }
                                            else {
                                              active[1]=1;
                                              ends[1]=1;
                                              break RUN;
                                            }
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                            enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                            currsigs.addElement(enableCapper);
                                            if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                              d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                              active[1]=1;
                                              ends[1]=1;
                                              break RUN;
                                            }
                                            else {
                                              active[1]=1;
                                              ends[1]=1;
                                              break RUN;
                                            }
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                      }
                                      else {
                                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                          currsigs.addElement(enableCapper);
                                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                    }
                                  }
                                  else {
                                    if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                      enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                      currsigs.addElement(enableLid);
                                      if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                        d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                          currsigs.addElement(enableCapper);
                                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                          currsigs.addElement(enableCapper);
                                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                    }
                                    else {
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                  }
                                }
                                else {
                                  if(!d2_thread_1){//sysj\turntableController.sysj line: 97, column: 7
                                    enableFiller2.setPresent();//sysj\turntableController.sysj line: 98, column: 5
                                    currsigs.addElement(enableFiller2);
                                    if(fillerDone2.getprestatus()){//sysj\turntableController.sysj line: 99, column: 13
                                      d2_thread_1 = true;//sysj\turntableController.sysj line: 99, column: 27
                                      if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                        enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                        currsigs.addElement(enableLid);
                                        if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                          d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                          if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                            enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                            currsigs.addElement(enableCapper);
                                            if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                              d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                              active[1]=1;
                                              ends[1]=1;
                                              break RUN;
                                            }
                                            else {
                                              active[1]=1;
                                              ends[1]=1;
                                              break RUN;
                                            }
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                            enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                            currsigs.addElement(enableCapper);
                                            if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                              d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                              active[1]=1;
                                              ends[1]=1;
                                              break RUN;
                                            }
                                            else {
                                              active[1]=1;
                                              ends[1]=1;
                                              break RUN;
                                            }
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                      }
                                      else {
                                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                          currsigs.addElement(enableCapper);
                                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                    }
                                    else {
                                      if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                        enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                        currsigs.addElement(enableLid);
                                        if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                          d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                          if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                            enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                            currsigs.addElement(enableCapper);
                                            if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                              d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                              active[1]=1;
                                              ends[1]=1;
                                              break RUN;
                                            }
                                            else {
                                              active[1]=1;
                                              ends[1]=1;
                                              break RUN;
                                            }
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                            enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                            currsigs.addElement(enableCapper);
                                            if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                              d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                              active[1]=1;
                                              ends[1]=1;
                                              break RUN;
                                            }
                                            else {
                                              active[1]=1;
                                              ends[1]=1;
                                              break RUN;
                                            }
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                      }
                                      else {
                                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                          currsigs.addElement(enableCapper);
                                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                    }
                                  }
                                  else {
                                    if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                      enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                      currsigs.addElement(enableLid);
                                      if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                        d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                          currsigs.addElement(enableCapper);
                                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                          currsigs.addElement(enableCapper);
                                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                    }
                                    else {
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                  }
                                }
                              }
                              else {
                                if(!d2_thread_1){//sysj\turntableController.sysj line: 97, column: 7
                                  enableFiller2.setPresent();//sysj\turntableController.sysj line: 98, column: 5
                                  currsigs.addElement(enableFiller2);
                                  if(fillerDone2.getprestatus()){//sysj\turntableController.sysj line: 99, column: 13
                                    d2_thread_1 = true;//sysj\turntableController.sysj line: 99, column: 27
                                    if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                      enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                      currsigs.addElement(enableLid);
                                      if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                        d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                          currsigs.addElement(enableCapper);
                                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                          currsigs.addElement(enableCapper);
                                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                    }
                                    else {
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                  }
                                  else {
                                    if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                      enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                      currsigs.addElement(enableLid);
                                      if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                        d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                          currsigs.addElement(enableCapper);
                                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                          enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                          currsigs.addElement(enableCapper);
                                          if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                            d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                          else {
                                            active[1]=1;
                                            ends[1]=1;
                                            break RUN;
                                          }
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                    }
                                    else {
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                  }
                                }
                                else {
                                  if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                    enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                    currsigs.addElement(enableLid);
                                    if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                      d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                  }
                                  else {
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                }
                              }
                            }
                            else {
                              ends[1]=2;
                              ;//sysj\turntableController.sysj line: 92, column: 3
                              rotaryTrigger.setPresent();//sysj\turntableController.sysj line: 113, column: 3
                              currsigs.addElement(rotaryTrigger);
                              S4709=5;
                              active[1]=1;
                              ends[1]=1;
                              break RUN;
                            }
                          }
                        }
                      }
                    }
                    else {
                      S4709=3;
                      if(got_thread_1){//sysj\turntableController.sysj line: 79, column: 3
                        loadPos1.setPresent();//sysj\turntableController.sysj line: 80, column: 4
                        currsigs.addElement(loadPos1);
                        bottleTaken.setPresent();//sysj\turntableController.sysj line: 80, column: 19
                        currsigs.addElement(bottleTaken);
                        S4846=0;
                        active[1]=1;
                        ends[1]=1;
                        break RUN;
                      }
                      else {
                        d1_thread_1 = !m_thread_1.at(1);//sysj\turntableController.sysj line: 87, column: 3
                        d2_thread_1 = !m_thread_1.at(2);//sysj\turntableController.sysj line: 88, column: 3
                        d3_thread_1 = !m_thread_1.at(3);//sysj\turntableController.sysj line: 89, column: 3
                        d4_thread_1 = !m_thread_1.at(4);//sysj\turntableController.sysj line: 90, column: 3
                        S4709=4;
                        if(!(d1_thread_1 && d2_thread_1 && d3_thread_1 && d4_thread_1)){//sysj\turntableController.sysj line: 92, column: 9
                          if(!d1_thread_1){//sysj\turntableController.sysj line: 93, column: 7
                            enableFiller1.setPresent();//sysj\turntableController.sysj line: 94, column: 5
                            currsigs.addElement(enableFiller1);
                            if(fillerDone1.getprestatus()){//sysj\turntableController.sysj line: 95, column: 13
                              d1_thread_1 = true;//sysj\turntableController.sysj line: 95, column: 27
                              if(!d2_thread_1){//sysj\turntableController.sysj line: 97, column: 7
                                enableFiller2.setPresent();//sysj\turntableController.sysj line: 98, column: 5
                                currsigs.addElement(enableFiller2);
                                if(fillerDone2.getprestatus()){//sysj\turntableController.sysj line: 99, column: 13
                                  d2_thread_1 = true;//sysj\turntableController.sysj line: 99, column: 27
                                  if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                    enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                    currsigs.addElement(enableLid);
                                    if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                      d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                  }
                                  else {
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                }
                                else {
                                  if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                    enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                    currsigs.addElement(enableLid);
                                    if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                      d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                  }
                                  else {
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                }
                              }
                              else {
                                if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                  enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                  currsigs.addElement(enableLid);
                                  if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                    d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                }
                                else {
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                              }
                            }
                            else {
                              if(!d2_thread_1){//sysj\turntableController.sysj line: 97, column: 7
                                enableFiller2.setPresent();//sysj\turntableController.sysj line: 98, column: 5
                                currsigs.addElement(enableFiller2);
                                if(fillerDone2.getprestatus()){//sysj\turntableController.sysj line: 99, column: 13
                                  d2_thread_1 = true;//sysj\turntableController.sysj line: 99, column: 27
                                  if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                    enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                    currsigs.addElement(enableLid);
                                    if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                      d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                  }
                                  else {
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                }
                                else {
                                  if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                    enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                    currsigs.addElement(enableLid);
                                    if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                      d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                        enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                        currsigs.addElement(enableCapper);
                                        if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                          d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                        else {
                                          active[1]=1;
                                          ends[1]=1;
                                          break RUN;
                                        }
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                  }
                                  else {
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                }
                              }
                              else {
                                if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                  enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                  currsigs.addElement(enableLid);
                                  if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                    d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                }
                                else {
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                              }
                            }
                          }
                          else {
                            if(!d2_thread_1){//sysj\turntableController.sysj line: 97, column: 7
                              enableFiller2.setPresent();//sysj\turntableController.sysj line: 98, column: 5
                              currsigs.addElement(enableFiller2);
                              if(fillerDone2.getprestatus()){//sysj\turntableController.sysj line: 99, column: 13
                                d2_thread_1 = true;//sysj\turntableController.sysj line: 99, column: 27
                                if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                  enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                  currsigs.addElement(enableLid);
                                  if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                    d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                }
                                else {
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                              }
                              else {
                                if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                  enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                  currsigs.addElement(enableLid);
                                  if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                    d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                      enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                      currsigs.addElement(enableCapper);
                                      if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                        d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                      else {
                                        active[1]=1;
                                        ends[1]=1;
                                        break RUN;
                                      }
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                }
                                else {
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                              }
                            }
                            else {
                              if(!d3_thread_1){//sysj\turntableController.sysj line: 101, column: 7
                                enableLid.setPresent();//sysj\turntableController.sysj line: 102, column: 5
                                currsigs.addElement(enableLid);
                                if(lidDone.getprestatus()){//sysj\turntableController.sysj line: 103, column: 13
                                  d3_thread_1 = true;//sysj\turntableController.sysj line: 103, column: 23
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                    enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                    currsigs.addElement(enableCapper);
                                    if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                      d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                    else {
                                      active[1]=1;
                                      ends[1]=1;
                                      break RUN;
                                    }
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                              }
                              else {
                                if(!d4_thread_1){//sysj\turntableController.sysj line: 105, column: 7
                                  enableCapper.setPresent();//sysj\turntableController.sysj line: 106, column: 5
                                  currsigs.addElement(enableCapper);
                                  if(capperDone.getprestatus()){//sysj\turntableController.sysj line: 107, column: 13
                                    d4_thread_1 = true;//sysj\turntableController.sysj line: 107, column: 26
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  active[1]=1;
                                  ends[1]=1;
                                  break RUN;
                                }
                              }
                            }
                          }
                        }
                        else {
                          ends[1]=2;
                          ;//sysj\turntableController.sysj line: 92, column: 3
                          rotaryTrigger.setPresent();//sysj\turntableController.sysj line: 113, column: 3
                          currsigs.addElement(rotaryTrigger);
                          S4709=5;
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                  }
                }
                else {
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
              }
              else {
                active[1]=1;
                ends[1]=1;
                break RUN;
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
          bottleToTable.gethook();
          tableAligned.gethook();
          bottleAtPos1.gethook();
          bottleAtPos2.gethook();
          bottleAtPos4.gethook();
          bottleAtPos6.gethook();
          fillerDone1.gethook();
          fillerDone2.gethook();
          lidDone.gethook();
          capperDone.gethook();
          df = true;
        }
        runClockDomain();
      }
      bottleToTable.setpreclear();
      tableAligned.setpreclear();
      bottleAtPos1.setpreclear();
      bottleAtPos2.setpreclear();
      bottleAtPos4.setpreclear();
      bottleAtPos6.setpreclear();
      fillerDone1.setpreclear();
      fillerDone2.setpreclear();
      lidDone.setpreclear();
      capperDone.setpreclear();
      tableReady.setpreclear();
      bottleFromTable.setpreclear();
      bottleTaken.setpreclear();
      rotaryTrigger.setpreclear();
      loadPos1.setpreclear();
      unloadExit.setpreclear();
      enableFiller1.setpreclear();
      enableFiller2.setpreclear();
      enableLid.setpreclear();
      enableCapper.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = bottleToTable.getStatus() ? bottleToTable.setprepresent() : bottleToTable.setpreclear();
      bottleToTable.setpreval(bottleToTable.getValue());
      bottleToTable.setClear();
      dummyint = tableAligned.getStatus() ? tableAligned.setprepresent() : tableAligned.setpreclear();
      tableAligned.setpreval(tableAligned.getValue());
      tableAligned.setClear();
      dummyint = bottleAtPos1.getStatus() ? bottleAtPos1.setprepresent() : bottleAtPos1.setpreclear();
      bottleAtPos1.setpreval(bottleAtPos1.getValue());
      bottleAtPos1.setClear();
      dummyint = bottleAtPos2.getStatus() ? bottleAtPos2.setprepresent() : bottleAtPos2.setpreclear();
      bottleAtPos2.setpreval(bottleAtPos2.getValue());
      bottleAtPos2.setClear();
      dummyint = bottleAtPos4.getStatus() ? bottleAtPos4.setprepresent() : bottleAtPos4.setpreclear();
      bottleAtPos4.setpreval(bottleAtPos4.getValue());
      bottleAtPos4.setClear();
      dummyint = bottleAtPos6.getStatus() ? bottleAtPos6.setprepresent() : bottleAtPos6.setpreclear();
      bottleAtPos6.setpreval(bottleAtPos6.getValue());
      bottleAtPos6.setClear();
      dummyint = fillerDone1.getStatus() ? fillerDone1.setprepresent() : fillerDone1.setpreclear();
      fillerDone1.setpreval(fillerDone1.getValue());
      fillerDone1.setClear();
      dummyint = fillerDone2.getStatus() ? fillerDone2.setprepresent() : fillerDone2.setpreclear();
      fillerDone2.setpreval(fillerDone2.getValue());
      fillerDone2.setClear();
      dummyint = lidDone.getStatus() ? lidDone.setprepresent() : lidDone.setpreclear();
      lidDone.setpreval(lidDone.getValue());
      lidDone.setClear();
      dummyint = capperDone.getStatus() ? capperDone.setprepresent() : capperDone.setpreclear();
      capperDone.setpreval(capperDone.getValue());
      capperDone.setClear();
      tableReady.sethook();
      tableReady.setClear();
      bottleFromTable.sethook();
      bottleFromTable.setClear();
      bottleTaken.sethook();
      bottleTaken.setClear();
      rotaryTrigger.sethook();
      rotaryTrigger.setClear();
      loadPos1.sethook();
      loadPos1.setClear();
      unloadExit.sethook();
      unloadExit.setClear();
      enableFiller1.sethook();
      enableFiller1.setClear();
      enableFiller2.sethook();
      enableFiller2.setClear();
      enableLid.sethook();
      enableLid.setClear();
      enableCapper.sethook();
      enableCapper.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        bottleToTable.gethook();
        tableAligned.gethook();
        bottleAtPos1.gethook();
        bottleAtPos2.gethook();
        bottleAtPos4.gethook();
        bottleAtPos6.gethook();
        fillerDone1.gethook();
        fillerDone2.gethook();
        lidDone.gethook();
        capperDone.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
