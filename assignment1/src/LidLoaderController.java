import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class LidLoaderController extends ClockDomain{
  public LidLoaderController(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal mode = new Signal("mode", Signal.INPUT);
  public Signal reset = new Signal("reset", Signal.INPUT);
  public Signal pusherExtended = new Signal("pusherExtended", Signal.INPUT);
  public Signal pusherRetracted = new Signal("pusherRetracted", Signal.INPUT);
  public Signal lidAtPickup = new Signal("lidAtPickup", Signal.INPUT);
  public Signal WPgripped = new Signal("WPgripped", Signal.INPUT);
  public Signal armAtSource = new Signal("armAtSource", Signal.INPUT);
  public Signal armAtDest = new Signal("armAtDest", Signal.INPUT);
  public Signal magazineEmpty = new Signal("magazineEmpty", Signal.INPUT);
  public Signal refilled = new Signal("refilled", Signal.INPUT);
  public Signal pusherExtendM = new Signal("pusherExtendM", Signal.INPUT);
  public Signal vacOnM = new Signal("vacOnM", Signal.INPUT);
  public Signal armSourceM = new Signal("armSourceM", Signal.INPUT);
  public Signal armDestM = new Signal("armDestM", Signal.INPUT);
  public Signal refillM = new Signal("refillM", Signal.INPUT);
  public Signal twin = new Signal("twin", Signal.OUTPUT);
  public Signal pusherExtend = new Signal("pusherExtend", Signal.OUTPUT);
  public Signal vacOn = new Signal("vacOn", Signal.OUTPUT);
  public Signal armSource = new Signal("armSource", Signal.OUTPUT);
  public Signal armDest = new Signal("armDest", Signal.OUTPUT);
  public Signal refill = new Signal("refill", Signal.OUTPUT);
  public input_Channel start_in = new input_Channel();
  public output_Channel done_o = new output_Channel();
  private Signal auto_1;
  private Signal manual_1;
  private LidLoaderTwin t_thread_3;//sysj\lidLoaderController.sysj line: 52, column: 3
  private int lids_thread_3;//sysj\lidLoaderController.sysj line: 53, column: 3
  private WorkpieceTwin w_thread_3;//sysj\lidLoaderController.sysj line: 54, column: 3
  private boolean lidded_thread_3;//sysj\lidLoaderController.sysj line: 55, column: 3
  private int S104208 = 1;
  private int S79058 = 1;
  private int S104206 = 1;
  private int S83250 = 1;
  private int S79082 = 1;
  private int S79066 = 1;
  private int S79061 = 1;
  private int S79083 = 1;
  private int S79090 = 1;
  private int S79365 = 1;
  private int S79370 = 1;
  private int S81737 = 1;
  private int S81732 = 1;
  
  private int[] ends = new int[6];
  private int[] tdone = new int[6];
  
  public void thread104300(int [] tdone, int [] ends){
        switch(S79370){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        vacOn.setPresent();//sysj\lidLoaderController.sysj line: 133, column: 33
        currsigs.addElement(vacOn);
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
        break;
      
    }
  }

  public void thread104299(int [] tdone, int [] ends){
        switch(S79365){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        armDest.setPresent();//sysj\lidLoaderController.sysj line: 133, column: 9
        currsigs.addElement(armDest);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
        break;
      
    }
  }

  public void thread104297(int [] tdone, int [] ends){
        S79370=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 133, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread104296(int [] tdone, int [] ends){
        S79365=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 133, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread104294(int [] tdone, int [] ends){
        S79370=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 133, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread104293(int [] tdone, int [] ends){
        S79365=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 133, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread104291(int [] tdone, int [] ends){
        S79370=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 133, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread104290(int [] tdone, int [] ends){
        S79365=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 133, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread104288(int [] tdone, int [] ends){
        S79370=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 133, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread104287(int [] tdone, int [] ends){
        S79365=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 133, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread104285(int [] tdone, int [] ends){
        S79370=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 133, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread104284(int [] tdone, int [] ends){
        S79365=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 133, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread104282(int [] tdone, int [] ends){
        S79370=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 133, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread104281(int [] tdone, int [] ends){
        S79365=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 133, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread104279(int [] tdone, int [] ends){
        S79370=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 133, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread104278(int [] tdone, int [] ends){
        S79365=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 133, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread104276(int [] tdone, int [] ends){
        S79370=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 133, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread104275(int [] tdone, int [] ends){
        S79365=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 133, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread104273(int [] tdone, int [] ends){
        S79370=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 133, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread104272(int [] tdone, int [] ends){
        S79365=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 133, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread104270(int [] tdone, int [] ends){
        S79370=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 133, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread104269(int [] tdone, int [] ends){
        S79365=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 133, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread104267(int [] tdone, int [] ends){
        S79370=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 133, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread104266(int [] tdone, int [] ends){
        S79365=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 133, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread104264(int [] tdone, int [] ends){
        S79370=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 133, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread104263(int [] tdone, int [] ends){
        S79365=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 133, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread104261(int [] tdone, int [] ends){
        S79370=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 133, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread104260(int [] tdone, int [] ends){
        S79365=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 133, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread104258(int [] tdone, int [] ends){
        S79370=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 133, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread104257(int [] tdone, int [] ends){
        S79365=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 133, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread104255(int [] tdone, int [] ends){
        S79370=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 133, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread104254(int [] tdone, int [] ends){
        S79365=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 133, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread104252(int [] tdone, int [] ends){
        S79370=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 133, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread104251(int [] tdone, int [] ends){
        S79365=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 133, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread104249(int [] tdone, int [] ends){
        S79370=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 133, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread104248(int [] tdone, int [] ends){
        S79365=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 133, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread104246(int [] tdone, int [] ends){
        S79370=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 133, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread104245(int [] tdone, int [] ends){
        S79365=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 133, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread104243(int [] tdone, int [] ends){
        S79370=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 133, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread104242(int [] tdone, int [] ends){
        S79365=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 133, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread104240(int [] tdone, int [] ends){
        S79370=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 133, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread104239(int [] tdone, int [] ends){
        S79365=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 133, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread104237(int [] tdone, int [] ends){
        S79370=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 133, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread104236(int [] tdone, int [] ends){
        S79365=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 133, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread104234(int [] tdone, int [] ends){
        S79370=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 133, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread104233(int [] tdone, int [] ends){
        S79365=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 133, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread104231(int [] tdone, int [] ends){
        S79370=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 133, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread104230(int [] tdone, int [] ends){
        S79365=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 133, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread104228(int [] tdone, int [] ends){
        S79370=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 133, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread104227(int [] tdone, int [] ends){
        S79365=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 133, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread104225(int [] tdone, int [] ends){
        S79370=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 133, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread104224(int [] tdone, int [] ends){
        S79365=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 133, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread104222(int [] tdone, int [] ends){
        S79370=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 133, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread104221(int [] tdone, int [] ends){
        S79365=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 133, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread104219(int [] tdone, int [] ends){
        S79370=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 133, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread104218(int [] tdone, int [] ends){
        S79365=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 133, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread104216(int [] tdone, int [] ends){
        S79370=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 133, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread104215(int [] tdone, int [] ends){
        S79365=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 133, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread104214(int [] tdone, int [] ends){
        switch(S104206){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S83250){
          case 0 : 
            if(reset.getprestatus()){//sysj\lidLoaderController.sysj line: 58, column: 20
              start_in.setPreempted();
              done_o.setPreempted();
              S83250=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              switch(S79082){
                case 0 : 
                  switch(S79066){
                    case 0 : 
                      if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 59, column: 5
                        start_in.setACK(false);//sysj\lidLoaderController.sysj line: 59, column: 5
                        S79066=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S79061){
                          case 0 : 
                            if(!start_in.isREQ()){//sysj\lidLoaderController.sysj line: 59, column: 5
                              start_in.setACK(true);//sysj\lidLoaderController.sysj line: 59, column: 5
                              S79061=1;
                              if(start_in.isREQ()){//sysj\lidLoaderController.sysj line: 59, column: 5
                                start_in.setACK(false);//sysj\lidLoaderController.sysj line: 59, column: 5
                                ends[3]=2;
                                ;//sysj\lidLoaderController.sysj line: 59, column: 5
                                w_thread_3 = (WorkpieceTwin)(start_in.getVal() == null ? null : ((WorkpieceTwin)start_in.getVal()));//sysj\lidLoaderController.sysj line: 60, column: 5
                                lidded_thread_3 = false;//sysj\lidLoaderController.sysj line: 67, column: 5
                                if(w_thread_3 != null) {//sysj\lidLoaderController.sysj line: 68, column: 18
                                  if(w_thread_3.catchFault("lid-fitted")) {//sysj\lidLoaderController.sysj line: 69, column: 36
                                    w_thread_3.lid();//sysj\lidLoaderController.sysj line: 70, column: 7
                                    w_thread_3.reject(Machine.LID_LOADER, "lid already fitted");//sysj\lidLoaderController.sysj line: 71, column: 7
                                  }
                                  lidded_thread_3 = w_thread_3.isLidded();//sysj\lidLoaderController.sysj line: 73, column: 6
                                }
                                S79082=1;
                                if(lidded_thread_3){//sysj\lidLoaderController.sysj line: 76, column: 5
                                  System.out.println("[LID] " + w_thread_3 + " already has a lid fitted.");//sysj\lidLoaderController.sysj line: 77, column: 6
                                  S79082=2;
                                  S81737=0;
                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                    S81737=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S81732=0;
                                    if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                      done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                      S81732=1;
                                      if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                        ends[3]=2;
                                        ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                        S83250=1;
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
                                  if(w_thread_3 != null){//sysj\lidLoaderController.sysj line: 79, column: 13
                                    t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 80, column: 21
                                    t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 81, column: 21
                                    if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "place", "placing lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 82, column: 21
                                      twin.setPresent();//sysj\lidLoaderController.sysj line: 83, column: 25
                                      currsigs.addElement(twin);
                                      twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 83, column: 25
                                      S79083=0;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S79083=0;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    S79082=2;
                                    S81737=0;
                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                      S81737=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S81732=0;
                                      if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                        done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                        S81732=1;
                                        if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                          S83250=1;
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
                            if(start_in.isREQ()){//sysj\lidLoaderController.sysj line: 59, column: 5
                              start_in.setACK(false);//sysj\lidLoaderController.sysj line: 59, column: 5
                              ends[3]=2;
                              ;//sysj\lidLoaderController.sysj line: 59, column: 5
                              w_thread_3 = (WorkpieceTwin)(start_in.getVal() == null ? null : ((WorkpieceTwin)start_in.getVal()));//sysj\lidLoaderController.sysj line: 60, column: 5
                              lidded_thread_3 = false;//sysj\lidLoaderController.sysj line: 67, column: 5
                              if(w_thread_3 != null) {//sysj\lidLoaderController.sysj line: 68, column: 18
                                if(w_thread_3.catchFault("lid-fitted")) {//sysj\lidLoaderController.sysj line: 69, column: 36
                                  w_thread_3.lid();//sysj\lidLoaderController.sysj line: 70, column: 7
                                  w_thread_3.reject(Machine.LID_LOADER, "lid already fitted");//sysj\lidLoaderController.sysj line: 71, column: 7
                                }
                                lidded_thread_3 = w_thread_3.isLidded();//sysj\lidLoaderController.sysj line: 73, column: 6
                              }
                              S79082=1;
                              if(lidded_thread_3){//sysj\lidLoaderController.sysj line: 76, column: 5
                                System.out.println("[LID] " + w_thread_3 + " already has a lid fitted.");//sysj\lidLoaderController.sysj line: 77, column: 6
                                S79082=2;
                                S81737=0;
                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                  S81737=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S81732=0;
                                  if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                    done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                    S81732=1;
                                    if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                      ends[3]=2;
                                      ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                      S83250=1;
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
                                if(w_thread_3 != null){//sysj\lidLoaderController.sysj line: 79, column: 13
                                  t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 80, column: 21
                                  t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 81, column: 21
                                  if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "place", "placing lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 82, column: 21
                                    twin.setPresent();//sysj\lidLoaderController.sysj line: 83, column: 25
                                    currsigs.addElement(twin);
                                    twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 83, column: 25
                                    S79083=0;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S79083=0;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  S79082=2;
                                  S81737=0;
                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                    S81737=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S81732=0;
                                    if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                      done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                      S81732=1;
                                      if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                        ends[3]=2;
                                        ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                        S83250=1;
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
                      S79066=1;
                      S79066=0;
                      if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 59, column: 5
                        start_in.setACK(false);//sysj\lidLoaderController.sysj line: 59, column: 5
                        S79066=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S79061=0;
                        if(!start_in.isREQ()){//sysj\lidLoaderController.sysj line: 59, column: 5
                          start_in.setACK(true);//sysj\lidLoaderController.sysj line: 59, column: 5
                          S79061=1;
                          if(start_in.isREQ()){//sysj\lidLoaderController.sysj line: 59, column: 5
                            start_in.setACK(false);//sysj\lidLoaderController.sysj line: 59, column: 5
                            ends[3]=2;
                            ;//sysj\lidLoaderController.sysj line: 59, column: 5
                            w_thread_3 = (WorkpieceTwin)(start_in.getVal() == null ? null : ((WorkpieceTwin)start_in.getVal()));//sysj\lidLoaderController.sysj line: 60, column: 5
                            lidded_thread_3 = false;//sysj\lidLoaderController.sysj line: 67, column: 5
                            if(w_thread_3 != null) {//sysj\lidLoaderController.sysj line: 68, column: 18
                              if(w_thread_3.catchFault("lid-fitted")) {//sysj\lidLoaderController.sysj line: 69, column: 36
                                w_thread_3.lid();//sysj\lidLoaderController.sysj line: 70, column: 7
                                w_thread_3.reject(Machine.LID_LOADER, "lid already fitted");//sysj\lidLoaderController.sysj line: 71, column: 7
                              }
                              lidded_thread_3 = w_thread_3.isLidded();//sysj\lidLoaderController.sysj line: 73, column: 6
                            }
                            S79082=1;
                            if(lidded_thread_3){//sysj\lidLoaderController.sysj line: 76, column: 5
                              System.out.println("[LID] " + w_thread_3 + " already has a lid fitted.");//sysj\lidLoaderController.sysj line: 77, column: 6
                              S79082=2;
                              S81737=0;
                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                S81737=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S81732=0;
                                if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                  done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                  S81732=1;
                                  if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                    ends[3]=2;
                                    ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                    S83250=1;
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
                              if(w_thread_3 != null){//sysj\lidLoaderController.sysj line: 79, column: 13
                                t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 80, column: 21
                                t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 81, column: 21
                                if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "place", "placing lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 82, column: 21
                                  twin.setPresent();//sysj\lidLoaderController.sysj line: 83, column: 25
                                  currsigs.addElement(twin);
                                  twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 83, column: 25
                                  S79083=0;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S79083=0;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                S79082=2;
                                S81737=0;
                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                  S81737=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S81732=0;
                                  if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                    done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                    S81732=1;
                                    if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                      ends[3]=2;
                                      ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                      S83250=1;
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
                  switch(S79083){
                    case 0 : 
                      S79083=0;
                      S79083=1;
                      if(magazineEmpty.getprestatus()){//sysj\lidLoaderController.sysj line: 87, column: 14
                        System.out.println("[LID] Magazine empty, refilling.");//sysj\lidLoaderController.sysj line: 88, column: 7
                        S79090=0;
                        if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 89, column: 23
                          S79090=1;
                          if(refilled.getprestatus()){//sysj\lidLoaderController.sysj line: 90, column: 23
                            S79083=2;
                            if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 105, column: 22
                              S79083=3;
                              if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 106, column: 22
                                S79083=4;
                                if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 109, column: 22
                                  S79083=5;
                                  if(lidAtPickup.getprestatus()){//sysj\lidLoaderController.sysj line: 110, column: 22
                                    S79083=6;
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
                                pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 107, column: 7
                                currsigs.addElement(pusherExtend);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(pusherExtendM.getprestatus()){//sysj\lidLoaderController.sysj line: 105, column: 45
                                S79083=3;
                                if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 106, column: 22
                                  S79083=4;
                                  if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 109, column: 22
                                    S79083=5;
                                    if(lidAtPickup.getprestatus()){//sysj\lidLoaderController.sysj line: 110, column: 22
                                      S79083=6;
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
                                  pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 107, column: 7
                                  currsigs.addElement(pusherExtend);
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
                            refill.setPresent();//sysj\lidLoaderController.sysj line: 91, column: 8
                            currsigs.addElement(refill);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          if(refillM.getprestatus()){//sysj\lidLoaderController.sysj line: 89, column: 46
                            S79090=1;
                            if(refilled.getprestatus()){//sysj\lidLoaderController.sysj line: 90, column: 23
                              S79083=2;
                              if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 105, column: 22
                                S79083=3;
                                if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 106, column: 22
                                  S79083=4;
                                  if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 109, column: 22
                                    S79083=5;
                                    if(lidAtPickup.getprestatus()){//sysj\lidLoaderController.sysj line: 110, column: 22
                                      S79083=6;
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
                                  pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 107, column: 7
                                  currsigs.addElement(pusherExtend);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                if(pusherExtendM.getprestatus()){//sysj\lidLoaderController.sysj line: 105, column: 45
                                  S79083=3;
                                  if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 106, column: 22
                                    S79083=4;
                                    if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 109, column: 22
                                      S79083=5;
                                      if(lidAtPickup.getprestatus()){//sysj\lidLoaderController.sysj line: 110, column: 22
                                        S79083=6;
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
                                    pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 107, column: 7
                                    currsigs.addElement(pusherExtend);
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
                              refill.setPresent();//sysj\lidLoaderController.sysj line: 91, column: 8
                              currsigs.addElement(refill);
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
                        S79083=2;
                        if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 105, column: 22
                          S79083=3;
                          if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 106, column: 22
                            S79083=4;
                            if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 109, column: 22
                              S79083=5;
                              if(lidAtPickup.getprestatus()){//sysj\lidLoaderController.sysj line: 110, column: 22
                                S79083=6;
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
                            pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 107, column: 7
                            currsigs.addElement(pusherExtend);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          if(pusherExtendM.getprestatus()){//sysj\lidLoaderController.sysj line: 105, column: 45
                            S79083=3;
                            if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 106, column: 22
                              S79083=4;
                              if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 109, column: 22
                                S79083=5;
                                if(lidAtPickup.getprestatus()){//sysj\lidLoaderController.sysj line: 110, column: 22
                                  S79083=6;
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
                              pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 107, column: 7
                              currsigs.addElement(pusherExtend);
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
                    
                    case 1 : 
                      switch(S79090){
                        case 0 : 
                          if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 89, column: 23
                            S79090=1;
                            if(refilled.getprestatus()){//sysj\lidLoaderController.sysj line: 90, column: 23
                              S79083=2;
                              if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 105, column: 22
                                S79083=3;
                                if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 106, column: 22
                                  S79083=4;
                                  if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 109, column: 22
                                    S79083=5;
                                    if(lidAtPickup.getprestatus()){//sysj\lidLoaderController.sysj line: 110, column: 22
                                      S79083=6;
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
                                  pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 107, column: 7
                                  currsigs.addElement(pusherExtend);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                if(pusherExtendM.getprestatus()){//sysj\lidLoaderController.sysj line: 105, column: 45
                                  S79083=3;
                                  if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 106, column: 22
                                    S79083=4;
                                    if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 109, column: 22
                                      S79083=5;
                                      if(lidAtPickup.getprestatus()){//sysj\lidLoaderController.sysj line: 110, column: 22
                                        S79083=6;
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
                                    pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 107, column: 7
                                    currsigs.addElement(pusherExtend);
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
                              refill.setPresent();//sysj\lidLoaderController.sysj line: 91, column: 8
                              currsigs.addElement(refill);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            if(refillM.getprestatus()){//sysj\lidLoaderController.sysj line: 89, column: 46
                              S79090=1;
                              if(refilled.getprestatus()){//sysj\lidLoaderController.sysj line: 90, column: 23
                                S79083=2;
                                if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 105, column: 22
                                  S79083=3;
                                  if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 106, column: 22
                                    S79083=4;
                                    if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 109, column: 22
                                      S79083=5;
                                      if(lidAtPickup.getprestatus()){//sysj\lidLoaderController.sysj line: 110, column: 22
                                        S79083=6;
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
                                    pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 107, column: 7
                                    currsigs.addElement(pusherExtend);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(pusherExtendM.getprestatus()){//sysj\lidLoaderController.sysj line: 105, column: 45
                                    S79083=3;
                                    if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 106, column: 22
                                      S79083=4;
                                      if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 109, column: 22
                                        S79083=5;
                                        if(lidAtPickup.getprestatus()){//sysj\lidLoaderController.sysj line: 110, column: 22
                                          S79083=6;
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
                                      pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 107, column: 7
                                      currsigs.addElement(pusherExtend);
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
                                refill.setPresent();//sysj\lidLoaderController.sysj line: 91, column: 8
                                currsigs.addElement(refill);
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
                        
                        case 1 : 
                          if(refilled.getprestatus()){//sysj\lidLoaderController.sysj line: 90, column: 23
                            S79083=2;
                            if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 105, column: 22
                              S79083=3;
                              if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 106, column: 22
                                S79083=4;
                                if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 109, column: 22
                                  S79083=5;
                                  if(lidAtPickup.getprestatus()){//sysj\lidLoaderController.sysj line: 110, column: 22
                                    S79083=6;
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
                                pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 107, column: 7
                                currsigs.addElement(pusherExtend);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(pusherExtendM.getprestatus()){//sysj\lidLoaderController.sysj line: 105, column: 45
                                S79083=3;
                                if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 106, column: 22
                                  S79083=4;
                                  if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 109, column: 22
                                    S79083=5;
                                    if(lidAtPickup.getprestatus()){//sysj\lidLoaderController.sysj line: 110, column: 22
                                      S79083=6;
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
                                  pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 107, column: 7
                                  currsigs.addElement(pusherExtend);
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
                            refill.setPresent();//sysj\lidLoaderController.sysj line: 91, column: 8
                            currsigs.addElement(refill);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          break;
                        
                      }
                      break;
                    
                    case 2 : 
                      if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 105, column: 22
                        S79083=3;
                        if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 106, column: 22
                          S79083=4;
                          if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 109, column: 22
                            S79083=5;
                            if(lidAtPickup.getprestatus()){//sysj\lidLoaderController.sysj line: 110, column: 22
                              S79083=6;
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
                          pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 107, column: 7
                          currsigs.addElement(pusherExtend);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        if(pusherExtendM.getprestatus()){//sysj\lidLoaderController.sysj line: 105, column: 45
                          S79083=3;
                          if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 106, column: 22
                            S79083=4;
                            if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 109, column: 22
                              S79083=5;
                              if(lidAtPickup.getprestatus()){//sysj\lidLoaderController.sysj line: 110, column: 22
                                S79083=6;
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
                            pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 107, column: 7
                            currsigs.addElement(pusherExtend);
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
                    
                    case 3 : 
                      if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 106, column: 22
                        S79083=4;
                        if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 109, column: 22
                          S79083=5;
                          if(lidAtPickup.getprestatus()){//sysj\lidLoaderController.sysj line: 110, column: 22
                            S79083=6;
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
                        pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 107, column: 7
                        currsigs.addElement(pusherExtend);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 4 : 
                      if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 109, column: 22
                        S79083=5;
                        if(lidAtPickup.getprestatus()){//sysj\lidLoaderController.sysj line: 110, column: 22
                          S79083=6;
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
                    
                    case 5 : 
                      if(lidAtPickup.getprestatus()){//sysj\lidLoaderController.sysj line: 110, column: 22
                        S79083=6;
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
                    
                    case 6 : 
                      S79083=6;
                      S79083=7;
                      if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 121, column: 22
                        S79083=8;
                        if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 122, column: 22
                          S79083=9;
                          if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 125, column: 22
                            S79083=10;
                            if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 126, column: 22
                              S79083=11;
                              if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 131, column: 22
                                S79083=12;
                                if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 132, column: 22
                                  S79083=13;
                                  if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 135, column: 22
                                    w_thread_3.lid();//sysj\lidLoaderController.sysj line: 137, column: 6
                                    lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 138, column: 6
                                    if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 139, column: 18
                                      lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 139, column: 20
                                    }
                                    t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 140, column: 6
                                    t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 141, column: 6
                                    if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 142, column: 6
                                      twin.setPresent();//sysj\lidLoaderController.sysj line: 143, column: 7
                                      currsigs.addElement(twin);
                                      twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 143, column: 7
                                      System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                                      S79082=2;
                                      S81737=0;
                                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                        S81737=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S81732=0;
                                        if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                          done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                          S81732=1;
                                          if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                            S83250=1;
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
                                      System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                                      S79082=2;
                                      S81737=0;
                                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                        S81737=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S81732=0;
                                        if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                          done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                          S81732=1;
                                          if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                            S83250=1;
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
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  thread104215(tdone,ends);
                                  thread104216(tdone,ends);
                                  int biggest104217 = 0;
                                  if(ends[4]>=biggest104217){
                                    biggest104217=ends[4];
                                  }
                                  if(ends[5]>=biggest104217){
                                    biggest104217=ends[5];
                                  }
                                  if(biggest104217 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 131, column: 45
                                  S79083=12;
                                  if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 132, column: 22
                                    S79083=13;
                                    if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 135, column: 22
                                      w_thread_3.lid();//sysj\lidLoaderController.sysj line: 137, column: 6
                                      lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 138, column: 6
                                      if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 139, column: 18
                                        lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 139, column: 20
                                      }
                                      t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 140, column: 6
                                      t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 141, column: 6
                                      if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 142, column: 6
                                        twin.setPresent();//sysj\lidLoaderController.sysj line: 143, column: 7
                                        currsigs.addElement(twin);
                                        twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 143, column: 7
                                        System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                                        S79082=2;
                                        S81737=0;
                                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                          S81737=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S81732=0;
                                          if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                            done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                            S81732=1;
                                            if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                              ends[3]=2;
                                              ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                              S83250=1;
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
                                        System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                                        S79082=2;
                                        S81737=0;
                                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                          S81737=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S81732=0;
                                          if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                            done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                            S81732=1;
                                            if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                              ends[3]=2;
                                              ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                              S83250=1;
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
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    thread104218(tdone,ends);
                                    thread104219(tdone,ends);
                                    int biggest104220 = 0;
                                    if(ends[4]>=biggest104220){
                                      biggest104220=ends[4];
                                    }
                                    if(ends[5]>=biggest104220){
                                      biggest104220=ends[5];
                                    }
                                    if(biggest104220 == 1){
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
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
                              vacOn.setPresent();//sysj\lidLoaderController.sysj line: 127, column: 7
                              currsigs.addElement(vacOn);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            if(vacOnM.getprestatus()){//sysj\lidLoaderController.sysj line: 125, column: 45
                              S79083=10;
                              if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 126, column: 22
                                S79083=11;
                                if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 131, column: 22
                                  S79083=12;
                                  if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 132, column: 22
                                    S79083=13;
                                    if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 135, column: 22
                                      w_thread_3.lid();//sysj\lidLoaderController.sysj line: 137, column: 6
                                      lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 138, column: 6
                                      if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 139, column: 18
                                        lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 139, column: 20
                                      }
                                      t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 140, column: 6
                                      t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 141, column: 6
                                      if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 142, column: 6
                                        twin.setPresent();//sysj\lidLoaderController.sysj line: 143, column: 7
                                        currsigs.addElement(twin);
                                        twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 143, column: 7
                                        System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                                        S79082=2;
                                        S81737=0;
                                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                          S81737=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S81732=0;
                                          if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                            done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                            S81732=1;
                                            if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                              ends[3]=2;
                                              ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                              S83250=1;
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
                                        System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                                        S79082=2;
                                        S81737=0;
                                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                          S81737=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S81732=0;
                                          if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                            done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                            S81732=1;
                                            if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                              ends[3]=2;
                                              ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                              S83250=1;
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
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    thread104221(tdone,ends);
                                    thread104222(tdone,ends);
                                    int biggest104223 = 0;
                                    if(ends[4]>=biggest104223){
                                      biggest104223=ends[4];
                                    }
                                    if(ends[5]>=biggest104223){
                                      biggest104223=ends[5];
                                    }
                                    if(biggest104223 == 1){
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 131, column: 45
                                    S79083=12;
                                    if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 132, column: 22
                                      S79083=13;
                                      if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 135, column: 22
                                        w_thread_3.lid();//sysj\lidLoaderController.sysj line: 137, column: 6
                                        lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 138, column: 6
                                        if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 139, column: 18
                                          lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 139, column: 20
                                        }
                                        t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 140, column: 6
                                        t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 141, column: 6
                                        if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 142, column: 6
                                          twin.setPresent();//sysj\lidLoaderController.sysj line: 143, column: 7
                                          currsigs.addElement(twin);
                                          twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 143, column: 7
                                          System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                                          S79082=2;
                                          S81737=0;
                                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                            S81737=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S81732=0;
                                            if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                              done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                              S81732=1;
                                              if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                                ends[3]=2;
                                                ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                                S83250=1;
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
                                          System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                                          S79082=2;
                                          S81737=0;
                                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                            S81737=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S81732=0;
                                            if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                              done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                              S81732=1;
                                              if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                                ends[3]=2;
                                                ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                                S83250=1;
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
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      thread104224(tdone,ends);
                                      thread104225(tdone,ends);
                                      int biggest104226 = 0;
                                      if(ends[4]>=biggest104226){
                                        biggest104226=ends[4];
                                      }
                                      if(ends[5]>=biggest104226){
                                        biggest104226=ends[5];
                                      }
                                      if(biggest104226 == 1){
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
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
                                vacOn.setPresent();//sysj\lidLoaderController.sysj line: 127, column: 7
                                currsigs.addElement(vacOn);
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
                          armSource.setPresent();//sysj\lidLoaderController.sysj line: 123, column: 7
                          currsigs.addElement(armSource);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 121, column: 45
                          S79083=8;
                          if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 122, column: 22
                            S79083=9;
                            if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 125, column: 22
                              S79083=10;
                              if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 126, column: 22
                                S79083=11;
                                if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 131, column: 22
                                  S79083=12;
                                  if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 132, column: 22
                                    S79083=13;
                                    if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 135, column: 22
                                      w_thread_3.lid();//sysj\lidLoaderController.sysj line: 137, column: 6
                                      lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 138, column: 6
                                      if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 139, column: 18
                                        lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 139, column: 20
                                      }
                                      t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 140, column: 6
                                      t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 141, column: 6
                                      if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 142, column: 6
                                        twin.setPresent();//sysj\lidLoaderController.sysj line: 143, column: 7
                                        currsigs.addElement(twin);
                                        twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 143, column: 7
                                        System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                                        S79082=2;
                                        S81737=0;
                                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                          S81737=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S81732=0;
                                          if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                            done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                            S81732=1;
                                            if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                              ends[3]=2;
                                              ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                              S83250=1;
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
                                        System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                                        S79082=2;
                                        S81737=0;
                                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                          S81737=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S81732=0;
                                          if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                            done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                            S81732=1;
                                            if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                              ends[3]=2;
                                              ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                              S83250=1;
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
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    thread104227(tdone,ends);
                                    thread104228(tdone,ends);
                                    int biggest104229 = 0;
                                    if(ends[4]>=biggest104229){
                                      biggest104229=ends[4];
                                    }
                                    if(ends[5]>=biggest104229){
                                      biggest104229=ends[5];
                                    }
                                    if(biggest104229 == 1){
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 131, column: 45
                                    S79083=12;
                                    if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 132, column: 22
                                      S79083=13;
                                      if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 135, column: 22
                                        w_thread_3.lid();//sysj\lidLoaderController.sysj line: 137, column: 6
                                        lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 138, column: 6
                                        if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 139, column: 18
                                          lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 139, column: 20
                                        }
                                        t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 140, column: 6
                                        t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 141, column: 6
                                        if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 142, column: 6
                                          twin.setPresent();//sysj\lidLoaderController.sysj line: 143, column: 7
                                          currsigs.addElement(twin);
                                          twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 143, column: 7
                                          System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                                          S79082=2;
                                          S81737=0;
                                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                            S81737=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S81732=0;
                                            if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                              done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                              S81732=1;
                                              if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                                ends[3]=2;
                                                ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                                S83250=1;
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
                                          System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                                          S79082=2;
                                          S81737=0;
                                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                            S81737=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S81732=0;
                                            if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                              done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                              S81732=1;
                                              if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                                ends[3]=2;
                                                ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                                S83250=1;
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
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      thread104230(tdone,ends);
                                      thread104231(tdone,ends);
                                      int biggest104232 = 0;
                                      if(ends[4]>=biggest104232){
                                        biggest104232=ends[4];
                                      }
                                      if(ends[5]>=biggest104232){
                                        biggest104232=ends[5];
                                      }
                                      if(biggest104232 == 1){
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
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
                                vacOn.setPresent();//sysj\lidLoaderController.sysj line: 127, column: 7
                                currsigs.addElement(vacOn);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(vacOnM.getprestatus()){//sysj\lidLoaderController.sysj line: 125, column: 45
                                S79083=10;
                                if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 126, column: 22
                                  S79083=11;
                                  if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 131, column: 22
                                    S79083=12;
                                    if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 132, column: 22
                                      S79083=13;
                                      if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 135, column: 22
                                        w_thread_3.lid();//sysj\lidLoaderController.sysj line: 137, column: 6
                                        lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 138, column: 6
                                        if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 139, column: 18
                                          lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 139, column: 20
                                        }
                                        t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 140, column: 6
                                        t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 141, column: 6
                                        if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 142, column: 6
                                          twin.setPresent();//sysj\lidLoaderController.sysj line: 143, column: 7
                                          currsigs.addElement(twin);
                                          twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 143, column: 7
                                          System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                                          S79082=2;
                                          S81737=0;
                                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                            S81737=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S81732=0;
                                            if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                              done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                              S81732=1;
                                              if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                                ends[3]=2;
                                                ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                                S83250=1;
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
                                          System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                                          S79082=2;
                                          S81737=0;
                                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                            S81737=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S81732=0;
                                            if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                              done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                              S81732=1;
                                              if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                                ends[3]=2;
                                                ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                                S83250=1;
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
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      thread104233(tdone,ends);
                                      thread104234(tdone,ends);
                                      int biggest104235 = 0;
                                      if(ends[4]>=biggest104235){
                                        biggest104235=ends[4];
                                      }
                                      if(ends[5]>=biggest104235){
                                        biggest104235=ends[5];
                                      }
                                      if(biggest104235 == 1){
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                  else {
                                    if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 131, column: 45
                                      S79083=12;
                                      if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 132, column: 22
                                        S79083=13;
                                        if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 135, column: 22
                                          w_thread_3.lid();//sysj\lidLoaderController.sysj line: 137, column: 6
                                          lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 138, column: 6
                                          if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 139, column: 18
                                            lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 139, column: 20
                                          }
                                          t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 140, column: 6
                                          t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 141, column: 6
                                          if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 142, column: 6
                                            twin.setPresent();//sysj\lidLoaderController.sysj line: 143, column: 7
                                            currsigs.addElement(twin);
                                            twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 143, column: 7
                                            System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                                            S79082=2;
                                            S81737=0;
                                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                              S81737=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S81732=0;
                                              if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                                done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                                S81732=1;
                                                if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                                  S83250=1;
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
                                            System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                                            S79082=2;
                                            S81737=0;
                                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                              S81737=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S81732=0;
                                              if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                                done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                                S81732=1;
                                                if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                                  S83250=1;
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
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        thread104236(tdone,ends);
                                        thread104237(tdone,ends);
                                        int biggest104238 = 0;
                                        if(ends[4]>=biggest104238){
                                          biggest104238=ends[4];
                                        }
                                        if(ends[5]>=biggest104238){
                                          biggest104238=ends[5];
                                        }
                                        if(biggest104238 == 1){
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
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
                                  vacOn.setPresent();//sysj\lidLoaderController.sysj line: 127, column: 7
                                  currsigs.addElement(vacOn);
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
                            armSource.setPresent();//sysj\lidLoaderController.sysj line: 123, column: 7
                            currsigs.addElement(armSource);
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
                    
                    case 7 : 
                      if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 121, column: 22
                        S79083=8;
                        if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 122, column: 22
                          S79083=9;
                          if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 125, column: 22
                            S79083=10;
                            if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 126, column: 22
                              S79083=11;
                              if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 131, column: 22
                                S79083=12;
                                if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 132, column: 22
                                  S79083=13;
                                  if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 135, column: 22
                                    w_thread_3.lid();//sysj\lidLoaderController.sysj line: 137, column: 6
                                    lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 138, column: 6
                                    if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 139, column: 18
                                      lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 139, column: 20
                                    }
                                    t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 140, column: 6
                                    t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 141, column: 6
                                    if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 142, column: 6
                                      twin.setPresent();//sysj\lidLoaderController.sysj line: 143, column: 7
                                      currsigs.addElement(twin);
                                      twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 143, column: 7
                                      System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                                      S79082=2;
                                      S81737=0;
                                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                        S81737=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S81732=0;
                                        if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                          done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                          S81732=1;
                                          if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                            S83250=1;
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
                                      System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                                      S79082=2;
                                      S81737=0;
                                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                        S81737=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S81732=0;
                                        if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                          done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                          S81732=1;
                                          if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                            S83250=1;
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
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  thread104239(tdone,ends);
                                  thread104240(tdone,ends);
                                  int biggest104241 = 0;
                                  if(ends[4]>=biggest104241){
                                    biggest104241=ends[4];
                                  }
                                  if(ends[5]>=biggest104241){
                                    biggest104241=ends[5];
                                  }
                                  if(biggest104241 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 131, column: 45
                                  S79083=12;
                                  if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 132, column: 22
                                    S79083=13;
                                    if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 135, column: 22
                                      w_thread_3.lid();//sysj\lidLoaderController.sysj line: 137, column: 6
                                      lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 138, column: 6
                                      if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 139, column: 18
                                        lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 139, column: 20
                                      }
                                      t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 140, column: 6
                                      t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 141, column: 6
                                      if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 142, column: 6
                                        twin.setPresent();//sysj\lidLoaderController.sysj line: 143, column: 7
                                        currsigs.addElement(twin);
                                        twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 143, column: 7
                                        System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                                        S79082=2;
                                        S81737=0;
                                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                          S81737=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S81732=0;
                                          if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                            done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                            S81732=1;
                                            if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                              ends[3]=2;
                                              ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                              S83250=1;
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
                                        System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                                        S79082=2;
                                        S81737=0;
                                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                          S81737=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S81732=0;
                                          if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                            done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                            S81732=1;
                                            if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                              ends[3]=2;
                                              ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                              S83250=1;
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
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    thread104242(tdone,ends);
                                    thread104243(tdone,ends);
                                    int biggest104244 = 0;
                                    if(ends[4]>=biggest104244){
                                      biggest104244=ends[4];
                                    }
                                    if(ends[5]>=biggest104244){
                                      biggest104244=ends[5];
                                    }
                                    if(biggest104244 == 1){
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
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
                              vacOn.setPresent();//sysj\lidLoaderController.sysj line: 127, column: 7
                              currsigs.addElement(vacOn);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            if(vacOnM.getprestatus()){//sysj\lidLoaderController.sysj line: 125, column: 45
                              S79083=10;
                              if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 126, column: 22
                                S79083=11;
                                if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 131, column: 22
                                  S79083=12;
                                  if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 132, column: 22
                                    S79083=13;
                                    if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 135, column: 22
                                      w_thread_3.lid();//sysj\lidLoaderController.sysj line: 137, column: 6
                                      lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 138, column: 6
                                      if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 139, column: 18
                                        lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 139, column: 20
                                      }
                                      t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 140, column: 6
                                      t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 141, column: 6
                                      if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 142, column: 6
                                        twin.setPresent();//sysj\lidLoaderController.sysj line: 143, column: 7
                                        currsigs.addElement(twin);
                                        twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 143, column: 7
                                        System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                                        S79082=2;
                                        S81737=0;
                                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                          S81737=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S81732=0;
                                          if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                            done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                            S81732=1;
                                            if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                              ends[3]=2;
                                              ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                              S83250=1;
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
                                        System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                                        S79082=2;
                                        S81737=0;
                                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                          S81737=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S81732=0;
                                          if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                            done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                            S81732=1;
                                            if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                              ends[3]=2;
                                              ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                              S83250=1;
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
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    thread104245(tdone,ends);
                                    thread104246(tdone,ends);
                                    int biggest104247 = 0;
                                    if(ends[4]>=biggest104247){
                                      biggest104247=ends[4];
                                    }
                                    if(ends[5]>=biggest104247){
                                      biggest104247=ends[5];
                                    }
                                    if(biggest104247 == 1){
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 131, column: 45
                                    S79083=12;
                                    if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 132, column: 22
                                      S79083=13;
                                      if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 135, column: 22
                                        w_thread_3.lid();//sysj\lidLoaderController.sysj line: 137, column: 6
                                        lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 138, column: 6
                                        if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 139, column: 18
                                          lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 139, column: 20
                                        }
                                        t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 140, column: 6
                                        t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 141, column: 6
                                        if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 142, column: 6
                                          twin.setPresent();//sysj\lidLoaderController.sysj line: 143, column: 7
                                          currsigs.addElement(twin);
                                          twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 143, column: 7
                                          System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                                          S79082=2;
                                          S81737=0;
                                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                            S81737=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S81732=0;
                                            if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                              done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                              S81732=1;
                                              if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                                ends[3]=2;
                                                ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                                S83250=1;
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
                                          System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                                          S79082=2;
                                          S81737=0;
                                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                            S81737=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S81732=0;
                                            if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                              done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                              S81732=1;
                                              if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                                ends[3]=2;
                                                ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                                S83250=1;
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
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      thread104248(tdone,ends);
                                      thread104249(tdone,ends);
                                      int biggest104250 = 0;
                                      if(ends[4]>=biggest104250){
                                        biggest104250=ends[4];
                                      }
                                      if(ends[5]>=biggest104250){
                                        biggest104250=ends[5];
                                      }
                                      if(biggest104250 == 1){
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
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
                                vacOn.setPresent();//sysj\lidLoaderController.sysj line: 127, column: 7
                                currsigs.addElement(vacOn);
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
                          armSource.setPresent();//sysj\lidLoaderController.sysj line: 123, column: 7
                          currsigs.addElement(armSource);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 121, column: 45
                          S79083=8;
                          if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 122, column: 22
                            S79083=9;
                            if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 125, column: 22
                              S79083=10;
                              if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 126, column: 22
                                S79083=11;
                                if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 131, column: 22
                                  S79083=12;
                                  if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 132, column: 22
                                    S79083=13;
                                    if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 135, column: 22
                                      w_thread_3.lid();//sysj\lidLoaderController.sysj line: 137, column: 6
                                      lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 138, column: 6
                                      if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 139, column: 18
                                        lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 139, column: 20
                                      }
                                      t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 140, column: 6
                                      t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 141, column: 6
                                      if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 142, column: 6
                                        twin.setPresent();//sysj\lidLoaderController.sysj line: 143, column: 7
                                        currsigs.addElement(twin);
                                        twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 143, column: 7
                                        System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                                        S79082=2;
                                        S81737=0;
                                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                          S81737=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S81732=0;
                                          if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                            done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                            S81732=1;
                                            if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                              ends[3]=2;
                                              ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                              S83250=1;
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
                                        System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                                        S79082=2;
                                        S81737=0;
                                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                          S81737=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S81732=0;
                                          if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                            done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                            S81732=1;
                                            if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                              ends[3]=2;
                                              ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                              S83250=1;
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
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    thread104251(tdone,ends);
                                    thread104252(tdone,ends);
                                    int biggest104253 = 0;
                                    if(ends[4]>=biggest104253){
                                      biggest104253=ends[4];
                                    }
                                    if(ends[5]>=biggest104253){
                                      biggest104253=ends[5];
                                    }
                                    if(biggest104253 == 1){
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 131, column: 45
                                    S79083=12;
                                    if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 132, column: 22
                                      S79083=13;
                                      if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 135, column: 22
                                        w_thread_3.lid();//sysj\lidLoaderController.sysj line: 137, column: 6
                                        lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 138, column: 6
                                        if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 139, column: 18
                                          lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 139, column: 20
                                        }
                                        t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 140, column: 6
                                        t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 141, column: 6
                                        if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 142, column: 6
                                          twin.setPresent();//sysj\lidLoaderController.sysj line: 143, column: 7
                                          currsigs.addElement(twin);
                                          twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 143, column: 7
                                          System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                                          S79082=2;
                                          S81737=0;
                                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                            S81737=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S81732=0;
                                            if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                              done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                              S81732=1;
                                              if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                                ends[3]=2;
                                                ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                                S83250=1;
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
                                          System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                                          S79082=2;
                                          S81737=0;
                                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                            S81737=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S81732=0;
                                            if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                              done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                              S81732=1;
                                              if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                                ends[3]=2;
                                                ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                                S83250=1;
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
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      thread104254(tdone,ends);
                                      thread104255(tdone,ends);
                                      int biggest104256 = 0;
                                      if(ends[4]>=biggest104256){
                                        biggest104256=ends[4];
                                      }
                                      if(ends[5]>=biggest104256){
                                        biggest104256=ends[5];
                                      }
                                      if(biggest104256 == 1){
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
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
                                vacOn.setPresent();//sysj\lidLoaderController.sysj line: 127, column: 7
                                currsigs.addElement(vacOn);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(vacOnM.getprestatus()){//sysj\lidLoaderController.sysj line: 125, column: 45
                                S79083=10;
                                if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 126, column: 22
                                  S79083=11;
                                  if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 131, column: 22
                                    S79083=12;
                                    if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 132, column: 22
                                      S79083=13;
                                      if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 135, column: 22
                                        w_thread_3.lid();//sysj\lidLoaderController.sysj line: 137, column: 6
                                        lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 138, column: 6
                                        if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 139, column: 18
                                          lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 139, column: 20
                                        }
                                        t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 140, column: 6
                                        t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 141, column: 6
                                        if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 142, column: 6
                                          twin.setPresent();//sysj\lidLoaderController.sysj line: 143, column: 7
                                          currsigs.addElement(twin);
                                          twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 143, column: 7
                                          System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                                          S79082=2;
                                          S81737=0;
                                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                            S81737=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S81732=0;
                                            if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                              done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                              S81732=1;
                                              if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                                ends[3]=2;
                                                ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                                S83250=1;
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
                                          System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                                          S79082=2;
                                          S81737=0;
                                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                            S81737=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S81732=0;
                                            if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                              done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                              S81732=1;
                                              if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                                ends[3]=2;
                                                ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                                S83250=1;
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
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      thread104257(tdone,ends);
                                      thread104258(tdone,ends);
                                      int biggest104259 = 0;
                                      if(ends[4]>=biggest104259){
                                        biggest104259=ends[4];
                                      }
                                      if(ends[5]>=biggest104259){
                                        biggest104259=ends[5];
                                      }
                                      if(biggest104259 == 1){
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                  else {
                                    if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 131, column: 45
                                      S79083=12;
                                      if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 132, column: 22
                                        S79083=13;
                                        if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 135, column: 22
                                          w_thread_3.lid();//sysj\lidLoaderController.sysj line: 137, column: 6
                                          lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 138, column: 6
                                          if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 139, column: 18
                                            lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 139, column: 20
                                          }
                                          t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 140, column: 6
                                          t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 141, column: 6
                                          if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 142, column: 6
                                            twin.setPresent();//sysj\lidLoaderController.sysj line: 143, column: 7
                                            currsigs.addElement(twin);
                                            twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 143, column: 7
                                            System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                                            S79082=2;
                                            S81737=0;
                                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                              S81737=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S81732=0;
                                              if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                                done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                                S81732=1;
                                                if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                                  S83250=1;
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
                                            System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                                            S79082=2;
                                            S81737=0;
                                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                              S81737=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S81732=0;
                                              if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                                done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                                S81732=1;
                                                if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                                  S83250=1;
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
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        thread104260(tdone,ends);
                                        thread104261(tdone,ends);
                                        int biggest104262 = 0;
                                        if(ends[4]>=biggest104262){
                                          biggest104262=ends[4];
                                        }
                                        if(ends[5]>=biggest104262){
                                          biggest104262=ends[5];
                                        }
                                        if(biggest104262 == 1){
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
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
                                  vacOn.setPresent();//sysj\lidLoaderController.sysj line: 127, column: 7
                                  currsigs.addElement(vacOn);
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
                            armSource.setPresent();//sysj\lidLoaderController.sysj line: 123, column: 7
                            currsigs.addElement(armSource);
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
                    
                    case 8 : 
                      if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 122, column: 22
                        S79083=9;
                        if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 125, column: 22
                          S79083=10;
                          if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 126, column: 22
                            S79083=11;
                            if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 131, column: 22
                              S79083=12;
                              if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 132, column: 22
                                S79083=13;
                                if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 135, column: 22
                                  w_thread_3.lid();//sysj\lidLoaderController.sysj line: 137, column: 6
                                  lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 138, column: 6
                                  if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 139, column: 18
                                    lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 139, column: 20
                                  }
                                  t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 140, column: 6
                                  t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 141, column: 6
                                  if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 142, column: 6
                                    twin.setPresent();//sysj\lidLoaderController.sysj line: 143, column: 7
                                    currsigs.addElement(twin);
                                    twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 143, column: 7
                                    System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                                    S79082=2;
                                    S81737=0;
                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                      S81737=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S81732=0;
                                      if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                        done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                        S81732=1;
                                        if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                          S83250=1;
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
                                    System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                                    S79082=2;
                                    S81737=0;
                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                      S81737=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S81732=0;
                                      if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                        done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                        S81732=1;
                                        if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                          S83250=1;
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
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                thread104263(tdone,ends);
                                thread104264(tdone,ends);
                                int biggest104265 = 0;
                                if(ends[4]>=biggest104265){
                                  biggest104265=ends[4];
                                }
                                if(ends[5]>=biggest104265){
                                  biggest104265=ends[5];
                                }
                                if(biggest104265 == 1){
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                            else {
                              if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 131, column: 45
                                S79083=12;
                                if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 132, column: 22
                                  S79083=13;
                                  if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 135, column: 22
                                    w_thread_3.lid();//sysj\lidLoaderController.sysj line: 137, column: 6
                                    lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 138, column: 6
                                    if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 139, column: 18
                                      lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 139, column: 20
                                    }
                                    t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 140, column: 6
                                    t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 141, column: 6
                                    if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 142, column: 6
                                      twin.setPresent();//sysj\lidLoaderController.sysj line: 143, column: 7
                                      currsigs.addElement(twin);
                                      twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 143, column: 7
                                      System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                                      S79082=2;
                                      S81737=0;
                                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                        S81737=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S81732=0;
                                        if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                          done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                          S81732=1;
                                          if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                            S83250=1;
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
                                      System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                                      S79082=2;
                                      S81737=0;
                                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                        S81737=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S81732=0;
                                        if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                          done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                          S81732=1;
                                          if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                            S83250=1;
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
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  thread104266(tdone,ends);
                                  thread104267(tdone,ends);
                                  int biggest104268 = 0;
                                  if(ends[4]>=biggest104268){
                                    biggest104268=ends[4];
                                  }
                                  if(ends[5]>=biggest104268){
                                    biggest104268=ends[5];
                                  }
                                  if(biggest104268 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
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
                            vacOn.setPresent();//sysj\lidLoaderController.sysj line: 127, column: 7
                            currsigs.addElement(vacOn);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          if(vacOnM.getprestatus()){//sysj\lidLoaderController.sysj line: 125, column: 45
                            S79083=10;
                            if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 126, column: 22
                              S79083=11;
                              if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 131, column: 22
                                S79083=12;
                                if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 132, column: 22
                                  S79083=13;
                                  if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 135, column: 22
                                    w_thread_3.lid();//sysj\lidLoaderController.sysj line: 137, column: 6
                                    lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 138, column: 6
                                    if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 139, column: 18
                                      lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 139, column: 20
                                    }
                                    t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 140, column: 6
                                    t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 141, column: 6
                                    if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 142, column: 6
                                      twin.setPresent();//sysj\lidLoaderController.sysj line: 143, column: 7
                                      currsigs.addElement(twin);
                                      twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 143, column: 7
                                      System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                                      S79082=2;
                                      S81737=0;
                                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                        S81737=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S81732=0;
                                        if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                          done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                          S81732=1;
                                          if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                            S83250=1;
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
                                      System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                                      S79082=2;
                                      S81737=0;
                                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                        S81737=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S81732=0;
                                        if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                          done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                          S81732=1;
                                          if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                            S83250=1;
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
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  thread104269(tdone,ends);
                                  thread104270(tdone,ends);
                                  int biggest104271 = 0;
                                  if(ends[4]>=biggest104271){
                                    biggest104271=ends[4];
                                  }
                                  if(ends[5]>=biggest104271){
                                    biggest104271=ends[5];
                                  }
                                  if(biggest104271 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 131, column: 45
                                  S79083=12;
                                  if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 132, column: 22
                                    S79083=13;
                                    if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 135, column: 22
                                      w_thread_3.lid();//sysj\lidLoaderController.sysj line: 137, column: 6
                                      lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 138, column: 6
                                      if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 139, column: 18
                                        lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 139, column: 20
                                      }
                                      t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 140, column: 6
                                      t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 141, column: 6
                                      if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 142, column: 6
                                        twin.setPresent();//sysj\lidLoaderController.sysj line: 143, column: 7
                                        currsigs.addElement(twin);
                                        twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 143, column: 7
                                        System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                                        S79082=2;
                                        S81737=0;
                                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                          S81737=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S81732=0;
                                          if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                            done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                            S81732=1;
                                            if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                              ends[3]=2;
                                              ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                              S83250=1;
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
                                        System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                                        S79082=2;
                                        S81737=0;
                                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                          S81737=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S81732=0;
                                          if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                            done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                            S81732=1;
                                            if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                              ends[3]=2;
                                              ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                              S83250=1;
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
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    thread104272(tdone,ends);
                                    thread104273(tdone,ends);
                                    int biggest104274 = 0;
                                    if(ends[4]>=biggest104274){
                                      biggest104274=ends[4];
                                    }
                                    if(ends[5]>=biggest104274){
                                      biggest104274=ends[5];
                                    }
                                    if(biggest104274 == 1){
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
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
                              vacOn.setPresent();//sysj\lidLoaderController.sysj line: 127, column: 7
                              currsigs.addElement(vacOn);
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
                        armSource.setPresent();//sysj\lidLoaderController.sysj line: 123, column: 7
                        currsigs.addElement(armSource);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 9 : 
                      if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 125, column: 22
                        S79083=10;
                        if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 126, column: 22
                          S79083=11;
                          if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 131, column: 22
                            S79083=12;
                            if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 132, column: 22
                              S79083=13;
                              if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 135, column: 22
                                w_thread_3.lid();//sysj\lidLoaderController.sysj line: 137, column: 6
                                lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 138, column: 6
                                if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 139, column: 18
                                  lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 139, column: 20
                                }
                                t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 140, column: 6
                                t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 141, column: 6
                                if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 142, column: 6
                                  twin.setPresent();//sysj\lidLoaderController.sysj line: 143, column: 7
                                  currsigs.addElement(twin);
                                  twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 143, column: 7
                                  System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                                  S79082=2;
                                  S81737=0;
                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                    S81737=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S81732=0;
                                    if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                      done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                      S81732=1;
                                      if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                        ends[3]=2;
                                        ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                        S83250=1;
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
                                  System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                                  S79082=2;
                                  S81737=0;
                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                    S81737=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S81732=0;
                                    if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                      done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                      S81732=1;
                                      if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                        ends[3]=2;
                                        ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                        S83250=1;
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
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              thread104275(tdone,ends);
                              thread104276(tdone,ends);
                              int biggest104277 = 0;
                              if(ends[4]>=biggest104277){
                                biggest104277=ends[4];
                              }
                              if(ends[5]>=biggest104277){
                                biggest104277=ends[5];
                              }
                              if(biggest104277 == 1){
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                          else {
                            if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 131, column: 45
                              S79083=12;
                              if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 132, column: 22
                                S79083=13;
                                if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 135, column: 22
                                  w_thread_3.lid();//sysj\lidLoaderController.sysj line: 137, column: 6
                                  lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 138, column: 6
                                  if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 139, column: 18
                                    lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 139, column: 20
                                  }
                                  t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 140, column: 6
                                  t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 141, column: 6
                                  if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 142, column: 6
                                    twin.setPresent();//sysj\lidLoaderController.sysj line: 143, column: 7
                                    currsigs.addElement(twin);
                                    twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 143, column: 7
                                    System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                                    S79082=2;
                                    S81737=0;
                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                      S81737=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S81732=0;
                                      if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                        done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                        S81732=1;
                                        if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                          S83250=1;
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
                                    System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                                    S79082=2;
                                    S81737=0;
                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                      S81737=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S81732=0;
                                      if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                        done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                        S81732=1;
                                        if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                          S83250=1;
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
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                thread104278(tdone,ends);
                                thread104279(tdone,ends);
                                int biggest104280 = 0;
                                if(ends[4]>=biggest104280){
                                  biggest104280=ends[4];
                                }
                                if(ends[5]>=biggest104280){
                                  biggest104280=ends[5];
                                }
                                if(biggest104280 == 1){
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
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
                          vacOn.setPresent();//sysj\lidLoaderController.sysj line: 127, column: 7
                          currsigs.addElement(vacOn);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        if(vacOnM.getprestatus()){//sysj\lidLoaderController.sysj line: 125, column: 45
                          S79083=10;
                          if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 126, column: 22
                            S79083=11;
                            if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 131, column: 22
                              S79083=12;
                              if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 132, column: 22
                                S79083=13;
                                if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 135, column: 22
                                  w_thread_3.lid();//sysj\lidLoaderController.sysj line: 137, column: 6
                                  lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 138, column: 6
                                  if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 139, column: 18
                                    lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 139, column: 20
                                  }
                                  t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 140, column: 6
                                  t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 141, column: 6
                                  if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 142, column: 6
                                    twin.setPresent();//sysj\lidLoaderController.sysj line: 143, column: 7
                                    currsigs.addElement(twin);
                                    twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 143, column: 7
                                    System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                                    S79082=2;
                                    S81737=0;
                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                      S81737=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S81732=0;
                                      if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                        done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                        S81732=1;
                                        if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                          S83250=1;
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
                                    System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                                    S79082=2;
                                    S81737=0;
                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                      S81737=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S81732=0;
                                      if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                        done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                        S81732=1;
                                        if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                          S83250=1;
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
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                thread104281(tdone,ends);
                                thread104282(tdone,ends);
                                int biggest104283 = 0;
                                if(ends[4]>=biggest104283){
                                  biggest104283=ends[4];
                                }
                                if(ends[5]>=biggest104283){
                                  biggest104283=ends[5];
                                }
                                if(biggest104283 == 1){
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                            else {
                              if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 131, column: 45
                                S79083=12;
                                if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 132, column: 22
                                  S79083=13;
                                  if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 135, column: 22
                                    w_thread_3.lid();//sysj\lidLoaderController.sysj line: 137, column: 6
                                    lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 138, column: 6
                                    if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 139, column: 18
                                      lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 139, column: 20
                                    }
                                    t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 140, column: 6
                                    t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 141, column: 6
                                    if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 142, column: 6
                                      twin.setPresent();//sysj\lidLoaderController.sysj line: 143, column: 7
                                      currsigs.addElement(twin);
                                      twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 143, column: 7
                                      System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                                      S79082=2;
                                      S81737=0;
                                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                        S81737=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S81732=0;
                                        if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                          done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                          S81732=1;
                                          if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                            S83250=1;
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
                                      System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                                      S79082=2;
                                      S81737=0;
                                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                        S81737=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S81732=0;
                                        if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                          done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                          S81732=1;
                                          if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                            S83250=1;
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
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  thread104284(tdone,ends);
                                  thread104285(tdone,ends);
                                  int biggest104286 = 0;
                                  if(ends[4]>=biggest104286){
                                    biggest104286=ends[4];
                                  }
                                  if(ends[5]>=biggest104286){
                                    biggest104286=ends[5];
                                  }
                                  if(biggest104286 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
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
                            vacOn.setPresent();//sysj\lidLoaderController.sysj line: 127, column: 7
                            currsigs.addElement(vacOn);
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
                    
                    case 10 : 
                      if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 126, column: 22
                        S79083=11;
                        if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 131, column: 22
                          S79083=12;
                          if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 132, column: 22
                            S79083=13;
                            if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 135, column: 22
                              w_thread_3.lid();//sysj\lidLoaderController.sysj line: 137, column: 6
                              lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 138, column: 6
                              if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 139, column: 18
                                lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 139, column: 20
                              }
                              t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 140, column: 6
                              t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 141, column: 6
                              if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 142, column: 6
                                twin.setPresent();//sysj\lidLoaderController.sysj line: 143, column: 7
                                currsigs.addElement(twin);
                                twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 143, column: 7
                                System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                                S79082=2;
                                S81737=0;
                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                  S81737=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S81732=0;
                                  if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                    done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                    S81732=1;
                                    if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                      ends[3]=2;
                                      ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                      S83250=1;
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
                                System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                                S79082=2;
                                S81737=0;
                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                  S81737=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S81732=0;
                                  if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                    done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                    S81732=1;
                                    if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                      ends[3]=2;
                                      ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                      S83250=1;
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
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            thread104287(tdone,ends);
                            thread104288(tdone,ends);
                            int biggest104289 = 0;
                            if(ends[4]>=biggest104289){
                              biggest104289=ends[4];
                            }
                            if(ends[5]>=biggest104289){
                              biggest104289=ends[5];
                            }
                            if(biggest104289 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 131, column: 45
                            S79083=12;
                            if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 132, column: 22
                              S79083=13;
                              if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 135, column: 22
                                w_thread_3.lid();//sysj\lidLoaderController.sysj line: 137, column: 6
                                lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 138, column: 6
                                if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 139, column: 18
                                  lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 139, column: 20
                                }
                                t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 140, column: 6
                                t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 141, column: 6
                                if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 142, column: 6
                                  twin.setPresent();//sysj\lidLoaderController.sysj line: 143, column: 7
                                  currsigs.addElement(twin);
                                  twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 143, column: 7
                                  System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                                  S79082=2;
                                  S81737=0;
                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                    S81737=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S81732=0;
                                    if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                      done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                      S81732=1;
                                      if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                        ends[3]=2;
                                        ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                        S83250=1;
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
                                  System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                                  S79082=2;
                                  S81737=0;
                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                    S81737=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S81732=0;
                                    if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                      done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                      S81732=1;
                                      if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                        ends[3]=2;
                                        ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                        S83250=1;
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
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              thread104290(tdone,ends);
                              thread104291(tdone,ends);
                              int biggest104292 = 0;
                              if(ends[4]>=biggest104292){
                                biggest104292=ends[4];
                              }
                              if(ends[5]>=biggest104292){
                                biggest104292=ends[5];
                              }
                              if(biggest104292 == 1){
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
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
                        vacOn.setPresent();//sysj\lidLoaderController.sysj line: 127, column: 7
                        currsigs.addElement(vacOn);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 11 : 
                      if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 131, column: 22
                        S79083=12;
                        if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 132, column: 22
                          S79083=13;
                          if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 135, column: 22
                            w_thread_3.lid();//sysj\lidLoaderController.sysj line: 137, column: 6
                            lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 138, column: 6
                            if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 139, column: 18
                              lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 139, column: 20
                            }
                            t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 140, column: 6
                            t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 141, column: 6
                            if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 142, column: 6
                              twin.setPresent();//sysj\lidLoaderController.sysj line: 143, column: 7
                              currsigs.addElement(twin);
                              twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 143, column: 7
                              System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                              S79082=2;
                              S81737=0;
                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                S81737=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S81732=0;
                                if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                  done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                  S81732=1;
                                  if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                    ends[3]=2;
                                    ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                    S83250=1;
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
                              System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                              S79082=2;
                              S81737=0;
                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                S81737=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S81732=0;
                                if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                  done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                  S81732=1;
                                  if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                    ends[3]=2;
                                    ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                    S83250=1;
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
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          thread104293(tdone,ends);
                          thread104294(tdone,ends);
                          int biggest104295 = 0;
                          if(ends[4]>=biggest104295){
                            biggest104295=ends[4];
                          }
                          if(ends[5]>=biggest104295){
                            biggest104295=ends[5];
                          }
                          if(biggest104295 == 1){
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 131, column: 45
                          S79083=12;
                          if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 132, column: 22
                            S79083=13;
                            if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 135, column: 22
                              w_thread_3.lid();//sysj\lidLoaderController.sysj line: 137, column: 6
                              lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 138, column: 6
                              if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 139, column: 18
                                lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 139, column: 20
                              }
                              t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 140, column: 6
                              t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 141, column: 6
                              if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 142, column: 6
                                twin.setPresent();//sysj\lidLoaderController.sysj line: 143, column: 7
                                currsigs.addElement(twin);
                                twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 143, column: 7
                                System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                                S79082=2;
                                S81737=0;
                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                  S81737=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S81732=0;
                                  if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                    done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                    S81732=1;
                                    if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                      ends[3]=2;
                                      ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                      S83250=1;
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
                                System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                                S79082=2;
                                S81737=0;
                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                  S81737=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S81732=0;
                                  if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                    done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                    S81732=1;
                                    if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                      ends[3]=2;
                                      ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                      S83250=1;
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
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            thread104296(tdone,ends);
                            thread104297(tdone,ends);
                            int biggest104298 = 0;
                            if(ends[4]>=biggest104298){
                              biggest104298=ends[4];
                            }
                            if(ends[5]>=biggest104298){
                              biggest104298=ends[5];
                            }
                            if(biggest104298 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      break;
                    
                    case 12 : 
                      if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 132, column: 22
                        S79083=13;
                        if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 135, column: 22
                          w_thread_3.lid();//sysj\lidLoaderController.sysj line: 137, column: 6
                          lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 138, column: 6
                          if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 139, column: 18
                            lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 139, column: 20
                          }
                          t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 140, column: 6
                          t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 141, column: 6
                          if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 142, column: 6
                            twin.setPresent();//sysj\lidLoaderController.sysj line: 143, column: 7
                            currsigs.addElement(twin);
                            twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 143, column: 7
                            System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                            S79082=2;
                            S81737=0;
                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                              S81737=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S81732=0;
                              if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                S81732=1;
                                if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                  ends[3]=2;
                                  ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                  S83250=1;
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
                            System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                            S79082=2;
                            S81737=0;
                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                              S81737=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S81732=0;
                              if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                S81732=1;
                                if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                  ends[3]=2;
                                  ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                  S83250=1;
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
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        thread104299(tdone,ends);
                        thread104300(tdone,ends);
                        int biggest104301 = 0;
                        if(ends[4]>=biggest104301){
                          biggest104301=ends[4];
                        }
                        if(ends[5]>=biggest104301){
                          biggest104301=ends[5];
                        }
                        if(biggest104301 == 1){
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        //FINXME code
                        if(biggest104301 == 0){
                          S79083=13;
                          if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 135, column: 22
                            w_thread_3.lid();//sysj\lidLoaderController.sysj line: 137, column: 6
                            lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 138, column: 6
                            if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 139, column: 18
                              lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 139, column: 20
                            }
                            t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 140, column: 6
                            t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 141, column: 6
                            if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 142, column: 6
                              twin.setPresent();//sysj\lidLoaderController.sysj line: 143, column: 7
                              currsigs.addElement(twin);
                              twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 143, column: 7
                              System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                              S79082=2;
                              S81737=0;
                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                S81737=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S81732=0;
                                if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                  done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                  S81732=1;
                                  if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                    ends[3]=2;
                                    ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                    S83250=1;
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
                              System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                              S79082=2;
                              S81737=0;
                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                S81737=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S81732=0;
                                if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                  done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                                  S81732=1;
                                  if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                    ends[3]=2;
                                    ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                    S83250=1;
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
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      break;
                    
                    case 13 : 
                      if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 135, column: 22
                        w_thread_3.lid();//sysj\lidLoaderController.sysj line: 137, column: 6
                        lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 138, column: 6
                        if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 139, column: 18
                          lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 139, column: 20
                        }
                        t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 140, column: 6
                        t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 141, column: 6
                        if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 142, column: 6
                          twin.setPresent();//sysj\lidLoaderController.sysj line: 143, column: 7
                          currsigs.addElement(twin);
                          twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 143, column: 7
                          System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                          S79082=2;
                          S81737=0;
                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                            S81737=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S81732=0;
                            if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                              done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                              S81732=1;
                              if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                ends[3]=2;
                                ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                S83250=1;
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
                          System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 145, column: 6
                          S79082=2;
                          S81737=0;
                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                            S81737=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S81732=0;
                            if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                              done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                              S81732=1;
                              if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                ends[3]=2;
                                ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                S83250=1;
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
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                  }
                  break;
                
                case 2 : 
                  switch(S81737){
                    case 0 : 
                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                        S81737=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S81732){
                          case 0 : 
                            if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                              done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                              S81732=1;
                              if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                                ends[3]=2;
                                ;//sysj\lidLoaderController.sysj line: 149, column: 5
                                S83250=1;
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
                            if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                              ends[3]=2;
                              ;//sysj\lidLoaderController.sysj line: 149, column: 5
                              S83250=1;
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
                      S81737=1;
                      S81737=0;
                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                        S81737=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S81732=0;
                        if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                          done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                          S81732=1;
                          if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                            ends[3]=2;
                            ;//sysj\lidLoaderController.sysj line: 149, column: 5
                            S83250=1;
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
                
                case 3 : 
                  S83250=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                  break;
                
                case 4 : 
                  S83250=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                  break;
                
              }
            }
            break;
          
          case 1 : 
            S83250=1;
            S83250=0;
            if(reset.getprestatus()){//sysj\lidLoaderController.sysj line: 58, column: 20
              start_in.setPreempted();
              done_o.setPreempted();
              S83250=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S79082=0;
              S79066=0;
              if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 59, column: 5
                start_in.setACK(false);//sysj\lidLoaderController.sysj line: 59, column: 5
                S79066=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S79061=0;
                if(!start_in.isREQ()){//sysj\lidLoaderController.sysj line: 59, column: 5
                  start_in.setACK(true);//sysj\lidLoaderController.sysj line: 59, column: 5
                  S79061=1;
                  if(start_in.isREQ()){//sysj\lidLoaderController.sysj line: 59, column: 5
                    start_in.setACK(false);//sysj\lidLoaderController.sysj line: 59, column: 5
                    ends[3]=2;
                    ;//sysj\lidLoaderController.sysj line: 59, column: 5
                    w_thread_3 = (WorkpieceTwin)(start_in.getVal() == null ? null : ((WorkpieceTwin)start_in.getVal()));//sysj\lidLoaderController.sysj line: 60, column: 5
                    lidded_thread_3 = false;//sysj\lidLoaderController.sysj line: 67, column: 5
                    if(w_thread_3 != null) {//sysj\lidLoaderController.sysj line: 68, column: 18
                      if(w_thread_3.catchFault("lid-fitted")) {//sysj\lidLoaderController.sysj line: 69, column: 36
                        w_thread_3.lid();//sysj\lidLoaderController.sysj line: 70, column: 7
                        w_thread_3.reject(Machine.LID_LOADER, "lid already fitted");//sysj\lidLoaderController.sysj line: 71, column: 7
                      }
                      lidded_thread_3 = w_thread_3.isLidded();//sysj\lidLoaderController.sysj line: 73, column: 6
                    }
                    S79082=1;
                    if(lidded_thread_3){//sysj\lidLoaderController.sysj line: 76, column: 5
                      System.out.println("[LID] " + w_thread_3 + " already has a lid fitted.");//sysj\lidLoaderController.sysj line: 77, column: 6
                      S79082=2;
                      S81737=0;
                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                        S81737=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S81732=0;
                        if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                          done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                          S81732=1;
                          if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                            ends[3]=2;
                            ;//sysj\lidLoaderController.sysj line: 149, column: 5
                            S83250=1;
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
                      if(w_thread_3 != null){//sysj\lidLoaderController.sysj line: 79, column: 13
                        t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 80, column: 21
                        t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 81, column: 21
                        if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "place", "placing lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 82, column: 21
                          twin.setPresent();//sysj\lidLoaderController.sysj line: 83, column: 25
                          currsigs.addElement(twin);
                          twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 83, column: 25
                          S79083=0;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S79083=0;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        S79082=2;
                        S81737=0;
                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                          S81737=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S81732=0;
                          if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                            done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                            S81732=1;
                            if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                              ends[3]=2;
                              ;//sysj\lidLoaderController.sysj line: 149, column: 5
                              S83250=1;
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
            break;
          
        }
        break;
      
    }
  }

  public void thread104213(int [] tdone, int [] ends){
        switch(S79058){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(mode.getprestatus()){//sysj\lidLoaderController.sysj line: 41, column: 12
          if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\lidLoaderController.sysj line: 44, column: 8
            auto_1.setPresent();//sysj\lidLoaderController.sysj line: 44, column: 30
            currsigs.addElement(auto_1);
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 1){//sysj\lidLoaderController.sysj line: 45, column: 13
              manual_1.setPresent();//sysj\lidLoaderController.sysj line: 45, column: 35
              currsigs.addElement(manual_1);
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
          active[2]=1;
          ends[2]=1;
          tdone[2]=1;
        }
        break;
      
    }
  }

  public void thread104211(int [] tdone, int [] ends){
        S104206=1;
    t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 52, column: 3
    lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 53, column: 3
    w_thread_3 = null;//sysj\lidLoaderController.sysj line: 54, column: 3
    lidded_thread_3 = false;//sysj\lidLoaderController.sysj line: 55, column: 3
    S83250=0;
    if(reset.getprestatus()){//sysj\lidLoaderController.sysj line: 58, column: 20
      start_in.setPreempted();
      done_o.setPreempted();
      S83250=1;
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
    else {
      S79082=0;
      S79066=0;
      if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 59, column: 5
        start_in.setACK(false);//sysj\lidLoaderController.sysj line: 59, column: 5
        S79066=1;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        S79061=0;
        if(!start_in.isREQ()){//sysj\lidLoaderController.sysj line: 59, column: 5
          start_in.setACK(true);//sysj\lidLoaderController.sysj line: 59, column: 5
          S79061=1;
          if(start_in.isREQ()){//sysj\lidLoaderController.sysj line: 59, column: 5
            start_in.setACK(false);//sysj\lidLoaderController.sysj line: 59, column: 5
            ends[3]=2;
            ;//sysj\lidLoaderController.sysj line: 59, column: 5
            w_thread_3 = (WorkpieceTwin)(start_in.getVal() == null ? null : ((WorkpieceTwin)start_in.getVal()));//sysj\lidLoaderController.sysj line: 60, column: 5
            lidded_thread_3 = false;//sysj\lidLoaderController.sysj line: 67, column: 5
            if(w_thread_3 != null) {//sysj\lidLoaderController.sysj line: 68, column: 18
              if(w_thread_3.catchFault("lid-fitted")) {//sysj\lidLoaderController.sysj line: 69, column: 36
                w_thread_3.lid();//sysj\lidLoaderController.sysj line: 70, column: 7
                w_thread_3.reject(Machine.LID_LOADER, "lid already fitted");//sysj\lidLoaderController.sysj line: 71, column: 7
              }
              lidded_thread_3 = w_thread_3.isLidded();//sysj\lidLoaderController.sysj line: 73, column: 6
            }
            S79082=1;
            if(lidded_thread_3){//sysj\lidLoaderController.sysj line: 76, column: 5
              System.out.println("[LID] " + w_thread_3 + " already has a lid fitted.");//sysj\lidLoaderController.sysj line: 77, column: 6
              S79082=2;
              S81737=0;
              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                S81737=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S81732=0;
                if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                  done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                  S81732=1;
                  if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                    ends[3]=2;
                    ;//sysj\lidLoaderController.sysj line: 149, column: 5
                    S83250=1;
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
              if(w_thread_3 != null){//sysj\lidLoaderController.sysj line: 79, column: 13
                t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 80, column: 21
                t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 81, column: 21
                if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "place", "placing lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 82, column: 21
                  twin.setPresent();//sysj\lidLoaderController.sysj line: 83, column: 25
                  currsigs.addElement(twin);
                  twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 83, column: 25
                  S79083=0;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S79083=0;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
              }
              else {
                S79082=2;
                S81737=0;
                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 149, column: 5
                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                  S81737=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S81732=0;
                  if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                    done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 149, column: 5
                    S81732=1;
                    if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 149, column: 5
                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 149, column: 5
                      ends[3]=2;
                      ;//sysj\lidLoaderController.sysj line: 149, column: 5
                      S83250=1;
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

  public void thread104210(int [] tdone, int [] ends){
        S79058=1;
    if(mode.getprestatus()){//sysj\lidLoaderController.sysj line: 41, column: 12
      if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\lidLoaderController.sysj line: 44, column: 8
        auto_1.setPresent();//sysj\lidLoaderController.sysj line: 44, column: 30
        currsigs.addElement(auto_1);
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
      }
      else {
        if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 1){//sysj\lidLoaderController.sysj line: 45, column: 13
          manual_1.setPresent();//sysj\lidLoaderController.sysj line: 45, column: 35
          currsigs.addElement(manual_1);
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
      switch(S104208){
        case 0 : 
          S104208=0;
          break RUN;
        
        case 1 : 
          S104208=2;
          S104208=2;
          auto_1.setClear();//sysj\lidLoaderController.sysj line: 37, column: 2
          manual_1.setClear();//sysj\lidLoaderController.sysj line: 37, column: 2
          thread104210(tdone,ends);
          thread104211(tdone,ends);
          int biggest104212 = 0;
          if(ends[2]>=biggest104212){
            biggest104212=ends[2];
          }
          if(ends[3]>=biggest104212){
            biggest104212=ends[3];
          }
          if(biggest104212 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          auto_1.setClear();//sysj\lidLoaderController.sysj line: 37, column: 2
          manual_1.setClear();//sysj\lidLoaderController.sysj line: 37, column: 2
          thread104213(tdone,ends);
          thread104214(tdone,ends);
          int biggest104302 = 0;
          if(ends[2]>=biggest104302){
            biggest104302=ends[2];
          }
          if(ends[3]>=biggest104302){
            biggest104302=ends[3];
          }
          if(biggest104302 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest104302 == 0){
            S104208=0;
            active[1]=0;
            ends[1]=0;
            S104208=0;
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
          start_in.gethook();
          done_o.gethook();
          mode.gethook();
          reset.gethook();
          pusherExtended.gethook();
          pusherRetracted.gethook();
          lidAtPickup.gethook();
          WPgripped.gethook();
          armAtSource.gethook();
          armAtDest.gethook();
          magazineEmpty.gethook();
          refilled.gethook();
          pusherExtendM.gethook();
          vacOnM.gethook();
          armSourceM.gethook();
          armDestM.gethook();
          refillM.gethook();
          df = true;
        }
        runClockDomain();
      }
      mode.setpreclear();
      reset.setpreclear();
      pusherExtended.setpreclear();
      pusherRetracted.setpreclear();
      lidAtPickup.setpreclear();
      WPgripped.setpreclear();
      armAtSource.setpreclear();
      armAtDest.setpreclear();
      magazineEmpty.setpreclear();
      refilled.setpreclear();
      pusherExtendM.setpreclear();
      vacOnM.setpreclear();
      armSourceM.setpreclear();
      armDestM.setpreclear();
      refillM.setpreclear();
      twin.setpreclear();
      pusherExtend.setpreclear();
      vacOn.setpreclear();
      armSource.setpreclear();
      armDest.setpreclear();
      refill.setpreclear();
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
      dummyint = reset.getStatus() ? reset.setprepresent() : reset.setpreclear();
      reset.setpreval(reset.getValue());
      reset.setClear();
      dummyint = pusherExtended.getStatus() ? pusherExtended.setprepresent() : pusherExtended.setpreclear();
      pusherExtended.setpreval(pusherExtended.getValue());
      pusherExtended.setClear();
      dummyint = pusherRetracted.getStatus() ? pusherRetracted.setprepresent() : pusherRetracted.setpreclear();
      pusherRetracted.setpreval(pusherRetracted.getValue());
      pusherRetracted.setClear();
      dummyint = lidAtPickup.getStatus() ? lidAtPickup.setprepresent() : lidAtPickup.setpreclear();
      lidAtPickup.setpreval(lidAtPickup.getValue());
      lidAtPickup.setClear();
      dummyint = WPgripped.getStatus() ? WPgripped.setprepresent() : WPgripped.setpreclear();
      WPgripped.setpreval(WPgripped.getValue());
      WPgripped.setClear();
      dummyint = armAtSource.getStatus() ? armAtSource.setprepresent() : armAtSource.setpreclear();
      armAtSource.setpreval(armAtSource.getValue());
      armAtSource.setClear();
      dummyint = armAtDest.getStatus() ? armAtDest.setprepresent() : armAtDest.setpreclear();
      armAtDest.setpreval(armAtDest.getValue());
      armAtDest.setClear();
      dummyint = magazineEmpty.getStatus() ? magazineEmpty.setprepresent() : magazineEmpty.setpreclear();
      magazineEmpty.setpreval(magazineEmpty.getValue());
      magazineEmpty.setClear();
      dummyint = refilled.getStatus() ? refilled.setprepresent() : refilled.setpreclear();
      refilled.setpreval(refilled.getValue());
      refilled.setClear();
      dummyint = pusherExtendM.getStatus() ? pusherExtendM.setprepresent() : pusherExtendM.setpreclear();
      pusherExtendM.setpreval(pusherExtendM.getValue());
      pusherExtendM.setClear();
      dummyint = vacOnM.getStatus() ? vacOnM.setprepresent() : vacOnM.setpreclear();
      vacOnM.setpreval(vacOnM.getValue());
      vacOnM.setClear();
      dummyint = armSourceM.getStatus() ? armSourceM.setprepresent() : armSourceM.setpreclear();
      armSourceM.setpreval(armSourceM.getValue());
      armSourceM.setClear();
      dummyint = armDestM.getStatus() ? armDestM.setprepresent() : armDestM.setpreclear();
      armDestM.setpreval(armDestM.getValue());
      armDestM.setClear();
      dummyint = refillM.getStatus() ? refillM.setprepresent() : refillM.setpreclear();
      refillM.setpreval(refillM.getValue());
      refillM.setClear();
      twin.sethook();
      twin.setClear();
      pusherExtend.sethook();
      pusherExtend.setClear();
      vacOn.sethook();
      vacOn.setClear();
      armSource.sethook();
      armSource.setClear();
      armDest.sethook();
      armDest.setClear();
      refill.sethook();
      refill.setClear();
      auto_1.setClear();
      manual_1.setClear();
      start_in.sethook();
      done_o.sethook();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        start_in.gethook();
        done_o.gethook();
        mode.gethook();
        reset.gethook();
        pusherExtended.gethook();
        pusherRetracted.gethook();
        lidAtPickup.gethook();
        WPgripped.gethook();
        armAtSource.gethook();
        armAtDest.gethook();
        magazineEmpty.gethook();
        refilled.gethook();
        pusherExtendM.gethook();
        vacOnM.gethook();
        armSourceM.gethook();
        armDestM.gethook();
        refillM.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
