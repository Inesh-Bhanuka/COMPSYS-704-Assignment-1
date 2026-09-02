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
  public Signal mode = new Signal("mode", Signal.OUTPUT);
  public Signal enableBL = new Signal("enableBL", Signal.OUTPUT);
  public Signal enableCV = new Signal("enableCV", Signal.OUTPUT);
  public Signal enableRT = new Signal("enableRT", Signal.OUTPUT);
  public Signal enableST = new Signal("enableST", Signal.OUTPUT);
  public input_Channel loadAck_in = new input_Channel();
  public input_Channel bottleDone_in = new input_Channel();
  public output_Channel loadOrder_o = new output_Channel();
  private int b_thread_5;//sysj/systemController.sysj line: 70, column: 3
  private int delivered_thread_6;//sysj/systemController.sysj line: 80, column: 3
  private int b_thread_6;//sysj/systemController.sysj line: 81, column: 3
  private int cycles_thread_4;//sysj/systemController.sysj line: 55, column: 3
  private int i_thread_4;//sysj/systemController.sysj line: 56, column: 3
  private int S13893 = 1;
  private int S13326 = 1;
  private int S13331 = 1;
  private int S13611 = 1;
  private int S13332 = 1;
  private int S13377 = 1;
  private int S13339 = 1;
  private int S13334 = 1;
  private int S13751 = 1;
  private int S13634 = 1;
  private int S13618 = 1;
  private int S13613 = 1;
  private int S13891 = 1;
  private int S13775 = 1;
  private int S13759 = 1;
  private int S13754 = 1;
  
  private int[] ends = new int[7];
  private int[] tdone = new int[7];
  
  public void thread13905(int [] tdone, int [] ends){
        switch(S13891){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S13775){
          case 0 : 
            switch(S13759){
              case 0 : 
                if(!bottleDone_in.isPartnerPresent() || bottleDone_in.isPartnerPreempted()){//sysj/systemController.sysj line: 83, column: 4
                  bottleDone_in.setACK(false);//sysj/systemController.sysj line: 83, column: 4
                  S13759=1;
                  active[6]=1;
                  ends[6]=1;
                  tdone[6]=1;
                }
                else {
                  switch(S13754){
                    case 0 : 
                      if(!bottleDone_in.isREQ()){//sysj/systemController.sysj line: 83, column: 4
                        bottleDone_in.setACK(true);//sysj/systemController.sysj line: 83, column: 4
                        S13754=1;
                        if(bottleDone_in.isREQ()){//sysj/systemController.sysj line: 83, column: 4
                          bottleDone_in.setACK(false);//sysj/systemController.sysj line: 83, column: 4
                          ends[6]=2;
                          ;//sysj/systemController.sysj line: 83, column: 4
                          b_thread_6 = ((Integer)(bottleDone_in.getVal() == null ? null : ((Integer)bottleDone_in.getVal()))).intValue();//sysj/systemController.sysj line: 84, column: 4
                          delivered_thread_6 = delivered_thread_6 + 1;//sysj/systemController.sysj line: 85, column: 4
                          System.out.println("[SC] Bottle " + b_thread_6 + " finished. " + delivered_thread_6 + " complete.");//sysj/systemController.sysj line: 86, column: 4
                          S13775=1;
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
                      if(bottleDone_in.isREQ()){//sysj/systemController.sysj line: 83, column: 4
                        bottleDone_in.setACK(false);//sysj/systemController.sysj line: 83, column: 4
                        ends[6]=2;
                        ;//sysj/systemController.sysj line: 83, column: 4
                        b_thread_6 = ((Integer)(bottleDone_in.getVal() == null ? null : ((Integer)bottleDone_in.getVal()))).intValue();//sysj/systemController.sysj line: 84, column: 4
                        delivered_thread_6 = delivered_thread_6 + 1;//sysj/systemController.sysj line: 85, column: 4
                        System.out.println("[SC] Bottle " + b_thread_6 + " finished. " + delivered_thread_6 + " complete.");//sysj/systemController.sysj line: 86, column: 4
                        S13775=1;
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
                S13759=1;
                S13759=0;
                if(!bottleDone_in.isPartnerPresent() || bottleDone_in.isPartnerPreempted()){//sysj/systemController.sysj line: 83, column: 4
                  bottleDone_in.setACK(false);//sysj/systemController.sysj line: 83, column: 4
                  S13759=1;
                  active[6]=1;
                  ends[6]=1;
                  tdone[6]=1;
                }
                else {
                  S13754=0;
                  if(!bottleDone_in.isREQ()){//sysj/systemController.sysj line: 83, column: 4
                    bottleDone_in.setACK(true);//sysj/systemController.sysj line: 83, column: 4
                    S13754=1;
                    if(bottleDone_in.isREQ()){//sysj/systemController.sysj line: 83, column: 4
                      bottleDone_in.setACK(false);//sysj/systemController.sysj line: 83, column: 4
                      ends[6]=2;
                      ;//sysj/systemController.sysj line: 83, column: 4
                      b_thread_6 = ((Integer)(bottleDone_in.getVal() == null ? null : ((Integer)bottleDone_in.getVal()))).intValue();//sysj/systemController.sysj line: 84, column: 4
                      delivered_thread_6 = delivered_thread_6 + 1;//sysj/systemController.sysj line: 85, column: 4
                      System.out.println("[SC] Bottle " + b_thread_6 + " finished. " + delivered_thread_6 + " complete.");//sysj/systemController.sysj line: 86, column: 4
                      S13775=1;
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
            S13775=1;
            S13775=0;
            S13759=0;
            if(!bottleDone_in.isPartnerPresent() || bottleDone_in.isPartnerPreempted()){//sysj/systemController.sysj line: 83, column: 4
              bottleDone_in.setACK(false);//sysj/systemController.sysj line: 83, column: 4
              S13759=1;
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            else {
              S13754=0;
              if(!bottleDone_in.isREQ()){//sysj/systemController.sysj line: 83, column: 4
                bottleDone_in.setACK(true);//sysj/systemController.sysj line: 83, column: 4
                S13754=1;
                if(bottleDone_in.isREQ()){//sysj/systemController.sysj line: 83, column: 4
                  bottleDone_in.setACK(false);//sysj/systemController.sysj line: 83, column: 4
                  ends[6]=2;
                  ;//sysj/systemController.sysj line: 83, column: 4
                  b_thread_6 = ((Integer)(bottleDone_in.getVal() == null ? null : ((Integer)bottleDone_in.getVal()))).intValue();//sysj/systemController.sysj line: 84, column: 4
                  delivered_thread_6 = delivered_thread_6 + 1;//sysj/systemController.sysj line: 85, column: 4
                  System.out.println("[SC] Bottle " + b_thread_6 + " finished. " + delivered_thread_6 + " complete.");//sysj/systemController.sysj line: 86, column: 4
                  S13775=1;
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

  public void thread13904(int [] tdone, int [] ends){
        switch(S13751){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S13634){
          case 0 : 
            switch(S13618){
              case 0 : 
                if(!loadAck_in.isPartnerPresent() || loadAck_in.isPartnerPreempted()){//sysj/systemController.sysj line: 72, column: 4
                  loadAck_in.setACK(false);//sysj/systemController.sysj line: 72, column: 4
                  S13618=1;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  switch(S13613){
                    case 0 : 
                      if(!loadAck_in.isREQ()){//sysj/systemController.sysj line: 72, column: 4
                        loadAck_in.setACK(true);//sysj/systemController.sysj line: 72, column: 4
                        S13613=1;
                        if(loadAck_in.isREQ()){//sysj/systemController.sysj line: 72, column: 4
                          loadAck_in.setACK(false);//sysj/systemController.sysj line: 72, column: 4
                          ends[5]=2;
                          ;//sysj/systemController.sysj line: 72, column: 4
                          b_thread_5 = ((Integer)(loadAck_in.getVal() == null ? null : ((Integer)loadAck_in.getVal()))).intValue();//sysj/systemController.sysj line: 73, column: 4
                          System.out.println("[SC] Bottle " + b_thread_5 + " is on the conveyor.");//sysj/systemController.sysj line: 74, column: 4
                          S13634=1;
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
                      if(loadAck_in.isREQ()){//sysj/systemController.sysj line: 72, column: 4
                        loadAck_in.setACK(false);//sysj/systemController.sysj line: 72, column: 4
                        ends[5]=2;
                        ;//sysj/systemController.sysj line: 72, column: 4
                        b_thread_5 = ((Integer)(loadAck_in.getVal() == null ? null : ((Integer)loadAck_in.getVal()))).intValue();//sysj/systemController.sysj line: 73, column: 4
                        System.out.println("[SC] Bottle " + b_thread_5 + " is on the conveyor.");//sysj/systemController.sysj line: 74, column: 4
                        S13634=1;
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
                S13618=1;
                S13618=0;
                if(!loadAck_in.isPartnerPresent() || loadAck_in.isPartnerPreempted()){//sysj/systemController.sysj line: 72, column: 4
                  loadAck_in.setACK(false);//sysj/systemController.sysj line: 72, column: 4
                  S13618=1;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  S13613=0;
                  if(!loadAck_in.isREQ()){//sysj/systemController.sysj line: 72, column: 4
                    loadAck_in.setACK(true);//sysj/systemController.sysj line: 72, column: 4
                    S13613=1;
                    if(loadAck_in.isREQ()){//sysj/systemController.sysj line: 72, column: 4
                      loadAck_in.setACK(false);//sysj/systemController.sysj line: 72, column: 4
                      ends[5]=2;
                      ;//sysj/systemController.sysj line: 72, column: 4
                      b_thread_5 = ((Integer)(loadAck_in.getVal() == null ? null : ((Integer)loadAck_in.getVal()))).intValue();//sysj/systemController.sysj line: 73, column: 4
                      System.out.println("[SC] Bottle " + b_thread_5 + " is on the conveyor.");//sysj/systemController.sysj line: 74, column: 4
                      S13634=1;
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
            S13634=1;
            S13634=0;
            S13618=0;
            if(!loadAck_in.isPartnerPresent() || loadAck_in.isPartnerPreempted()){//sysj/systemController.sysj line: 72, column: 4
              loadAck_in.setACK(false);//sysj/systemController.sysj line: 72, column: 4
              S13618=1;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              S13613=0;
              if(!loadAck_in.isREQ()){//sysj/systemController.sysj line: 72, column: 4
                loadAck_in.setACK(true);//sysj/systemController.sysj line: 72, column: 4
                S13613=1;
                if(loadAck_in.isREQ()){//sysj/systemController.sysj line: 72, column: 4
                  loadAck_in.setACK(false);//sysj/systemController.sysj line: 72, column: 4
                  ends[5]=2;
                  ;//sysj/systemController.sysj line: 72, column: 4
                  b_thread_5 = ((Integer)(loadAck_in.getVal() == null ? null : ((Integer)loadAck_in.getVal()))).intValue();//sysj/systemController.sysj line: 73, column: 4
                  System.out.println("[SC] Bottle " + b_thread_5 + " is on the conveyor.");//sysj/systemController.sysj line: 74, column: 4
                  S13634=1;
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
      
    }
  }

  public void thread13903(int [] tdone, int [] ends){
        switch(S13611){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S13332){
          case 0 : 
            S13332=0;
            S13332=1;
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
            break;
          
          case 1 : 
            S13332=1;
            S13332=2;
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
            break;
          
          case 2 : 
            S13332=2;
            S13332=3;
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
            break;
          
          case 3 : 
            S13332=3;
            S13332=4;
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
            break;
          
          case 4 : 
            S13332=4;
            cycles_thread_4 = 4;//sysj/systemController.sysj line: 55, column: 3
            i_thread_4 = 1;//sysj/systemController.sysj line: 56, column: 3
            S13332=5;
            if(i_thread_4 <= cycles_thread_4){//sysj/systemController.sysj line: 58, column: 9
              System.out.println("[SC] Order: load bottle " + i_thread_4 + " of " + cycles_thread_4 + ".");//sysj/systemController.sysj line: 59, column: 4
              S13377=0;
              S13339=0;
              if(!loadOrder_o.isPartnerPresent() || loadOrder_o.isPartnerPreempted()){//sysj/systemController.sysj line: 60, column: 4
                loadOrder_o.setREQ(false);//sysj/systemController.sysj line: 60, column: 4
                S13339=1;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                S13334=0;
                if(loadOrder_o.isACK()){//sysj/systemController.sysj line: 60, column: 4
                  loadOrder_o.setVal(i_thread_4);//sysj/systemController.sysj line: 60, column: 4
                  S13334=1;
                  if(!loadOrder_o.isACK()){//sysj/systemController.sysj line: 60, column: 4
                    loadOrder_o.setREQ(false);//sysj/systemController.sysj line: 60, column: 4
                    ends[4]=2;
                    ;//sysj/systemController.sysj line: 60, column: 4
                    i_thread_4 = i_thread_4 + 1;//sysj/systemController.sysj line: 61, column: 4
                    S13377=1;
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
            }
            else {
              loadOrder_o.setPreempted();//sysj/systemController.sysj line: 58, column: 3
              ends[4]=2;
              ;//sysj/systemController.sysj line: 58, column: 3
              System.out.println("[SC] All " + cycles_thread_4 + " load orders issued.");//sysj/systemController.sysj line: 65, column: 3
              S13332=6;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 5 : 
            switch(S13377){
              case 0 : 
                switch(S13339){
                  case 0 : 
                    if(!loadOrder_o.isPartnerPresent() || loadOrder_o.isPartnerPreempted()){//sysj/systemController.sysj line: 60, column: 4
                      loadOrder_o.setREQ(false);//sysj/systemController.sysj line: 60, column: 4
                      S13339=1;
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                    else {
                      switch(S13334){
                        case 0 : 
                          if(loadOrder_o.isACK()){//sysj/systemController.sysj line: 60, column: 4
                            loadOrder_o.setVal(i_thread_4);//sysj/systemController.sysj line: 60, column: 4
                            S13334=1;
                            if(!loadOrder_o.isACK()){//sysj/systemController.sysj line: 60, column: 4
                              loadOrder_o.setREQ(false);//sysj/systemController.sysj line: 60, column: 4
                              ends[4]=2;
                              ;//sysj/systemController.sysj line: 60, column: 4
                              i_thread_4 = i_thread_4 + 1;//sysj/systemController.sysj line: 61, column: 4
                              S13377=1;
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
                        
                        case 1 : 
                          if(!loadOrder_o.isACK()){//sysj/systemController.sysj line: 60, column: 4
                            loadOrder_o.setREQ(false);//sysj/systemController.sysj line: 60, column: 4
                            ends[4]=2;
                            ;//sysj/systemController.sysj line: 60, column: 4
                            i_thread_4 = i_thread_4 + 1;//sysj/systemController.sysj line: 61, column: 4
                            S13377=1;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          break;
                        
                      }
                    }
                    break;
                  
                  case 1 : 
                    S13339=1;
                    S13339=0;
                    if(!loadOrder_o.isPartnerPresent() || loadOrder_o.isPartnerPreempted()){//sysj/systemController.sysj line: 60, column: 4
                      loadOrder_o.setREQ(false);//sysj/systemController.sysj line: 60, column: 4
                      S13339=1;
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                    else {
                      S13334=0;
                      if(loadOrder_o.isACK()){//sysj/systemController.sysj line: 60, column: 4
                        loadOrder_o.setVal(i_thread_4);//sysj/systemController.sysj line: 60, column: 4
                        S13334=1;
                        if(!loadOrder_o.isACK()){//sysj/systemController.sysj line: 60, column: 4
                          loadOrder_o.setREQ(false);//sysj/systemController.sysj line: 60, column: 4
                          ends[4]=2;
                          ;//sysj/systemController.sysj line: 60, column: 4
                          i_thread_4 = i_thread_4 + 1;//sysj/systemController.sysj line: 61, column: 4
                          S13377=1;
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
                    break;
                  
                }
                break;
              
              case 1 : 
                S13377=1;
                if(i_thread_4 <= cycles_thread_4){//sysj/systemController.sysj line: 58, column: 9
                  System.out.println("[SC] Order: load bottle " + i_thread_4 + " of " + cycles_thread_4 + ".");//sysj/systemController.sysj line: 59, column: 4
                  S13377=0;
                  S13339=0;
                  if(!loadOrder_o.isPartnerPresent() || loadOrder_o.isPartnerPreempted()){//sysj/systemController.sysj line: 60, column: 4
                    loadOrder_o.setREQ(false);//sysj/systemController.sysj line: 60, column: 4
                    S13339=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S13334=0;
                    if(loadOrder_o.isACK()){//sysj/systemController.sysj line: 60, column: 4
                      loadOrder_o.setVal(i_thread_4);//sysj/systemController.sysj line: 60, column: 4
                      S13334=1;
                      if(!loadOrder_o.isACK()){//sysj/systemController.sysj line: 60, column: 4
                        loadOrder_o.setREQ(false);//sysj/systemController.sysj line: 60, column: 4
                        ends[4]=2;
                        ;//sysj/systemController.sysj line: 60, column: 4
                        i_thread_4 = i_thread_4 + 1;//sysj/systemController.sysj line: 61, column: 4
                        S13377=1;
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
                }
                else {
                  loadOrder_o.setPreempted();//sysj/systemController.sysj line: 58, column: 3
                  ends[4]=2;
                  ;//sysj/systemController.sysj line: 58, column: 3
                  System.out.println("[SC] All " + cycles_thread_4 + " load orders issued.");//sysj/systemController.sysj line: 65, column: 3
                  S13332=6;
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

  public void thread13902(int [] tdone, int [] ends){
        switch(S13331){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        enableBL.setPresent();//sysj/systemController.sysj line: 40, column: 4
        currsigs.addElement(enableBL);
        enableCV.setPresent();//sysj/systemController.sysj line: 41, column: 4
        currsigs.addElement(enableCV);
        enableRT.setPresent();//sysj/systemController.sysj line: 42, column: 4
        currsigs.addElement(enableRT);
        enableST.setPresent();//sysj/systemController.sysj line: 43, column: 4
        currsigs.addElement(enableST);
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
        break;
      
    }
  }

  public void thread13901(int [] tdone, int [] ends){
        switch(S13326){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        mode.setPresent();//sysj/systemController.sysj line: 33, column: 4
        currsigs.addElement(mode);
        mode.setValue(0);//sysj/systemController.sysj line: 33, column: 4
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
        break;
      
    }
  }

  public void thread13899(int [] tdone, int [] ends){
        S13891=1;
    delivered_thread_6 = 0;//sysj/systemController.sysj line: 80, column: 3
    b_thread_6 = 0;//sysj/systemController.sysj line: 81, column: 3
    S13775=0;
    S13759=0;
    if(!bottleDone_in.isPartnerPresent() || bottleDone_in.isPartnerPreempted()){//sysj/systemController.sysj line: 83, column: 4
      bottleDone_in.setACK(false);//sysj/systemController.sysj line: 83, column: 4
      S13759=1;
      active[6]=1;
      ends[6]=1;
      tdone[6]=1;
    }
    else {
      S13754=0;
      if(!bottleDone_in.isREQ()){//sysj/systemController.sysj line: 83, column: 4
        bottleDone_in.setACK(true);//sysj/systemController.sysj line: 83, column: 4
        S13754=1;
        if(bottleDone_in.isREQ()){//sysj/systemController.sysj line: 83, column: 4
          bottleDone_in.setACK(false);//sysj/systemController.sysj line: 83, column: 4
          ends[6]=2;
          ;//sysj/systemController.sysj line: 83, column: 4
          b_thread_6 = ((Integer)(bottleDone_in.getVal() == null ? null : ((Integer)bottleDone_in.getVal()))).intValue();//sysj/systemController.sysj line: 84, column: 4
          delivered_thread_6 = delivered_thread_6 + 1;//sysj/systemController.sysj line: 85, column: 4
          System.out.println("[SC] Bottle " + b_thread_6 + " finished. " + delivered_thread_6 + " complete.");//sysj/systemController.sysj line: 86, column: 4
          S13775=1;
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

  public void thread13898(int [] tdone, int [] ends){
        S13751=1;
    b_thread_5 = 0;//sysj/systemController.sysj line: 70, column: 3
    S13634=0;
    S13618=0;
    if(!loadAck_in.isPartnerPresent() || loadAck_in.isPartnerPreempted()){//sysj/systemController.sysj line: 72, column: 4
      loadAck_in.setACK(false);//sysj/systemController.sysj line: 72, column: 4
      S13618=1;
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
    else {
      S13613=0;
      if(!loadAck_in.isREQ()){//sysj/systemController.sysj line: 72, column: 4
        loadAck_in.setACK(true);//sysj/systemController.sysj line: 72, column: 4
        S13613=1;
        if(loadAck_in.isREQ()){//sysj/systemController.sysj line: 72, column: 4
          loadAck_in.setACK(false);//sysj/systemController.sysj line: 72, column: 4
          ends[5]=2;
          ;//sysj/systemController.sysj line: 72, column: 4
          b_thread_5 = ((Integer)(loadAck_in.getVal() == null ? null : ((Integer)loadAck_in.getVal()))).intValue();//sysj/systemController.sysj line: 73, column: 4
          System.out.println("[SC] Bottle " + b_thread_5 + " is on the conveyor.");//sysj/systemController.sysj line: 74, column: 4
          S13634=1;
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

  public void thread13897(int [] tdone, int [] ends){
        S13611=1;
    S13332=0;
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread13896(int [] tdone, int [] ends){
        S13331=1;
    enableBL.setPresent();//sysj/systemController.sysj line: 40, column: 4
    currsigs.addElement(enableBL);
    enableCV.setPresent();//sysj/systemController.sysj line: 41, column: 4
    currsigs.addElement(enableCV);
    enableRT.setPresent();//sysj/systemController.sysj line: 42, column: 4
    currsigs.addElement(enableRT);
    enableST.setPresent();//sysj/systemController.sysj line: 43, column: 4
    currsigs.addElement(enableST);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread13895(int [] tdone, int [] ends){
        S13326=1;
    mode.setPresent();//sysj/systemController.sysj line: 33, column: 4
    currsigs.addElement(mode);
    mode.setValue(0);//sysj/systemController.sysj line: 33, column: 4
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
      switch(S13893){
        case 0 : 
          S13893=0;
          break RUN;
        
        case 1 : 
          S13893=2;
          S13893=2;
          thread13895(tdone,ends);
          thread13896(tdone,ends);
          thread13897(tdone,ends);
          thread13898(tdone,ends);
          thread13899(tdone,ends);
          int biggest13900 = 0;
          if(ends[2]>=biggest13900){
            biggest13900=ends[2];
          }
          if(ends[3]>=biggest13900){
            biggest13900=ends[3];
          }
          if(ends[4]>=biggest13900){
            biggest13900=ends[4];
          }
          if(ends[5]>=biggest13900){
            biggest13900=ends[5];
          }
          if(ends[6]>=biggest13900){
            biggest13900=ends[6];
          }
          if(biggest13900 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          thread13901(tdone,ends);
          thread13902(tdone,ends);
          thread13903(tdone,ends);
          thread13904(tdone,ends);
          thread13905(tdone,ends);
          int biggest13906 = 0;
          if(ends[2]>=biggest13906){
            biggest13906=ends[2];
          }
          if(ends[3]>=biggest13906){
            biggest13906=ends[3];
          }
          if(ends[4]>=biggest13906){
            biggest13906=ends[4];
          }
          if(ends[5]>=biggest13906){
            biggest13906=ends[5];
          }
          if(ends[6]>=biggest13906){
            biggest13906=ends[6];
          }
          if(biggest13906 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest13906 == 0){
            S13893=0;
            active[1]=0;
            ends[1]=0;
            S13893=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0};
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
          loadOrder_o.gethook();
          df = true;
        }
        runClockDomain();
      }
      mode.setpreclear();
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
      mode.sethook();
      mode.setClear();
      enableBL.sethook();
      enableBL.setClear();
      enableCV.sethook();
      enableCV.setClear();
      enableRT.sethook();
      enableRT.setClear();
      enableST.sethook();
      enableST.setClear();
      loadAck_in.sethook();
      bottleDone_in.sethook();
      loadOrder_o.sethook();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        loadAck_in.gethook();
        bottleDone_in.gethook();
        loadOrder_o.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
