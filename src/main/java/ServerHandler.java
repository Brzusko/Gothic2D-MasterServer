import java.util.Vector;

public class ServerHandler implements Runnable{

    private Thread thread;
    private int serverTick;
    private boolean canRun = true;

    public ServerHandler(int serverTick) {
        this.serverTick = serverTick;
    }
    @Override
    public void run() {
            Vector<String> serversToDelete = new Vector<>();
            while(canRun){
                try {
                    Thread.sleep(serverTick);
                    synchronized (Main.servers){
                        if(Main.servers.isEmpty())
                            continue;
                        Main.servers.forEach((k,v) -> {
                            if(v.Tick() <= 0)
                                serversToDelete.add(v.GetInfoForCheck());
                        });
                        serversToDelete.forEach(value ->{
                            Main.servers.remove(value);
                            System.out.println("Server deleted from list with ip:port " + value);
                        });
                        serversToDelete.clear();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }
}
