import java.util.*;
import javax.swing.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;

/** Reproduces the customer's 10 + 20 bottle order with repeated forced rejects. */
public final class GuiQualityRecoveryTest {
    private static GuiClient client;
    private static void check(boolean value,String message) { if(!value) throw new AssertionError(message); }
    private static void command(GuiCommand c) throws Exception {
        check(client.send(c),"Cannot send "+c.action);
        GuiRepeatOrderTest.await("ack "+c.action,()->c.id.equals(client.latest().commandId),15);
        System.out.println("[QUALITY TEST] "+c.action+": "+client.latest().commandMessage);
    }
    private static PosOrderRequest order(int... quantities) {
        List<PosOrderRequest.ProductBatch> batches=new ArrayList<>();
        for(int q:quantities) batches.add(new PosOrderRequest.ProductBatch("Custom Product",250,50,50,q));
        return new PosOrderRequest(PosOrderRequest.newOrderId(),"Registered Customer",batches);
    }
    private static void submitAndWaitForStart(PosOrderRequest order) throws Exception {
        int before=client.latest().bottles.size();
        PosBridge.submit(order);
        GuiRepeatOrderTest.await("accepted "+order.orderId,()->order.orderId.equals(client.latest().orderId),20);
        Thread.sleep(1000);
        check(client.latest().bottles.size()==before,"Order admitted bottles before Start");
        check(client.latest().state.equals("PAUSED"),"New order did not wait for operator Start");
    }
    public static void main(String[] args) {
        try {
            System.setProperty("gui.enabled","true"); System.setProperty("gui.headless","true");
            System.setProperty("pos.headless","true"); System.setProperty("gui.portOffset","30000");
            String xml=new String(Files.readAllBytes(Paths.get("sysj/abs.xml")),StandardCharsets.UTF_8);
            java.util.regex.Matcher ports=java.util.regex.Pattern.compile("Port=\"(\\d+)\"").matcher(xml);
            StringBuffer isolated=new StringBuffer();
            while(ports.find()) ports.appendReplacement(isolated,"Port=\""+(Integer.parseInt(ports.group(1))+30000)+"\"");
            ports.appendTail(isolated);
            Files.write(Paths.get("bin/quality-abs.xml"),isolated.toString().getBytes(StandardCharsets.UTF_8));
            client=new GuiClient(); GuiRepeatOrderTest.client=client;
            GuiClient.daemon("quality test plant",()->com.systemj.SystemJRunner.main(new String[]{"bin/quality-abs.xml"}));
            GuiRepeatOrderTest.await("connection",()->client.connected(),25);
            SwingUtilities.invokeAndWait(()->GuiRepeatOrderTest.window=new AbsWindow(client));
            for(int frequency:new int[]{3,5}) {
                submitAndWaitForStart(order(10,20));
                command(new GuiCommand("QUALITY",Collections.emptyList(),frequency));
                command(new GuiCommand("START"));
                GuiRepeatOrderTest.await("first rejected bottle",()->client.latest().batches.get(0).recycled>0,90);
                command(new GuiCommand("PAUSE"));
                Thread.sleep(500);
                check(client.connected()&&client.latest().state.equals("PAUSED"),"Pause stopped responding during quality recycling");
                command(new GuiCommand("START"));
                GuiRepeatOrderTest.await("complete 10+20 with every "+frequency+" failing",
                    ()->PosBridge.latest()!=null&&PosBridge.latest().isComplete(),180);
                GuiRepeatOrderTest.await("final batch telemetry",()->client.latest().batches.get(1).accepted==20,15);
                int recovered=0;
                for(GuiSnapshot.BatchView b:client.latest().batches) {
                    check(b.accepted==b.target&&b.inProcess==0,"Incomplete batch after POS completion"); recovered+=b.recycled;
                }
                check(recovered==30/frequency,"Forced failures/replacements miscounted: "+recovered);
                check(client.latest().alerts.stream().noneMatch(e->"QUALITY".equals(e.severity)),"Recovered bottle still has an active quality alert");
                System.out.println("[QUALITY TEST] Every "+frequency+": 30 accepted, "+recovered+" recovered");
            }
            for(String receptacle:new String[]{"Lid waste bin","Bottle collector","Waste tank"})
                check(client.events().stream().anyMatch(e->e.message.contains(receptacle+" emptied")),"No servicing event for "+receptacle);
            submitAndWaitForStart(order(20));
            command(new GuiCommand("QUALITY",Collections.emptyList(),3));
            command(new GuiCommand("START"));
            GuiRepeatOrderTest.await("rejects before reset",()->client.latest().batches.get(0).recycled>=1&&client.latest().batches.get(0).inProcess>0,90);
            command(new GuiCommand("RESET"));
            GuiRepeatOrderTest.await("reset drains rejects",()->client.latest().batches.isEmpty(),90);
            GuiRepeatOrderTest.await("POS reset acknowledgement",()->PosBridge.latest()!=null&&PosBridge.latest().isTerminal(),15);
            submitAndWaitForStart(order(1));
            command(new GuiCommand("QUALITY",Collections.emptyList(),0));
            command(new GuiCommand("START"));
            GuiRepeatOrderTest.await("order after reset",()->PosBridge.latest()!=null&&PosBridge.latest().isComplete(),60);
            SwingUtilities.invokeAndWait(()->GuiRepeatOrderTest.window.dispose());
            System.out.println("QUALITY RECOVERY TEST PASSED: every-3/every-5, finite bin/tank servicing, start per order, pause/resume, reset with rejects, next order.");
            System.exit(0);
        } catch(Throwable e) { e.printStackTrace(); System.exit(1); }
    }
}
