import java.util.*;
import java.util.function.BooleanSupplier;
import javax.swing.*;

/** Consecutive multi-batch orders with a live Swing event loop and TCP controls. */
public final class GuiRepeatOrderTest {
    static GuiClient client;
    static AbsWindow window;
    static boolean capWorking, capIdleAfterWorking;
    static void sampleMachine() {
        if(client.latest()==null) return;
        String status=client.latest().stations.get("LID_LOADER");
        if("WORKING".equals(status)) capWorking=true;
        if(capWorking&&"IDLE".equals(status)) capIdleAfterWorking=true;
    }
    static void await(String name, BooleanSupplier ready, int seconds) throws Exception {
        long end=System.currentTimeMillis()+seconds*1000L;
        while(System.currentTimeMillis()<end) { sampleMachine(); if(ready.getAsBoolean()) return; Thread.sleep(50); }
        GuiSnapshot s=client.latest();
        if(s==null) throw new AssertionError("TIMEOUT "+name+": no telemetry");
        System.err.println("TIMEOUT "+name+" state="+s.state+" connected="+client.connected()+" tick="+s.tick);
        for(GuiSnapshot.Bottle b:s.bottles) if(!b.stage.equals("DONE")&&!b.stage.equals("RECOVERED"))
            System.err.println(b.serial+" "+b.stage+" "+b.location+" slot="+b.position);
        for(Map.Entry<Thread,StackTraceElement[]> e:Thread.getAllStackTraces().entrySet()) {
            System.err.println(e.getKey()); for(StackTraceElement f:e.getValue()) System.err.println("  "+f);
        }
        throw new AssertionError(name);
    }
    static void command(String action) throws Exception {
        GuiCommand c=new GuiCommand(action);
        SwingUtilities.invokeAndWait(()->{ if(!client.send(c)) throw new AssertionError("Disconnected "+action); });
        await("ack "+action,()->c.id.equals(client.latest().commandId),15);
        System.out.println("[REPEAT] "+action+" "+client.latest().commandMessage);
    }
    static Object field(Object target,String name) throws Exception {
        java.lang.reflect.Field f=A1_GUI.class.getDeclaredField(name); f.setAccessible(true); return f.get(target);
    }
    static void selectionCheck() throws Exception {
        SwingUtilities.invokeAndWait(()->{
            try {
                window.refreshView();
                JPanel factory=(JPanel)field(window,"factoryPanel");
                factory.setSize(1100,820);
                java.awt.image.BufferedImage image=new java.awt.image.BufferedImage(1100,820,java.awt.image.BufferedImage.TYPE_INT_RGB);
                java.awt.Graphics2D g=image.createGraphics(); factory.paint(g); g.dispose();
                java.lang.reflect.Field hits=factory.getClass().getDeclaredField("paintedBottles"); hits.setAccessible(true);
                Map<Long,java.awt.Rectangle> painted=(Map<Long,java.awt.Rectangle>)hits.get(factory);
                Map.Entry<Long,java.awt.Rectangle> hit=null;
                for(Map.Entry<Long,java.awt.Rectangle> e:painted.entrySet()) hit=e;
                if(hit==null) throw new AssertionError("No painted bottles");
                int x=(int)hit.getValue().getCenterX(), y=(int)hit.getValue().getCenterY();
                java.awt.event.MouseEvent click=new java.awt.event.MouseEvent(factory,java.awt.event.MouseEvent.MOUSE_PRESSED,System.currentTimeMillis(),0,x,y,1,false);
                for(java.awt.event.MouseListener listener:factory.getMouseListeners()) listener.mousePressed(click);
                if(((Long)field(window,"selectedId")).longValue()!=hit.getKey()) throw new AssertionError("Painted bottle was not selected");
                JPopupMenu popup=(JPopupMenu)field(window,"labelPopup");
                JPanel label=(JPanel)popup.getComponent(0); label.setSize(560,180);
                java.awt.image.BufferedImage preview=new java.awt.image.BufferedImage(560,180,java.awt.image.BufferedImage.TYPE_INT_RGB);
                g=preview.createGraphics(); label.paint(g); g.dispose();
                javax.imageio.ImageIO.write(preview,"png",new java.io.File("bin/label-fix.png"));
                click=new java.awt.event.MouseEvent(factory,java.awt.event.MouseEvent.MOUSE_PRESSED,System.currentTimeMillis(),0,10,10,1,false);
                for(java.awt.event.MouseListener listener:factory.getMouseListeners()) listener.mousePressed(click);
                if(((Long)field(window,"selectedId")).longValue()!=-1||popup.isVisible()) throw new AssertionError("Empty-space click retained a bottle label");
            } catch(Exception e) { throw new RuntimeException(e); }
        });
    }
    public static void main(String[] args) {
        try {
            System.setProperty("gui.enabled","true"); System.setProperty("gui.headless","true"); System.setProperty("pos.headless","true");
            System.setProperty("gui.portOffset","30000");
            String xml=new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get("sysj/abs.xml")),java.nio.charset.StandardCharsets.UTF_8);
            java.util.regex.Matcher ports=java.util.regex.Pattern.compile("Port=\"(\\d+)\"").matcher(xml);
            StringBuffer isolated=new StringBuffer();
            while(ports.find()) ports.appendReplacement(isolated,"Port=\""+(Integer.parseInt(ports.group(1))+30000)+"\"");
            ports.appendTail(isolated);
            java.nio.file.Files.write(java.nio.file.Paths.get("bin/repeat-abs.xml"),isolated.toString().getBytes(java.nio.charset.StandardCharsets.UTF_8));
            client=new GuiClient();
            GuiClient.daemon("test plant",()->com.systemj.SystemJRunner.main(new String[]{"bin/repeat-abs.xml"}));
            await("connection",()->client.connected(),25);
            SwingUtilities.invokeAndWait(()->window=new AbsWindow(client));
            for(int round=1;round<=3;round++) {
                List<PosOrderRequest.ProductBatch> batches=new ArrayList<>();
                for(int i=0;i<3;i++) batches.add(new PosOrderRequest.ProductBatch("Order "+round+" blend "+i,250,45,55,10));
                PosOrderRequest order=new PosOrderRequest(PosOrderRequest.newOrderId(),"Repeat Customer",batches);
                PosBridge.submit(order);
                await("order accepted",()->order.orderId.equals(client.latest().orderId),20);
                int beforeStart=client.latest().bottles.size();
                Thread.sleep(750);
                if(client.latest().bottles.size()!=beforeStart) throw new AssertionError("New order started before Start");
                command("START");
                if(round==2) {
                    await("second order underway",()->client.latest().batches.get(0).inProcess>0,25);
                    command("PAUSE");
                    await("pause",()->client.latest().state.equals("PAUSED"),90);
                    Thread.sleep(1500);
                    selectionCheck();
                    command("START");
                }
                await("order completed",()->PosBridge.latest()!=null&&PosBridge.latest().isComplete(),180);
                System.out.println("[REPEAT] Order "+round+" completed");
                Thread.sleep(1500);
            }
            PosOrderRequest resetOrder=new PosOrderRequest(PosOrderRequest.newOrderId(),"Reset Customer",
                Collections.singletonList(new PosOrderRequest.ProductBatch("Reset batch",250,50,50,10)));
            PosBridge.submit(resetOrder);
            await("reset order accepted",()->resetOrder.orderId.equals(client.latest().orderId),20);
            command("START");
            await("reset order underway",()->resetOrder.orderId.equals(client.latest().orderId)&&client.latest().batches.get(0).inProcess>=2,30);
            command("PAUSE");
            command("RESET");
            await("drain/reset",()->client.latest().batches.isEmpty(),60);
            await("POS reset acknowledgement",()->PosBridge.latest()!=null&&PosBridge.latest().isTerminal(),10);
            PosOrderRequest afterReset=new PosOrderRequest(PosOrderRequest.newOrderId(),"Reset Customer",
                Collections.singletonList(new PosOrderRequest.ProductBatch("After reset",250,50,50,1)));
            PosBridge.submit(afterReset);
            await("order after reset",()->afterReset.orderId.equals(client.latest().orderId),20);
            command("START");
            await("completion after reset",()->PosBridge.latest()!=null&&PosBridge.latest().isComplete(),60);
            if(!capWorking||!capIdleAfterWorking) throw new AssertionError("Cap loader did not report WORKING then IDLE");
            SwingUtilities.invokeAndWait(()->window.dispose());
            System.out.println("REPEATED ORDER TEST PASSED"); System.exit(0);
        } catch(Throwable e) { e.printStackTrace(); System.exit(1); }
    }
}
