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
  public Signal tableAligned = new Signal("tableAligned", Signal.INPUT);
  public Signal bottleAtPos1 = new Signal("bottleAtPos1", Signal.INPUT);
  public Signal bottleAtPos2 = new Signal("bottleAtPos2", Signal.INPUT);
  public Signal bottleAtPos4 = new Signal("bottleAtPos4", Signal.INPUT);
  public Signal bottleAtPos5 = new Signal("bottleAtPos5", Signal.INPUT);
  public Signal exitCleared = new Signal("exitCleared", Signal.INPUT);
  public Signal rotaryTrigger = new Signal("rotaryTrigger", Signal.OUTPUT);
  public Signal loadPos1 = new Signal("loadPos1", Signal.OUTPUT);
  public Signal unloadExit = new Signal("unloadExit", Signal.OUTPUT);
  public input_Channel tableInfeed_in = new input_Channel();
  public input_Channel doneFiller1_in = new input_Channel();
  public input_Channel doneFiller2_in = new input_Channel();
  public input_Channel doneLid_in = new input_Channel();
  public input_Channel doneCapper_in = new input_Channel();
  public output_Channel tableOutfeed_o = new output_Channel();
  public output_Channel startFiller1_o = new output_Channel();
  public output_Channel startFiller2_o = new output_Channel();
  public output_Channel startLid_o = new output_Channel();
  public output_Channel startCapper_o = new output_Channel();
  private Signal placed_1;
  private TableModel m_thread_2;//sysj/turntableController.sysj line: 56, column: 3
  private int exiting_thread_2;//sysj/turntableController.sysj line: 57, column: 3
  private TableModel m_thread_3;//sysj/turntableController.sysj line: 137, column: 3
  private int b_thread_3;//sysj/turntableController.sysj line: 138, column: 3
  private int S42359 = 1;
  private int S42193 = 1;
  private int S14096 = 1;
  private int S13910 = 1;
  private int S13917 = 1;
  private int S13912 = 1;
  private int S14141 = 1;
  private int S14239 = 1;
  private int S14234 = 1;
  private int S14613 = 1;
  private int S14608 = 1;
  private int S15031 = 1;
  private int S15026 = 1;
  private int S15493 = 1;
  private int S15488 = 1;
  private int S15999 = 1;
  private int S15994 = 1;
  private int S16549 = 1;
  private int S16544 = 1;
  private int S17143 = 1;
  private int S17138 = 1;
  private int S17781 = 1;
  private int S17776 = 1;
  private int S42357 = 1;
  private int S42217 = 1;
  private int S42201 = 1;
  private int S42196 = 1;
  
  private int[] ends = new int[4];
  private int[] tdone = new int[4];
  
  public void thread42365(int [] tdone, int [] ends){
        switch(S42357){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S42217){
          case 0 : 
            switch(S42201){
              case 0 : 
                if(!tableInfeed_in.isPartnerPresent() || tableInfeed_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 140, column: 4
                  tableInfeed_in.setACK(false);//sysj/turntableController.sysj line: 140, column: 4
                  S42201=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S42196){
                    case 0 : 
                      if(!tableInfeed_in.isREQ()){//sysj/turntableController.sysj line: 140, column: 4
                        tableInfeed_in.setACK(true);//sysj/turntableController.sysj line: 140, column: 4
                        S42196=1;
                        if(tableInfeed_in.isREQ()){//sysj/turntableController.sysj line: 140, column: 4
                          tableInfeed_in.setACK(false);//sysj/turntableController.sysj line: 140, column: 4
                          ends[3]=2;
                          ;//sysj/turntableController.sysj line: 140, column: 4
                          b_thread_3 = ((Integer)(tableInfeed_in.getVal() == null ? null : ((Integer)tableInfeed_in.getVal()))).intValue();//sysj/turntableController.sysj line: 141, column: 4
                          m_thread_3.setPending(b_thread_3);//sysj/turntableController.sysj line: 142, column: 4
                          System.out.println("[RT] Accepted bottle " + b_thread_3 + " from the conveyor.");//sysj/turntableController.sysj line: 143, column: 4
                          S42217=1;
                          if(placed_1.getprestatus()){//sysj/turntableController.sysj line: 144, column: 20
                            S42217=2;
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
                      else {
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(tableInfeed_in.isREQ()){//sysj/turntableController.sysj line: 140, column: 4
                        tableInfeed_in.setACK(false);//sysj/turntableController.sysj line: 140, column: 4
                        ends[3]=2;
                        ;//sysj/turntableController.sysj line: 140, column: 4
                        b_thread_3 = ((Integer)(tableInfeed_in.getVal() == null ? null : ((Integer)tableInfeed_in.getVal()))).intValue();//sysj/turntableController.sysj line: 141, column: 4
                        m_thread_3.setPending(b_thread_3);//sysj/turntableController.sysj line: 142, column: 4
                        System.out.println("[RT] Accepted bottle " + b_thread_3 + " from the conveyor.");//sysj/turntableController.sysj line: 143, column: 4
                        S42217=1;
                        if(placed_1.getprestatus()){//sysj/turntableController.sysj line: 144, column: 20
                          S42217=2;
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
                    
                  }
                }
                break;
              
              case 1 : 
                S42201=1;
                S42201=0;
                if(!tableInfeed_in.isPartnerPresent() || tableInfeed_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 140, column: 4
                  tableInfeed_in.setACK(false);//sysj/turntableController.sysj line: 140, column: 4
                  S42201=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S42196=0;
                  if(!tableInfeed_in.isREQ()){//sysj/turntableController.sysj line: 140, column: 4
                    tableInfeed_in.setACK(true);//sysj/turntableController.sysj line: 140, column: 4
                    S42196=1;
                    if(tableInfeed_in.isREQ()){//sysj/turntableController.sysj line: 140, column: 4
                      tableInfeed_in.setACK(false);//sysj/turntableController.sysj line: 140, column: 4
                      ends[3]=2;
                      ;//sysj/turntableController.sysj line: 140, column: 4
                      b_thread_3 = ((Integer)(tableInfeed_in.getVal() == null ? null : ((Integer)tableInfeed_in.getVal()))).intValue();//sysj/turntableController.sysj line: 141, column: 4
                      m_thread_3.setPending(b_thread_3);//sysj/turntableController.sysj line: 142, column: 4
                      System.out.println("[RT] Accepted bottle " + b_thread_3 + " from the conveyor.");//sysj/turntableController.sysj line: 143, column: 4
                      S42217=1;
                      if(placed_1.getprestatus()){//sysj/turntableController.sysj line: 144, column: 20
                        S42217=2;
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
            if(placed_1.getprestatus()){//sysj/turntableController.sysj line: 144, column: 20
              S42217=2;
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
          
          case 2 : 
            S42217=2;
            S42217=0;
            S42201=0;
            if(!tableInfeed_in.isPartnerPresent() || tableInfeed_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 140, column: 4
              tableInfeed_in.setACK(false);//sysj/turntableController.sysj line: 140, column: 4
              S42201=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S42196=0;
              if(!tableInfeed_in.isREQ()){//sysj/turntableController.sysj line: 140, column: 4
                tableInfeed_in.setACK(true);//sysj/turntableController.sysj line: 140, column: 4
                S42196=1;
                if(tableInfeed_in.isREQ()){//sysj/turntableController.sysj line: 140, column: 4
                  tableInfeed_in.setACK(false);//sysj/turntableController.sysj line: 140, column: 4
                  ends[3]=2;
                  ;//sysj/turntableController.sysj line: 140, column: 4
                  b_thread_3 = ((Integer)(tableInfeed_in.getVal() == null ? null : ((Integer)tableInfeed_in.getVal()))).intValue();//sysj/turntableController.sysj line: 141, column: 4
                  m_thread_3.setPending(b_thread_3);//sysj/turntableController.sysj line: 142, column: 4
                  System.out.println("[RT] Accepted bottle " + b_thread_3 + " from the conveyor.");//sysj/turntableController.sysj line: 143, column: 4
                  S42217=1;
                  if(placed_1.getprestatus()){//sysj/turntableController.sysj line: 144, column: 20
                    S42217=2;
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

  public void thread42364(int [] tdone, int [] ends){
        switch(S42193){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S14096){
          case 0 : 
            if(tableAligned.getprestatus()){//sysj/turntableController.sysj line: 61, column: 20
              S14096=1;
              if(m_thread_2.exitOccupied()){//sysj/turntableController.sysj line: 69, column: 4
                exiting_thread_2 = m_thread_2.exitId();//sysj/turntableController.sysj line: 70, column: 5
                m_thread_2.sayUnloading();//sysj/turntableController.sysj line: 71, column: 5
                S13910=0;
                S13917=0;
                if(!tableOutfeed_o.isPartnerPresent() || tableOutfeed_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 72, column: 5
                  tableOutfeed_o.setREQ(false);//sysj/turntableController.sysj line: 72, column: 5
                  S13917=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S13912=0;
                  if(tableOutfeed_o.isACK()){//sysj/turntableController.sysj line: 72, column: 5
                    tableOutfeed_o.setVal(exiting_thread_2);//sysj/turntableController.sysj line: 72, column: 5
                    S13912=1;
                    if(!tableOutfeed_o.isACK()){//sysj/turntableController.sysj line: 72, column: 5
                      tableOutfeed_o.setREQ(false);//sysj/turntableController.sysj line: 72, column: 5
                      ends[2]=2;
                      ;//sysj/turntableController.sysj line: 72, column: 5
                      S13910=1;
                      if(exitCleared.getprestatus()){//sysj/turntableController.sysj line: 73, column: 21
                        m_thread_2.clearExit();//sysj/turntableController.sysj line: 76, column: 5
                        S14096=2;
                        if(m_thread_2.idle()){//sysj/turntableController.sysj line: 82, column: 4
                          if(!m_thread_2.hasPending()){//sysj/turntableController.sysj line: 83, column: 11
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            ends[2]=2;
                            ;//sysj/turntableController.sysj line: 83, column: 5
                            S14096=3;
                            if(m_thread_2.readyToPlace()){//sysj/turntableController.sysj line: 85, column: 4
                              S14141=0;
                              if(bottleAtPos1.getprestatus()){//sysj/turntableController.sysj line: 86, column: 21
                                m_thread_2.commitPending();//sysj/turntableController.sysj line: 89, column: 5
                                placed_1.setPresent();//sysj/turntableController.sysj line: 90, column: 5
                                currsigs.addElement(placed_1);
                                S14141=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                loadPos1.setPresent();//sysj/turntableController.sysj line: 87, column: 6
                                currsigs.addElement(loadPos1);
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                            }
                            else {
                              S14096=4;
                              S14239=0;
                              if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 111, column: 4
                                startFiller1_o.setREQ(false);//sysj/turntableController.sysj line: 111, column: 4
                                S14239=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S14234=0;
                                if(startFiller1_o.isACK()){//sysj/turntableController.sysj line: 111, column: 4
                                  startFiller1_o.setVal(m_thread_2.idAt(1));//sysj/turntableController.sysj line: 111, column: 4
                                  S14234=1;
                                  if(!startFiller1_o.isACK()){//sysj/turntableController.sysj line: 111, column: 4
                                    startFiller1_o.setREQ(false);//sysj/turntableController.sysj line: 111, column: 4
                                    ends[2]=2;
                                    ;//sysj/turntableController.sysj line: 111, column: 4
                                    S14096=5;
                                    S14613=0;
                                    if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 112, column: 4
                                      startFiller2_o.setREQ(false);//sysj/turntableController.sysj line: 112, column: 4
                                      S14613=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S14608=0;
                                      if(startFiller2_o.isACK()){//sysj/turntableController.sysj line: 112, column: 4
                                        startFiller2_o.setVal(m_thread_2.idAt(2));//sysj/turntableController.sysj line: 112, column: 4
                                        S14608=1;
                                        if(!startFiller2_o.isACK()){//sysj/turntableController.sysj line: 112, column: 4
                                          startFiller2_o.setREQ(false);//sysj/turntableController.sysj line: 112, column: 4
                                          ends[2]=2;
                                          ;//sysj/turntableController.sysj line: 112, column: 4
                                          S14096=6;
                                          S15031=0;
                                          if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 113, column: 4
                                            startLid_o.setREQ(false);//sysj/turntableController.sysj line: 113, column: 4
                                            S15031=1;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S15026=0;
                                            if(startLid_o.isACK()){//sysj/turntableController.sysj line: 113, column: 4
                                              startLid_o.setVal(m_thread_2.idAt(3));//sysj/turntableController.sysj line: 113, column: 4
                                              S15026=1;
                                              if(!startLid_o.isACK()){//sysj/turntableController.sysj line: 113, column: 4
                                                startLid_o.setREQ(false);//sysj/turntableController.sysj line: 113, column: 4
                                                ends[2]=2;
                                                ;//sysj/turntableController.sysj line: 113, column: 4
                                                S14096=7;
                                                S15493=0;
                                                if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 114, column: 4
                                                  startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                                                  S15493=1;
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                                else {
                                                  S15488=0;
                                                  if(startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                                                    startCapper_o.setVal(m_thread_2.idAt(4));//sysj/turntableController.sysj line: 114, column: 4
                                                    S15488=1;
                                                    if(!startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                                                      startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                                                      ends[2]=2;
                                                      ;//sysj/turntableController.sysj line: 114, column: 4
                                                      S14096=8;
                                                      S15999=0;
                                                      if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 116, column: 4
                                                        doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                                        S15999=1;
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                      else {
                                                        S15994=0;
                                                        if(!doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                                          doneFiller1_in.setACK(true);//sysj/turntableController.sysj line: 116, column: 4
                                                          S15994=1;
                                                          if(doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                                            doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                                            ends[2]=2;
                                                            ;//sysj/turntableController.sysj line: 116, column: 4
                                                            S14096=9;
                                                            S16549=0;
                                                            if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 117, column: 4
                                                              doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                                              S16549=1;
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                            else {
                                                              S16544=0;
                                                              if(!doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                                                doneFiller2_in.setACK(true);//sysj/turntableController.sysj line: 117, column: 4
                                                                S16544=1;
                                                                if(doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                                                  doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                                                  ends[2]=2;
                                                                  ;//sysj/turntableController.sysj line: 117, column: 4
                                                                  S14096=10;
                                                                  S17143=0;
                                                                  if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 118, column: 4
                                                                    doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                                                    S17143=1;
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
                                                                  }
                                                                  else {
                                                                    S17138=0;
                                                                    if(!doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                                                      doneLid_in.setACK(true);//sysj/turntableController.sysj line: 118, column: 4
                                                                      S17138=1;
                                                                      if(doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                                                        doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                                                        ends[2]=2;
                                                                        ;//sysj/turntableController.sysj line: 118, column: 4
                                                                        S14096=11;
                                                                        S17781=0;
                                                                        if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 119, column: 4
                                                                          doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                                          S17781=1;
                                                                          active[2]=1;
                                                                          ends[2]=1;
                                                                          tdone[2]=1;
                                                                        }
                                                                        else {
                                                                          S17776=0;
                                                                          if(!doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                                            doneCapper_in.setACK(true);//sysj/turntableController.sysj line: 119, column: 4
                                                                            S17776=1;
                                                                            if(doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                                              doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                                              ends[2]=2;
                                                                              ;//sysj/turntableController.sysj line: 119, column: 4
                                                                              S14096=12;
                                                                              if(!tableAligned.getprestatus()){//sysj/turntableController.sysj line: 125, column: 20
                                                                                S14096=13;
                                                                                if(tableAligned.getprestatus()){//sysj/turntableController.sysj line: 128, column: 20
                                                                                  m_thread_2.index();//sysj/turntableController.sysj line: 130, column: 4
                                                                                  m_thread_2.report();//sysj/turntableController.sysj line: 131, column: 4
                                                                                  S14096=14;
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
                                                                                rotaryTrigger.setPresent();//sysj/turntableController.sysj line: 126, column: 5
                                                                                currsigs.addElement(rotaryTrigger);
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
                              }
                            }
                          }
                        }
                        else {
                          S14096=3;
                          if(m_thread_2.readyToPlace()){//sysj/turntableController.sysj line: 85, column: 4
                            S14141=0;
                            if(bottleAtPos1.getprestatus()){//sysj/turntableController.sysj line: 86, column: 21
                              m_thread_2.commitPending();//sysj/turntableController.sysj line: 89, column: 5
                              placed_1.setPresent();//sysj/turntableController.sysj line: 90, column: 5
                              currsigs.addElement(placed_1);
                              S14141=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              loadPos1.setPresent();//sysj/turntableController.sysj line: 87, column: 6
                              currsigs.addElement(loadPos1);
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                          }
                          else {
                            S14096=4;
                            S14239=0;
                            if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 111, column: 4
                              startFiller1_o.setREQ(false);//sysj/turntableController.sysj line: 111, column: 4
                              S14239=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S14234=0;
                              if(startFiller1_o.isACK()){//sysj/turntableController.sysj line: 111, column: 4
                                startFiller1_o.setVal(m_thread_2.idAt(1));//sysj/turntableController.sysj line: 111, column: 4
                                S14234=1;
                                if(!startFiller1_o.isACK()){//sysj/turntableController.sysj line: 111, column: 4
                                  startFiller1_o.setREQ(false);//sysj/turntableController.sysj line: 111, column: 4
                                  ends[2]=2;
                                  ;//sysj/turntableController.sysj line: 111, column: 4
                                  S14096=5;
                                  S14613=0;
                                  if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 112, column: 4
                                    startFiller2_o.setREQ(false);//sysj/turntableController.sysj line: 112, column: 4
                                    S14613=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S14608=0;
                                    if(startFiller2_o.isACK()){//sysj/turntableController.sysj line: 112, column: 4
                                      startFiller2_o.setVal(m_thread_2.idAt(2));//sysj/turntableController.sysj line: 112, column: 4
                                      S14608=1;
                                      if(!startFiller2_o.isACK()){//sysj/turntableController.sysj line: 112, column: 4
                                        startFiller2_o.setREQ(false);//sysj/turntableController.sysj line: 112, column: 4
                                        ends[2]=2;
                                        ;//sysj/turntableController.sysj line: 112, column: 4
                                        S14096=6;
                                        S15031=0;
                                        if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 113, column: 4
                                          startLid_o.setREQ(false);//sysj/turntableController.sysj line: 113, column: 4
                                          S15031=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S15026=0;
                                          if(startLid_o.isACK()){//sysj/turntableController.sysj line: 113, column: 4
                                            startLid_o.setVal(m_thread_2.idAt(3));//sysj/turntableController.sysj line: 113, column: 4
                                            S15026=1;
                                            if(!startLid_o.isACK()){//sysj/turntableController.sysj line: 113, column: 4
                                              startLid_o.setREQ(false);//sysj/turntableController.sysj line: 113, column: 4
                                              ends[2]=2;
                                              ;//sysj/turntableController.sysj line: 113, column: 4
                                              S14096=7;
                                              S15493=0;
                                              if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 114, column: 4
                                                startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                                                S15493=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S15488=0;
                                                if(startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                                                  startCapper_o.setVal(m_thread_2.idAt(4));//sysj/turntableController.sysj line: 114, column: 4
                                                  S15488=1;
                                                  if(!startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                                                    startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                                                    ends[2]=2;
                                                    ;//sysj/turntableController.sysj line: 114, column: 4
                                                    S14096=8;
                                                    S15999=0;
                                                    if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 116, column: 4
                                                      doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                                      S15999=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S15994=0;
                                                      if(!doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                                        doneFiller1_in.setACK(true);//sysj/turntableController.sysj line: 116, column: 4
                                                        S15994=1;
                                                        if(doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                                          doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                                          ends[2]=2;
                                                          ;//sysj/turntableController.sysj line: 116, column: 4
                                                          S14096=9;
                                                          S16549=0;
                                                          if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 117, column: 4
                                                            doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                                            S16549=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S16544=0;
                                                            if(!doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                                              doneFiller2_in.setACK(true);//sysj/turntableController.sysj line: 117, column: 4
                                                              S16544=1;
                                                              if(doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                                                doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                                                ends[2]=2;
                                                                ;//sysj/turntableController.sysj line: 117, column: 4
                                                                S14096=10;
                                                                S17143=0;
                                                                if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 118, column: 4
                                                                  doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                                                  S17143=1;
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                                else {
                                                                  S17138=0;
                                                                  if(!doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                                                    doneLid_in.setACK(true);//sysj/turntableController.sysj line: 118, column: 4
                                                                    S17138=1;
                                                                    if(doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                                                      doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                                                      ends[2]=2;
                                                                      ;//sysj/turntableController.sysj line: 118, column: 4
                                                                      S14096=11;
                                                                      S17781=0;
                                                                      if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 119, column: 4
                                                                        doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                                        S17781=1;
                                                                        active[2]=1;
                                                                        ends[2]=1;
                                                                        tdone[2]=1;
                                                                      }
                                                                      else {
                                                                        S17776=0;
                                                                        if(!doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                                          doneCapper_in.setACK(true);//sysj/turntableController.sysj line: 119, column: 4
                                                                          S17776=1;
                                                                          if(doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                                            doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                                            ends[2]=2;
                                                                            ;//sysj/turntableController.sysj line: 119, column: 4
                                                                            S14096=12;
                                                                            if(!tableAligned.getprestatus()){//sysj/turntableController.sysj line: 125, column: 20
                                                                              S14096=13;
                                                                              if(tableAligned.getprestatus()){//sysj/turntableController.sysj line: 128, column: 20
                                                                                m_thread_2.index();//sysj/turntableController.sysj line: 130, column: 4
                                                                                m_thread_2.report();//sysj/turntableController.sysj line: 131, column: 4
                                                                                S14096=14;
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
                                                                              rotaryTrigger.setPresent();//sysj/turntableController.sysj line: 126, column: 5
                                                                              currsigs.addElement(rotaryTrigger);
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
                            }
                          }
                        }
                      }
                      else {
                        unloadExit.setPresent();//sysj/turntableController.sysj line: 74, column: 6
                        currsigs.addElement(unloadExit);
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
                }
              }
              else {
                S14096=2;
                if(m_thread_2.idle()){//sysj/turntableController.sysj line: 82, column: 4
                  if(!m_thread_2.hasPending()){//sysj/turntableController.sysj line: 83, column: 11
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    ends[2]=2;
                    ;//sysj/turntableController.sysj line: 83, column: 5
                    S14096=3;
                    if(m_thread_2.readyToPlace()){//sysj/turntableController.sysj line: 85, column: 4
                      S14141=0;
                      if(bottleAtPos1.getprestatus()){//sysj/turntableController.sysj line: 86, column: 21
                        m_thread_2.commitPending();//sysj/turntableController.sysj line: 89, column: 5
                        placed_1.setPresent();//sysj/turntableController.sysj line: 90, column: 5
                        currsigs.addElement(placed_1);
                        S14141=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        loadPos1.setPresent();//sysj/turntableController.sysj line: 87, column: 6
                        currsigs.addElement(loadPos1);
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                    }
                    else {
                      S14096=4;
                      S14239=0;
                      if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 111, column: 4
                        startFiller1_o.setREQ(false);//sysj/turntableController.sysj line: 111, column: 4
                        S14239=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S14234=0;
                        if(startFiller1_o.isACK()){//sysj/turntableController.sysj line: 111, column: 4
                          startFiller1_o.setVal(m_thread_2.idAt(1));//sysj/turntableController.sysj line: 111, column: 4
                          S14234=1;
                          if(!startFiller1_o.isACK()){//sysj/turntableController.sysj line: 111, column: 4
                            startFiller1_o.setREQ(false);//sysj/turntableController.sysj line: 111, column: 4
                            ends[2]=2;
                            ;//sysj/turntableController.sysj line: 111, column: 4
                            S14096=5;
                            S14613=0;
                            if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 112, column: 4
                              startFiller2_o.setREQ(false);//sysj/turntableController.sysj line: 112, column: 4
                              S14613=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S14608=0;
                              if(startFiller2_o.isACK()){//sysj/turntableController.sysj line: 112, column: 4
                                startFiller2_o.setVal(m_thread_2.idAt(2));//sysj/turntableController.sysj line: 112, column: 4
                                S14608=1;
                                if(!startFiller2_o.isACK()){//sysj/turntableController.sysj line: 112, column: 4
                                  startFiller2_o.setREQ(false);//sysj/turntableController.sysj line: 112, column: 4
                                  ends[2]=2;
                                  ;//sysj/turntableController.sysj line: 112, column: 4
                                  S14096=6;
                                  S15031=0;
                                  if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 113, column: 4
                                    startLid_o.setREQ(false);//sysj/turntableController.sysj line: 113, column: 4
                                    S15031=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S15026=0;
                                    if(startLid_o.isACK()){//sysj/turntableController.sysj line: 113, column: 4
                                      startLid_o.setVal(m_thread_2.idAt(3));//sysj/turntableController.sysj line: 113, column: 4
                                      S15026=1;
                                      if(!startLid_o.isACK()){//sysj/turntableController.sysj line: 113, column: 4
                                        startLid_o.setREQ(false);//sysj/turntableController.sysj line: 113, column: 4
                                        ends[2]=2;
                                        ;//sysj/turntableController.sysj line: 113, column: 4
                                        S14096=7;
                                        S15493=0;
                                        if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 114, column: 4
                                          startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                                          S15493=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S15488=0;
                                          if(startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                                            startCapper_o.setVal(m_thread_2.idAt(4));//sysj/turntableController.sysj line: 114, column: 4
                                            S15488=1;
                                            if(!startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                                              startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                                              ends[2]=2;
                                              ;//sysj/turntableController.sysj line: 114, column: 4
                                              S14096=8;
                                              S15999=0;
                                              if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 116, column: 4
                                                doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                                S15999=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S15994=0;
                                                if(!doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                                  doneFiller1_in.setACK(true);//sysj/turntableController.sysj line: 116, column: 4
                                                  S15994=1;
                                                  if(doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                                    doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                                    ends[2]=2;
                                                    ;//sysj/turntableController.sysj line: 116, column: 4
                                                    S14096=9;
                                                    S16549=0;
                                                    if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 117, column: 4
                                                      doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                                      S16549=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S16544=0;
                                                      if(!doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                                        doneFiller2_in.setACK(true);//sysj/turntableController.sysj line: 117, column: 4
                                                        S16544=1;
                                                        if(doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                                          doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                                          ends[2]=2;
                                                          ;//sysj/turntableController.sysj line: 117, column: 4
                                                          S14096=10;
                                                          S17143=0;
                                                          if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 118, column: 4
                                                            doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                                            S17143=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S17138=0;
                                                            if(!doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                                              doneLid_in.setACK(true);//sysj/turntableController.sysj line: 118, column: 4
                                                              S17138=1;
                                                              if(doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                                                doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                                                ends[2]=2;
                                                                ;//sysj/turntableController.sysj line: 118, column: 4
                                                                S14096=11;
                                                                S17781=0;
                                                                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 119, column: 4
                                                                  doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                                  S17781=1;
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                                else {
                                                                  S17776=0;
                                                                  if(!doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                                    doneCapper_in.setACK(true);//sysj/turntableController.sysj line: 119, column: 4
                                                                    S17776=1;
                                                                    if(doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                                      doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                                      ends[2]=2;
                                                                      ;//sysj/turntableController.sysj line: 119, column: 4
                                                                      S14096=12;
                                                                      if(!tableAligned.getprestatus()){//sysj/turntableController.sysj line: 125, column: 20
                                                                        S14096=13;
                                                                        if(tableAligned.getprestatus()){//sysj/turntableController.sysj line: 128, column: 20
                                                                          m_thread_2.index();//sysj/turntableController.sysj line: 130, column: 4
                                                                          m_thread_2.report();//sysj/turntableController.sysj line: 131, column: 4
                                                                          S14096=14;
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
                                                                        rotaryTrigger.setPresent();//sysj/turntableController.sysj line: 126, column: 5
                                                                        currsigs.addElement(rotaryTrigger);
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
                      }
                    }
                  }
                }
                else {
                  S14096=3;
                  if(m_thread_2.readyToPlace()){//sysj/turntableController.sysj line: 85, column: 4
                    S14141=0;
                    if(bottleAtPos1.getprestatus()){//sysj/turntableController.sysj line: 86, column: 21
                      m_thread_2.commitPending();//sysj/turntableController.sysj line: 89, column: 5
                      placed_1.setPresent();//sysj/turntableController.sysj line: 90, column: 5
                      currsigs.addElement(placed_1);
                      S14141=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      loadPos1.setPresent();//sysj/turntableController.sysj line: 87, column: 6
                      currsigs.addElement(loadPos1);
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                  }
                  else {
                    S14096=4;
                    S14239=0;
                    if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 111, column: 4
                      startFiller1_o.setREQ(false);//sysj/turntableController.sysj line: 111, column: 4
                      S14239=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      S14234=0;
                      if(startFiller1_o.isACK()){//sysj/turntableController.sysj line: 111, column: 4
                        startFiller1_o.setVal(m_thread_2.idAt(1));//sysj/turntableController.sysj line: 111, column: 4
                        S14234=1;
                        if(!startFiller1_o.isACK()){//sysj/turntableController.sysj line: 111, column: 4
                          startFiller1_o.setREQ(false);//sysj/turntableController.sysj line: 111, column: 4
                          ends[2]=2;
                          ;//sysj/turntableController.sysj line: 111, column: 4
                          S14096=5;
                          S14613=0;
                          if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 112, column: 4
                            startFiller2_o.setREQ(false);//sysj/turntableController.sysj line: 112, column: 4
                            S14613=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S14608=0;
                            if(startFiller2_o.isACK()){//sysj/turntableController.sysj line: 112, column: 4
                              startFiller2_o.setVal(m_thread_2.idAt(2));//sysj/turntableController.sysj line: 112, column: 4
                              S14608=1;
                              if(!startFiller2_o.isACK()){//sysj/turntableController.sysj line: 112, column: 4
                                startFiller2_o.setREQ(false);//sysj/turntableController.sysj line: 112, column: 4
                                ends[2]=2;
                                ;//sysj/turntableController.sysj line: 112, column: 4
                                S14096=6;
                                S15031=0;
                                if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 113, column: 4
                                  startLid_o.setREQ(false);//sysj/turntableController.sysj line: 113, column: 4
                                  S15031=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S15026=0;
                                  if(startLid_o.isACK()){//sysj/turntableController.sysj line: 113, column: 4
                                    startLid_o.setVal(m_thread_2.idAt(3));//sysj/turntableController.sysj line: 113, column: 4
                                    S15026=1;
                                    if(!startLid_o.isACK()){//sysj/turntableController.sysj line: 113, column: 4
                                      startLid_o.setREQ(false);//sysj/turntableController.sysj line: 113, column: 4
                                      ends[2]=2;
                                      ;//sysj/turntableController.sysj line: 113, column: 4
                                      S14096=7;
                                      S15493=0;
                                      if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 114, column: 4
                                        startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                                        S15493=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S15488=0;
                                        if(startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                                          startCapper_o.setVal(m_thread_2.idAt(4));//sysj/turntableController.sysj line: 114, column: 4
                                          S15488=1;
                                          if(!startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                                            startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                                            ends[2]=2;
                                            ;//sysj/turntableController.sysj line: 114, column: 4
                                            S14096=8;
                                            S15999=0;
                                            if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 116, column: 4
                                              doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                              S15999=1;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S15994=0;
                                              if(!doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                                doneFiller1_in.setACK(true);//sysj/turntableController.sysj line: 116, column: 4
                                                S15994=1;
                                                if(doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                                  doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                                  ends[2]=2;
                                                  ;//sysj/turntableController.sysj line: 116, column: 4
                                                  S14096=9;
                                                  S16549=0;
                                                  if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 117, column: 4
                                                    doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                                    S16549=1;
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                  else {
                                                    S16544=0;
                                                    if(!doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                                      doneFiller2_in.setACK(true);//sysj/turntableController.sysj line: 117, column: 4
                                                      S16544=1;
                                                      if(doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                                        doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                                        ends[2]=2;
                                                        ;//sysj/turntableController.sysj line: 117, column: 4
                                                        S14096=10;
                                                        S17143=0;
                                                        if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 118, column: 4
                                                          doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                                          S17143=1;
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                        else {
                                                          S17138=0;
                                                          if(!doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                                            doneLid_in.setACK(true);//sysj/turntableController.sysj line: 118, column: 4
                                                            S17138=1;
                                                            if(doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                                              doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                                              ends[2]=2;
                                                              ;//sysj/turntableController.sysj line: 118, column: 4
                                                              S14096=11;
                                                              S17781=0;
                                                              if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 119, column: 4
                                                                doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                                S17781=1;
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                              else {
                                                                S17776=0;
                                                                if(!doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                                  doneCapper_in.setACK(true);//sysj/turntableController.sysj line: 119, column: 4
                                                                  S17776=1;
                                                                  if(doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                                    doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                                    ends[2]=2;
                                                                    ;//sysj/turntableController.sysj line: 119, column: 4
                                                                    S14096=12;
                                                                    if(!tableAligned.getprestatus()){//sysj/turntableController.sysj line: 125, column: 20
                                                                      S14096=13;
                                                                      if(tableAligned.getprestatus()){//sysj/turntableController.sysj line: 128, column: 20
                                                                        m_thread_2.index();//sysj/turntableController.sysj line: 130, column: 4
                                                                        m_thread_2.report();//sysj/turntableController.sysj line: 131, column: 4
                                                                        S14096=14;
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
                                                                      rotaryTrigger.setPresent();//sysj/turntableController.sysj line: 126, column: 5
                                                                      currsigs.addElement(rotaryTrigger);
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
                    }
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
          
          case 1 : 
            switch(S13910){
              case 0 : 
                switch(S13917){
                  case 0 : 
                    if(!tableOutfeed_o.isPartnerPresent() || tableOutfeed_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 72, column: 5
                      tableOutfeed_o.setREQ(false);//sysj/turntableController.sysj line: 72, column: 5
                      S13917=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      switch(S13912){
                        case 0 : 
                          if(tableOutfeed_o.isACK()){//sysj/turntableController.sysj line: 72, column: 5
                            tableOutfeed_o.setVal(exiting_thread_2);//sysj/turntableController.sysj line: 72, column: 5
                            S13912=1;
                            if(!tableOutfeed_o.isACK()){//sysj/turntableController.sysj line: 72, column: 5
                              tableOutfeed_o.setREQ(false);//sysj/turntableController.sysj line: 72, column: 5
                              ends[2]=2;
                              ;//sysj/turntableController.sysj line: 72, column: 5
                              S13910=1;
                              if(exitCleared.getprestatus()){//sysj/turntableController.sysj line: 73, column: 21
                                m_thread_2.clearExit();//sysj/turntableController.sysj line: 76, column: 5
                                S14096=2;
                                if(m_thread_2.idle()){//sysj/turntableController.sysj line: 82, column: 4
                                  if(!m_thread_2.hasPending()){//sysj/turntableController.sysj line: 83, column: 11
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    ends[2]=2;
                                    ;//sysj/turntableController.sysj line: 83, column: 5
                                    S14096=3;
                                    if(m_thread_2.readyToPlace()){//sysj/turntableController.sysj line: 85, column: 4
                                      S14141=0;
                                      if(bottleAtPos1.getprestatus()){//sysj/turntableController.sysj line: 86, column: 21
                                        m_thread_2.commitPending();//sysj/turntableController.sysj line: 89, column: 5
                                        placed_1.setPresent();//sysj/turntableController.sysj line: 90, column: 5
                                        currsigs.addElement(placed_1);
                                        S14141=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        loadPos1.setPresent();//sysj/turntableController.sysj line: 87, column: 6
                                        currsigs.addElement(loadPos1);
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                    }
                                    else {
                                      S14096=4;
                                      S14239=0;
                                      if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 111, column: 4
                                        startFiller1_o.setREQ(false);//sysj/turntableController.sysj line: 111, column: 4
                                        S14239=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S14234=0;
                                        if(startFiller1_o.isACK()){//sysj/turntableController.sysj line: 111, column: 4
                                          startFiller1_o.setVal(m_thread_2.idAt(1));//sysj/turntableController.sysj line: 111, column: 4
                                          S14234=1;
                                          if(!startFiller1_o.isACK()){//sysj/turntableController.sysj line: 111, column: 4
                                            startFiller1_o.setREQ(false);//sysj/turntableController.sysj line: 111, column: 4
                                            ends[2]=2;
                                            ;//sysj/turntableController.sysj line: 111, column: 4
                                            S14096=5;
                                            S14613=0;
                                            if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 112, column: 4
                                              startFiller2_o.setREQ(false);//sysj/turntableController.sysj line: 112, column: 4
                                              S14613=1;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S14608=0;
                                              if(startFiller2_o.isACK()){//sysj/turntableController.sysj line: 112, column: 4
                                                startFiller2_o.setVal(m_thread_2.idAt(2));//sysj/turntableController.sysj line: 112, column: 4
                                                S14608=1;
                                                if(!startFiller2_o.isACK()){//sysj/turntableController.sysj line: 112, column: 4
                                                  startFiller2_o.setREQ(false);//sysj/turntableController.sysj line: 112, column: 4
                                                  ends[2]=2;
                                                  ;//sysj/turntableController.sysj line: 112, column: 4
                                                  S14096=6;
                                                  S15031=0;
                                                  if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 113, column: 4
                                                    startLid_o.setREQ(false);//sysj/turntableController.sysj line: 113, column: 4
                                                    S15031=1;
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                  else {
                                                    S15026=0;
                                                    if(startLid_o.isACK()){//sysj/turntableController.sysj line: 113, column: 4
                                                      startLid_o.setVal(m_thread_2.idAt(3));//sysj/turntableController.sysj line: 113, column: 4
                                                      S15026=1;
                                                      if(!startLid_o.isACK()){//sysj/turntableController.sysj line: 113, column: 4
                                                        startLid_o.setREQ(false);//sysj/turntableController.sysj line: 113, column: 4
                                                        ends[2]=2;
                                                        ;//sysj/turntableController.sysj line: 113, column: 4
                                                        S14096=7;
                                                        S15493=0;
                                                        if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 114, column: 4
                                                          startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                                                          S15493=1;
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                        else {
                                                          S15488=0;
                                                          if(startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                                                            startCapper_o.setVal(m_thread_2.idAt(4));//sysj/turntableController.sysj line: 114, column: 4
                                                            S15488=1;
                                                            if(!startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                                                              startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                                                              ends[2]=2;
                                                              ;//sysj/turntableController.sysj line: 114, column: 4
                                                              S14096=8;
                                                              S15999=0;
                                                              if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 116, column: 4
                                                                doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                                                S15999=1;
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                              else {
                                                                S15994=0;
                                                                if(!doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                                                  doneFiller1_in.setACK(true);//sysj/turntableController.sysj line: 116, column: 4
                                                                  S15994=1;
                                                                  if(doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                                                    doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                                                    ends[2]=2;
                                                                    ;//sysj/turntableController.sysj line: 116, column: 4
                                                                    S14096=9;
                                                                    S16549=0;
                                                                    if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 117, column: 4
                                                                      doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                                                      S16549=1;
                                                                      active[2]=1;
                                                                      ends[2]=1;
                                                                      tdone[2]=1;
                                                                    }
                                                                    else {
                                                                      S16544=0;
                                                                      if(!doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                                                        doneFiller2_in.setACK(true);//sysj/turntableController.sysj line: 117, column: 4
                                                                        S16544=1;
                                                                        if(doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                                                          doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                                                          ends[2]=2;
                                                                          ;//sysj/turntableController.sysj line: 117, column: 4
                                                                          S14096=10;
                                                                          S17143=0;
                                                                          if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 118, column: 4
                                                                            doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                                                            S17143=1;
                                                                            active[2]=1;
                                                                            ends[2]=1;
                                                                            tdone[2]=1;
                                                                          }
                                                                          else {
                                                                            S17138=0;
                                                                            if(!doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                                                              doneLid_in.setACK(true);//sysj/turntableController.sysj line: 118, column: 4
                                                                              S17138=1;
                                                                              if(doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                                                                doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                                                                ends[2]=2;
                                                                                ;//sysj/turntableController.sysj line: 118, column: 4
                                                                                S14096=11;
                                                                                S17781=0;
                                                                                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 119, column: 4
                                                                                  doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                                                  S17781=1;
                                                                                  active[2]=1;
                                                                                  ends[2]=1;
                                                                                  tdone[2]=1;
                                                                                }
                                                                                else {
                                                                                  S17776=0;
                                                                                  if(!doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                                                    doneCapper_in.setACK(true);//sysj/turntableController.sysj line: 119, column: 4
                                                                                    S17776=1;
                                                                                    if(doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                                                      doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                                                      ends[2]=2;
                                                                                      ;//sysj/turntableController.sysj line: 119, column: 4
                                                                                      S14096=12;
                                                                                      if(!tableAligned.getprestatus()){//sysj/turntableController.sysj line: 125, column: 20
                                                                                        S14096=13;
                                                                                        if(tableAligned.getprestatus()){//sysj/turntableController.sysj line: 128, column: 20
                                                                                          m_thread_2.index();//sysj/turntableController.sysj line: 130, column: 4
                                                                                          m_thread_2.report();//sysj/turntableController.sysj line: 131, column: 4
                                                                                          S14096=14;
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
                                                                                        rotaryTrigger.setPresent();//sysj/turntableController.sysj line: 126, column: 5
                                                                                        currsigs.addElement(rotaryTrigger);
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
                                      }
                                    }
                                  }
                                }
                                else {
                                  S14096=3;
                                  if(m_thread_2.readyToPlace()){//sysj/turntableController.sysj line: 85, column: 4
                                    S14141=0;
                                    if(bottleAtPos1.getprestatus()){//sysj/turntableController.sysj line: 86, column: 21
                                      m_thread_2.commitPending();//sysj/turntableController.sysj line: 89, column: 5
                                      placed_1.setPresent();//sysj/turntableController.sysj line: 90, column: 5
                                      currsigs.addElement(placed_1);
                                      S14141=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      loadPos1.setPresent();//sysj/turntableController.sysj line: 87, column: 6
                                      currsigs.addElement(loadPos1);
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                  }
                                  else {
                                    S14096=4;
                                    S14239=0;
                                    if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 111, column: 4
                                      startFiller1_o.setREQ(false);//sysj/turntableController.sysj line: 111, column: 4
                                      S14239=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S14234=0;
                                      if(startFiller1_o.isACK()){//sysj/turntableController.sysj line: 111, column: 4
                                        startFiller1_o.setVal(m_thread_2.idAt(1));//sysj/turntableController.sysj line: 111, column: 4
                                        S14234=1;
                                        if(!startFiller1_o.isACK()){//sysj/turntableController.sysj line: 111, column: 4
                                          startFiller1_o.setREQ(false);//sysj/turntableController.sysj line: 111, column: 4
                                          ends[2]=2;
                                          ;//sysj/turntableController.sysj line: 111, column: 4
                                          S14096=5;
                                          S14613=0;
                                          if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 112, column: 4
                                            startFiller2_o.setREQ(false);//sysj/turntableController.sysj line: 112, column: 4
                                            S14613=1;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S14608=0;
                                            if(startFiller2_o.isACK()){//sysj/turntableController.sysj line: 112, column: 4
                                              startFiller2_o.setVal(m_thread_2.idAt(2));//sysj/turntableController.sysj line: 112, column: 4
                                              S14608=1;
                                              if(!startFiller2_o.isACK()){//sysj/turntableController.sysj line: 112, column: 4
                                                startFiller2_o.setREQ(false);//sysj/turntableController.sysj line: 112, column: 4
                                                ends[2]=2;
                                                ;//sysj/turntableController.sysj line: 112, column: 4
                                                S14096=6;
                                                S15031=0;
                                                if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 113, column: 4
                                                  startLid_o.setREQ(false);//sysj/turntableController.sysj line: 113, column: 4
                                                  S15031=1;
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                                else {
                                                  S15026=0;
                                                  if(startLid_o.isACK()){//sysj/turntableController.sysj line: 113, column: 4
                                                    startLid_o.setVal(m_thread_2.idAt(3));//sysj/turntableController.sysj line: 113, column: 4
                                                    S15026=1;
                                                    if(!startLid_o.isACK()){//sysj/turntableController.sysj line: 113, column: 4
                                                      startLid_o.setREQ(false);//sysj/turntableController.sysj line: 113, column: 4
                                                      ends[2]=2;
                                                      ;//sysj/turntableController.sysj line: 113, column: 4
                                                      S14096=7;
                                                      S15493=0;
                                                      if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 114, column: 4
                                                        startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                                                        S15493=1;
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                      else {
                                                        S15488=0;
                                                        if(startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                                                          startCapper_o.setVal(m_thread_2.idAt(4));//sysj/turntableController.sysj line: 114, column: 4
                                                          S15488=1;
                                                          if(!startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                                                            startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                                                            ends[2]=2;
                                                            ;//sysj/turntableController.sysj line: 114, column: 4
                                                            S14096=8;
                                                            S15999=0;
                                                            if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 116, column: 4
                                                              doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                                              S15999=1;
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                            else {
                                                              S15994=0;
                                                              if(!doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                                                doneFiller1_in.setACK(true);//sysj/turntableController.sysj line: 116, column: 4
                                                                S15994=1;
                                                                if(doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                                                  doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                                                  ends[2]=2;
                                                                  ;//sysj/turntableController.sysj line: 116, column: 4
                                                                  S14096=9;
                                                                  S16549=0;
                                                                  if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 117, column: 4
                                                                    doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                                                    S16549=1;
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
                                                                  }
                                                                  else {
                                                                    S16544=0;
                                                                    if(!doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                                                      doneFiller2_in.setACK(true);//sysj/turntableController.sysj line: 117, column: 4
                                                                      S16544=1;
                                                                      if(doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                                                        doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                                                        ends[2]=2;
                                                                        ;//sysj/turntableController.sysj line: 117, column: 4
                                                                        S14096=10;
                                                                        S17143=0;
                                                                        if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 118, column: 4
                                                                          doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                                                          S17143=1;
                                                                          active[2]=1;
                                                                          ends[2]=1;
                                                                          tdone[2]=1;
                                                                        }
                                                                        else {
                                                                          S17138=0;
                                                                          if(!doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                                                            doneLid_in.setACK(true);//sysj/turntableController.sysj line: 118, column: 4
                                                                            S17138=1;
                                                                            if(doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                                                              doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                                                              ends[2]=2;
                                                                              ;//sysj/turntableController.sysj line: 118, column: 4
                                                                              S14096=11;
                                                                              S17781=0;
                                                                              if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 119, column: 4
                                                                                doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                                                S17781=1;
                                                                                active[2]=1;
                                                                                ends[2]=1;
                                                                                tdone[2]=1;
                                                                              }
                                                                              else {
                                                                                S17776=0;
                                                                                if(!doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                                                  doneCapper_in.setACK(true);//sysj/turntableController.sysj line: 119, column: 4
                                                                                  S17776=1;
                                                                                  if(doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                                                    doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                                                    ends[2]=2;
                                                                                    ;//sysj/turntableController.sysj line: 119, column: 4
                                                                                    S14096=12;
                                                                                    if(!tableAligned.getprestatus()){//sysj/turntableController.sysj line: 125, column: 20
                                                                                      S14096=13;
                                                                                      if(tableAligned.getprestatus()){//sysj/turntableController.sysj line: 128, column: 20
                                                                                        m_thread_2.index();//sysj/turntableController.sysj line: 130, column: 4
                                                                                        m_thread_2.report();//sysj/turntableController.sysj line: 131, column: 4
                                                                                        S14096=14;
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
                                                                                      rotaryTrigger.setPresent();//sysj/turntableController.sysj line: 126, column: 5
                                                                                      currsigs.addElement(rotaryTrigger);
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
                                    }
                                  }
                                }
                              }
                              else {
                                unloadExit.setPresent();//sysj/turntableController.sysj line: 74, column: 6
                                currsigs.addElement(unloadExit);
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
                        
                        case 1 : 
                          if(!tableOutfeed_o.isACK()){//sysj/turntableController.sysj line: 72, column: 5
                            tableOutfeed_o.setREQ(false);//sysj/turntableController.sysj line: 72, column: 5
                            ends[2]=2;
                            ;//sysj/turntableController.sysj line: 72, column: 5
                            S13910=1;
                            if(exitCleared.getprestatus()){//sysj/turntableController.sysj line: 73, column: 21
                              m_thread_2.clearExit();//sysj/turntableController.sysj line: 76, column: 5
                              S14096=2;
                              if(m_thread_2.idle()){//sysj/turntableController.sysj line: 82, column: 4
                                if(!m_thread_2.hasPending()){//sysj/turntableController.sysj line: 83, column: 11
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  ends[2]=2;
                                  ;//sysj/turntableController.sysj line: 83, column: 5
                                  S14096=3;
                                  if(m_thread_2.readyToPlace()){//sysj/turntableController.sysj line: 85, column: 4
                                    S14141=0;
                                    if(bottleAtPos1.getprestatus()){//sysj/turntableController.sysj line: 86, column: 21
                                      m_thread_2.commitPending();//sysj/turntableController.sysj line: 89, column: 5
                                      placed_1.setPresent();//sysj/turntableController.sysj line: 90, column: 5
                                      currsigs.addElement(placed_1);
                                      S14141=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      loadPos1.setPresent();//sysj/turntableController.sysj line: 87, column: 6
                                      currsigs.addElement(loadPos1);
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                  }
                                  else {
                                    S14096=4;
                                    S14239=0;
                                    if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 111, column: 4
                                      startFiller1_o.setREQ(false);//sysj/turntableController.sysj line: 111, column: 4
                                      S14239=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S14234=0;
                                      if(startFiller1_o.isACK()){//sysj/turntableController.sysj line: 111, column: 4
                                        startFiller1_o.setVal(m_thread_2.idAt(1));//sysj/turntableController.sysj line: 111, column: 4
                                        S14234=1;
                                        if(!startFiller1_o.isACK()){//sysj/turntableController.sysj line: 111, column: 4
                                          startFiller1_o.setREQ(false);//sysj/turntableController.sysj line: 111, column: 4
                                          ends[2]=2;
                                          ;//sysj/turntableController.sysj line: 111, column: 4
                                          S14096=5;
                                          S14613=0;
                                          if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 112, column: 4
                                            startFiller2_o.setREQ(false);//sysj/turntableController.sysj line: 112, column: 4
                                            S14613=1;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S14608=0;
                                            if(startFiller2_o.isACK()){//sysj/turntableController.sysj line: 112, column: 4
                                              startFiller2_o.setVal(m_thread_2.idAt(2));//sysj/turntableController.sysj line: 112, column: 4
                                              S14608=1;
                                              if(!startFiller2_o.isACK()){//sysj/turntableController.sysj line: 112, column: 4
                                                startFiller2_o.setREQ(false);//sysj/turntableController.sysj line: 112, column: 4
                                                ends[2]=2;
                                                ;//sysj/turntableController.sysj line: 112, column: 4
                                                S14096=6;
                                                S15031=0;
                                                if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 113, column: 4
                                                  startLid_o.setREQ(false);//sysj/turntableController.sysj line: 113, column: 4
                                                  S15031=1;
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                                else {
                                                  S15026=0;
                                                  if(startLid_o.isACK()){//sysj/turntableController.sysj line: 113, column: 4
                                                    startLid_o.setVal(m_thread_2.idAt(3));//sysj/turntableController.sysj line: 113, column: 4
                                                    S15026=1;
                                                    if(!startLid_o.isACK()){//sysj/turntableController.sysj line: 113, column: 4
                                                      startLid_o.setREQ(false);//sysj/turntableController.sysj line: 113, column: 4
                                                      ends[2]=2;
                                                      ;//sysj/turntableController.sysj line: 113, column: 4
                                                      S14096=7;
                                                      S15493=0;
                                                      if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 114, column: 4
                                                        startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                                                        S15493=1;
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                      else {
                                                        S15488=0;
                                                        if(startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                                                          startCapper_o.setVal(m_thread_2.idAt(4));//sysj/turntableController.sysj line: 114, column: 4
                                                          S15488=1;
                                                          if(!startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                                                            startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                                                            ends[2]=2;
                                                            ;//sysj/turntableController.sysj line: 114, column: 4
                                                            S14096=8;
                                                            S15999=0;
                                                            if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 116, column: 4
                                                              doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                                              S15999=1;
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                            else {
                                                              S15994=0;
                                                              if(!doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                                                doneFiller1_in.setACK(true);//sysj/turntableController.sysj line: 116, column: 4
                                                                S15994=1;
                                                                if(doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                                                  doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                                                  ends[2]=2;
                                                                  ;//sysj/turntableController.sysj line: 116, column: 4
                                                                  S14096=9;
                                                                  S16549=0;
                                                                  if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 117, column: 4
                                                                    doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                                                    S16549=1;
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
                                                                  }
                                                                  else {
                                                                    S16544=0;
                                                                    if(!doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                                                      doneFiller2_in.setACK(true);//sysj/turntableController.sysj line: 117, column: 4
                                                                      S16544=1;
                                                                      if(doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                                                        doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                                                        ends[2]=2;
                                                                        ;//sysj/turntableController.sysj line: 117, column: 4
                                                                        S14096=10;
                                                                        S17143=0;
                                                                        if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 118, column: 4
                                                                          doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                                                          S17143=1;
                                                                          active[2]=1;
                                                                          ends[2]=1;
                                                                          tdone[2]=1;
                                                                        }
                                                                        else {
                                                                          S17138=0;
                                                                          if(!doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                                                            doneLid_in.setACK(true);//sysj/turntableController.sysj line: 118, column: 4
                                                                            S17138=1;
                                                                            if(doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                                                              doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                                                              ends[2]=2;
                                                                              ;//sysj/turntableController.sysj line: 118, column: 4
                                                                              S14096=11;
                                                                              S17781=0;
                                                                              if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 119, column: 4
                                                                                doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                                                S17781=1;
                                                                                active[2]=1;
                                                                                ends[2]=1;
                                                                                tdone[2]=1;
                                                                              }
                                                                              else {
                                                                                S17776=0;
                                                                                if(!doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                                                  doneCapper_in.setACK(true);//sysj/turntableController.sysj line: 119, column: 4
                                                                                  S17776=1;
                                                                                  if(doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                                                    doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                                                    ends[2]=2;
                                                                                    ;//sysj/turntableController.sysj line: 119, column: 4
                                                                                    S14096=12;
                                                                                    if(!tableAligned.getprestatus()){//sysj/turntableController.sysj line: 125, column: 20
                                                                                      S14096=13;
                                                                                      if(tableAligned.getprestatus()){//sysj/turntableController.sysj line: 128, column: 20
                                                                                        m_thread_2.index();//sysj/turntableController.sysj line: 130, column: 4
                                                                                        m_thread_2.report();//sysj/turntableController.sysj line: 131, column: 4
                                                                                        S14096=14;
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
                                                                                      rotaryTrigger.setPresent();//sysj/turntableController.sysj line: 126, column: 5
                                                                                      currsigs.addElement(rotaryTrigger);
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
                                    }
                                  }
                                }
                              }
                              else {
                                S14096=3;
                                if(m_thread_2.readyToPlace()){//sysj/turntableController.sysj line: 85, column: 4
                                  S14141=0;
                                  if(bottleAtPos1.getprestatus()){//sysj/turntableController.sysj line: 86, column: 21
                                    m_thread_2.commitPending();//sysj/turntableController.sysj line: 89, column: 5
                                    placed_1.setPresent();//sysj/turntableController.sysj line: 90, column: 5
                                    currsigs.addElement(placed_1);
                                    S14141=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    loadPos1.setPresent();//sysj/turntableController.sysj line: 87, column: 6
                                    currsigs.addElement(loadPos1);
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                }
                                else {
                                  S14096=4;
                                  S14239=0;
                                  if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 111, column: 4
                                    startFiller1_o.setREQ(false);//sysj/turntableController.sysj line: 111, column: 4
                                    S14239=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S14234=0;
                                    if(startFiller1_o.isACK()){//sysj/turntableController.sysj line: 111, column: 4
                                      startFiller1_o.setVal(m_thread_2.idAt(1));//sysj/turntableController.sysj line: 111, column: 4
                                      S14234=1;
                                      if(!startFiller1_o.isACK()){//sysj/turntableController.sysj line: 111, column: 4
                                        startFiller1_o.setREQ(false);//sysj/turntableController.sysj line: 111, column: 4
                                        ends[2]=2;
                                        ;//sysj/turntableController.sysj line: 111, column: 4
                                        S14096=5;
                                        S14613=0;
                                        if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 112, column: 4
                                          startFiller2_o.setREQ(false);//sysj/turntableController.sysj line: 112, column: 4
                                          S14613=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S14608=0;
                                          if(startFiller2_o.isACK()){//sysj/turntableController.sysj line: 112, column: 4
                                            startFiller2_o.setVal(m_thread_2.idAt(2));//sysj/turntableController.sysj line: 112, column: 4
                                            S14608=1;
                                            if(!startFiller2_o.isACK()){//sysj/turntableController.sysj line: 112, column: 4
                                              startFiller2_o.setREQ(false);//sysj/turntableController.sysj line: 112, column: 4
                                              ends[2]=2;
                                              ;//sysj/turntableController.sysj line: 112, column: 4
                                              S14096=6;
                                              S15031=0;
                                              if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 113, column: 4
                                                startLid_o.setREQ(false);//sysj/turntableController.sysj line: 113, column: 4
                                                S15031=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S15026=0;
                                                if(startLid_o.isACK()){//sysj/turntableController.sysj line: 113, column: 4
                                                  startLid_o.setVal(m_thread_2.idAt(3));//sysj/turntableController.sysj line: 113, column: 4
                                                  S15026=1;
                                                  if(!startLid_o.isACK()){//sysj/turntableController.sysj line: 113, column: 4
                                                    startLid_o.setREQ(false);//sysj/turntableController.sysj line: 113, column: 4
                                                    ends[2]=2;
                                                    ;//sysj/turntableController.sysj line: 113, column: 4
                                                    S14096=7;
                                                    S15493=0;
                                                    if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 114, column: 4
                                                      startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                                                      S15493=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S15488=0;
                                                      if(startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                                                        startCapper_o.setVal(m_thread_2.idAt(4));//sysj/turntableController.sysj line: 114, column: 4
                                                        S15488=1;
                                                        if(!startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                                                          startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                                                          ends[2]=2;
                                                          ;//sysj/turntableController.sysj line: 114, column: 4
                                                          S14096=8;
                                                          S15999=0;
                                                          if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 116, column: 4
                                                            doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                                            S15999=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S15994=0;
                                                            if(!doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                                              doneFiller1_in.setACK(true);//sysj/turntableController.sysj line: 116, column: 4
                                                              S15994=1;
                                                              if(doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                                                doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                                                ends[2]=2;
                                                                ;//sysj/turntableController.sysj line: 116, column: 4
                                                                S14096=9;
                                                                S16549=0;
                                                                if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 117, column: 4
                                                                  doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                                                  S16549=1;
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                                else {
                                                                  S16544=0;
                                                                  if(!doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                                                    doneFiller2_in.setACK(true);//sysj/turntableController.sysj line: 117, column: 4
                                                                    S16544=1;
                                                                    if(doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                                                      doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                                                      ends[2]=2;
                                                                      ;//sysj/turntableController.sysj line: 117, column: 4
                                                                      S14096=10;
                                                                      S17143=0;
                                                                      if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 118, column: 4
                                                                        doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                                                        S17143=1;
                                                                        active[2]=1;
                                                                        ends[2]=1;
                                                                        tdone[2]=1;
                                                                      }
                                                                      else {
                                                                        S17138=0;
                                                                        if(!doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                                                          doneLid_in.setACK(true);//sysj/turntableController.sysj line: 118, column: 4
                                                                          S17138=1;
                                                                          if(doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                                                            doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                                                            ends[2]=2;
                                                                            ;//sysj/turntableController.sysj line: 118, column: 4
                                                                            S14096=11;
                                                                            S17781=0;
                                                                            if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 119, column: 4
                                                                              doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                                              S17781=1;
                                                                              active[2]=1;
                                                                              ends[2]=1;
                                                                              tdone[2]=1;
                                                                            }
                                                                            else {
                                                                              S17776=0;
                                                                              if(!doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                                                doneCapper_in.setACK(true);//sysj/turntableController.sysj line: 119, column: 4
                                                                                S17776=1;
                                                                                if(doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                                                  doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                                                  ends[2]=2;
                                                                                  ;//sysj/turntableController.sysj line: 119, column: 4
                                                                                  S14096=12;
                                                                                  if(!tableAligned.getprestatus()){//sysj/turntableController.sysj line: 125, column: 20
                                                                                    S14096=13;
                                                                                    if(tableAligned.getprestatus()){//sysj/turntableController.sysj line: 128, column: 20
                                                                                      m_thread_2.index();//sysj/turntableController.sysj line: 130, column: 4
                                                                                      m_thread_2.report();//sysj/turntableController.sysj line: 131, column: 4
                                                                                      S14096=14;
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
                                                                                    rotaryTrigger.setPresent();//sysj/turntableController.sysj line: 126, column: 5
                                                                                    currsigs.addElement(rotaryTrigger);
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
                                  }
                                }
                              }
                            }
                            else {
                              unloadExit.setPresent();//sysj/turntableController.sysj line: 74, column: 6
                              currsigs.addElement(unloadExit);
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
                    break;
                  
                  case 1 : 
                    S13917=1;
                    S13917=0;
                    if(!tableOutfeed_o.isPartnerPresent() || tableOutfeed_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 72, column: 5
                      tableOutfeed_o.setREQ(false);//sysj/turntableController.sysj line: 72, column: 5
                      S13917=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      S13912=0;
                      if(tableOutfeed_o.isACK()){//sysj/turntableController.sysj line: 72, column: 5
                        tableOutfeed_o.setVal(exiting_thread_2);//sysj/turntableController.sysj line: 72, column: 5
                        S13912=1;
                        if(!tableOutfeed_o.isACK()){//sysj/turntableController.sysj line: 72, column: 5
                          tableOutfeed_o.setREQ(false);//sysj/turntableController.sysj line: 72, column: 5
                          ends[2]=2;
                          ;//sysj/turntableController.sysj line: 72, column: 5
                          S13910=1;
                          if(exitCleared.getprestatus()){//sysj/turntableController.sysj line: 73, column: 21
                            m_thread_2.clearExit();//sysj/turntableController.sysj line: 76, column: 5
                            S14096=2;
                            if(m_thread_2.idle()){//sysj/turntableController.sysj line: 82, column: 4
                              if(!m_thread_2.hasPending()){//sysj/turntableController.sysj line: 83, column: 11
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                ends[2]=2;
                                ;//sysj/turntableController.sysj line: 83, column: 5
                                S14096=3;
                                if(m_thread_2.readyToPlace()){//sysj/turntableController.sysj line: 85, column: 4
                                  S14141=0;
                                  if(bottleAtPos1.getprestatus()){//sysj/turntableController.sysj line: 86, column: 21
                                    m_thread_2.commitPending();//sysj/turntableController.sysj line: 89, column: 5
                                    placed_1.setPresent();//sysj/turntableController.sysj line: 90, column: 5
                                    currsigs.addElement(placed_1);
                                    S14141=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    loadPos1.setPresent();//sysj/turntableController.sysj line: 87, column: 6
                                    currsigs.addElement(loadPos1);
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                }
                                else {
                                  S14096=4;
                                  S14239=0;
                                  if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 111, column: 4
                                    startFiller1_o.setREQ(false);//sysj/turntableController.sysj line: 111, column: 4
                                    S14239=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S14234=0;
                                    if(startFiller1_o.isACK()){//sysj/turntableController.sysj line: 111, column: 4
                                      startFiller1_o.setVal(m_thread_2.idAt(1));//sysj/turntableController.sysj line: 111, column: 4
                                      S14234=1;
                                      if(!startFiller1_o.isACK()){//sysj/turntableController.sysj line: 111, column: 4
                                        startFiller1_o.setREQ(false);//sysj/turntableController.sysj line: 111, column: 4
                                        ends[2]=2;
                                        ;//sysj/turntableController.sysj line: 111, column: 4
                                        S14096=5;
                                        S14613=0;
                                        if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 112, column: 4
                                          startFiller2_o.setREQ(false);//sysj/turntableController.sysj line: 112, column: 4
                                          S14613=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S14608=0;
                                          if(startFiller2_o.isACK()){//sysj/turntableController.sysj line: 112, column: 4
                                            startFiller2_o.setVal(m_thread_2.idAt(2));//sysj/turntableController.sysj line: 112, column: 4
                                            S14608=1;
                                            if(!startFiller2_o.isACK()){//sysj/turntableController.sysj line: 112, column: 4
                                              startFiller2_o.setREQ(false);//sysj/turntableController.sysj line: 112, column: 4
                                              ends[2]=2;
                                              ;//sysj/turntableController.sysj line: 112, column: 4
                                              S14096=6;
                                              S15031=0;
                                              if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 113, column: 4
                                                startLid_o.setREQ(false);//sysj/turntableController.sysj line: 113, column: 4
                                                S15031=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S15026=0;
                                                if(startLid_o.isACK()){//sysj/turntableController.sysj line: 113, column: 4
                                                  startLid_o.setVal(m_thread_2.idAt(3));//sysj/turntableController.sysj line: 113, column: 4
                                                  S15026=1;
                                                  if(!startLid_o.isACK()){//sysj/turntableController.sysj line: 113, column: 4
                                                    startLid_o.setREQ(false);//sysj/turntableController.sysj line: 113, column: 4
                                                    ends[2]=2;
                                                    ;//sysj/turntableController.sysj line: 113, column: 4
                                                    S14096=7;
                                                    S15493=0;
                                                    if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 114, column: 4
                                                      startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                                                      S15493=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S15488=0;
                                                      if(startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                                                        startCapper_o.setVal(m_thread_2.idAt(4));//sysj/turntableController.sysj line: 114, column: 4
                                                        S15488=1;
                                                        if(!startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                                                          startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                                                          ends[2]=2;
                                                          ;//sysj/turntableController.sysj line: 114, column: 4
                                                          S14096=8;
                                                          S15999=0;
                                                          if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 116, column: 4
                                                            doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                                            S15999=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S15994=0;
                                                            if(!doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                                              doneFiller1_in.setACK(true);//sysj/turntableController.sysj line: 116, column: 4
                                                              S15994=1;
                                                              if(doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                                                doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                                                ends[2]=2;
                                                                ;//sysj/turntableController.sysj line: 116, column: 4
                                                                S14096=9;
                                                                S16549=0;
                                                                if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 117, column: 4
                                                                  doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                                                  S16549=1;
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                                else {
                                                                  S16544=0;
                                                                  if(!doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                                                    doneFiller2_in.setACK(true);//sysj/turntableController.sysj line: 117, column: 4
                                                                    S16544=1;
                                                                    if(doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                                                      doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                                                      ends[2]=2;
                                                                      ;//sysj/turntableController.sysj line: 117, column: 4
                                                                      S14096=10;
                                                                      S17143=0;
                                                                      if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 118, column: 4
                                                                        doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                                                        S17143=1;
                                                                        active[2]=1;
                                                                        ends[2]=1;
                                                                        tdone[2]=1;
                                                                      }
                                                                      else {
                                                                        S17138=0;
                                                                        if(!doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                                                          doneLid_in.setACK(true);//sysj/turntableController.sysj line: 118, column: 4
                                                                          S17138=1;
                                                                          if(doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                                                            doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                                                            ends[2]=2;
                                                                            ;//sysj/turntableController.sysj line: 118, column: 4
                                                                            S14096=11;
                                                                            S17781=0;
                                                                            if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 119, column: 4
                                                                              doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                                              S17781=1;
                                                                              active[2]=1;
                                                                              ends[2]=1;
                                                                              tdone[2]=1;
                                                                            }
                                                                            else {
                                                                              S17776=0;
                                                                              if(!doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                                                doneCapper_in.setACK(true);//sysj/turntableController.sysj line: 119, column: 4
                                                                                S17776=1;
                                                                                if(doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                                                  doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                                                  ends[2]=2;
                                                                                  ;//sysj/turntableController.sysj line: 119, column: 4
                                                                                  S14096=12;
                                                                                  if(!tableAligned.getprestatus()){//sysj/turntableController.sysj line: 125, column: 20
                                                                                    S14096=13;
                                                                                    if(tableAligned.getprestatus()){//sysj/turntableController.sysj line: 128, column: 20
                                                                                      m_thread_2.index();//sysj/turntableController.sysj line: 130, column: 4
                                                                                      m_thread_2.report();//sysj/turntableController.sysj line: 131, column: 4
                                                                                      S14096=14;
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
                                                                                    rotaryTrigger.setPresent();//sysj/turntableController.sysj line: 126, column: 5
                                                                                    currsigs.addElement(rotaryTrigger);
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
                                  }
                                }
                              }
                            }
                            else {
                              S14096=3;
                              if(m_thread_2.readyToPlace()){//sysj/turntableController.sysj line: 85, column: 4
                                S14141=0;
                                if(bottleAtPos1.getprestatus()){//sysj/turntableController.sysj line: 86, column: 21
                                  m_thread_2.commitPending();//sysj/turntableController.sysj line: 89, column: 5
                                  placed_1.setPresent();//sysj/turntableController.sysj line: 90, column: 5
                                  currsigs.addElement(placed_1);
                                  S14141=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  loadPos1.setPresent();//sysj/turntableController.sysj line: 87, column: 6
                                  currsigs.addElement(loadPos1);
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                              }
                              else {
                                S14096=4;
                                S14239=0;
                                if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 111, column: 4
                                  startFiller1_o.setREQ(false);//sysj/turntableController.sysj line: 111, column: 4
                                  S14239=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S14234=0;
                                  if(startFiller1_o.isACK()){//sysj/turntableController.sysj line: 111, column: 4
                                    startFiller1_o.setVal(m_thread_2.idAt(1));//sysj/turntableController.sysj line: 111, column: 4
                                    S14234=1;
                                    if(!startFiller1_o.isACK()){//sysj/turntableController.sysj line: 111, column: 4
                                      startFiller1_o.setREQ(false);//sysj/turntableController.sysj line: 111, column: 4
                                      ends[2]=2;
                                      ;//sysj/turntableController.sysj line: 111, column: 4
                                      S14096=5;
                                      S14613=0;
                                      if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 112, column: 4
                                        startFiller2_o.setREQ(false);//sysj/turntableController.sysj line: 112, column: 4
                                        S14613=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S14608=0;
                                        if(startFiller2_o.isACK()){//sysj/turntableController.sysj line: 112, column: 4
                                          startFiller2_o.setVal(m_thread_2.idAt(2));//sysj/turntableController.sysj line: 112, column: 4
                                          S14608=1;
                                          if(!startFiller2_o.isACK()){//sysj/turntableController.sysj line: 112, column: 4
                                            startFiller2_o.setREQ(false);//sysj/turntableController.sysj line: 112, column: 4
                                            ends[2]=2;
                                            ;//sysj/turntableController.sysj line: 112, column: 4
                                            S14096=6;
                                            S15031=0;
                                            if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 113, column: 4
                                              startLid_o.setREQ(false);//sysj/turntableController.sysj line: 113, column: 4
                                              S15031=1;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S15026=0;
                                              if(startLid_o.isACK()){//sysj/turntableController.sysj line: 113, column: 4
                                                startLid_o.setVal(m_thread_2.idAt(3));//sysj/turntableController.sysj line: 113, column: 4
                                                S15026=1;
                                                if(!startLid_o.isACK()){//sysj/turntableController.sysj line: 113, column: 4
                                                  startLid_o.setREQ(false);//sysj/turntableController.sysj line: 113, column: 4
                                                  ends[2]=2;
                                                  ;//sysj/turntableController.sysj line: 113, column: 4
                                                  S14096=7;
                                                  S15493=0;
                                                  if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 114, column: 4
                                                    startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                                                    S15493=1;
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                  else {
                                                    S15488=0;
                                                    if(startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                                                      startCapper_o.setVal(m_thread_2.idAt(4));//sysj/turntableController.sysj line: 114, column: 4
                                                      S15488=1;
                                                      if(!startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                                                        startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                                                        ends[2]=2;
                                                        ;//sysj/turntableController.sysj line: 114, column: 4
                                                        S14096=8;
                                                        S15999=0;
                                                        if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 116, column: 4
                                                          doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                                          S15999=1;
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                        else {
                                                          S15994=0;
                                                          if(!doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                                            doneFiller1_in.setACK(true);//sysj/turntableController.sysj line: 116, column: 4
                                                            S15994=1;
                                                            if(doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                                              doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                                              ends[2]=2;
                                                              ;//sysj/turntableController.sysj line: 116, column: 4
                                                              S14096=9;
                                                              S16549=0;
                                                              if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 117, column: 4
                                                                doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                                                S16549=1;
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                              else {
                                                                S16544=0;
                                                                if(!doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                                                  doneFiller2_in.setACK(true);//sysj/turntableController.sysj line: 117, column: 4
                                                                  S16544=1;
                                                                  if(doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                                                    doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                                                    ends[2]=2;
                                                                    ;//sysj/turntableController.sysj line: 117, column: 4
                                                                    S14096=10;
                                                                    S17143=0;
                                                                    if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 118, column: 4
                                                                      doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                                                      S17143=1;
                                                                      active[2]=1;
                                                                      ends[2]=1;
                                                                      tdone[2]=1;
                                                                    }
                                                                    else {
                                                                      S17138=0;
                                                                      if(!doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                                                        doneLid_in.setACK(true);//sysj/turntableController.sysj line: 118, column: 4
                                                                        S17138=1;
                                                                        if(doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                                                          doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                                                          ends[2]=2;
                                                                          ;//sysj/turntableController.sysj line: 118, column: 4
                                                                          S14096=11;
                                                                          S17781=0;
                                                                          if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 119, column: 4
                                                                            doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                                            S17781=1;
                                                                            active[2]=1;
                                                                            ends[2]=1;
                                                                            tdone[2]=1;
                                                                          }
                                                                          else {
                                                                            S17776=0;
                                                                            if(!doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                                              doneCapper_in.setACK(true);//sysj/turntableController.sysj line: 119, column: 4
                                                                              S17776=1;
                                                                              if(doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                                                doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                                                ends[2]=2;
                                                                                ;//sysj/turntableController.sysj line: 119, column: 4
                                                                                S14096=12;
                                                                                if(!tableAligned.getprestatus()){//sysj/turntableController.sysj line: 125, column: 20
                                                                                  S14096=13;
                                                                                  if(tableAligned.getprestatus()){//sysj/turntableController.sysj line: 128, column: 20
                                                                                    m_thread_2.index();//sysj/turntableController.sysj line: 130, column: 4
                                                                                    m_thread_2.report();//sysj/turntableController.sysj line: 131, column: 4
                                                                                    S14096=14;
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
                                                                                  rotaryTrigger.setPresent();//sysj/turntableController.sysj line: 126, column: 5
                                                                                  currsigs.addElement(rotaryTrigger);
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
                                }
                              }
                            }
                          }
                          else {
                            unloadExit.setPresent();//sysj/turntableController.sysj line: 74, column: 6
                            currsigs.addElement(unloadExit);
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
                    }
                    break;
                  
                }
                break;
              
              case 1 : 
                if(exitCleared.getprestatus()){//sysj/turntableController.sysj line: 73, column: 21
                  m_thread_2.clearExit();//sysj/turntableController.sysj line: 76, column: 5
                  S14096=2;
                  if(m_thread_2.idle()){//sysj/turntableController.sysj line: 82, column: 4
                    if(!m_thread_2.hasPending()){//sysj/turntableController.sysj line: 83, column: 11
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      ends[2]=2;
                      ;//sysj/turntableController.sysj line: 83, column: 5
                      S14096=3;
                      if(m_thread_2.readyToPlace()){//sysj/turntableController.sysj line: 85, column: 4
                        S14141=0;
                        if(bottleAtPos1.getprestatus()){//sysj/turntableController.sysj line: 86, column: 21
                          m_thread_2.commitPending();//sysj/turntableController.sysj line: 89, column: 5
                          placed_1.setPresent();//sysj/turntableController.sysj line: 90, column: 5
                          currsigs.addElement(placed_1);
                          S14141=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          loadPos1.setPresent();//sysj/turntableController.sysj line: 87, column: 6
                          currsigs.addElement(loadPos1);
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                      }
                      else {
                        S14096=4;
                        S14239=0;
                        if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 111, column: 4
                          startFiller1_o.setREQ(false);//sysj/turntableController.sysj line: 111, column: 4
                          S14239=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          S14234=0;
                          if(startFiller1_o.isACK()){//sysj/turntableController.sysj line: 111, column: 4
                            startFiller1_o.setVal(m_thread_2.idAt(1));//sysj/turntableController.sysj line: 111, column: 4
                            S14234=1;
                            if(!startFiller1_o.isACK()){//sysj/turntableController.sysj line: 111, column: 4
                              startFiller1_o.setREQ(false);//sysj/turntableController.sysj line: 111, column: 4
                              ends[2]=2;
                              ;//sysj/turntableController.sysj line: 111, column: 4
                              S14096=5;
                              S14613=0;
                              if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 112, column: 4
                                startFiller2_o.setREQ(false);//sysj/turntableController.sysj line: 112, column: 4
                                S14613=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S14608=0;
                                if(startFiller2_o.isACK()){//sysj/turntableController.sysj line: 112, column: 4
                                  startFiller2_o.setVal(m_thread_2.idAt(2));//sysj/turntableController.sysj line: 112, column: 4
                                  S14608=1;
                                  if(!startFiller2_o.isACK()){//sysj/turntableController.sysj line: 112, column: 4
                                    startFiller2_o.setREQ(false);//sysj/turntableController.sysj line: 112, column: 4
                                    ends[2]=2;
                                    ;//sysj/turntableController.sysj line: 112, column: 4
                                    S14096=6;
                                    S15031=0;
                                    if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 113, column: 4
                                      startLid_o.setREQ(false);//sysj/turntableController.sysj line: 113, column: 4
                                      S15031=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S15026=0;
                                      if(startLid_o.isACK()){//sysj/turntableController.sysj line: 113, column: 4
                                        startLid_o.setVal(m_thread_2.idAt(3));//sysj/turntableController.sysj line: 113, column: 4
                                        S15026=1;
                                        if(!startLid_o.isACK()){//sysj/turntableController.sysj line: 113, column: 4
                                          startLid_o.setREQ(false);//sysj/turntableController.sysj line: 113, column: 4
                                          ends[2]=2;
                                          ;//sysj/turntableController.sysj line: 113, column: 4
                                          S14096=7;
                                          S15493=0;
                                          if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 114, column: 4
                                            startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                                            S15493=1;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S15488=0;
                                            if(startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                                              startCapper_o.setVal(m_thread_2.idAt(4));//sysj/turntableController.sysj line: 114, column: 4
                                              S15488=1;
                                              if(!startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                                                startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                                                ends[2]=2;
                                                ;//sysj/turntableController.sysj line: 114, column: 4
                                                S14096=8;
                                                S15999=0;
                                                if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 116, column: 4
                                                  doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                                  S15999=1;
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                                else {
                                                  S15994=0;
                                                  if(!doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                                    doneFiller1_in.setACK(true);//sysj/turntableController.sysj line: 116, column: 4
                                                    S15994=1;
                                                    if(doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                                      doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                                      ends[2]=2;
                                                      ;//sysj/turntableController.sysj line: 116, column: 4
                                                      S14096=9;
                                                      S16549=0;
                                                      if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 117, column: 4
                                                        doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                                        S16549=1;
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                      else {
                                                        S16544=0;
                                                        if(!doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                                          doneFiller2_in.setACK(true);//sysj/turntableController.sysj line: 117, column: 4
                                                          S16544=1;
                                                          if(doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                                            doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                                            ends[2]=2;
                                                            ;//sysj/turntableController.sysj line: 117, column: 4
                                                            S14096=10;
                                                            S17143=0;
                                                            if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 118, column: 4
                                                              doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                                              S17143=1;
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                            else {
                                                              S17138=0;
                                                              if(!doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                                                doneLid_in.setACK(true);//sysj/turntableController.sysj line: 118, column: 4
                                                                S17138=1;
                                                                if(doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                                                  doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                                                  ends[2]=2;
                                                                  ;//sysj/turntableController.sysj line: 118, column: 4
                                                                  S14096=11;
                                                                  S17781=0;
                                                                  if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 119, column: 4
                                                                    doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                                    S17781=1;
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
                                                                  }
                                                                  else {
                                                                    S17776=0;
                                                                    if(!doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                                      doneCapper_in.setACK(true);//sysj/turntableController.sysj line: 119, column: 4
                                                                      S17776=1;
                                                                      if(doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                                        doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                                        ends[2]=2;
                                                                        ;//sysj/turntableController.sysj line: 119, column: 4
                                                                        S14096=12;
                                                                        if(!tableAligned.getprestatus()){//sysj/turntableController.sysj line: 125, column: 20
                                                                          S14096=13;
                                                                          if(tableAligned.getprestatus()){//sysj/turntableController.sysj line: 128, column: 20
                                                                            m_thread_2.index();//sysj/turntableController.sysj line: 130, column: 4
                                                                            m_thread_2.report();//sysj/turntableController.sysj line: 131, column: 4
                                                                            S14096=14;
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
                                                                          rotaryTrigger.setPresent();//sysj/turntableController.sysj line: 126, column: 5
                                                                          currsigs.addElement(rotaryTrigger);
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
                        }
                      }
                    }
                  }
                  else {
                    S14096=3;
                    if(m_thread_2.readyToPlace()){//sysj/turntableController.sysj line: 85, column: 4
                      S14141=0;
                      if(bottleAtPos1.getprestatus()){//sysj/turntableController.sysj line: 86, column: 21
                        m_thread_2.commitPending();//sysj/turntableController.sysj line: 89, column: 5
                        placed_1.setPresent();//sysj/turntableController.sysj line: 90, column: 5
                        currsigs.addElement(placed_1);
                        S14141=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        loadPos1.setPresent();//sysj/turntableController.sysj line: 87, column: 6
                        currsigs.addElement(loadPos1);
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                    }
                    else {
                      S14096=4;
                      S14239=0;
                      if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 111, column: 4
                        startFiller1_o.setREQ(false);//sysj/turntableController.sysj line: 111, column: 4
                        S14239=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S14234=0;
                        if(startFiller1_o.isACK()){//sysj/turntableController.sysj line: 111, column: 4
                          startFiller1_o.setVal(m_thread_2.idAt(1));//sysj/turntableController.sysj line: 111, column: 4
                          S14234=1;
                          if(!startFiller1_o.isACK()){//sysj/turntableController.sysj line: 111, column: 4
                            startFiller1_o.setREQ(false);//sysj/turntableController.sysj line: 111, column: 4
                            ends[2]=2;
                            ;//sysj/turntableController.sysj line: 111, column: 4
                            S14096=5;
                            S14613=0;
                            if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 112, column: 4
                              startFiller2_o.setREQ(false);//sysj/turntableController.sysj line: 112, column: 4
                              S14613=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S14608=0;
                              if(startFiller2_o.isACK()){//sysj/turntableController.sysj line: 112, column: 4
                                startFiller2_o.setVal(m_thread_2.idAt(2));//sysj/turntableController.sysj line: 112, column: 4
                                S14608=1;
                                if(!startFiller2_o.isACK()){//sysj/turntableController.sysj line: 112, column: 4
                                  startFiller2_o.setREQ(false);//sysj/turntableController.sysj line: 112, column: 4
                                  ends[2]=2;
                                  ;//sysj/turntableController.sysj line: 112, column: 4
                                  S14096=6;
                                  S15031=0;
                                  if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 113, column: 4
                                    startLid_o.setREQ(false);//sysj/turntableController.sysj line: 113, column: 4
                                    S15031=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S15026=0;
                                    if(startLid_o.isACK()){//sysj/turntableController.sysj line: 113, column: 4
                                      startLid_o.setVal(m_thread_2.idAt(3));//sysj/turntableController.sysj line: 113, column: 4
                                      S15026=1;
                                      if(!startLid_o.isACK()){//sysj/turntableController.sysj line: 113, column: 4
                                        startLid_o.setREQ(false);//sysj/turntableController.sysj line: 113, column: 4
                                        ends[2]=2;
                                        ;//sysj/turntableController.sysj line: 113, column: 4
                                        S14096=7;
                                        S15493=0;
                                        if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 114, column: 4
                                          startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                                          S15493=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S15488=0;
                                          if(startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                                            startCapper_o.setVal(m_thread_2.idAt(4));//sysj/turntableController.sysj line: 114, column: 4
                                            S15488=1;
                                            if(!startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                                              startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                                              ends[2]=2;
                                              ;//sysj/turntableController.sysj line: 114, column: 4
                                              S14096=8;
                                              S15999=0;
                                              if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 116, column: 4
                                                doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                                S15999=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S15994=0;
                                                if(!doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                                  doneFiller1_in.setACK(true);//sysj/turntableController.sysj line: 116, column: 4
                                                  S15994=1;
                                                  if(doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                                    doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                                    ends[2]=2;
                                                    ;//sysj/turntableController.sysj line: 116, column: 4
                                                    S14096=9;
                                                    S16549=0;
                                                    if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 117, column: 4
                                                      doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                                      S16549=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S16544=0;
                                                      if(!doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                                        doneFiller2_in.setACK(true);//sysj/turntableController.sysj line: 117, column: 4
                                                        S16544=1;
                                                        if(doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                                          doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                                          ends[2]=2;
                                                          ;//sysj/turntableController.sysj line: 117, column: 4
                                                          S14096=10;
                                                          S17143=0;
                                                          if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 118, column: 4
                                                            doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                                            S17143=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S17138=0;
                                                            if(!doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                                              doneLid_in.setACK(true);//sysj/turntableController.sysj line: 118, column: 4
                                                              S17138=1;
                                                              if(doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                                                doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                                                ends[2]=2;
                                                                ;//sysj/turntableController.sysj line: 118, column: 4
                                                                S14096=11;
                                                                S17781=0;
                                                                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 119, column: 4
                                                                  doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                                  S17781=1;
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                                else {
                                                                  S17776=0;
                                                                  if(!doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                                    doneCapper_in.setACK(true);//sysj/turntableController.sysj line: 119, column: 4
                                                                    S17776=1;
                                                                    if(doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                                      doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                                      ends[2]=2;
                                                                      ;//sysj/turntableController.sysj line: 119, column: 4
                                                                      S14096=12;
                                                                      if(!tableAligned.getprestatus()){//sysj/turntableController.sysj line: 125, column: 20
                                                                        S14096=13;
                                                                        if(tableAligned.getprestatus()){//sysj/turntableController.sysj line: 128, column: 20
                                                                          m_thread_2.index();//sysj/turntableController.sysj line: 130, column: 4
                                                                          m_thread_2.report();//sysj/turntableController.sysj line: 131, column: 4
                                                                          S14096=14;
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
                                                                        rotaryTrigger.setPresent();//sysj/turntableController.sysj line: 126, column: 5
                                                                        currsigs.addElement(rotaryTrigger);
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
                      }
                    }
                  }
                }
                else {
                  unloadExit.setPresent();//sysj/turntableController.sysj line: 74, column: 6
                  currsigs.addElement(unloadExit);
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                break;
              
            }
            break;
          
          case 2 : 
            if(!m_thread_2.hasPending()){//sysj/turntableController.sysj line: 83, column: 11
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              ends[2]=2;
              ;//sysj/turntableController.sysj line: 83, column: 5
              S14096=3;
              if(m_thread_2.readyToPlace()){//sysj/turntableController.sysj line: 85, column: 4
                S14141=0;
                if(bottleAtPos1.getprestatus()){//sysj/turntableController.sysj line: 86, column: 21
                  m_thread_2.commitPending();//sysj/turntableController.sysj line: 89, column: 5
                  placed_1.setPresent();//sysj/turntableController.sysj line: 90, column: 5
                  currsigs.addElement(placed_1);
                  S14141=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  loadPos1.setPresent();//sysj/turntableController.sysj line: 87, column: 6
                  currsigs.addElement(loadPos1);
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
              }
              else {
                S14096=4;
                S14239=0;
                if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 111, column: 4
                  startFiller1_o.setREQ(false);//sysj/turntableController.sysj line: 111, column: 4
                  S14239=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S14234=0;
                  if(startFiller1_o.isACK()){//sysj/turntableController.sysj line: 111, column: 4
                    startFiller1_o.setVal(m_thread_2.idAt(1));//sysj/turntableController.sysj line: 111, column: 4
                    S14234=1;
                    if(!startFiller1_o.isACK()){//sysj/turntableController.sysj line: 111, column: 4
                      startFiller1_o.setREQ(false);//sysj/turntableController.sysj line: 111, column: 4
                      ends[2]=2;
                      ;//sysj/turntableController.sysj line: 111, column: 4
                      S14096=5;
                      S14613=0;
                      if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 112, column: 4
                        startFiller2_o.setREQ(false);//sysj/turntableController.sysj line: 112, column: 4
                        S14613=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S14608=0;
                        if(startFiller2_o.isACK()){//sysj/turntableController.sysj line: 112, column: 4
                          startFiller2_o.setVal(m_thread_2.idAt(2));//sysj/turntableController.sysj line: 112, column: 4
                          S14608=1;
                          if(!startFiller2_o.isACK()){//sysj/turntableController.sysj line: 112, column: 4
                            startFiller2_o.setREQ(false);//sysj/turntableController.sysj line: 112, column: 4
                            ends[2]=2;
                            ;//sysj/turntableController.sysj line: 112, column: 4
                            S14096=6;
                            S15031=0;
                            if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 113, column: 4
                              startLid_o.setREQ(false);//sysj/turntableController.sysj line: 113, column: 4
                              S15031=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S15026=0;
                              if(startLid_o.isACK()){//sysj/turntableController.sysj line: 113, column: 4
                                startLid_o.setVal(m_thread_2.idAt(3));//sysj/turntableController.sysj line: 113, column: 4
                                S15026=1;
                                if(!startLid_o.isACK()){//sysj/turntableController.sysj line: 113, column: 4
                                  startLid_o.setREQ(false);//sysj/turntableController.sysj line: 113, column: 4
                                  ends[2]=2;
                                  ;//sysj/turntableController.sysj line: 113, column: 4
                                  S14096=7;
                                  S15493=0;
                                  if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 114, column: 4
                                    startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                                    S15493=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S15488=0;
                                    if(startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                                      startCapper_o.setVal(m_thread_2.idAt(4));//sysj/turntableController.sysj line: 114, column: 4
                                      S15488=1;
                                      if(!startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                                        startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                                        ends[2]=2;
                                        ;//sysj/turntableController.sysj line: 114, column: 4
                                        S14096=8;
                                        S15999=0;
                                        if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 116, column: 4
                                          doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                          S15999=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S15994=0;
                                          if(!doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                            doneFiller1_in.setACK(true);//sysj/turntableController.sysj line: 116, column: 4
                                            S15994=1;
                                            if(doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                              doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                              ends[2]=2;
                                              ;//sysj/turntableController.sysj line: 116, column: 4
                                              S14096=9;
                                              S16549=0;
                                              if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 117, column: 4
                                                doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                                S16549=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S16544=0;
                                                if(!doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                                  doneFiller2_in.setACK(true);//sysj/turntableController.sysj line: 117, column: 4
                                                  S16544=1;
                                                  if(doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                                    doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                                    ends[2]=2;
                                                    ;//sysj/turntableController.sysj line: 117, column: 4
                                                    S14096=10;
                                                    S17143=0;
                                                    if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 118, column: 4
                                                      doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                                      S17143=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S17138=0;
                                                      if(!doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                                        doneLid_in.setACK(true);//sysj/turntableController.sysj line: 118, column: 4
                                                        S17138=1;
                                                        if(doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                                          doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                                          ends[2]=2;
                                                          ;//sysj/turntableController.sysj line: 118, column: 4
                                                          S14096=11;
                                                          S17781=0;
                                                          if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 119, column: 4
                                                            doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                            S17781=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S17776=0;
                                                            if(!doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                              doneCapper_in.setACK(true);//sysj/turntableController.sysj line: 119, column: 4
                                                              S17776=1;
                                                              if(doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                                doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                                ends[2]=2;
                                                                ;//sysj/turntableController.sysj line: 119, column: 4
                                                                S14096=12;
                                                                if(!tableAligned.getprestatus()){//sysj/turntableController.sysj line: 125, column: 20
                                                                  S14096=13;
                                                                  if(tableAligned.getprestatus()){//sysj/turntableController.sysj line: 128, column: 20
                                                                    m_thread_2.index();//sysj/turntableController.sysj line: 130, column: 4
                                                                    m_thread_2.report();//sysj/turntableController.sysj line: 131, column: 4
                                                                    S14096=14;
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
                                                                  rotaryTrigger.setPresent();//sysj/turntableController.sysj line: 126, column: 5
                                                                  currsigs.addElement(rotaryTrigger);
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
                }
              }
            }
            break;
          
          case 3 : 
            switch(S14141){
              case 0 : 
                if(bottleAtPos1.getprestatus()){//sysj/turntableController.sysj line: 86, column: 21
                  m_thread_2.commitPending();//sysj/turntableController.sysj line: 89, column: 5
                  placed_1.setPresent();//sysj/turntableController.sysj line: 90, column: 5
                  currsigs.addElement(placed_1);
                  S14141=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  loadPos1.setPresent();//sysj/turntableController.sysj line: 87, column: 6
                  currsigs.addElement(loadPos1);
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                break;
              
              case 1 : 
                S14141=1;
                S14096=4;
                S14239=0;
                if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 111, column: 4
                  startFiller1_o.setREQ(false);//sysj/turntableController.sysj line: 111, column: 4
                  S14239=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S14234=0;
                  if(startFiller1_o.isACK()){//sysj/turntableController.sysj line: 111, column: 4
                    startFiller1_o.setVal(m_thread_2.idAt(1));//sysj/turntableController.sysj line: 111, column: 4
                    S14234=1;
                    if(!startFiller1_o.isACK()){//sysj/turntableController.sysj line: 111, column: 4
                      startFiller1_o.setREQ(false);//sysj/turntableController.sysj line: 111, column: 4
                      ends[2]=2;
                      ;//sysj/turntableController.sysj line: 111, column: 4
                      S14096=5;
                      S14613=0;
                      if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 112, column: 4
                        startFiller2_o.setREQ(false);//sysj/turntableController.sysj line: 112, column: 4
                        S14613=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S14608=0;
                        if(startFiller2_o.isACK()){//sysj/turntableController.sysj line: 112, column: 4
                          startFiller2_o.setVal(m_thread_2.idAt(2));//sysj/turntableController.sysj line: 112, column: 4
                          S14608=1;
                          if(!startFiller2_o.isACK()){//sysj/turntableController.sysj line: 112, column: 4
                            startFiller2_o.setREQ(false);//sysj/turntableController.sysj line: 112, column: 4
                            ends[2]=2;
                            ;//sysj/turntableController.sysj line: 112, column: 4
                            S14096=6;
                            S15031=0;
                            if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 113, column: 4
                              startLid_o.setREQ(false);//sysj/turntableController.sysj line: 113, column: 4
                              S15031=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S15026=0;
                              if(startLid_o.isACK()){//sysj/turntableController.sysj line: 113, column: 4
                                startLid_o.setVal(m_thread_2.idAt(3));//sysj/turntableController.sysj line: 113, column: 4
                                S15026=1;
                                if(!startLid_o.isACK()){//sysj/turntableController.sysj line: 113, column: 4
                                  startLid_o.setREQ(false);//sysj/turntableController.sysj line: 113, column: 4
                                  ends[2]=2;
                                  ;//sysj/turntableController.sysj line: 113, column: 4
                                  S14096=7;
                                  S15493=0;
                                  if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 114, column: 4
                                    startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                                    S15493=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S15488=0;
                                    if(startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                                      startCapper_o.setVal(m_thread_2.idAt(4));//sysj/turntableController.sysj line: 114, column: 4
                                      S15488=1;
                                      if(!startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                                        startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                                        ends[2]=2;
                                        ;//sysj/turntableController.sysj line: 114, column: 4
                                        S14096=8;
                                        S15999=0;
                                        if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 116, column: 4
                                          doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                          S15999=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S15994=0;
                                          if(!doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                            doneFiller1_in.setACK(true);//sysj/turntableController.sysj line: 116, column: 4
                                            S15994=1;
                                            if(doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                              doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                              ends[2]=2;
                                              ;//sysj/turntableController.sysj line: 116, column: 4
                                              S14096=9;
                                              S16549=0;
                                              if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 117, column: 4
                                                doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                                S16549=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S16544=0;
                                                if(!doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                                  doneFiller2_in.setACK(true);//sysj/turntableController.sysj line: 117, column: 4
                                                  S16544=1;
                                                  if(doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                                    doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                                    ends[2]=2;
                                                    ;//sysj/turntableController.sysj line: 117, column: 4
                                                    S14096=10;
                                                    S17143=0;
                                                    if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 118, column: 4
                                                      doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                                      S17143=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S17138=0;
                                                      if(!doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                                        doneLid_in.setACK(true);//sysj/turntableController.sysj line: 118, column: 4
                                                        S17138=1;
                                                        if(doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                                          doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                                          ends[2]=2;
                                                          ;//sysj/turntableController.sysj line: 118, column: 4
                                                          S14096=11;
                                                          S17781=0;
                                                          if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 119, column: 4
                                                            doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                            S17781=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S17776=0;
                                                            if(!doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                              doneCapper_in.setACK(true);//sysj/turntableController.sysj line: 119, column: 4
                                                              S17776=1;
                                                              if(doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                                doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                                ends[2]=2;
                                                                ;//sysj/turntableController.sysj line: 119, column: 4
                                                                S14096=12;
                                                                if(!tableAligned.getprestatus()){//sysj/turntableController.sysj line: 125, column: 20
                                                                  S14096=13;
                                                                  if(tableAligned.getprestatus()){//sysj/turntableController.sysj line: 128, column: 20
                                                                    m_thread_2.index();//sysj/turntableController.sysj line: 130, column: 4
                                                                    m_thread_2.report();//sysj/turntableController.sysj line: 131, column: 4
                                                                    S14096=14;
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
                                                                  rotaryTrigger.setPresent();//sysj/turntableController.sysj line: 126, column: 5
                                                                  currsigs.addElement(rotaryTrigger);
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
                }
                break;
              
            }
            break;
          
          case 4 : 
            switch(S14239){
              case 0 : 
                if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 111, column: 4
                  startFiller1_o.setREQ(false);//sysj/turntableController.sysj line: 111, column: 4
                  S14239=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  switch(S14234){
                    case 0 : 
                      if(startFiller1_o.isACK()){//sysj/turntableController.sysj line: 111, column: 4
                        startFiller1_o.setVal(m_thread_2.idAt(1));//sysj/turntableController.sysj line: 111, column: 4
                        S14234=1;
                        if(!startFiller1_o.isACK()){//sysj/turntableController.sysj line: 111, column: 4
                          startFiller1_o.setREQ(false);//sysj/turntableController.sysj line: 111, column: 4
                          ends[2]=2;
                          ;//sysj/turntableController.sysj line: 111, column: 4
                          S14096=5;
                          S14613=0;
                          if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 112, column: 4
                            startFiller2_o.setREQ(false);//sysj/turntableController.sysj line: 112, column: 4
                            S14613=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S14608=0;
                            if(startFiller2_o.isACK()){//sysj/turntableController.sysj line: 112, column: 4
                              startFiller2_o.setVal(m_thread_2.idAt(2));//sysj/turntableController.sysj line: 112, column: 4
                              S14608=1;
                              if(!startFiller2_o.isACK()){//sysj/turntableController.sysj line: 112, column: 4
                                startFiller2_o.setREQ(false);//sysj/turntableController.sysj line: 112, column: 4
                                ends[2]=2;
                                ;//sysj/turntableController.sysj line: 112, column: 4
                                S14096=6;
                                S15031=0;
                                if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 113, column: 4
                                  startLid_o.setREQ(false);//sysj/turntableController.sysj line: 113, column: 4
                                  S15031=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S15026=0;
                                  if(startLid_o.isACK()){//sysj/turntableController.sysj line: 113, column: 4
                                    startLid_o.setVal(m_thread_2.idAt(3));//sysj/turntableController.sysj line: 113, column: 4
                                    S15026=1;
                                    if(!startLid_o.isACK()){//sysj/turntableController.sysj line: 113, column: 4
                                      startLid_o.setREQ(false);//sysj/turntableController.sysj line: 113, column: 4
                                      ends[2]=2;
                                      ;//sysj/turntableController.sysj line: 113, column: 4
                                      S14096=7;
                                      S15493=0;
                                      if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 114, column: 4
                                        startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                                        S15493=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S15488=0;
                                        if(startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                                          startCapper_o.setVal(m_thread_2.idAt(4));//sysj/turntableController.sysj line: 114, column: 4
                                          S15488=1;
                                          if(!startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                                            startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                                            ends[2]=2;
                                            ;//sysj/turntableController.sysj line: 114, column: 4
                                            S14096=8;
                                            S15999=0;
                                            if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 116, column: 4
                                              doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                              S15999=1;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S15994=0;
                                              if(!doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                                doneFiller1_in.setACK(true);//sysj/turntableController.sysj line: 116, column: 4
                                                S15994=1;
                                                if(doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                                  doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                                  ends[2]=2;
                                                  ;//sysj/turntableController.sysj line: 116, column: 4
                                                  S14096=9;
                                                  S16549=0;
                                                  if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 117, column: 4
                                                    doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                                    S16549=1;
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                  else {
                                                    S16544=0;
                                                    if(!doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                                      doneFiller2_in.setACK(true);//sysj/turntableController.sysj line: 117, column: 4
                                                      S16544=1;
                                                      if(doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                                        doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                                        ends[2]=2;
                                                        ;//sysj/turntableController.sysj line: 117, column: 4
                                                        S14096=10;
                                                        S17143=0;
                                                        if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 118, column: 4
                                                          doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                                          S17143=1;
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                        else {
                                                          S17138=0;
                                                          if(!doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                                            doneLid_in.setACK(true);//sysj/turntableController.sysj line: 118, column: 4
                                                            S17138=1;
                                                            if(doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                                              doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                                              ends[2]=2;
                                                              ;//sysj/turntableController.sysj line: 118, column: 4
                                                              S14096=11;
                                                              S17781=0;
                                                              if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 119, column: 4
                                                                doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                                S17781=1;
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                              else {
                                                                S17776=0;
                                                                if(!doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                                  doneCapper_in.setACK(true);//sysj/turntableController.sysj line: 119, column: 4
                                                                  S17776=1;
                                                                  if(doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                                    doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                                    ends[2]=2;
                                                                    ;//sysj/turntableController.sysj line: 119, column: 4
                                                                    S14096=12;
                                                                    if(!tableAligned.getprestatus()){//sysj/turntableController.sysj line: 125, column: 20
                                                                      S14096=13;
                                                                      if(tableAligned.getprestatus()){//sysj/turntableController.sysj line: 128, column: 20
                                                                        m_thread_2.index();//sysj/turntableController.sysj line: 130, column: 4
                                                                        m_thread_2.report();//sysj/turntableController.sysj line: 131, column: 4
                                                                        S14096=14;
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
                                                                      rotaryTrigger.setPresent();//sysj/turntableController.sysj line: 126, column: 5
                                                                      currsigs.addElement(rotaryTrigger);
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
                    
                    case 1 : 
                      if(!startFiller1_o.isACK()){//sysj/turntableController.sysj line: 111, column: 4
                        startFiller1_o.setREQ(false);//sysj/turntableController.sysj line: 111, column: 4
                        ends[2]=2;
                        ;//sysj/turntableController.sysj line: 111, column: 4
                        S14096=5;
                        S14613=0;
                        if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 112, column: 4
                          startFiller2_o.setREQ(false);//sysj/turntableController.sysj line: 112, column: 4
                          S14613=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          S14608=0;
                          if(startFiller2_o.isACK()){//sysj/turntableController.sysj line: 112, column: 4
                            startFiller2_o.setVal(m_thread_2.idAt(2));//sysj/turntableController.sysj line: 112, column: 4
                            S14608=1;
                            if(!startFiller2_o.isACK()){//sysj/turntableController.sysj line: 112, column: 4
                              startFiller2_o.setREQ(false);//sysj/turntableController.sysj line: 112, column: 4
                              ends[2]=2;
                              ;//sysj/turntableController.sysj line: 112, column: 4
                              S14096=6;
                              S15031=0;
                              if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 113, column: 4
                                startLid_o.setREQ(false);//sysj/turntableController.sysj line: 113, column: 4
                                S15031=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S15026=0;
                                if(startLid_o.isACK()){//sysj/turntableController.sysj line: 113, column: 4
                                  startLid_o.setVal(m_thread_2.idAt(3));//sysj/turntableController.sysj line: 113, column: 4
                                  S15026=1;
                                  if(!startLid_o.isACK()){//sysj/turntableController.sysj line: 113, column: 4
                                    startLid_o.setREQ(false);//sysj/turntableController.sysj line: 113, column: 4
                                    ends[2]=2;
                                    ;//sysj/turntableController.sysj line: 113, column: 4
                                    S14096=7;
                                    S15493=0;
                                    if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 114, column: 4
                                      startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                                      S15493=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S15488=0;
                                      if(startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                                        startCapper_o.setVal(m_thread_2.idAt(4));//sysj/turntableController.sysj line: 114, column: 4
                                        S15488=1;
                                        if(!startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                                          startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                                          ends[2]=2;
                                          ;//sysj/turntableController.sysj line: 114, column: 4
                                          S14096=8;
                                          S15999=0;
                                          if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 116, column: 4
                                            doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                            S15999=1;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S15994=0;
                                            if(!doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                              doneFiller1_in.setACK(true);//sysj/turntableController.sysj line: 116, column: 4
                                              S15994=1;
                                              if(doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                                doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                                ends[2]=2;
                                                ;//sysj/turntableController.sysj line: 116, column: 4
                                                S14096=9;
                                                S16549=0;
                                                if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 117, column: 4
                                                  doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                                  S16549=1;
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                                else {
                                                  S16544=0;
                                                  if(!doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                                    doneFiller2_in.setACK(true);//sysj/turntableController.sysj line: 117, column: 4
                                                    S16544=1;
                                                    if(doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                                      doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                                      ends[2]=2;
                                                      ;//sysj/turntableController.sysj line: 117, column: 4
                                                      S14096=10;
                                                      S17143=0;
                                                      if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 118, column: 4
                                                        doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                                        S17143=1;
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                      else {
                                                        S17138=0;
                                                        if(!doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                                          doneLid_in.setACK(true);//sysj/turntableController.sysj line: 118, column: 4
                                                          S17138=1;
                                                          if(doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                                            doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                                            ends[2]=2;
                                                            ;//sysj/turntableController.sysj line: 118, column: 4
                                                            S14096=11;
                                                            S17781=0;
                                                            if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 119, column: 4
                                                              doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                              S17781=1;
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                            else {
                                                              S17776=0;
                                                              if(!doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                                doneCapper_in.setACK(true);//sysj/turntableController.sysj line: 119, column: 4
                                                                S17776=1;
                                                                if(doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                                  doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                                  ends[2]=2;
                                                                  ;//sysj/turntableController.sysj line: 119, column: 4
                                                                  S14096=12;
                                                                  if(!tableAligned.getprestatus()){//sysj/turntableController.sysj line: 125, column: 20
                                                                    S14096=13;
                                                                    if(tableAligned.getprestatus()){//sysj/turntableController.sysj line: 128, column: 20
                                                                      m_thread_2.index();//sysj/turntableController.sysj line: 130, column: 4
                                                                      m_thread_2.report();//sysj/turntableController.sysj line: 131, column: 4
                                                                      S14096=14;
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
                                                                    rotaryTrigger.setPresent();//sysj/turntableController.sysj line: 126, column: 5
                                                                    currsigs.addElement(rotaryTrigger);
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
                break;
              
              case 1 : 
                S14239=1;
                S14239=0;
                if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 111, column: 4
                  startFiller1_o.setREQ(false);//sysj/turntableController.sysj line: 111, column: 4
                  S14239=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S14234=0;
                  if(startFiller1_o.isACK()){//sysj/turntableController.sysj line: 111, column: 4
                    startFiller1_o.setVal(m_thread_2.idAt(1));//sysj/turntableController.sysj line: 111, column: 4
                    S14234=1;
                    if(!startFiller1_o.isACK()){//sysj/turntableController.sysj line: 111, column: 4
                      startFiller1_o.setREQ(false);//sysj/turntableController.sysj line: 111, column: 4
                      ends[2]=2;
                      ;//sysj/turntableController.sysj line: 111, column: 4
                      S14096=5;
                      S14613=0;
                      if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 112, column: 4
                        startFiller2_o.setREQ(false);//sysj/turntableController.sysj line: 112, column: 4
                        S14613=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S14608=0;
                        if(startFiller2_o.isACK()){//sysj/turntableController.sysj line: 112, column: 4
                          startFiller2_o.setVal(m_thread_2.idAt(2));//sysj/turntableController.sysj line: 112, column: 4
                          S14608=1;
                          if(!startFiller2_o.isACK()){//sysj/turntableController.sysj line: 112, column: 4
                            startFiller2_o.setREQ(false);//sysj/turntableController.sysj line: 112, column: 4
                            ends[2]=2;
                            ;//sysj/turntableController.sysj line: 112, column: 4
                            S14096=6;
                            S15031=0;
                            if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 113, column: 4
                              startLid_o.setREQ(false);//sysj/turntableController.sysj line: 113, column: 4
                              S15031=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S15026=0;
                              if(startLid_o.isACK()){//sysj/turntableController.sysj line: 113, column: 4
                                startLid_o.setVal(m_thread_2.idAt(3));//sysj/turntableController.sysj line: 113, column: 4
                                S15026=1;
                                if(!startLid_o.isACK()){//sysj/turntableController.sysj line: 113, column: 4
                                  startLid_o.setREQ(false);//sysj/turntableController.sysj line: 113, column: 4
                                  ends[2]=2;
                                  ;//sysj/turntableController.sysj line: 113, column: 4
                                  S14096=7;
                                  S15493=0;
                                  if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 114, column: 4
                                    startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                                    S15493=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S15488=0;
                                    if(startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                                      startCapper_o.setVal(m_thread_2.idAt(4));//sysj/turntableController.sysj line: 114, column: 4
                                      S15488=1;
                                      if(!startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                                        startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                                        ends[2]=2;
                                        ;//sysj/turntableController.sysj line: 114, column: 4
                                        S14096=8;
                                        S15999=0;
                                        if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 116, column: 4
                                          doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                          S15999=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S15994=0;
                                          if(!doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                            doneFiller1_in.setACK(true);//sysj/turntableController.sysj line: 116, column: 4
                                            S15994=1;
                                            if(doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                              doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                              ends[2]=2;
                                              ;//sysj/turntableController.sysj line: 116, column: 4
                                              S14096=9;
                                              S16549=0;
                                              if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 117, column: 4
                                                doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                                S16549=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S16544=0;
                                                if(!doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                                  doneFiller2_in.setACK(true);//sysj/turntableController.sysj line: 117, column: 4
                                                  S16544=1;
                                                  if(doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                                    doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                                    ends[2]=2;
                                                    ;//sysj/turntableController.sysj line: 117, column: 4
                                                    S14096=10;
                                                    S17143=0;
                                                    if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 118, column: 4
                                                      doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                                      S17143=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S17138=0;
                                                      if(!doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                                        doneLid_in.setACK(true);//sysj/turntableController.sysj line: 118, column: 4
                                                        S17138=1;
                                                        if(doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                                          doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                                          ends[2]=2;
                                                          ;//sysj/turntableController.sysj line: 118, column: 4
                                                          S14096=11;
                                                          S17781=0;
                                                          if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 119, column: 4
                                                            doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                            S17781=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S17776=0;
                                                            if(!doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                              doneCapper_in.setACK(true);//sysj/turntableController.sysj line: 119, column: 4
                                                              S17776=1;
                                                              if(doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                                doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                                ends[2]=2;
                                                                ;//sysj/turntableController.sysj line: 119, column: 4
                                                                S14096=12;
                                                                if(!tableAligned.getprestatus()){//sysj/turntableController.sysj line: 125, column: 20
                                                                  S14096=13;
                                                                  if(tableAligned.getprestatus()){//sysj/turntableController.sysj line: 128, column: 20
                                                                    m_thread_2.index();//sysj/turntableController.sysj line: 130, column: 4
                                                                    m_thread_2.report();//sysj/turntableController.sysj line: 131, column: 4
                                                                    S14096=14;
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
                                                                  rotaryTrigger.setPresent();//sysj/turntableController.sysj line: 126, column: 5
                                                                  currsigs.addElement(rotaryTrigger);
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
                }
                break;
              
            }
            break;
          
          case 5 : 
            switch(S14613){
              case 0 : 
                if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 112, column: 4
                  startFiller2_o.setREQ(false);//sysj/turntableController.sysj line: 112, column: 4
                  S14613=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  switch(S14608){
                    case 0 : 
                      if(startFiller2_o.isACK()){//sysj/turntableController.sysj line: 112, column: 4
                        startFiller2_o.setVal(m_thread_2.idAt(2));//sysj/turntableController.sysj line: 112, column: 4
                        S14608=1;
                        if(!startFiller2_o.isACK()){//sysj/turntableController.sysj line: 112, column: 4
                          startFiller2_o.setREQ(false);//sysj/turntableController.sysj line: 112, column: 4
                          ends[2]=2;
                          ;//sysj/turntableController.sysj line: 112, column: 4
                          S14096=6;
                          S15031=0;
                          if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 113, column: 4
                            startLid_o.setREQ(false);//sysj/turntableController.sysj line: 113, column: 4
                            S15031=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S15026=0;
                            if(startLid_o.isACK()){//sysj/turntableController.sysj line: 113, column: 4
                              startLid_o.setVal(m_thread_2.idAt(3));//sysj/turntableController.sysj line: 113, column: 4
                              S15026=1;
                              if(!startLid_o.isACK()){//sysj/turntableController.sysj line: 113, column: 4
                                startLid_o.setREQ(false);//sysj/turntableController.sysj line: 113, column: 4
                                ends[2]=2;
                                ;//sysj/turntableController.sysj line: 113, column: 4
                                S14096=7;
                                S15493=0;
                                if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 114, column: 4
                                  startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                                  S15493=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S15488=0;
                                  if(startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                                    startCapper_o.setVal(m_thread_2.idAt(4));//sysj/turntableController.sysj line: 114, column: 4
                                    S15488=1;
                                    if(!startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                                      startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                                      ends[2]=2;
                                      ;//sysj/turntableController.sysj line: 114, column: 4
                                      S14096=8;
                                      S15999=0;
                                      if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 116, column: 4
                                        doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                        S15999=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S15994=0;
                                        if(!doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                          doneFiller1_in.setACK(true);//sysj/turntableController.sysj line: 116, column: 4
                                          S15994=1;
                                          if(doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                            doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                            ends[2]=2;
                                            ;//sysj/turntableController.sysj line: 116, column: 4
                                            S14096=9;
                                            S16549=0;
                                            if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 117, column: 4
                                              doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                              S16549=1;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S16544=0;
                                              if(!doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                                doneFiller2_in.setACK(true);//sysj/turntableController.sysj line: 117, column: 4
                                                S16544=1;
                                                if(doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                                  doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                                  ends[2]=2;
                                                  ;//sysj/turntableController.sysj line: 117, column: 4
                                                  S14096=10;
                                                  S17143=0;
                                                  if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 118, column: 4
                                                    doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                                    S17143=1;
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                  else {
                                                    S17138=0;
                                                    if(!doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                                      doneLid_in.setACK(true);//sysj/turntableController.sysj line: 118, column: 4
                                                      S17138=1;
                                                      if(doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                                        doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                                        ends[2]=2;
                                                        ;//sysj/turntableController.sysj line: 118, column: 4
                                                        S14096=11;
                                                        S17781=0;
                                                        if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 119, column: 4
                                                          doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                          S17781=1;
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                        else {
                                                          S17776=0;
                                                          if(!doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                            doneCapper_in.setACK(true);//sysj/turntableController.sysj line: 119, column: 4
                                                            S17776=1;
                                                            if(doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                              doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                              ends[2]=2;
                                                              ;//sysj/turntableController.sysj line: 119, column: 4
                                                              S14096=12;
                                                              if(!tableAligned.getprestatus()){//sysj/turntableController.sysj line: 125, column: 20
                                                                S14096=13;
                                                                if(tableAligned.getprestatus()){//sysj/turntableController.sysj line: 128, column: 20
                                                                  m_thread_2.index();//sysj/turntableController.sysj line: 130, column: 4
                                                                  m_thread_2.report();//sysj/turntableController.sysj line: 131, column: 4
                                                                  S14096=14;
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
                                                                rotaryTrigger.setPresent();//sysj/turntableController.sysj line: 126, column: 5
                                                                currsigs.addElement(rotaryTrigger);
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
                    
                    case 1 : 
                      if(!startFiller2_o.isACK()){//sysj/turntableController.sysj line: 112, column: 4
                        startFiller2_o.setREQ(false);//sysj/turntableController.sysj line: 112, column: 4
                        ends[2]=2;
                        ;//sysj/turntableController.sysj line: 112, column: 4
                        S14096=6;
                        S15031=0;
                        if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 113, column: 4
                          startLid_o.setREQ(false);//sysj/turntableController.sysj line: 113, column: 4
                          S15031=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          S15026=0;
                          if(startLid_o.isACK()){//sysj/turntableController.sysj line: 113, column: 4
                            startLid_o.setVal(m_thread_2.idAt(3));//sysj/turntableController.sysj line: 113, column: 4
                            S15026=1;
                            if(!startLid_o.isACK()){//sysj/turntableController.sysj line: 113, column: 4
                              startLid_o.setREQ(false);//sysj/turntableController.sysj line: 113, column: 4
                              ends[2]=2;
                              ;//sysj/turntableController.sysj line: 113, column: 4
                              S14096=7;
                              S15493=0;
                              if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 114, column: 4
                                startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                                S15493=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S15488=0;
                                if(startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                                  startCapper_o.setVal(m_thread_2.idAt(4));//sysj/turntableController.sysj line: 114, column: 4
                                  S15488=1;
                                  if(!startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                                    startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                                    ends[2]=2;
                                    ;//sysj/turntableController.sysj line: 114, column: 4
                                    S14096=8;
                                    S15999=0;
                                    if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 116, column: 4
                                      doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                      S15999=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S15994=0;
                                      if(!doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                        doneFiller1_in.setACK(true);//sysj/turntableController.sysj line: 116, column: 4
                                        S15994=1;
                                        if(doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                          doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                          ends[2]=2;
                                          ;//sysj/turntableController.sysj line: 116, column: 4
                                          S14096=9;
                                          S16549=0;
                                          if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 117, column: 4
                                            doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                            S16549=1;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S16544=0;
                                            if(!doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                              doneFiller2_in.setACK(true);//sysj/turntableController.sysj line: 117, column: 4
                                              S16544=1;
                                              if(doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                                doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                                ends[2]=2;
                                                ;//sysj/turntableController.sysj line: 117, column: 4
                                                S14096=10;
                                                S17143=0;
                                                if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 118, column: 4
                                                  doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                                  S17143=1;
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                                else {
                                                  S17138=0;
                                                  if(!doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                                    doneLid_in.setACK(true);//sysj/turntableController.sysj line: 118, column: 4
                                                    S17138=1;
                                                    if(doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                                      doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                                      ends[2]=2;
                                                      ;//sysj/turntableController.sysj line: 118, column: 4
                                                      S14096=11;
                                                      S17781=0;
                                                      if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 119, column: 4
                                                        doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                        S17781=1;
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                      else {
                                                        S17776=0;
                                                        if(!doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                          doneCapper_in.setACK(true);//sysj/turntableController.sysj line: 119, column: 4
                                                          S17776=1;
                                                          if(doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                            doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                            ends[2]=2;
                                                            ;//sysj/turntableController.sysj line: 119, column: 4
                                                            S14096=12;
                                                            if(!tableAligned.getprestatus()){//sysj/turntableController.sysj line: 125, column: 20
                                                              S14096=13;
                                                              if(tableAligned.getprestatus()){//sysj/turntableController.sysj line: 128, column: 20
                                                                m_thread_2.index();//sysj/turntableController.sysj line: 130, column: 4
                                                                m_thread_2.report();//sysj/turntableController.sysj line: 131, column: 4
                                                                S14096=14;
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
                                                              rotaryTrigger.setPresent();//sysj/turntableController.sysj line: 126, column: 5
                                                              currsigs.addElement(rotaryTrigger);
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
                break;
              
              case 1 : 
                S14613=1;
                S14613=0;
                if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 112, column: 4
                  startFiller2_o.setREQ(false);//sysj/turntableController.sysj line: 112, column: 4
                  S14613=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S14608=0;
                  if(startFiller2_o.isACK()){//sysj/turntableController.sysj line: 112, column: 4
                    startFiller2_o.setVal(m_thread_2.idAt(2));//sysj/turntableController.sysj line: 112, column: 4
                    S14608=1;
                    if(!startFiller2_o.isACK()){//sysj/turntableController.sysj line: 112, column: 4
                      startFiller2_o.setREQ(false);//sysj/turntableController.sysj line: 112, column: 4
                      ends[2]=2;
                      ;//sysj/turntableController.sysj line: 112, column: 4
                      S14096=6;
                      S15031=0;
                      if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 113, column: 4
                        startLid_o.setREQ(false);//sysj/turntableController.sysj line: 113, column: 4
                        S15031=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S15026=0;
                        if(startLid_o.isACK()){//sysj/turntableController.sysj line: 113, column: 4
                          startLid_o.setVal(m_thread_2.idAt(3));//sysj/turntableController.sysj line: 113, column: 4
                          S15026=1;
                          if(!startLid_o.isACK()){//sysj/turntableController.sysj line: 113, column: 4
                            startLid_o.setREQ(false);//sysj/turntableController.sysj line: 113, column: 4
                            ends[2]=2;
                            ;//sysj/turntableController.sysj line: 113, column: 4
                            S14096=7;
                            S15493=0;
                            if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 114, column: 4
                              startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                              S15493=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S15488=0;
                              if(startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                                startCapper_o.setVal(m_thread_2.idAt(4));//sysj/turntableController.sysj line: 114, column: 4
                                S15488=1;
                                if(!startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                                  startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                                  ends[2]=2;
                                  ;//sysj/turntableController.sysj line: 114, column: 4
                                  S14096=8;
                                  S15999=0;
                                  if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 116, column: 4
                                    doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                    S15999=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S15994=0;
                                    if(!doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                      doneFiller1_in.setACK(true);//sysj/turntableController.sysj line: 116, column: 4
                                      S15994=1;
                                      if(doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                        doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                        ends[2]=2;
                                        ;//sysj/turntableController.sysj line: 116, column: 4
                                        S14096=9;
                                        S16549=0;
                                        if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 117, column: 4
                                          doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                          S16549=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S16544=0;
                                          if(!doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                            doneFiller2_in.setACK(true);//sysj/turntableController.sysj line: 117, column: 4
                                            S16544=1;
                                            if(doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                              doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                              ends[2]=2;
                                              ;//sysj/turntableController.sysj line: 117, column: 4
                                              S14096=10;
                                              S17143=0;
                                              if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 118, column: 4
                                                doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                                S17143=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S17138=0;
                                                if(!doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                                  doneLid_in.setACK(true);//sysj/turntableController.sysj line: 118, column: 4
                                                  S17138=1;
                                                  if(doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                                    doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                                    ends[2]=2;
                                                    ;//sysj/turntableController.sysj line: 118, column: 4
                                                    S14096=11;
                                                    S17781=0;
                                                    if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 119, column: 4
                                                      doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                      S17781=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S17776=0;
                                                      if(!doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                        doneCapper_in.setACK(true);//sysj/turntableController.sysj line: 119, column: 4
                                                        S17776=1;
                                                        if(doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                          doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                          ends[2]=2;
                                                          ;//sysj/turntableController.sysj line: 119, column: 4
                                                          S14096=12;
                                                          if(!tableAligned.getprestatus()){//sysj/turntableController.sysj line: 125, column: 20
                                                            S14096=13;
                                                            if(tableAligned.getprestatus()){//sysj/turntableController.sysj line: 128, column: 20
                                                              m_thread_2.index();//sysj/turntableController.sysj line: 130, column: 4
                                                              m_thread_2.report();//sysj/turntableController.sysj line: 131, column: 4
                                                              S14096=14;
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
                                                            rotaryTrigger.setPresent();//sysj/turntableController.sysj line: 126, column: 5
                                                            currsigs.addElement(rotaryTrigger);
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
                }
                break;
              
            }
            break;
          
          case 6 : 
            switch(S15031){
              case 0 : 
                if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 113, column: 4
                  startLid_o.setREQ(false);//sysj/turntableController.sysj line: 113, column: 4
                  S15031=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  switch(S15026){
                    case 0 : 
                      if(startLid_o.isACK()){//sysj/turntableController.sysj line: 113, column: 4
                        startLid_o.setVal(m_thread_2.idAt(3));//sysj/turntableController.sysj line: 113, column: 4
                        S15026=1;
                        if(!startLid_o.isACK()){//sysj/turntableController.sysj line: 113, column: 4
                          startLid_o.setREQ(false);//sysj/turntableController.sysj line: 113, column: 4
                          ends[2]=2;
                          ;//sysj/turntableController.sysj line: 113, column: 4
                          S14096=7;
                          S15493=0;
                          if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 114, column: 4
                            startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                            S15493=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S15488=0;
                            if(startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                              startCapper_o.setVal(m_thread_2.idAt(4));//sysj/turntableController.sysj line: 114, column: 4
                              S15488=1;
                              if(!startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                                startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                                ends[2]=2;
                                ;//sysj/turntableController.sysj line: 114, column: 4
                                S14096=8;
                                S15999=0;
                                if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 116, column: 4
                                  doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                  S15999=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S15994=0;
                                  if(!doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                    doneFiller1_in.setACK(true);//sysj/turntableController.sysj line: 116, column: 4
                                    S15994=1;
                                    if(doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                      doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                      ends[2]=2;
                                      ;//sysj/turntableController.sysj line: 116, column: 4
                                      S14096=9;
                                      S16549=0;
                                      if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 117, column: 4
                                        doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                        S16549=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S16544=0;
                                        if(!doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                          doneFiller2_in.setACK(true);//sysj/turntableController.sysj line: 117, column: 4
                                          S16544=1;
                                          if(doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                            doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                            ends[2]=2;
                                            ;//sysj/turntableController.sysj line: 117, column: 4
                                            S14096=10;
                                            S17143=0;
                                            if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 118, column: 4
                                              doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                              S17143=1;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S17138=0;
                                              if(!doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                                doneLid_in.setACK(true);//sysj/turntableController.sysj line: 118, column: 4
                                                S17138=1;
                                                if(doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                                  doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                                  ends[2]=2;
                                                  ;//sysj/turntableController.sysj line: 118, column: 4
                                                  S14096=11;
                                                  S17781=0;
                                                  if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 119, column: 4
                                                    doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                    S17781=1;
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                  else {
                                                    S17776=0;
                                                    if(!doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                      doneCapper_in.setACK(true);//sysj/turntableController.sysj line: 119, column: 4
                                                      S17776=1;
                                                      if(doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                        doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                        ends[2]=2;
                                                        ;//sysj/turntableController.sysj line: 119, column: 4
                                                        S14096=12;
                                                        if(!tableAligned.getprestatus()){//sysj/turntableController.sysj line: 125, column: 20
                                                          S14096=13;
                                                          if(tableAligned.getprestatus()){//sysj/turntableController.sysj line: 128, column: 20
                                                            m_thread_2.index();//sysj/turntableController.sysj line: 130, column: 4
                                                            m_thread_2.report();//sysj/turntableController.sysj line: 131, column: 4
                                                            S14096=14;
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
                                                          rotaryTrigger.setPresent();//sysj/turntableController.sysj line: 126, column: 5
                                                          currsigs.addElement(rotaryTrigger);
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
                    
                    case 1 : 
                      if(!startLid_o.isACK()){//sysj/turntableController.sysj line: 113, column: 4
                        startLid_o.setREQ(false);//sysj/turntableController.sysj line: 113, column: 4
                        ends[2]=2;
                        ;//sysj/turntableController.sysj line: 113, column: 4
                        S14096=7;
                        S15493=0;
                        if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 114, column: 4
                          startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                          S15493=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          S15488=0;
                          if(startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                            startCapper_o.setVal(m_thread_2.idAt(4));//sysj/turntableController.sysj line: 114, column: 4
                            S15488=1;
                            if(!startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                              startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                              ends[2]=2;
                              ;//sysj/turntableController.sysj line: 114, column: 4
                              S14096=8;
                              S15999=0;
                              if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 116, column: 4
                                doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                S15999=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S15994=0;
                                if(!doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                  doneFiller1_in.setACK(true);//sysj/turntableController.sysj line: 116, column: 4
                                  S15994=1;
                                  if(doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                    doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                    ends[2]=2;
                                    ;//sysj/turntableController.sysj line: 116, column: 4
                                    S14096=9;
                                    S16549=0;
                                    if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 117, column: 4
                                      doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                      S16549=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S16544=0;
                                      if(!doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                        doneFiller2_in.setACK(true);//sysj/turntableController.sysj line: 117, column: 4
                                        S16544=1;
                                        if(doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                          doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                          ends[2]=2;
                                          ;//sysj/turntableController.sysj line: 117, column: 4
                                          S14096=10;
                                          S17143=0;
                                          if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 118, column: 4
                                            doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                            S17143=1;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S17138=0;
                                            if(!doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                              doneLid_in.setACK(true);//sysj/turntableController.sysj line: 118, column: 4
                                              S17138=1;
                                              if(doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                                doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                                ends[2]=2;
                                                ;//sysj/turntableController.sysj line: 118, column: 4
                                                S14096=11;
                                                S17781=0;
                                                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 119, column: 4
                                                  doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                  S17781=1;
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                                else {
                                                  S17776=0;
                                                  if(!doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                    doneCapper_in.setACK(true);//sysj/turntableController.sysj line: 119, column: 4
                                                    S17776=1;
                                                    if(doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                      doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                      ends[2]=2;
                                                      ;//sysj/turntableController.sysj line: 119, column: 4
                                                      S14096=12;
                                                      if(!tableAligned.getprestatus()){//sysj/turntableController.sysj line: 125, column: 20
                                                        S14096=13;
                                                        if(tableAligned.getprestatus()){//sysj/turntableController.sysj line: 128, column: 20
                                                          m_thread_2.index();//sysj/turntableController.sysj line: 130, column: 4
                                                          m_thread_2.report();//sysj/turntableController.sysj line: 131, column: 4
                                                          S14096=14;
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
                                                        rotaryTrigger.setPresent();//sysj/turntableController.sysj line: 126, column: 5
                                                        currsigs.addElement(rotaryTrigger);
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
                break;
              
              case 1 : 
                S15031=1;
                S15031=0;
                if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 113, column: 4
                  startLid_o.setREQ(false);//sysj/turntableController.sysj line: 113, column: 4
                  S15031=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S15026=0;
                  if(startLid_o.isACK()){//sysj/turntableController.sysj line: 113, column: 4
                    startLid_o.setVal(m_thread_2.idAt(3));//sysj/turntableController.sysj line: 113, column: 4
                    S15026=1;
                    if(!startLid_o.isACK()){//sysj/turntableController.sysj line: 113, column: 4
                      startLid_o.setREQ(false);//sysj/turntableController.sysj line: 113, column: 4
                      ends[2]=2;
                      ;//sysj/turntableController.sysj line: 113, column: 4
                      S14096=7;
                      S15493=0;
                      if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 114, column: 4
                        startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                        S15493=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S15488=0;
                        if(startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                          startCapper_o.setVal(m_thread_2.idAt(4));//sysj/turntableController.sysj line: 114, column: 4
                          S15488=1;
                          if(!startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                            startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                            ends[2]=2;
                            ;//sysj/turntableController.sysj line: 114, column: 4
                            S14096=8;
                            S15999=0;
                            if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 116, column: 4
                              doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                              S15999=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S15994=0;
                              if(!doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                doneFiller1_in.setACK(true);//sysj/turntableController.sysj line: 116, column: 4
                                S15994=1;
                                if(doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                  doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                  ends[2]=2;
                                  ;//sysj/turntableController.sysj line: 116, column: 4
                                  S14096=9;
                                  S16549=0;
                                  if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 117, column: 4
                                    doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                    S16549=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S16544=0;
                                    if(!doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                      doneFiller2_in.setACK(true);//sysj/turntableController.sysj line: 117, column: 4
                                      S16544=1;
                                      if(doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                        doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                        ends[2]=2;
                                        ;//sysj/turntableController.sysj line: 117, column: 4
                                        S14096=10;
                                        S17143=0;
                                        if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 118, column: 4
                                          doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                          S17143=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S17138=0;
                                          if(!doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                            doneLid_in.setACK(true);//sysj/turntableController.sysj line: 118, column: 4
                                            S17138=1;
                                            if(doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                              doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                              ends[2]=2;
                                              ;//sysj/turntableController.sysj line: 118, column: 4
                                              S14096=11;
                                              S17781=0;
                                              if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 119, column: 4
                                                doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                S17781=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S17776=0;
                                                if(!doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                  doneCapper_in.setACK(true);//sysj/turntableController.sysj line: 119, column: 4
                                                  S17776=1;
                                                  if(doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                    doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                    ends[2]=2;
                                                    ;//sysj/turntableController.sysj line: 119, column: 4
                                                    S14096=12;
                                                    if(!tableAligned.getprestatus()){//sysj/turntableController.sysj line: 125, column: 20
                                                      S14096=13;
                                                      if(tableAligned.getprestatus()){//sysj/turntableController.sysj line: 128, column: 20
                                                        m_thread_2.index();//sysj/turntableController.sysj line: 130, column: 4
                                                        m_thread_2.report();//sysj/turntableController.sysj line: 131, column: 4
                                                        S14096=14;
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
                                                      rotaryTrigger.setPresent();//sysj/turntableController.sysj line: 126, column: 5
                                                      currsigs.addElement(rotaryTrigger);
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
                }
                break;
              
            }
            break;
          
          case 7 : 
            switch(S15493){
              case 0 : 
                if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 114, column: 4
                  startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                  S15493=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  switch(S15488){
                    case 0 : 
                      if(startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                        startCapper_o.setVal(m_thread_2.idAt(4));//sysj/turntableController.sysj line: 114, column: 4
                        S15488=1;
                        if(!startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                          startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                          ends[2]=2;
                          ;//sysj/turntableController.sysj line: 114, column: 4
                          S14096=8;
                          S15999=0;
                          if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 116, column: 4
                            doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                            S15999=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S15994=0;
                            if(!doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                              doneFiller1_in.setACK(true);//sysj/turntableController.sysj line: 116, column: 4
                              S15994=1;
                              if(doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                ends[2]=2;
                                ;//sysj/turntableController.sysj line: 116, column: 4
                                S14096=9;
                                S16549=0;
                                if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 117, column: 4
                                  doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                  S16549=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S16544=0;
                                  if(!doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                    doneFiller2_in.setACK(true);//sysj/turntableController.sysj line: 117, column: 4
                                    S16544=1;
                                    if(doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                      doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                      ends[2]=2;
                                      ;//sysj/turntableController.sysj line: 117, column: 4
                                      S14096=10;
                                      S17143=0;
                                      if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 118, column: 4
                                        doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                        S17143=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S17138=0;
                                        if(!doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                          doneLid_in.setACK(true);//sysj/turntableController.sysj line: 118, column: 4
                                          S17138=1;
                                          if(doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                            doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                            ends[2]=2;
                                            ;//sysj/turntableController.sysj line: 118, column: 4
                                            S14096=11;
                                            S17781=0;
                                            if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 119, column: 4
                                              doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                              S17781=1;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S17776=0;
                                              if(!doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                doneCapper_in.setACK(true);//sysj/turntableController.sysj line: 119, column: 4
                                                S17776=1;
                                                if(doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                  doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                  ends[2]=2;
                                                  ;//sysj/turntableController.sysj line: 119, column: 4
                                                  S14096=12;
                                                  if(!tableAligned.getprestatus()){//sysj/turntableController.sysj line: 125, column: 20
                                                    S14096=13;
                                                    if(tableAligned.getprestatus()){//sysj/turntableController.sysj line: 128, column: 20
                                                      m_thread_2.index();//sysj/turntableController.sysj line: 130, column: 4
                                                      m_thread_2.report();//sysj/turntableController.sysj line: 131, column: 4
                                                      S14096=14;
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
                                                    rotaryTrigger.setPresent();//sysj/turntableController.sysj line: 126, column: 5
                                                    currsigs.addElement(rotaryTrigger);
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
                    
                    case 1 : 
                      if(!startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                        startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                        ends[2]=2;
                        ;//sysj/turntableController.sysj line: 114, column: 4
                        S14096=8;
                        S15999=0;
                        if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 116, column: 4
                          doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                          S15999=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          S15994=0;
                          if(!doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                            doneFiller1_in.setACK(true);//sysj/turntableController.sysj line: 116, column: 4
                            S15994=1;
                            if(doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                              doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                              ends[2]=2;
                              ;//sysj/turntableController.sysj line: 116, column: 4
                              S14096=9;
                              S16549=0;
                              if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 117, column: 4
                                doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                S16549=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S16544=0;
                                if(!doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                  doneFiller2_in.setACK(true);//sysj/turntableController.sysj line: 117, column: 4
                                  S16544=1;
                                  if(doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                    doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                    ends[2]=2;
                                    ;//sysj/turntableController.sysj line: 117, column: 4
                                    S14096=10;
                                    S17143=0;
                                    if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 118, column: 4
                                      doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                      S17143=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S17138=0;
                                      if(!doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                        doneLid_in.setACK(true);//sysj/turntableController.sysj line: 118, column: 4
                                        S17138=1;
                                        if(doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                          doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                          ends[2]=2;
                                          ;//sysj/turntableController.sysj line: 118, column: 4
                                          S14096=11;
                                          S17781=0;
                                          if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 119, column: 4
                                            doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                            S17781=1;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S17776=0;
                                            if(!doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                              doneCapper_in.setACK(true);//sysj/turntableController.sysj line: 119, column: 4
                                              S17776=1;
                                              if(doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                ends[2]=2;
                                                ;//sysj/turntableController.sysj line: 119, column: 4
                                                S14096=12;
                                                if(!tableAligned.getprestatus()){//sysj/turntableController.sysj line: 125, column: 20
                                                  S14096=13;
                                                  if(tableAligned.getprestatus()){//sysj/turntableController.sysj line: 128, column: 20
                                                    m_thread_2.index();//sysj/turntableController.sysj line: 130, column: 4
                                                    m_thread_2.report();//sysj/turntableController.sysj line: 131, column: 4
                                                    S14096=14;
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
                                                  rotaryTrigger.setPresent();//sysj/turntableController.sysj line: 126, column: 5
                                                  currsigs.addElement(rotaryTrigger);
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
                break;
              
              case 1 : 
                S15493=1;
                S15493=0;
                if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 114, column: 4
                  startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                  S15493=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S15488=0;
                  if(startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                    startCapper_o.setVal(m_thread_2.idAt(4));//sysj/turntableController.sysj line: 114, column: 4
                    S15488=1;
                    if(!startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                      startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                      ends[2]=2;
                      ;//sysj/turntableController.sysj line: 114, column: 4
                      S14096=8;
                      S15999=0;
                      if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 116, column: 4
                        doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                        S15999=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S15994=0;
                        if(!doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                          doneFiller1_in.setACK(true);//sysj/turntableController.sysj line: 116, column: 4
                          S15994=1;
                          if(doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                            doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                            ends[2]=2;
                            ;//sysj/turntableController.sysj line: 116, column: 4
                            S14096=9;
                            S16549=0;
                            if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 117, column: 4
                              doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                              S16549=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S16544=0;
                              if(!doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                doneFiller2_in.setACK(true);//sysj/turntableController.sysj line: 117, column: 4
                                S16544=1;
                                if(doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                  doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                  ends[2]=2;
                                  ;//sysj/turntableController.sysj line: 117, column: 4
                                  S14096=10;
                                  S17143=0;
                                  if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 118, column: 4
                                    doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                    S17143=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S17138=0;
                                    if(!doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                      doneLid_in.setACK(true);//sysj/turntableController.sysj line: 118, column: 4
                                      S17138=1;
                                      if(doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                        doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                        ends[2]=2;
                                        ;//sysj/turntableController.sysj line: 118, column: 4
                                        S14096=11;
                                        S17781=0;
                                        if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 119, column: 4
                                          doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                          S17781=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S17776=0;
                                          if(!doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                            doneCapper_in.setACK(true);//sysj/turntableController.sysj line: 119, column: 4
                                            S17776=1;
                                            if(doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                              doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                              ends[2]=2;
                                              ;//sysj/turntableController.sysj line: 119, column: 4
                                              S14096=12;
                                              if(!tableAligned.getprestatus()){//sysj/turntableController.sysj line: 125, column: 20
                                                S14096=13;
                                                if(tableAligned.getprestatus()){//sysj/turntableController.sysj line: 128, column: 20
                                                  m_thread_2.index();//sysj/turntableController.sysj line: 130, column: 4
                                                  m_thread_2.report();//sysj/turntableController.sysj line: 131, column: 4
                                                  S14096=14;
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
                                                rotaryTrigger.setPresent();//sysj/turntableController.sysj line: 126, column: 5
                                                currsigs.addElement(rotaryTrigger);
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
                }
                break;
              
            }
            break;
          
          case 8 : 
            switch(S15999){
              case 0 : 
                if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 116, column: 4
                  doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                  S15999=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  switch(S15994){
                    case 0 : 
                      if(!doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                        doneFiller1_in.setACK(true);//sysj/turntableController.sysj line: 116, column: 4
                        S15994=1;
                        if(doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                          doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                          ends[2]=2;
                          ;//sysj/turntableController.sysj line: 116, column: 4
                          S14096=9;
                          S16549=0;
                          if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 117, column: 4
                            doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                            S16549=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S16544=0;
                            if(!doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                              doneFiller2_in.setACK(true);//sysj/turntableController.sysj line: 117, column: 4
                              S16544=1;
                              if(doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                ends[2]=2;
                                ;//sysj/turntableController.sysj line: 117, column: 4
                                S14096=10;
                                S17143=0;
                                if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 118, column: 4
                                  doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                  S17143=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S17138=0;
                                  if(!doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                    doneLid_in.setACK(true);//sysj/turntableController.sysj line: 118, column: 4
                                    S17138=1;
                                    if(doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                      doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                      ends[2]=2;
                                      ;//sysj/turntableController.sysj line: 118, column: 4
                                      S14096=11;
                                      S17781=0;
                                      if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 119, column: 4
                                        doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                        S17781=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S17776=0;
                                        if(!doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                          doneCapper_in.setACK(true);//sysj/turntableController.sysj line: 119, column: 4
                                          S17776=1;
                                          if(doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                            doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                            ends[2]=2;
                                            ;//sysj/turntableController.sysj line: 119, column: 4
                                            S14096=12;
                                            if(!tableAligned.getprestatus()){//sysj/turntableController.sysj line: 125, column: 20
                                              S14096=13;
                                              if(tableAligned.getprestatus()){//sysj/turntableController.sysj line: 128, column: 20
                                                m_thread_2.index();//sysj/turntableController.sysj line: 130, column: 4
                                                m_thread_2.report();//sysj/turntableController.sysj line: 131, column: 4
                                                S14096=14;
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
                                              rotaryTrigger.setPresent();//sysj/turntableController.sysj line: 126, column: 5
                                              currsigs.addElement(rotaryTrigger);
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
                    
                    case 1 : 
                      if(doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                        doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                        ends[2]=2;
                        ;//sysj/turntableController.sysj line: 116, column: 4
                        S14096=9;
                        S16549=0;
                        if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 117, column: 4
                          doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                          S16549=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          S16544=0;
                          if(!doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                            doneFiller2_in.setACK(true);//sysj/turntableController.sysj line: 117, column: 4
                            S16544=1;
                            if(doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                              doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                              ends[2]=2;
                              ;//sysj/turntableController.sysj line: 117, column: 4
                              S14096=10;
                              S17143=0;
                              if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 118, column: 4
                                doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                S17143=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S17138=0;
                                if(!doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                  doneLid_in.setACK(true);//sysj/turntableController.sysj line: 118, column: 4
                                  S17138=1;
                                  if(doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                    doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                    ends[2]=2;
                                    ;//sysj/turntableController.sysj line: 118, column: 4
                                    S14096=11;
                                    S17781=0;
                                    if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 119, column: 4
                                      doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                      S17781=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S17776=0;
                                      if(!doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                        doneCapper_in.setACK(true);//sysj/turntableController.sysj line: 119, column: 4
                                        S17776=1;
                                        if(doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                          doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                          ends[2]=2;
                                          ;//sysj/turntableController.sysj line: 119, column: 4
                                          S14096=12;
                                          if(!tableAligned.getprestatus()){//sysj/turntableController.sysj line: 125, column: 20
                                            S14096=13;
                                            if(tableAligned.getprestatus()){//sysj/turntableController.sysj line: 128, column: 20
                                              m_thread_2.index();//sysj/turntableController.sysj line: 130, column: 4
                                              m_thread_2.report();//sysj/turntableController.sysj line: 131, column: 4
                                              S14096=14;
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
                                            rotaryTrigger.setPresent();//sysj/turntableController.sysj line: 126, column: 5
                                            currsigs.addElement(rotaryTrigger);
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
                break;
              
              case 1 : 
                S15999=1;
                S15999=0;
                if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 116, column: 4
                  doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                  S15999=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S15994=0;
                  if(!doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                    doneFiller1_in.setACK(true);//sysj/turntableController.sysj line: 116, column: 4
                    S15994=1;
                    if(doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                      doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                      ends[2]=2;
                      ;//sysj/turntableController.sysj line: 116, column: 4
                      S14096=9;
                      S16549=0;
                      if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 117, column: 4
                        doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                        S16549=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S16544=0;
                        if(!doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                          doneFiller2_in.setACK(true);//sysj/turntableController.sysj line: 117, column: 4
                          S16544=1;
                          if(doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                            doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                            ends[2]=2;
                            ;//sysj/turntableController.sysj line: 117, column: 4
                            S14096=10;
                            S17143=0;
                            if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 118, column: 4
                              doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                              S17143=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S17138=0;
                              if(!doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                doneLid_in.setACK(true);//sysj/turntableController.sysj line: 118, column: 4
                                S17138=1;
                                if(doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                  doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                  ends[2]=2;
                                  ;//sysj/turntableController.sysj line: 118, column: 4
                                  S14096=11;
                                  S17781=0;
                                  if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 119, column: 4
                                    doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                    S17781=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S17776=0;
                                    if(!doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                      doneCapper_in.setACK(true);//sysj/turntableController.sysj line: 119, column: 4
                                      S17776=1;
                                      if(doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                        doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                        ends[2]=2;
                                        ;//sysj/turntableController.sysj line: 119, column: 4
                                        S14096=12;
                                        if(!tableAligned.getprestatus()){//sysj/turntableController.sysj line: 125, column: 20
                                          S14096=13;
                                          if(tableAligned.getprestatus()){//sysj/turntableController.sysj line: 128, column: 20
                                            m_thread_2.index();//sysj/turntableController.sysj line: 130, column: 4
                                            m_thread_2.report();//sysj/turntableController.sysj line: 131, column: 4
                                            S14096=14;
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
                                          rotaryTrigger.setPresent();//sysj/turntableController.sysj line: 126, column: 5
                                          currsigs.addElement(rotaryTrigger);
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
                }
                break;
              
            }
            break;
          
          case 9 : 
            switch(S16549){
              case 0 : 
                if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 117, column: 4
                  doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                  S16549=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  switch(S16544){
                    case 0 : 
                      if(!doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                        doneFiller2_in.setACK(true);//sysj/turntableController.sysj line: 117, column: 4
                        S16544=1;
                        if(doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                          doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                          ends[2]=2;
                          ;//sysj/turntableController.sysj line: 117, column: 4
                          S14096=10;
                          S17143=0;
                          if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 118, column: 4
                            doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                            S17143=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S17138=0;
                            if(!doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                              doneLid_in.setACK(true);//sysj/turntableController.sysj line: 118, column: 4
                              S17138=1;
                              if(doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                ends[2]=2;
                                ;//sysj/turntableController.sysj line: 118, column: 4
                                S14096=11;
                                S17781=0;
                                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 119, column: 4
                                  doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                  S17781=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S17776=0;
                                  if(!doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                    doneCapper_in.setACK(true);//sysj/turntableController.sysj line: 119, column: 4
                                    S17776=1;
                                    if(doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                      doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                      ends[2]=2;
                                      ;//sysj/turntableController.sysj line: 119, column: 4
                                      S14096=12;
                                      if(!tableAligned.getprestatus()){//sysj/turntableController.sysj line: 125, column: 20
                                        S14096=13;
                                        if(tableAligned.getprestatus()){//sysj/turntableController.sysj line: 128, column: 20
                                          m_thread_2.index();//sysj/turntableController.sysj line: 130, column: 4
                                          m_thread_2.report();//sysj/turntableController.sysj line: 131, column: 4
                                          S14096=14;
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
                                        rotaryTrigger.setPresent();//sysj/turntableController.sysj line: 126, column: 5
                                        currsigs.addElement(rotaryTrigger);
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
                    
                    case 1 : 
                      if(doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                        doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                        ends[2]=2;
                        ;//sysj/turntableController.sysj line: 117, column: 4
                        S14096=10;
                        S17143=0;
                        if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 118, column: 4
                          doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                          S17143=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          S17138=0;
                          if(!doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                            doneLid_in.setACK(true);//sysj/turntableController.sysj line: 118, column: 4
                            S17138=1;
                            if(doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                              doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                              ends[2]=2;
                              ;//sysj/turntableController.sysj line: 118, column: 4
                              S14096=11;
                              S17781=0;
                              if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 119, column: 4
                                doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                S17781=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S17776=0;
                                if(!doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                  doneCapper_in.setACK(true);//sysj/turntableController.sysj line: 119, column: 4
                                  S17776=1;
                                  if(doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                    doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                    ends[2]=2;
                                    ;//sysj/turntableController.sysj line: 119, column: 4
                                    S14096=12;
                                    if(!tableAligned.getprestatus()){//sysj/turntableController.sysj line: 125, column: 20
                                      S14096=13;
                                      if(tableAligned.getprestatus()){//sysj/turntableController.sysj line: 128, column: 20
                                        m_thread_2.index();//sysj/turntableController.sysj line: 130, column: 4
                                        m_thread_2.report();//sysj/turntableController.sysj line: 131, column: 4
                                        S14096=14;
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
                                      rotaryTrigger.setPresent();//sysj/turntableController.sysj line: 126, column: 5
                                      currsigs.addElement(rotaryTrigger);
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
                break;
              
              case 1 : 
                S16549=1;
                S16549=0;
                if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 117, column: 4
                  doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                  S16549=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S16544=0;
                  if(!doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                    doneFiller2_in.setACK(true);//sysj/turntableController.sysj line: 117, column: 4
                    S16544=1;
                    if(doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                      doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                      ends[2]=2;
                      ;//sysj/turntableController.sysj line: 117, column: 4
                      S14096=10;
                      S17143=0;
                      if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 118, column: 4
                        doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                        S17143=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S17138=0;
                        if(!doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                          doneLid_in.setACK(true);//sysj/turntableController.sysj line: 118, column: 4
                          S17138=1;
                          if(doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                            doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                            ends[2]=2;
                            ;//sysj/turntableController.sysj line: 118, column: 4
                            S14096=11;
                            S17781=0;
                            if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 119, column: 4
                              doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                              S17781=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S17776=0;
                              if(!doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                doneCapper_in.setACK(true);//sysj/turntableController.sysj line: 119, column: 4
                                S17776=1;
                                if(doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                  doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                  ends[2]=2;
                                  ;//sysj/turntableController.sysj line: 119, column: 4
                                  S14096=12;
                                  if(!tableAligned.getprestatus()){//sysj/turntableController.sysj line: 125, column: 20
                                    S14096=13;
                                    if(tableAligned.getprestatus()){//sysj/turntableController.sysj line: 128, column: 20
                                      m_thread_2.index();//sysj/turntableController.sysj line: 130, column: 4
                                      m_thread_2.report();//sysj/turntableController.sysj line: 131, column: 4
                                      S14096=14;
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
                                    rotaryTrigger.setPresent();//sysj/turntableController.sysj line: 126, column: 5
                                    currsigs.addElement(rotaryTrigger);
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
                }
                break;
              
            }
            break;
          
          case 10 : 
            switch(S17143){
              case 0 : 
                if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 118, column: 4
                  doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                  S17143=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  switch(S17138){
                    case 0 : 
                      if(!doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                        doneLid_in.setACK(true);//sysj/turntableController.sysj line: 118, column: 4
                        S17138=1;
                        if(doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                          doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                          ends[2]=2;
                          ;//sysj/turntableController.sysj line: 118, column: 4
                          S14096=11;
                          S17781=0;
                          if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 119, column: 4
                            doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                            S17781=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S17776=0;
                            if(!doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                              doneCapper_in.setACK(true);//sysj/turntableController.sysj line: 119, column: 4
                              S17776=1;
                              if(doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                ends[2]=2;
                                ;//sysj/turntableController.sysj line: 119, column: 4
                                S14096=12;
                                if(!tableAligned.getprestatus()){//sysj/turntableController.sysj line: 125, column: 20
                                  S14096=13;
                                  if(tableAligned.getprestatus()){//sysj/turntableController.sysj line: 128, column: 20
                                    m_thread_2.index();//sysj/turntableController.sysj line: 130, column: 4
                                    m_thread_2.report();//sysj/turntableController.sysj line: 131, column: 4
                                    S14096=14;
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
                                  rotaryTrigger.setPresent();//sysj/turntableController.sysj line: 126, column: 5
                                  currsigs.addElement(rotaryTrigger);
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
                    
                    case 1 : 
                      if(doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                        doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                        ends[2]=2;
                        ;//sysj/turntableController.sysj line: 118, column: 4
                        S14096=11;
                        S17781=0;
                        if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 119, column: 4
                          doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                          S17781=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          S17776=0;
                          if(!doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                            doneCapper_in.setACK(true);//sysj/turntableController.sysj line: 119, column: 4
                            S17776=1;
                            if(doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                              doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                              ends[2]=2;
                              ;//sysj/turntableController.sysj line: 119, column: 4
                              S14096=12;
                              if(!tableAligned.getprestatus()){//sysj/turntableController.sysj line: 125, column: 20
                                S14096=13;
                                if(tableAligned.getprestatus()){//sysj/turntableController.sysj line: 128, column: 20
                                  m_thread_2.index();//sysj/turntableController.sysj line: 130, column: 4
                                  m_thread_2.report();//sysj/turntableController.sysj line: 131, column: 4
                                  S14096=14;
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
                                rotaryTrigger.setPresent();//sysj/turntableController.sysj line: 126, column: 5
                                currsigs.addElement(rotaryTrigger);
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
                break;
              
              case 1 : 
                S17143=1;
                S17143=0;
                if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 118, column: 4
                  doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                  S17143=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S17138=0;
                  if(!doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                    doneLid_in.setACK(true);//sysj/turntableController.sysj line: 118, column: 4
                    S17138=1;
                    if(doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                      doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                      ends[2]=2;
                      ;//sysj/turntableController.sysj line: 118, column: 4
                      S14096=11;
                      S17781=0;
                      if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 119, column: 4
                        doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                        S17781=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S17776=0;
                        if(!doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                          doneCapper_in.setACK(true);//sysj/turntableController.sysj line: 119, column: 4
                          S17776=1;
                          if(doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                            doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                            ends[2]=2;
                            ;//sysj/turntableController.sysj line: 119, column: 4
                            S14096=12;
                            if(!tableAligned.getprestatus()){//sysj/turntableController.sysj line: 125, column: 20
                              S14096=13;
                              if(tableAligned.getprestatus()){//sysj/turntableController.sysj line: 128, column: 20
                                m_thread_2.index();//sysj/turntableController.sysj line: 130, column: 4
                                m_thread_2.report();//sysj/turntableController.sysj line: 131, column: 4
                                S14096=14;
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
                              rotaryTrigger.setPresent();//sysj/turntableController.sysj line: 126, column: 5
                              currsigs.addElement(rotaryTrigger);
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
                }
                break;
              
            }
            break;
          
          case 11 : 
            switch(S17781){
              case 0 : 
                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 119, column: 4
                  doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                  S17781=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  switch(S17776){
                    case 0 : 
                      if(!doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                        doneCapper_in.setACK(true);//sysj/turntableController.sysj line: 119, column: 4
                        S17776=1;
                        if(doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                          doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                          ends[2]=2;
                          ;//sysj/turntableController.sysj line: 119, column: 4
                          S14096=12;
                          if(!tableAligned.getprestatus()){//sysj/turntableController.sysj line: 125, column: 20
                            S14096=13;
                            if(tableAligned.getprestatus()){//sysj/turntableController.sysj line: 128, column: 20
                              m_thread_2.index();//sysj/turntableController.sysj line: 130, column: 4
                              m_thread_2.report();//sysj/turntableController.sysj line: 131, column: 4
                              S14096=14;
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
                            rotaryTrigger.setPresent();//sysj/turntableController.sysj line: 126, column: 5
                            currsigs.addElement(rotaryTrigger);
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
                    
                    case 1 : 
                      if(doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                        doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                        ends[2]=2;
                        ;//sysj/turntableController.sysj line: 119, column: 4
                        S14096=12;
                        if(!tableAligned.getprestatus()){//sysj/turntableController.sysj line: 125, column: 20
                          S14096=13;
                          if(tableAligned.getprestatus()){//sysj/turntableController.sysj line: 128, column: 20
                            m_thread_2.index();//sysj/turntableController.sysj line: 130, column: 4
                            m_thread_2.report();//sysj/turntableController.sysj line: 131, column: 4
                            S14096=14;
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
                          rotaryTrigger.setPresent();//sysj/turntableController.sysj line: 126, column: 5
                          currsigs.addElement(rotaryTrigger);
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
                break;
              
              case 1 : 
                S17781=1;
                S17781=0;
                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 119, column: 4
                  doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                  S17781=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S17776=0;
                  if(!doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                    doneCapper_in.setACK(true);//sysj/turntableController.sysj line: 119, column: 4
                    S17776=1;
                    if(doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                      doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                      ends[2]=2;
                      ;//sysj/turntableController.sysj line: 119, column: 4
                      S14096=12;
                      if(!tableAligned.getprestatus()){//sysj/turntableController.sysj line: 125, column: 20
                        S14096=13;
                        if(tableAligned.getprestatus()){//sysj/turntableController.sysj line: 128, column: 20
                          m_thread_2.index();//sysj/turntableController.sysj line: 130, column: 4
                          m_thread_2.report();//sysj/turntableController.sysj line: 131, column: 4
                          S14096=14;
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
                        rotaryTrigger.setPresent();//sysj/turntableController.sysj line: 126, column: 5
                        currsigs.addElement(rotaryTrigger);
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
                }
                break;
              
            }
            break;
          
          case 12 : 
            if(!tableAligned.getprestatus()){//sysj/turntableController.sysj line: 125, column: 20
              S14096=13;
              if(tableAligned.getprestatus()){//sysj/turntableController.sysj line: 128, column: 20
                m_thread_2.index();//sysj/turntableController.sysj line: 130, column: 4
                m_thread_2.report();//sysj/turntableController.sysj line: 131, column: 4
                S14096=14;
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
              rotaryTrigger.setPresent();//sysj/turntableController.sysj line: 126, column: 5
              currsigs.addElement(rotaryTrigger);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 13 : 
            if(tableAligned.getprestatus()){//sysj/turntableController.sysj line: 128, column: 20
              m_thread_2.index();//sysj/turntableController.sysj line: 130, column: 4
              m_thread_2.report();//sysj/turntableController.sysj line: 131, column: 4
              S14096=14;
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
          
          case 14 : 
            S14096=14;
            S14096=0;
            if(tableAligned.getprestatus()){//sysj/turntableController.sysj line: 61, column: 20
              S14096=1;
              if(m_thread_2.exitOccupied()){//sysj/turntableController.sysj line: 69, column: 4
                exiting_thread_2 = m_thread_2.exitId();//sysj/turntableController.sysj line: 70, column: 5
                m_thread_2.sayUnloading();//sysj/turntableController.sysj line: 71, column: 5
                S13910=0;
                S13917=0;
                if(!tableOutfeed_o.isPartnerPresent() || tableOutfeed_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 72, column: 5
                  tableOutfeed_o.setREQ(false);//sysj/turntableController.sysj line: 72, column: 5
                  S13917=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S13912=0;
                  if(tableOutfeed_o.isACK()){//sysj/turntableController.sysj line: 72, column: 5
                    tableOutfeed_o.setVal(exiting_thread_2);//sysj/turntableController.sysj line: 72, column: 5
                    S13912=1;
                    if(!tableOutfeed_o.isACK()){//sysj/turntableController.sysj line: 72, column: 5
                      tableOutfeed_o.setREQ(false);//sysj/turntableController.sysj line: 72, column: 5
                      ends[2]=2;
                      ;//sysj/turntableController.sysj line: 72, column: 5
                      S13910=1;
                      if(exitCleared.getprestatus()){//sysj/turntableController.sysj line: 73, column: 21
                        m_thread_2.clearExit();//sysj/turntableController.sysj line: 76, column: 5
                        S14096=2;
                        if(m_thread_2.idle()){//sysj/turntableController.sysj line: 82, column: 4
                          if(!m_thread_2.hasPending()){//sysj/turntableController.sysj line: 83, column: 11
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            ends[2]=2;
                            ;//sysj/turntableController.sysj line: 83, column: 5
                            S14096=3;
                            if(m_thread_2.readyToPlace()){//sysj/turntableController.sysj line: 85, column: 4
                              S14141=0;
                              if(bottleAtPos1.getprestatus()){//sysj/turntableController.sysj line: 86, column: 21
                                m_thread_2.commitPending();//sysj/turntableController.sysj line: 89, column: 5
                                placed_1.setPresent();//sysj/turntableController.sysj line: 90, column: 5
                                currsigs.addElement(placed_1);
                                S14141=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                loadPos1.setPresent();//sysj/turntableController.sysj line: 87, column: 6
                                currsigs.addElement(loadPos1);
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                            }
                            else {
                              S14096=4;
                              S14239=0;
                              if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 111, column: 4
                                startFiller1_o.setREQ(false);//sysj/turntableController.sysj line: 111, column: 4
                                S14239=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S14234=0;
                                if(startFiller1_o.isACK()){//sysj/turntableController.sysj line: 111, column: 4
                                  startFiller1_o.setVal(m_thread_2.idAt(1));//sysj/turntableController.sysj line: 111, column: 4
                                  S14234=1;
                                  if(!startFiller1_o.isACK()){//sysj/turntableController.sysj line: 111, column: 4
                                    startFiller1_o.setREQ(false);//sysj/turntableController.sysj line: 111, column: 4
                                    ends[2]=2;
                                    ;//sysj/turntableController.sysj line: 111, column: 4
                                    S14096=5;
                                    S14613=0;
                                    if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 112, column: 4
                                      startFiller2_o.setREQ(false);//sysj/turntableController.sysj line: 112, column: 4
                                      S14613=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S14608=0;
                                      if(startFiller2_o.isACK()){//sysj/turntableController.sysj line: 112, column: 4
                                        startFiller2_o.setVal(m_thread_2.idAt(2));//sysj/turntableController.sysj line: 112, column: 4
                                        S14608=1;
                                        if(!startFiller2_o.isACK()){//sysj/turntableController.sysj line: 112, column: 4
                                          startFiller2_o.setREQ(false);//sysj/turntableController.sysj line: 112, column: 4
                                          ends[2]=2;
                                          ;//sysj/turntableController.sysj line: 112, column: 4
                                          S14096=6;
                                          S15031=0;
                                          if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 113, column: 4
                                            startLid_o.setREQ(false);//sysj/turntableController.sysj line: 113, column: 4
                                            S15031=1;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S15026=0;
                                            if(startLid_o.isACK()){//sysj/turntableController.sysj line: 113, column: 4
                                              startLid_o.setVal(m_thread_2.idAt(3));//sysj/turntableController.sysj line: 113, column: 4
                                              S15026=1;
                                              if(!startLid_o.isACK()){//sysj/turntableController.sysj line: 113, column: 4
                                                startLid_o.setREQ(false);//sysj/turntableController.sysj line: 113, column: 4
                                                ends[2]=2;
                                                ;//sysj/turntableController.sysj line: 113, column: 4
                                                S14096=7;
                                                S15493=0;
                                                if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 114, column: 4
                                                  startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                                                  S15493=1;
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                                else {
                                                  S15488=0;
                                                  if(startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                                                    startCapper_o.setVal(m_thread_2.idAt(4));//sysj/turntableController.sysj line: 114, column: 4
                                                    S15488=1;
                                                    if(!startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                                                      startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                                                      ends[2]=2;
                                                      ;//sysj/turntableController.sysj line: 114, column: 4
                                                      S14096=8;
                                                      S15999=0;
                                                      if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 116, column: 4
                                                        doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                                        S15999=1;
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                      else {
                                                        S15994=0;
                                                        if(!doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                                          doneFiller1_in.setACK(true);//sysj/turntableController.sysj line: 116, column: 4
                                                          S15994=1;
                                                          if(doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                                            doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                                            ends[2]=2;
                                                            ;//sysj/turntableController.sysj line: 116, column: 4
                                                            S14096=9;
                                                            S16549=0;
                                                            if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 117, column: 4
                                                              doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                                              S16549=1;
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                            else {
                                                              S16544=0;
                                                              if(!doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                                                doneFiller2_in.setACK(true);//sysj/turntableController.sysj line: 117, column: 4
                                                                S16544=1;
                                                                if(doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                                                  doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                                                  ends[2]=2;
                                                                  ;//sysj/turntableController.sysj line: 117, column: 4
                                                                  S14096=10;
                                                                  S17143=0;
                                                                  if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 118, column: 4
                                                                    doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                                                    S17143=1;
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
                                                                  }
                                                                  else {
                                                                    S17138=0;
                                                                    if(!doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                                                      doneLid_in.setACK(true);//sysj/turntableController.sysj line: 118, column: 4
                                                                      S17138=1;
                                                                      if(doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                                                        doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                                                        ends[2]=2;
                                                                        ;//sysj/turntableController.sysj line: 118, column: 4
                                                                        S14096=11;
                                                                        S17781=0;
                                                                        if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 119, column: 4
                                                                          doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                                          S17781=1;
                                                                          active[2]=1;
                                                                          ends[2]=1;
                                                                          tdone[2]=1;
                                                                        }
                                                                        else {
                                                                          S17776=0;
                                                                          if(!doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                                            doneCapper_in.setACK(true);//sysj/turntableController.sysj line: 119, column: 4
                                                                            S17776=1;
                                                                            if(doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                                              doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                                              ends[2]=2;
                                                                              ;//sysj/turntableController.sysj line: 119, column: 4
                                                                              S14096=12;
                                                                              if(!tableAligned.getprestatus()){//sysj/turntableController.sysj line: 125, column: 20
                                                                                S14096=13;
                                                                                if(tableAligned.getprestatus()){//sysj/turntableController.sysj line: 128, column: 20
                                                                                  m_thread_2.index();//sysj/turntableController.sysj line: 130, column: 4
                                                                                  m_thread_2.report();//sysj/turntableController.sysj line: 131, column: 4
                                                                                  S14096=14;
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
                                                                                rotaryTrigger.setPresent();//sysj/turntableController.sysj line: 126, column: 5
                                                                                currsigs.addElement(rotaryTrigger);
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
                              }
                            }
                          }
                        }
                        else {
                          S14096=3;
                          if(m_thread_2.readyToPlace()){//sysj/turntableController.sysj line: 85, column: 4
                            S14141=0;
                            if(bottleAtPos1.getprestatus()){//sysj/turntableController.sysj line: 86, column: 21
                              m_thread_2.commitPending();//sysj/turntableController.sysj line: 89, column: 5
                              placed_1.setPresent();//sysj/turntableController.sysj line: 90, column: 5
                              currsigs.addElement(placed_1);
                              S14141=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              loadPos1.setPresent();//sysj/turntableController.sysj line: 87, column: 6
                              currsigs.addElement(loadPos1);
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                          }
                          else {
                            S14096=4;
                            S14239=0;
                            if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 111, column: 4
                              startFiller1_o.setREQ(false);//sysj/turntableController.sysj line: 111, column: 4
                              S14239=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S14234=0;
                              if(startFiller1_o.isACK()){//sysj/turntableController.sysj line: 111, column: 4
                                startFiller1_o.setVal(m_thread_2.idAt(1));//sysj/turntableController.sysj line: 111, column: 4
                                S14234=1;
                                if(!startFiller1_o.isACK()){//sysj/turntableController.sysj line: 111, column: 4
                                  startFiller1_o.setREQ(false);//sysj/turntableController.sysj line: 111, column: 4
                                  ends[2]=2;
                                  ;//sysj/turntableController.sysj line: 111, column: 4
                                  S14096=5;
                                  S14613=0;
                                  if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 112, column: 4
                                    startFiller2_o.setREQ(false);//sysj/turntableController.sysj line: 112, column: 4
                                    S14613=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S14608=0;
                                    if(startFiller2_o.isACK()){//sysj/turntableController.sysj line: 112, column: 4
                                      startFiller2_o.setVal(m_thread_2.idAt(2));//sysj/turntableController.sysj line: 112, column: 4
                                      S14608=1;
                                      if(!startFiller2_o.isACK()){//sysj/turntableController.sysj line: 112, column: 4
                                        startFiller2_o.setREQ(false);//sysj/turntableController.sysj line: 112, column: 4
                                        ends[2]=2;
                                        ;//sysj/turntableController.sysj line: 112, column: 4
                                        S14096=6;
                                        S15031=0;
                                        if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 113, column: 4
                                          startLid_o.setREQ(false);//sysj/turntableController.sysj line: 113, column: 4
                                          S15031=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S15026=0;
                                          if(startLid_o.isACK()){//sysj/turntableController.sysj line: 113, column: 4
                                            startLid_o.setVal(m_thread_2.idAt(3));//sysj/turntableController.sysj line: 113, column: 4
                                            S15026=1;
                                            if(!startLid_o.isACK()){//sysj/turntableController.sysj line: 113, column: 4
                                              startLid_o.setREQ(false);//sysj/turntableController.sysj line: 113, column: 4
                                              ends[2]=2;
                                              ;//sysj/turntableController.sysj line: 113, column: 4
                                              S14096=7;
                                              S15493=0;
                                              if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 114, column: 4
                                                startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                                                S15493=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S15488=0;
                                                if(startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                                                  startCapper_o.setVal(m_thread_2.idAt(4));//sysj/turntableController.sysj line: 114, column: 4
                                                  S15488=1;
                                                  if(!startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                                                    startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                                                    ends[2]=2;
                                                    ;//sysj/turntableController.sysj line: 114, column: 4
                                                    S14096=8;
                                                    S15999=0;
                                                    if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 116, column: 4
                                                      doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                                      S15999=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S15994=0;
                                                      if(!doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                                        doneFiller1_in.setACK(true);//sysj/turntableController.sysj line: 116, column: 4
                                                        S15994=1;
                                                        if(doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                                          doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                                          ends[2]=2;
                                                          ;//sysj/turntableController.sysj line: 116, column: 4
                                                          S14096=9;
                                                          S16549=0;
                                                          if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 117, column: 4
                                                            doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                                            S16549=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S16544=0;
                                                            if(!doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                                              doneFiller2_in.setACK(true);//sysj/turntableController.sysj line: 117, column: 4
                                                              S16544=1;
                                                              if(doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                                                doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                                                ends[2]=2;
                                                                ;//sysj/turntableController.sysj line: 117, column: 4
                                                                S14096=10;
                                                                S17143=0;
                                                                if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 118, column: 4
                                                                  doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                                                  S17143=1;
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                                else {
                                                                  S17138=0;
                                                                  if(!doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                                                    doneLid_in.setACK(true);//sysj/turntableController.sysj line: 118, column: 4
                                                                    S17138=1;
                                                                    if(doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                                                      doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                                                      ends[2]=2;
                                                                      ;//sysj/turntableController.sysj line: 118, column: 4
                                                                      S14096=11;
                                                                      S17781=0;
                                                                      if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 119, column: 4
                                                                        doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                                        S17781=1;
                                                                        active[2]=1;
                                                                        ends[2]=1;
                                                                        tdone[2]=1;
                                                                      }
                                                                      else {
                                                                        S17776=0;
                                                                        if(!doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                                          doneCapper_in.setACK(true);//sysj/turntableController.sysj line: 119, column: 4
                                                                          S17776=1;
                                                                          if(doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                                            doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                                            ends[2]=2;
                                                                            ;//sysj/turntableController.sysj line: 119, column: 4
                                                                            S14096=12;
                                                                            if(!tableAligned.getprestatus()){//sysj/turntableController.sysj line: 125, column: 20
                                                                              S14096=13;
                                                                              if(tableAligned.getprestatus()){//sysj/turntableController.sysj line: 128, column: 20
                                                                                m_thread_2.index();//sysj/turntableController.sysj line: 130, column: 4
                                                                                m_thread_2.report();//sysj/turntableController.sysj line: 131, column: 4
                                                                                S14096=14;
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
                                                                              rotaryTrigger.setPresent();//sysj/turntableController.sysj line: 126, column: 5
                                                                              currsigs.addElement(rotaryTrigger);
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
                            }
                          }
                        }
                      }
                      else {
                        unloadExit.setPresent();//sysj/turntableController.sysj line: 74, column: 6
                        currsigs.addElement(unloadExit);
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
                }
              }
              else {
                S14096=2;
                if(m_thread_2.idle()){//sysj/turntableController.sysj line: 82, column: 4
                  if(!m_thread_2.hasPending()){//sysj/turntableController.sysj line: 83, column: 11
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    ends[2]=2;
                    ;//sysj/turntableController.sysj line: 83, column: 5
                    S14096=3;
                    if(m_thread_2.readyToPlace()){//sysj/turntableController.sysj line: 85, column: 4
                      S14141=0;
                      if(bottleAtPos1.getprestatus()){//sysj/turntableController.sysj line: 86, column: 21
                        m_thread_2.commitPending();//sysj/turntableController.sysj line: 89, column: 5
                        placed_1.setPresent();//sysj/turntableController.sysj line: 90, column: 5
                        currsigs.addElement(placed_1);
                        S14141=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        loadPos1.setPresent();//sysj/turntableController.sysj line: 87, column: 6
                        currsigs.addElement(loadPos1);
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                    }
                    else {
                      S14096=4;
                      S14239=0;
                      if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 111, column: 4
                        startFiller1_o.setREQ(false);//sysj/turntableController.sysj line: 111, column: 4
                        S14239=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S14234=0;
                        if(startFiller1_o.isACK()){//sysj/turntableController.sysj line: 111, column: 4
                          startFiller1_o.setVal(m_thread_2.idAt(1));//sysj/turntableController.sysj line: 111, column: 4
                          S14234=1;
                          if(!startFiller1_o.isACK()){//sysj/turntableController.sysj line: 111, column: 4
                            startFiller1_o.setREQ(false);//sysj/turntableController.sysj line: 111, column: 4
                            ends[2]=2;
                            ;//sysj/turntableController.sysj line: 111, column: 4
                            S14096=5;
                            S14613=0;
                            if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 112, column: 4
                              startFiller2_o.setREQ(false);//sysj/turntableController.sysj line: 112, column: 4
                              S14613=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S14608=0;
                              if(startFiller2_o.isACK()){//sysj/turntableController.sysj line: 112, column: 4
                                startFiller2_o.setVal(m_thread_2.idAt(2));//sysj/turntableController.sysj line: 112, column: 4
                                S14608=1;
                                if(!startFiller2_o.isACK()){//sysj/turntableController.sysj line: 112, column: 4
                                  startFiller2_o.setREQ(false);//sysj/turntableController.sysj line: 112, column: 4
                                  ends[2]=2;
                                  ;//sysj/turntableController.sysj line: 112, column: 4
                                  S14096=6;
                                  S15031=0;
                                  if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 113, column: 4
                                    startLid_o.setREQ(false);//sysj/turntableController.sysj line: 113, column: 4
                                    S15031=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S15026=0;
                                    if(startLid_o.isACK()){//sysj/turntableController.sysj line: 113, column: 4
                                      startLid_o.setVal(m_thread_2.idAt(3));//sysj/turntableController.sysj line: 113, column: 4
                                      S15026=1;
                                      if(!startLid_o.isACK()){//sysj/turntableController.sysj line: 113, column: 4
                                        startLid_o.setREQ(false);//sysj/turntableController.sysj line: 113, column: 4
                                        ends[2]=2;
                                        ;//sysj/turntableController.sysj line: 113, column: 4
                                        S14096=7;
                                        S15493=0;
                                        if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 114, column: 4
                                          startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                                          S15493=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S15488=0;
                                          if(startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                                            startCapper_o.setVal(m_thread_2.idAt(4));//sysj/turntableController.sysj line: 114, column: 4
                                            S15488=1;
                                            if(!startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                                              startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                                              ends[2]=2;
                                              ;//sysj/turntableController.sysj line: 114, column: 4
                                              S14096=8;
                                              S15999=0;
                                              if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 116, column: 4
                                                doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                                S15999=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S15994=0;
                                                if(!doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                                  doneFiller1_in.setACK(true);//sysj/turntableController.sysj line: 116, column: 4
                                                  S15994=1;
                                                  if(doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                                    doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                                    ends[2]=2;
                                                    ;//sysj/turntableController.sysj line: 116, column: 4
                                                    S14096=9;
                                                    S16549=0;
                                                    if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 117, column: 4
                                                      doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                                      S16549=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S16544=0;
                                                      if(!doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                                        doneFiller2_in.setACK(true);//sysj/turntableController.sysj line: 117, column: 4
                                                        S16544=1;
                                                        if(doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                                          doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                                          ends[2]=2;
                                                          ;//sysj/turntableController.sysj line: 117, column: 4
                                                          S14096=10;
                                                          S17143=0;
                                                          if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 118, column: 4
                                                            doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                                            S17143=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S17138=0;
                                                            if(!doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                                              doneLid_in.setACK(true);//sysj/turntableController.sysj line: 118, column: 4
                                                              S17138=1;
                                                              if(doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                                                doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                                                ends[2]=2;
                                                                ;//sysj/turntableController.sysj line: 118, column: 4
                                                                S14096=11;
                                                                S17781=0;
                                                                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 119, column: 4
                                                                  doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                                  S17781=1;
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                                else {
                                                                  S17776=0;
                                                                  if(!doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                                    doneCapper_in.setACK(true);//sysj/turntableController.sysj line: 119, column: 4
                                                                    S17776=1;
                                                                    if(doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                                      doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                                      ends[2]=2;
                                                                      ;//sysj/turntableController.sysj line: 119, column: 4
                                                                      S14096=12;
                                                                      if(!tableAligned.getprestatus()){//sysj/turntableController.sysj line: 125, column: 20
                                                                        S14096=13;
                                                                        if(tableAligned.getprestatus()){//sysj/turntableController.sysj line: 128, column: 20
                                                                          m_thread_2.index();//sysj/turntableController.sysj line: 130, column: 4
                                                                          m_thread_2.report();//sysj/turntableController.sysj line: 131, column: 4
                                                                          S14096=14;
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
                                                                        rotaryTrigger.setPresent();//sysj/turntableController.sysj line: 126, column: 5
                                                                        currsigs.addElement(rotaryTrigger);
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
                      }
                    }
                  }
                }
                else {
                  S14096=3;
                  if(m_thread_2.readyToPlace()){//sysj/turntableController.sysj line: 85, column: 4
                    S14141=0;
                    if(bottleAtPos1.getprestatus()){//sysj/turntableController.sysj line: 86, column: 21
                      m_thread_2.commitPending();//sysj/turntableController.sysj line: 89, column: 5
                      placed_1.setPresent();//sysj/turntableController.sysj line: 90, column: 5
                      currsigs.addElement(placed_1);
                      S14141=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      loadPos1.setPresent();//sysj/turntableController.sysj line: 87, column: 6
                      currsigs.addElement(loadPos1);
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                  }
                  else {
                    S14096=4;
                    S14239=0;
                    if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 111, column: 4
                      startFiller1_o.setREQ(false);//sysj/turntableController.sysj line: 111, column: 4
                      S14239=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      S14234=0;
                      if(startFiller1_o.isACK()){//sysj/turntableController.sysj line: 111, column: 4
                        startFiller1_o.setVal(m_thread_2.idAt(1));//sysj/turntableController.sysj line: 111, column: 4
                        S14234=1;
                        if(!startFiller1_o.isACK()){//sysj/turntableController.sysj line: 111, column: 4
                          startFiller1_o.setREQ(false);//sysj/turntableController.sysj line: 111, column: 4
                          ends[2]=2;
                          ;//sysj/turntableController.sysj line: 111, column: 4
                          S14096=5;
                          S14613=0;
                          if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 112, column: 4
                            startFiller2_o.setREQ(false);//sysj/turntableController.sysj line: 112, column: 4
                            S14613=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S14608=0;
                            if(startFiller2_o.isACK()){//sysj/turntableController.sysj line: 112, column: 4
                              startFiller2_o.setVal(m_thread_2.idAt(2));//sysj/turntableController.sysj line: 112, column: 4
                              S14608=1;
                              if(!startFiller2_o.isACK()){//sysj/turntableController.sysj line: 112, column: 4
                                startFiller2_o.setREQ(false);//sysj/turntableController.sysj line: 112, column: 4
                                ends[2]=2;
                                ;//sysj/turntableController.sysj line: 112, column: 4
                                S14096=6;
                                S15031=0;
                                if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 113, column: 4
                                  startLid_o.setREQ(false);//sysj/turntableController.sysj line: 113, column: 4
                                  S15031=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S15026=0;
                                  if(startLid_o.isACK()){//sysj/turntableController.sysj line: 113, column: 4
                                    startLid_o.setVal(m_thread_2.idAt(3));//sysj/turntableController.sysj line: 113, column: 4
                                    S15026=1;
                                    if(!startLid_o.isACK()){//sysj/turntableController.sysj line: 113, column: 4
                                      startLid_o.setREQ(false);//sysj/turntableController.sysj line: 113, column: 4
                                      ends[2]=2;
                                      ;//sysj/turntableController.sysj line: 113, column: 4
                                      S14096=7;
                                      S15493=0;
                                      if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 114, column: 4
                                        startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                                        S15493=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S15488=0;
                                        if(startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                                          startCapper_o.setVal(m_thread_2.idAt(4));//sysj/turntableController.sysj line: 114, column: 4
                                          S15488=1;
                                          if(!startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                                            startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                                            ends[2]=2;
                                            ;//sysj/turntableController.sysj line: 114, column: 4
                                            S14096=8;
                                            S15999=0;
                                            if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 116, column: 4
                                              doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                              S15999=1;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S15994=0;
                                              if(!doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                                doneFiller1_in.setACK(true);//sysj/turntableController.sysj line: 116, column: 4
                                                S15994=1;
                                                if(doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                                  doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                                  ends[2]=2;
                                                  ;//sysj/turntableController.sysj line: 116, column: 4
                                                  S14096=9;
                                                  S16549=0;
                                                  if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 117, column: 4
                                                    doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                                    S16549=1;
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                  else {
                                                    S16544=0;
                                                    if(!doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                                      doneFiller2_in.setACK(true);//sysj/turntableController.sysj line: 117, column: 4
                                                      S16544=1;
                                                      if(doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                                        doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                                        ends[2]=2;
                                                        ;//sysj/turntableController.sysj line: 117, column: 4
                                                        S14096=10;
                                                        S17143=0;
                                                        if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 118, column: 4
                                                          doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                                          S17143=1;
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                        else {
                                                          S17138=0;
                                                          if(!doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                                            doneLid_in.setACK(true);//sysj/turntableController.sysj line: 118, column: 4
                                                            S17138=1;
                                                            if(doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                                              doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                                              ends[2]=2;
                                                              ;//sysj/turntableController.sysj line: 118, column: 4
                                                              S14096=11;
                                                              S17781=0;
                                                              if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 119, column: 4
                                                                doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                                S17781=1;
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                              else {
                                                                S17776=0;
                                                                if(!doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                                  doneCapper_in.setACK(true);//sysj/turntableController.sysj line: 119, column: 4
                                                                  S17776=1;
                                                                  if(doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                                    doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                                    ends[2]=2;
                                                                    ;//sysj/turntableController.sysj line: 119, column: 4
                                                                    S14096=12;
                                                                    if(!tableAligned.getprestatus()){//sysj/turntableController.sysj line: 125, column: 20
                                                                      S14096=13;
                                                                      if(tableAligned.getprestatus()){//sysj/turntableController.sysj line: 128, column: 20
                                                                        m_thread_2.index();//sysj/turntableController.sysj line: 130, column: 4
                                                                        m_thread_2.report();//sysj/turntableController.sysj line: 131, column: 4
                                                                        S14096=14;
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
                                                                      rotaryTrigger.setPresent();//sysj/turntableController.sysj line: 126, column: 5
                                                                      currsigs.addElement(rotaryTrigger);
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
                    }
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
        break;
      
    }
  }

  public void thread42362(int [] tdone, int [] ends){
        S42357=1;
    m_thread_3 = TableModel.shared();//sysj/turntableController.sysj line: 137, column: 3
    b_thread_3 = 0;//sysj/turntableController.sysj line: 138, column: 3
    S42217=0;
    S42201=0;
    if(!tableInfeed_in.isPartnerPresent() || tableInfeed_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 140, column: 4
      tableInfeed_in.setACK(false);//sysj/turntableController.sysj line: 140, column: 4
      S42201=1;
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
    else {
      S42196=0;
      if(!tableInfeed_in.isREQ()){//sysj/turntableController.sysj line: 140, column: 4
        tableInfeed_in.setACK(true);//sysj/turntableController.sysj line: 140, column: 4
        S42196=1;
        if(tableInfeed_in.isREQ()){//sysj/turntableController.sysj line: 140, column: 4
          tableInfeed_in.setACK(false);//sysj/turntableController.sysj line: 140, column: 4
          ends[3]=2;
          ;//sysj/turntableController.sysj line: 140, column: 4
          b_thread_3 = ((Integer)(tableInfeed_in.getVal() == null ? null : ((Integer)tableInfeed_in.getVal()))).intValue();//sysj/turntableController.sysj line: 141, column: 4
          m_thread_3.setPending(b_thread_3);//sysj/turntableController.sysj line: 142, column: 4
          System.out.println("[RT] Accepted bottle " + b_thread_3 + " from the conveyor.");//sysj/turntableController.sysj line: 143, column: 4
          S42217=1;
          if(placed_1.getprestatus()){//sysj/turntableController.sysj line: 144, column: 20
            S42217=2;
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
      else {
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
    }
  }

  public void thread42361(int [] tdone, int [] ends){
        S42193=1;
    m_thread_2 = TableModel.shared();//sysj/turntableController.sysj line: 56, column: 3
    exiting_thread_2 = 0;//sysj/turntableController.sysj line: 57, column: 3
    S14096=0;
    if(tableAligned.getprestatus()){//sysj/turntableController.sysj line: 61, column: 20
      S14096=1;
      if(m_thread_2.exitOccupied()){//sysj/turntableController.sysj line: 69, column: 4
        exiting_thread_2 = m_thread_2.exitId();//sysj/turntableController.sysj line: 70, column: 5
        m_thread_2.sayUnloading();//sysj/turntableController.sysj line: 71, column: 5
        S13910=0;
        S13917=0;
        if(!tableOutfeed_o.isPartnerPresent() || tableOutfeed_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 72, column: 5
          tableOutfeed_o.setREQ(false);//sysj/turntableController.sysj line: 72, column: 5
          S13917=1;
          active[2]=1;
          ends[2]=1;
          tdone[2]=1;
        }
        else {
          S13912=0;
          if(tableOutfeed_o.isACK()){//sysj/turntableController.sysj line: 72, column: 5
            tableOutfeed_o.setVal(exiting_thread_2);//sysj/turntableController.sysj line: 72, column: 5
            S13912=1;
            if(!tableOutfeed_o.isACK()){//sysj/turntableController.sysj line: 72, column: 5
              tableOutfeed_o.setREQ(false);//sysj/turntableController.sysj line: 72, column: 5
              ends[2]=2;
              ;//sysj/turntableController.sysj line: 72, column: 5
              S13910=1;
              if(exitCleared.getprestatus()){//sysj/turntableController.sysj line: 73, column: 21
                m_thread_2.clearExit();//sysj/turntableController.sysj line: 76, column: 5
                S14096=2;
                if(m_thread_2.idle()){//sysj/turntableController.sysj line: 82, column: 4
                  if(!m_thread_2.hasPending()){//sysj/turntableController.sysj line: 83, column: 11
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    ends[2]=2;
                    ;//sysj/turntableController.sysj line: 83, column: 5
                    S14096=3;
                    if(m_thread_2.readyToPlace()){//sysj/turntableController.sysj line: 85, column: 4
                      S14141=0;
                      if(bottleAtPos1.getprestatus()){//sysj/turntableController.sysj line: 86, column: 21
                        m_thread_2.commitPending();//sysj/turntableController.sysj line: 89, column: 5
                        placed_1.setPresent();//sysj/turntableController.sysj line: 90, column: 5
                        currsigs.addElement(placed_1);
                        S14141=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        loadPos1.setPresent();//sysj/turntableController.sysj line: 87, column: 6
                        currsigs.addElement(loadPos1);
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                    }
                    else {
                      S14096=4;
                      S14239=0;
                      if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 111, column: 4
                        startFiller1_o.setREQ(false);//sysj/turntableController.sysj line: 111, column: 4
                        S14239=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S14234=0;
                        if(startFiller1_o.isACK()){//sysj/turntableController.sysj line: 111, column: 4
                          startFiller1_o.setVal(m_thread_2.idAt(1));//sysj/turntableController.sysj line: 111, column: 4
                          S14234=1;
                          if(!startFiller1_o.isACK()){//sysj/turntableController.sysj line: 111, column: 4
                            startFiller1_o.setREQ(false);//sysj/turntableController.sysj line: 111, column: 4
                            ends[2]=2;
                            ;//sysj/turntableController.sysj line: 111, column: 4
                            S14096=5;
                            S14613=0;
                            if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 112, column: 4
                              startFiller2_o.setREQ(false);//sysj/turntableController.sysj line: 112, column: 4
                              S14613=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S14608=0;
                              if(startFiller2_o.isACK()){//sysj/turntableController.sysj line: 112, column: 4
                                startFiller2_o.setVal(m_thread_2.idAt(2));//sysj/turntableController.sysj line: 112, column: 4
                                S14608=1;
                                if(!startFiller2_o.isACK()){//sysj/turntableController.sysj line: 112, column: 4
                                  startFiller2_o.setREQ(false);//sysj/turntableController.sysj line: 112, column: 4
                                  ends[2]=2;
                                  ;//sysj/turntableController.sysj line: 112, column: 4
                                  S14096=6;
                                  S15031=0;
                                  if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 113, column: 4
                                    startLid_o.setREQ(false);//sysj/turntableController.sysj line: 113, column: 4
                                    S15031=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S15026=0;
                                    if(startLid_o.isACK()){//sysj/turntableController.sysj line: 113, column: 4
                                      startLid_o.setVal(m_thread_2.idAt(3));//sysj/turntableController.sysj line: 113, column: 4
                                      S15026=1;
                                      if(!startLid_o.isACK()){//sysj/turntableController.sysj line: 113, column: 4
                                        startLid_o.setREQ(false);//sysj/turntableController.sysj line: 113, column: 4
                                        ends[2]=2;
                                        ;//sysj/turntableController.sysj line: 113, column: 4
                                        S14096=7;
                                        S15493=0;
                                        if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 114, column: 4
                                          startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                                          S15493=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S15488=0;
                                          if(startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                                            startCapper_o.setVal(m_thread_2.idAt(4));//sysj/turntableController.sysj line: 114, column: 4
                                            S15488=1;
                                            if(!startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                                              startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                                              ends[2]=2;
                                              ;//sysj/turntableController.sysj line: 114, column: 4
                                              S14096=8;
                                              S15999=0;
                                              if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 116, column: 4
                                                doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                                S15999=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S15994=0;
                                                if(!doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                                  doneFiller1_in.setACK(true);//sysj/turntableController.sysj line: 116, column: 4
                                                  S15994=1;
                                                  if(doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                                    doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                                    ends[2]=2;
                                                    ;//sysj/turntableController.sysj line: 116, column: 4
                                                    S14096=9;
                                                    S16549=0;
                                                    if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 117, column: 4
                                                      doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                                      S16549=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S16544=0;
                                                      if(!doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                                        doneFiller2_in.setACK(true);//sysj/turntableController.sysj line: 117, column: 4
                                                        S16544=1;
                                                        if(doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                                          doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                                          ends[2]=2;
                                                          ;//sysj/turntableController.sysj line: 117, column: 4
                                                          S14096=10;
                                                          S17143=0;
                                                          if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 118, column: 4
                                                            doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                                            S17143=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S17138=0;
                                                            if(!doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                                              doneLid_in.setACK(true);//sysj/turntableController.sysj line: 118, column: 4
                                                              S17138=1;
                                                              if(doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                                                doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                                                ends[2]=2;
                                                                ;//sysj/turntableController.sysj line: 118, column: 4
                                                                S14096=11;
                                                                S17781=0;
                                                                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 119, column: 4
                                                                  doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                                  S17781=1;
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                                else {
                                                                  S17776=0;
                                                                  if(!doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                                    doneCapper_in.setACK(true);//sysj/turntableController.sysj line: 119, column: 4
                                                                    S17776=1;
                                                                    if(doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                                      doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                                      ends[2]=2;
                                                                      ;//sysj/turntableController.sysj line: 119, column: 4
                                                                      S14096=12;
                                                                      if(!tableAligned.getprestatus()){//sysj/turntableController.sysj line: 125, column: 20
                                                                        S14096=13;
                                                                        if(tableAligned.getprestatus()){//sysj/turntableController.sysj line: 128, column: 20
                                                                          m_thread_2.index();//sysj/turntableController.sysj line: 130, column: 4
                                                                          m_thread_2.report();//sysj/turntableController.sysj line: 131, column: 4
                                                                          S14096=14;
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
                                                                        rotaryTrigger.setPresent();//sysj/turntableController.sysj line: 126, column: 5
                                                                        currsigs.addElement(rotaryTrigger);
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
                      }
                    }
                  }
                }
                else {
                  S14096=3;
                  if(m_thread_2.readyToPlace()){//sysj/turntableController.sysj line: 85, column: 4
                    S14141=0;
                    if(bottleAtPos1.getprestatus()){//sysj/turntableController.sysj line: 86, column: 21
                      m_thread_2.commitPending();//sysj/turntableController.sysj line: 89, column: 5
                      placed_1.setPresent();//sysj/turntableController.sysj line: 90, column: 5
                      currsigs.addElement(placed_1);
                      S14141=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      loadPos1.setPresent();//sysj/turntableController.sysj line: 87, column: 6
                      currsigs.addElement(loadPos1);
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                  }
                  else {
                    S14096=4;
                    S14239=0;
                    if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 111, column: 4
                      startFiller1_o.setREQ(false);//sysj/turntableController.sysj line: 111, column: 4
                      S14239=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      S14234=0;
                      if(startFiller1_o.isACK()){//sysj/turntableController.sysj line: 111, column: 4
                        startFiller1_o.setVal(m_thread_2.idAt(1));//sysj/turntableController.sysj line: 111, column: 4
                        S14234=1;
                        if(!startFiller1_o.isACK()){//sysj/turntableController.sysj line: 111, column: 4
                          startFiller1_o.setREQ(false);//sysj/turntableController.sysj line: 111, column: 4
                          ends[2]=2;
                          ;//sysj/turntableController.sysj line: 111, column: 4
                          S14096=5;
                          S14613=0;
                          if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 112, column: 4
                            startFiller2_o.setREQ(false);//sysj/turntableController.sysj line: 112, column: 4
                            S14613=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S14608=0;
                            if(startFiller2_o.isACK()){//sysj/turntableController.sysj line: 112, column: 4
                              startFiller2_o.setVal(m_thread_2.idAt(2));//sysj/turntableController.sysj line: 112, column: 4
                              S14608=1;
                              if(!startFiller2_o.isACK()){//sysj/turntableController.sysj line: 112, column: 4
                                startFiller2_o.setREQ(false);//sysj/turntableController.sysj line: 112, column: 4
                                ends[2]=2;
                                ;//sysj/turntableController.sysj line: 112, column: 4
                                S14096=6;
                                S15031=0;
                                if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 113, column: 4
                                  startLid_o.setREQ(false);//sysj/turntableController.sysj line: 113, column: 4
                                  S15031=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S15026=0;
                                  if(startLid_o.isACK()){//sysj/turntableController.sysj line: 113, column: 4
                                    startLid_o.setVal(m_thread_2.idAt(3));//sysj/turntableController.sysj line: 113, column: 4
                                    S15026=1;
                                    if(!startLid_o.isACK()){//sysj/turntableController.sysj line: 113, column: 4
                                      startLid_o.setREQ(false);//sysj/turntableController.sysj line: 113, column: 4
                                      ends[2]=2;
                                      ;//sysj/turntableController.sysj line: 113, column: 4
                                      S14096=7;
                                      S15493=0;
                                      if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 114, column: 4
                                        startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                                        S15493=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S15488=0;
                                        if(startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                                          startCapper_o.setVal(m_thread_2.idAt(4));//sysj/turntableController.sysj line: 114, column: 4
                                          S15488=1;
                                          if(!startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                                            startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                                            ends[2]=2;
                                            ;//sysj/turntableController.sysj line: 114, column: 4
                                            S14096=8;
                                            S15999=0;
                                            if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 116, column: 4
                                              doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                              S15999=1;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S15994=0;
                                              if(!doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                                doneFiller1_in.setACK(true);//sysj/turntableController.sysj line: 116, column: 4
                                                S15994=1;
                                                if(doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                                  doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                                  ends[2]=2;
                                                  ;//sysj/turntableController.sysj line: 116, column: 4
                                                  S14096=9;
                                                  S16549=0;
                                                  if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 117, column: 4
                                                    doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                                    S16549=1;
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                  else {
                                                    S16544=0;
                                                    if(!doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                                      doneFiller2_in.setACK(true);//sysj/turntableController.sysj line: 117, column: 4
                                                      S16544=1;
                                                      if(doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                                        doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                                        ends[2]=2;
                                                        ;//sysj/turntableController.sysj line: 117, column: 4
                                                        S14096=10;
                                                        S17143=0;
                                                        if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 118, column: 4
                                                          doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                                          S17143=1;
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                        else {
                                                          S17138=0;
                                                          if(!doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                                            doneLid_in.setACK(true);//sysj/turntableController.sysj line: 118, column: 4
                                                            S17138=1;
                                                            if(doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                                              doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                                              ends[2]=2;
                                                              ;//sysj/turntableController.sysj line: 118, column: 4
                                                              S14096=11;
                                                              S17781=0;
                                                              if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 119, column: 4
                                                                doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                                S17781=1;
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                              else {
                                                                S17776=0;
                                                                if(!doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                                  doneCapper_in.setACK(true);//sysj/turntableController.sysj line: 119, column: 4
                                                                  S17776=1;
                                                                  if(doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                                    doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                                    ends[2]=2;
                                                                    ;//sysj/turntableController.sysj line: 119, column: 4
                                                                    S14096=12;
                                                                    if(!tableAligned.getprestatus()){//sysj/turntableController.sysj line: 125, column: 20
                                                                      S14096=13;
                                                                      if(tableAligned.getprestatus()){//sysj/turntableController.sysj line: 128, column: 20
                                                                        m_thread_2.index();//sysj/turntableController.sysj line: 130, column: 4
                                                                        m_thread_2.report();//sysj/turntableController.sysj line: 131, column: 4
                                                                        S14096=14;
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
                                                                      rotaryTrigger.setPresent();//sysj/turntableController.sysj line: 126, column: 5
                                                                      currsigs.addElement(rotaryTrigger);
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
                    }
                  }
                }
              }
              else {
                unloadExit.setPresent();//sysj/turntableController.sysj line: 74, column: 6
                currsigs.addElement(unloadExit);
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
        }
      }
      else {
        S14096=2;
        if(m_thread_2.idle()){//sysj/turntableController.sysj line: 82, column: 4
          if(!m_thread_2.hasPending()){//sysj/turntableController.sysj line: 83, column: 11
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            ends[2]=2;
            ;//sysj/turntableController.sysj line: 83, column: 5
            S14096=3;
            if(m_thread_2.readyToPlace()){//sysj/turntableController.sysj line: 85, column: 4
              S14141=0;
              if(bottleAtPos1.getprestatus()){//sysj/turntableController.sysj line: 86, column: 21
                m_thread_2.commitPending();//sysj/turntableController.sysj line: 89, column: 5
                placed_1.setPresent();//sysj/turntableController.sysj line: 90, column: 5
                currsigs.addElement(placed_1);
                S14141=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                loadPos1.setPresent();//sysj/turntableController.sysj line: 87, column: 6
                currsigs.addElement(loadPos1);
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
            }
            else {
              S14096=4;
              S14239=0;
              if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 111, column: 4
                startFiller1_o.setREQ(false);//sysj/turntableController.sysj line: 111, column: 4
                S14239=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                S14234=0;
                if(startFiller1_o.isACK()){//sysj/turntableController.sysj line: 111, column: 4
                  startFiller1_o.setVal(m_thread_2.idAt(1));//sysj/turntableController.sysj line: 111, column: 4
                  S14234=1;
                  if(!startFiller1_o.isACK()){//sysj/turntableController.sysj line: 111, column: 4
                    startFiller1_o.setREQ(false);//sysj/turntableController.sysj line: 111, column: 4
                    ends[2]=2;
                    ;//sysj/turntableController.sysj line: 111, column: 4
                    S14096=5;
                    S14613=0;
                    if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 112, column: 4
                      startFiller2_o.setREQ(false);//sysj/turntableController.sysj line: 112, column: 4
                      S14613=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      S14608=0;
                      if(startFiller2_o.isACK()){//sysj/turntableController.sysj line: 112, column: 4
                        startFiller2_o.setVal(m_thread_2.idAt(2));//sysj/turntableController.sysj line: 112, column: 4
                        S14608=1;
                        if(!startFiller2_o.isACK()){//sysj/turntableController.sysj line: 112, column: 4
                          startFiller2_o.setREQ(false);//sysj/turntableController.sysj line: 112, column: 4
                          ends[2]=2;
                          ;//sysj/turntableController.sysj line: 112, column: 4
                          S14096=6;
                          S15031=0;
                          if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 113, column: 4
                            startLid_o.setREQ(false);//sysj/turntableController.sysj line: 113, column: 4
                            S15031=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S15026=0;
                            if(startLid_o.isACK()){//sysj/turntableController.sysj line: 113, column: 4
                              startLid_o.setVal(m_thread_2.idAt(3));//sysj/turntableController.sysj line: 113, column: 4
                              S15026=1;
                              if(!startLid_o.isACK()){//sysj/turntableController.sysj line: 113, column: 4
                                startLid_o.setREQ(false);//sysj/turntableController.sysj line: 113, column: 4
                                ends[2]=2;
                                ;//sysj/turntableController.sysj line: 113, column: 4
                                S14096=7;
                                S15493=0;
                                if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 114, column: 4
                                  startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                                  S15493=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S15488=0;
                                  if(startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                                    startCapper_o.setVal(m_thread_2.idAt(4));//sysj/turntableController.sysj line: 114, column: 4
                                    S15488=1;
                                    if(!startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                                      startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                                      ends[2]=2;
                                      ;//sysj/turntableController.sysj line: 114, column: 4
                                      S14096=8;
                                      S15999=0;
                                      if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 116, column: 4
                                        doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                        S15999=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S15994=0;
                                        if(!doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                          doneFiller1_in.setACK(true);//sysj/turntableController.sysj line: 116, column: 4
                                          S15994=1;
                                          if(doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                            doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                            ends[2]=2;
                                            ;//sysj/turntableController.sysj line: 116, column: 4
                                            S14096=9;
                                            S16549=0;
                                            if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 117, column: 4
                                              doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                              S16549=1;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S16544=0;
                                              if(!doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                                doneFiller2_in.setACK(true);//sysj/turntableController.sysj line: 117, column: 4
                                                S16544=1;
                                                if(doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                                  doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                                  ends[2]=2;
                                                  ;//sysj/turntableController.sysj line: 117, column: 4
                                                  S14096=10;
                                                  S17143=0;
                                                  if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 118, column: 4
                                                    doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                                    S17143=1;
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                  else {
                                                    S17138=0;
                                                    if(!doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                                      doneLid_in.setACK(true);//sysj/turntableController.sysj line: 118, column: 4
                                                      S17138=1;
                                                      if(doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                                        doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                                        ends[2]=2;
                                                        ;//sysj/turntableController.sysj line: 118, column: 4
                                                        S14096=11;
                                                        S17781=0;
                                                        if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 119, column: 4
                                                          doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                          S17781=1;
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                        else {
                                                          S17776=0;
                                                          if(!doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                            doneCapper_in.setACK(true);//sysj/turntableController.sysj line: 119, column: 4
                                                            S17776=1;
                                                            if(doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                              doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                              ends[2]=2;
                                                              ;//sysj/turntableController.sysj line: 119, column: 4
                                                              S14096=12;
                                                              if(!tableAligned.getprestatus()){//sysj/turntableController.sysj line: 125, column: 20
                                                                S14096=13;
                                                                if(tableAligned.getprestatus()){//sysj/turntableController.sysj line: 128, column: 20
                                                                  m_thread_2.index();//sysj/turntableController.sysj line: 130, column: 4
                                                                  m_thread_2.report();//sysj/turntableController.sysj line: 131, column: 4
                                                                  S14096=14;
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
                                                                rotaryTrigger.setPresent();//sysj/turntableController.sysj line: 126, column: 5
                                                                currsigs.addElement(rotaryTrigger);
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
              }
            }
          }
        }
        else {
          S14096=3;
          if(m_thread_2.readyToPlace()){//sysj/turntableController.sysj line: 85, column: 4
            S14141=0;
            if(bottleAtPos1.getprestatus()){//sysj/turntableController.sysj line: 86, column: 21
              m_thread_2.commitPending();//sysj/turntableController.sysj line: 89, column: 5
              placed_1.setPresent();//sysj/turntableController.sysj line: 90, column: 5
              currsigs.addElement(placed_1);
              S14141=1;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              loadPos1.setPresent();//sysj/turntableController.sysj line: 87, column: 6
              currsigs.addElement(loadPos1);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
          }
          else {
            S14096=4;
            S14239=0;
            if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 111, column: 4
              startFiller1_o.setREQ(false);//sysj/turntableController.sysj line: 111, column: 4
              S14239=1;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              S14234=0;
              if(startFiller1_o.isACK()){//sysj/turntableController.sysj line: 111, column: 4
                startFiller1_o.setVal(m_thread_2.idAt(1));//sysj/turntableController.sysj line: 111, column: 4
                S14234=1;
                if(!startFiller1_o.isACK()){//sysj/turntableController.sysj line: 111, column: 4
                  startFiller1_o.setREQ(false);//sysj/turntableController.sysj line: 111, column: 4
                  ends[2]=2;
                  ;//sysj/turntableController.sysj line: 111, column: 4
                  S14096=5;
                  S14613=0;
                  if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 112, column: 4
                    startFiller2_o.setREQ(false);//sysj/turntableController.sysj line: 112, column: 4
                    S14613=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    S14608=0;
                    if(startFiller2_o.isACK()){//sysj/turntableController.sysj line: 112, column: 4
                      startFiller2_o.setVal(m_thread_2.idAt(2));//sysj/turntableController.sysj line: 112, column: 4
                      S14608=1;
                      if(!startFiller2_o.isACK()){//sysj/turntableController.sysj line: 112, column: 4
                        startFiller2_o.setREQ(false);//sysj/turntableController.sysj line: 112, column: 4
                        ends[2]=2;
                        ;//sysj/turntableController.sysj line: 112, column: 4
                        S14096=6;
                        S15031=0;
                        if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 113, column: 4
                          startLid_o.setREQ(false);//sysj/turntableController.sysj line: 113, column: 4
                          S15031=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          S15026=0;
                          if(startLid_o.isACK()){//sysj/turntableController.sysj line: 113, column: 4
                            startLid_o.setVal(m_thread_2.idAt(3));//sysj/turntableController.sysj line: 113, column: 4
                            S15026=1;
                            if(!startLid_o.isACK()){//sysj/turntableController.sysj line: 113, column: 4
                              startLid_o.setREQ(false);//sysj/turntableController.sysj line: 113, column: 4
                              ends[2]=2;
                              ;//sysj/turntableController.sysj line: 113, column: 4
                              S14096=7;
                              S15493=0;
                              if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/turntableController.sysj line: 114, column: 4
                                startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                                S15493=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S15488=0;
                                if(startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                                  startCapper_o.setVal(m_thread_2.idAt(4));//sysj/turntableController.sysj line: 114, column: 4
                                  S15488=1;
                                  if(!startCapper_o.isACK()){//sysj/turntableController.sysj line: 114, column: 4
                                    startCapper_o.setREQ(false);//sysj/turntableController.sysj line: 114, column: 4
                                    ends[2]=2;
                                    ;//sysj/turntableController.sysj line: 114, column: 4
                                    S14096=8;
                                    S15999=0;
                                    if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 116, column: 4
                                      doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                      S15999=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S15994=0;
                                      if(!doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                        doneFiller1_in.setACK(true);//sysj/turntableController.sysj line: 116, column: 4
                                        S15994=1;
                                        if(doneFiller1_in.isREQ()){//sysj/turntableController.sysj line: 116, column: 4
                                          doneFiller1_in.setACK(false);//sysj/turntableController.sysj line: 116, column: 4
                                          ends[2]=2;
                                          ;//sysj/turntableController.sysj line: 116, column: 4
                                          S14096=9;
                                          S16549=0;
                                          if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 117, column: 4
                                            doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                            S16549=1;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S16544=0;
                                            if(!doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                              doneFiller2_in.setACK(true);//sysj/turntableController.sysj line: 117, column: 4
                                              S16544=1;
                                              if(doneFiller2_in.isREQ()){//sysj/turntableController.sysj line: 117, column: 4
                                                doneFiller2_in.setACK(false);//sysj/turntableController.sysj line: 117, column: 4
                                                ends[2]=2;
                                                ;//sysj/turntableController.sysj line: 117, column: 4
                                                S14096=10;
                                                S17143=0;
                                                if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 118, column: 4
                                                  doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                                  S17143=1;
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                                else {
                                                  S17138=0;
                                                  if(!doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                                    doneLid_in.setACK(true);//sysj/turntableController.sysj line: 118, column: 4
                                                    S17138=1;
                                                    if(doneLid_in.isREQ()){//sysj/turntableController.sysj line: 118, column: 4
                                                      doneLid_in.setACK(false);//sysj/turntableController.sysj line: 118, column: 4
                                                      ends[2]=2;
                                                      ;//sysj/turntableController.sysj line: 118, column: 4
                                                      S14096=11;
                                                      S17781=0;
                                                      if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/turntableController.sysj line: 119, column: 4
                                                        doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                        S17781=1;
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                      else {
                                                        S17776=0;
                                                        if(!doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                          doneCapper_in.setACK(true);//sysj/turntableController.sysj line: 119, column: 4
                                                          S17776=1;
                                                          if(doneCapper_in.isREQ()){//sysj/turntableController.sysj line: 119, column: 4
                                                            doneCapper_in.setACK(false);//sysj/turntableController.sysj line: 119, column: 4
                                                            ends[2]=2;
                                                            ;//sysj/turntableController.sysj line: 119, column: 4
                                                            S14096=12;
                                                            if(!tableAligned.getprestatus()){//sysj/turntableController.sysj line: 125, column: 20
                                                              S14096=13;
                                                              if(tableAligned.getprestatus()){//sysj/turntableController.sysj line: 128, column: 20
                                                                m_thread_2.index();//sysj/turntableController.sysj line: 130, column: 4
                                                                m_thread_2.report();//sysj/turntableController.sysj line: 131, column: 4
                                                                S14096=14;
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
                                                              rotaryTrigger.setPresent();//sysj/turntableController.sysj line: 126, column: 5
                                                              currsigs.addElement(rotaryTrigger);
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
            }
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
      switch(S42359){
        case 0 : 
          S42359=0;
          break RUN;
        
        case 1 : 
          S42359=2;
          S42359=2;
          placed_1.setClear();//sysj/turntableController.sysj line: 53, column: 2
          thread42361(tdone,ends);
          thread42362(tdone,ends);
          int biggest42363 = 0;
          if(ends[2]>=biggest42363){
            biggest42363=ends[2];
          }
          if(ends[3]>=biggest42363){
            biggest42363=ends[3];
          }
          if(biggest42363 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          placed_1.setClear();//sysj/turntableController.sysj line: 53, column: 2
          thread42364(tdone,ends);
          thread42365(tdone,ends);
          int biggest42366 = 0;
          if(ends[2]>=biggest42366){
            biggest42366=ends[2];
          }
          if(ends[3]>=biggest42366){
            biggest42366=ends[3];
          }
          if(biggest42366 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest42366 == 0){
            S42359=0;
            active[1]=0;
            ends[1]=0;
            S42359=0;
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
    placed_1 = new Signal();
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
          tableInfeed_in.gethook();
          doneFiller1_in.gethook();
          doneFiller2_in.gethook();
          doneLid_in.gethook();
          doneCapper_in.gethook();
          tableOutfeed_o.gethook();
          startFiller1_o.gethook();
          startFiller2_o.gethook();
          startLid_o.gethook();
          startCapper_o.gethook();
          tableAligned.gethook();
          bottleAtPos1.gethook();
          bottleAtPos2.gethook();
          bottleAtPos4.gethook();
          bottleAtPos5.gethook();
          exitCleared.gethook();
          df = true;
        }
        runClockDomain();
      }
      tableAligned.setpreclear();
      bottleAtPos1.setpreclear();
      bottleAtPos2.setpreclear();
      bottleAtPos4.setpreclear();
      bottleAtPos5.setpreclear();
      exitCleared.setpreclear();
      rotaryTrigger.setpreclear();
      loadPos1.setpreclear();
      unloadExit.setpreclear();
      placed_1.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
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
      dummyint = bottleAtPos5.getStatus() ? bottleAtPos5.setprepresent() : bottleAtPos5.setpreclear();
      bottleAtPos5.setpreval(bottleAtPos5.getValue());
      bottleAtPos5.setClear();
      dummyint = exitCleared.getStatus() ? exitCleared.setprepresent() : exitCleared.setpreclear();
      exitCleared.setpreval(exitCleared.getValue());
      exitCleared.setClear();
      rotaryTrigger.sethook();
      rotaryTrigger.setClear();
      loadPos1.sethook();
      loadPos1.setClear();
      unloadExit.sethook();
      unloadExit.setClear();
      placed_1.setClear();
      tableInfeed_in.sethook();
      doneFiller1_in.sethook();
      doneFiller2_in.sethook();
      doneLid_in.sethook();
      doneCapper_in.sethook();
      tableOutfeed_o.sethook();
      startFiller1_o.sethook();
      startFiller2_o.sethook();
      startLid_o.sethook();
      startCapper_o.sethook();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        tableInfeed_in.gethook();
        doneFiller1_in.gethook();
        doneFiller2_in.gethook();
        doneLid_in.gethook();
        doneCapper_in.gethook();
        tableOutfeed_o.gethook();
        startFiller1_o.gethook();
        startFiller2_o.gethook();
        startLid_o.gethook();
        startCapper_o.gethook();
        tableAligned.gethook();
        bottleAtPos1.gethook();
        bottleAtPos2.gethook();
        bottleAtPos4.gethook();
        bottleAtPos5.gethook();
        exitCleared.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
