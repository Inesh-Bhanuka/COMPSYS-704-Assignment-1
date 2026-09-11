import com.systemj.netapi.*;
import java.util.*;
import java.util.concurrent.*;

/** Nonblocking GUI-side TCP client. Commands remain queued until their controller acknowledgement. */
public final class GuiClient {
    public static final int STATUS_PORT=21000, EVENTS_PORT=21001, COMMAND_PORT=21002;
    private volatile GuiSnapshot latest;
    private volatile long lastReceived;
    private final BlockingQueue<GuiCommand> commands=new ArrayBlockingQueue<GuiCommand>(32);
    private final NavigableMap<Long,GuiSnapshot.Event> events=new TreeMap<Long,GuiSnapshot.Event>();
    private long sentCount;
    public GuiClient() {
        TCPReceiver status=new TCPReceiver("127.0.0.1",STATUS_PORT);
        status.setConsumer((present,value)-> {
            if(present && value instanceof GuiSnapshot) {
                GuiSnapshot s=(GuiSnapshot)value;
                if(latest==null || s.capturedAt>=latest.capturedAt) { latest=s; lastReceived=System.currentTimeMillis(); addEvents(s.events); }
            }
        });
        // TCPReceiver starts its own server thread in its constructor.
        TCPReceiver log=new TCPReceiver("127.0.0.1",EVENTS_PORT);
        log.setConsumer((present,value)-> {
            if(present && value instanceof List<?>) for(Object e:(List<?>)value) if(e instanceof GuiSnapshot.Event) addEvent((GuiSnapshot.Event)e);
        });

        daemon("GUI commands",()-> {
            GuiCommand pending=null;
            while(true) {
                try(TCPSender sender=new TCPSender("127.0.0.1",COMMAND_PORT)) {
                    while(true) {
                        if(pending==null) pending=commands.take();
                        GuiSnapshot s=latest;
                        if(s!=null && pending.id.equals(s.commandId)) { pending=null; continue; }
                        sender.emit(pending,1); Thread.sleep(120);
                    }
                } catch(Exception e) { try { Thread.sleep(300); } catch(InterruptedException stop) { return; } }
            }
        });
    }
    private synchronized void addEvent(GuiSnapshot.Event event) { events.put(event.sequence,event); while(events.size()>5000) events.pollFirstEntry(); }
    private void addEvents(List<GuiSnapshot.Event> incoming) { for(GuiSnapshot.Event e:incoming) addEvent(e); }
    public synchronized List<GuiSnapshot.Event> events() { return new ArrayList<GuiSnapshot.Event>(events.values()); }
    public boolean connected() { return latest!=null && System.currentTimeMillis()-lastReceived<2000 && System.currentTimeMillis()-latest.capturedAt<2000; }
    public GuiSnapshot latest() { return latest; }
    public synchronized long sentCount() { return sentCount; }
    public synchronized boolean send(GuiCommand command) {
        if(!connected() || !commands.offer(command)) return false;
        sentCount++; return true;
    }
    public static void daemon(String name,Runnable task) { Thread t=new Thread(task,name); t.setDaemon(true); t.start(); }
}
