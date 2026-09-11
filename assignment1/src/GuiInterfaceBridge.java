import com.systemj.netapi.*;
import java.util.concurrent.*;
import javax.swing.SwingUtilities;

/** Dedicated interface-CD adapter: socket waits never run on a clock-domain tick. */
public final class GuiInterfaceBridge {
    private static boolean started;
    private static volatile GuiSnapshot latest;
    private static volatile GuiCommand pending;
    private static final BlockingQueue<GuiCommand> commands=new ArrayBlockingQueue<GuiCommand>(64);
    private static String receivedId="";
    public static synchronized void open() {
        if(started || !Boolean.getBoolean("gui.enabled")) return;
        started=true;
        TCPReceiver receiver=new TCPReceiver("127.0.0.1",GuiClient.COMMAND_PORT);
        receiver.setConsumer((present,value)-> {
            if(present && value instanceof GuiCommand) {
                GuiCommand c=(GuiCommand)value;
                synchronized(commands) { if(!c.id.equals(receivedId) && commands.offer(c)) receivedId=c.id; }
            }
        });
        // TCPReceiver starts listening in its constructor.
        GuiClient.daemon("GUI interface publisher",()-> {
            while(true) {
                try(TCPSender status=new TCPSender("127.0.0.1",GuiClient.STATUS_PORT);
                    TCPSender events=new TCPSender("127.0.0.1",GuiClient.EVENTS_PORT)) {
                    while(true) {
                        GuiSnapshot s=latest;
                        if(s!=null) { status.emit(s,1); events.emit(s.events,1); }
                        Thread.sleep(100);
                    }
                } catch(Exception e) { try { Thread.sleep(300); } catch(InterruptedException stop) { return; } }
            }
        });
        if(!Boolean.getBoolean("gui.headless")) SwingUtilities.invokeLater(()->new AbsWindow(new GuiClient()).setVisible(true));
    }
    public static GuiCommand command() {
        if(pending!=null && latest!=null && pending.id.equals(latest.commandId)) pending=null;
        if(pending==null) pending=commands.poll();
        return pending;
    }
    public static void publish(GuiSnapshot snapshot) { if(snapshot!=null) latest=snapshot; }
}
