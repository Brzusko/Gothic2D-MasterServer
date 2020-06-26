import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Vector;

import com.google.gson.Gson;
import io.javalin.Javalin;

public class Main {
    public static Javalin app = Javalin.create(javalinConfig -> {
        javalinConfig.enableCorsForAllOrigins();
    }).start(7171);

    public static final Hashtable<String, GameServer> servers = new Hashtable<String, GameServer>();

    public static GameServer testServer =  new GameServer("127.0.0.1", 7070, "Kolona Gornicza", 20, "Valley");

    public static void main(String[] args) {
        Thread serverHandler = new Thread(new ServerHandler(1000));
        serverHandler.start();

        app.get("/", ctx -> {
           ctx.result(testServer.getDetailedInfo());
        });

        app.get("/getservers", ctx -> {
            final Vector<GameServer> returnValue = new Vector<>();
            Gson gson = new Gson();
           if(servers.isEmpty())
           {
               ctx.result("{}");
               return;
           } else {
               servers.forEach((key, value) ->{
                    returnValue.add(value);
               });
               ctx.result(gson.toJson(returnValue));

           }
        });

        app.post("/createserver", ctx -> {
            Gson gson = new Gson();
            GameServer server = null;

            try {
                server = gson.fromJson(ctx.body(), GameServer.class);
            } catch(Exception ex) {
                ctx.result("Something goes wrong with parsing json");
            } finally {

                if(server != null)
                {
                    synchronized (Main.servers){
                        GameServer test =  servers.get(server.GetInfoForCheck());
                        if(test == null)
                        {
                            server = new GameServer(server);
                            servers.put(server.GetInfoForCheck(), server);
                            ctx.result("Successfully added server to dictionary");
                        }
                        else {
                            ctx.result("Server with that port and IP already exist");
                        }
                    }
                }
            }
        });

        app.post("/detailedinfo", ctx ->{
           synchronized (servers) {
               String body = ctx.body();
               Gson gson = new Gson();
               GameServer server = gson.fromJson(body, GameServer.class);
               if(Main.servers.get(server.GetInfoForCheck()) != null)
               {
                   Player[] playersCopy = server.getPlayers();
                   server.initializePlayerList();
                   server.setPlayers(playersCopy);
                   server.GenerateCounter();
                   Main.servers.put(server.GetInfoForCheck(), server);
               }
           }
        });
    }
}
