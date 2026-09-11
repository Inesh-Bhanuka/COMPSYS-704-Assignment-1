import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.*;
import java.util.List;
import java.util.function.BooleanSupplier;
import javax.imageio.ImageIO;
import javax.swing.*;

/** Exercises the report scenarios through TCP, GUIInterfaceCD, and SystemControllerCD. */
public final class GuiIntegrationTest {
    private static GuiClient client;
    private static AbsWindow window;
    private static void check(boolean value,String message){if(!value)throw new AssertionError(message);}
    private static void await(String label,BooleanSupplier condition,int seconds)throws Exception{
        long end=System.currentTimeMillis()+seconds*1000L;
        while(System.currentTimeMillis()<end){if(condition.getAsBoolean())return;Thread.sleep(80);}
        throw new AssertionError("Timed out: "+label+"; state="+(client.latest()==null?"no feedback":client.latest().state));
    }
    private static void command(GuiCommand command)throws Exception{
        check(client.send(command),"Command not accepted by TCP client: "+command.action);
        await("ack "+command.action,()->client.latest()!=null&&command.id.equals(client.latest().commandId),12);
        System.out.println("[GUI TEST] "+command.action+": "+client.latest().commandMessage);
    }
    private static Component find(Container parent,String name){
        for(Component c:parent.getComponents()){
            if(name.equals(c.getName()))return c;
            if(c instanceof Container){Component found=find((Container)c,name);if(found!=null)return found;}
        }return null;
    }
    private static JTable bottles(Container parent){
        for(Component c:parent.getComponents()){
            if(c instanceof JTable){JTable t=(JTable)c;if(t.getColumnCount()>0&&t.getColumnName(0).equals("Serial"))return t;}
            if(c instanceof Container){JTable t=bottles((Container)c);if(t!=null)return t;}
        }return null;
    }
    private static void render(String name)throws Exception{
        SwingUtilities.invokeAndWait(()->{
            window.refreshView();window.addNotify();window.setBounds(0,0,1600,1020);window.validate();
            Container content=window.getContentPane();
            BufferedImage image=new BufferedImage(content.getWidth(),content.getHeight(),BufferedImage.TYPE_INT_RGB);
            Graphics2D g=image.createGraphics();content.printAll(g);g.dispose();
            try{ImageIO.write(image,"png",new File("bin/"+name));}catch(Exception e){throw new RuntimeException(e);}
        });
    }
    private static PosOrderRequest order(String product,int quantity){return new PosOrderRequest(PosOrderRequest.newOrderId(),"GUI Validation Customer",Collections.singletonList(new PosOrderRequest.ProductBatch(product,250,45,55,quantity)));}
    public static void main(String[] args){
        try{
            System.setProperty("gui.enabled","true");System.setProperty("gui.headless","true");System.setProperty("pos.headless","true");
            client=new GuiClient();
            Thread plant=new Thread(()->com.systemj.SystemJRunner.main(new String[]{"sysj/abs.xml"}));plant.setDaemon(true);plant.start();
            await("live TCP feedback",()->client.connected(),20);
            SwingUtilities.invokeAndWait(()->window=new AbsWindow(client));
            PosOrderRequest first=order("Custom Blend A",6);PosBridge.submit(first);
            await("POS batch visible",()->!client.latest().batches.isEmpty(),15);
            check(client.latest().bottles.isEmpty(),"Production started without operator Start");
            command(new GuiCommand("QUALITY",Collections.<String>emptyList(),3));
            command(new GuiCommand("START"));
            await("bottles in plant",()->client.latest().bottles.size()>=2,20);
            SwingUtilities.invokeAndWait(()->{JTable t=bottles(window);if(t!=null&&t.getRowCount()>0)t.setRowSelectionInterval(0,0);});
            render("abs-overview.png");
            command(new GuiCommand("PAUSE"));
            await("safe paused line",()->client.latest().state.equals("PAUSED"),120);
            for(GuiSnapshot.Bottle b:client.latest().bottles)check(b.stage.equals("DONE")||b.stage.equals("RECOVERED"),"Pause left a bottle in process");
            command(new GuiCommand("START"));
            await("full automatic batch with reject replacement",()->PosBridge.latest()!=null&&PosBridge.latest().isComplete(),180);
            await("GUI completion snapshot",()->client.latest().batches.get(0).accepted==6,12);
            check(client.latest().batches.get(0).recycled>=1,"Quality simulation never recycled a bottle");
            check(!client.latest().sensors.isEmpty(),"No sensor feedback");
            check(!client.events().isEmpty()&&!client.latest().history.isEmpty(),"Missing events/history");
            command(new GuiCommand("MANUAL"));
            await("manual ready",()->client.latest().state.equals("MANUAL"),30);
            Thread.sleep(250);
            long before=client.sentCount();
            SwingUtilities.invokeAndWait(()->{
                ((JCheckBox)find(window,"operation-LOAD")).doClick();
                ((JCheckBox)find(window,"operation-INDEX")).doClick();
                ((JButton)find(window,"Clear Ticks")).doClick();
            });
            check(client.sentCount()==before,"Checkbox or Clear Ticks sent equipment commands");
            command(new GuiCommand("QUALITY",Collections.<String>emptyList(),0));
            PosOrderRequest second=order("Manual Blend",1);PosBridge.submit(second);
            await("second POS batch",()->client.latest().orderId.equals(second.orderId),15);
            int count=client.latest().bottles.size();Thread.sleep(250);
            check(client.latest().bottles.size()==count,"Manual bottle loaded without Enable Selected");
            SwingUtilities.invokeAndWait(()->{
                for(String op:GuiSupervisor.OPERATIONS)((JCheckBox)find(window,"operation-"+op)).setSelected(true);
                ((JButton)find(window,"Enable Selected")).doClick();
            });
            await("manual load",()->client.latest().bottles.size()>count,25);
            SwingUtilities.invokeAndWait(()->{window.refreshView();JTable t=bottles(window);if(t!=null&&t.getRowCount()>0)t.setRowSelectionInterval(t.getRowCount()-1,t.getRowCount()-1);});
            render("abs-manual.png");
            long deadline=System.currentTimeMillis()+120000;
            while((PosBridge.latest()==null||!PosBridge.latest().isComplete())&&System.currentTimeMillis()<deadline){
                command(new GuiCommand("ENABLE",Arrays.asList(GuiSupervisor.OPERATIONS),0));Thread.sleep(400);
            }
            check(PosBridge.latest()!=null&&PosBridge.latest().isComplete(),"Manual sequence did not complete");
            command(new GuiCommand("FAULT"));
            await("fault indicator",()->client.latest().state.equals("FAULT")&&!client.latest().alerts.isEmpty(),10);
            render("abs-alert.png");
            command(new GuiCommand("CLEAR_FAULT"));
            await("fault cleared",()->!client.latest().state.equals("FAULT")&&client.latest().alerts.isEmpty(),20);
            command(new GuiCommand("RESET"));
            await("reset",()->client.latest().state.equals("PAUSED")&&client.latest().batches.isEmpty(),30);
            render("abs-history.png");
            // Freezing the model must invalidate cached publisher data and disable controls.
            GuiClient.daemon("Test stop model",()->com.systemj.SystemJRunner.getProgram().shutDownNow());
            await("stale feedback disabled",()->!client.connected(),12);
            check(!client.send(new GuiCommand("START")),"Disconnected GUI accepted a control command");
            SwingUtilities.invokeAndWait(()->window.dispose());
            System.out.println("GUI INTEGRATION TEST PASSED: automatic, quality/recycling, drain pause, manual gating, fault, reset, telemetry and stale connection.");
            System.exit(0);
        }catch(Throwable error){error.printStackTrace();System.exit(1);}
    }
}
