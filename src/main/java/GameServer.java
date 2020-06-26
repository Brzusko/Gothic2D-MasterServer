import com.google.gson.Gson;
import com.google.gson.annotations.Expose;

import java.util.Vector;

public class GameServer {

    private String IP;
    private int PORT;
    private String serverName;
    private int maxPlayers;
    private int playerCount;
    private String currentMap;
    private ServerCounter serverCounter;
    @Expose(serialize = false)
    private Player[] players;

    public GameServer(String ip, int port, String serverName, int maxPlayers, String currentMap){
        IP = ip;
        PORT = port;
        this.serverName = serverName;
        this.maxPlayers = maxPlayers;
        this.currentMap = currentMap;
        playerCount = 0;
        serverCounter = new ServerCounter(5);
        initializePlayerList();
    }

    public GameServer(GameServer copy){
        IP = copy.getIP();
        PORT = copy.getPORT();
        serverName = copy.getServerName();
        serverCounter = new ServerCounter(5);
        maxPlayers = copy.getMaxPlayers();
        playerCount = copy.getPlayerCount();
        players = copy.getPlayers();
        currentMap = copy.getCurrentMap();
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        String json = gson.toJson(new SerializeInfo(IP, PORT, serverName, maxPlayers, currentMap, playerCount));
        return json;
    }

    public String getDetailedInfo() {
        Gson gson = new Gson();
        if(players == null)
            System.out.println("Null player list");
        String json = gson.toJson(new SerializeDetailedInfo(IP, PORT, serverName, maxPlayers, currentMap, playerCount, players));
        return json;
    }

    public static GameServer UpdateInfoJSON(String json){
        Gson gson = new Gson();
        GameServer server = gson.fromJson(json, GameServer.class);
        System.out.println(server.toString());
        return server;
    }

    public String GetInfoForCheck(){
        String port = Integer.toString(PORT);
        return IP + ":" + port;
    }

    private class SerializeInfo{
        private String IP;
        private int PORT;
        private String serverName;
        private int maxPlayers;
        private int playerCount;
        private String currentMap;

        public SerializeInfo(String ip, int port, String serverName, int maxPlayers, String currentMap, int playerCount){
            IP = ip;
            PORT = port;
            this.serverName = serverName;
            this.maxPlayers = maxPlayers;
            this.currentMap = currentMap;
            this.playerCount = playerCount;
        }
    }

    private class SerializeDetailedInfo extends SerializeInfo{
        private Vector<Player> players;
        public SerializeDetailedInfo(String ip, int port, String serverName, int maxPlayers, String currentMap, int playerCount, Player[] players){
            super(ip, port, serverName, maxPlayers, currentMap, playerCount);

            System.out.println(players.length);
            for(int i = 0 ; i<maxPlayers; i++)
            {
                if(players[i].getScore() != -1)
                    this.players.add(players[i]);
            }
        }
    }

    public int Tick(){
        return serverCounter.Tick();
    }

    public void GenerateCounter(){
        this.serverCounter = new ServerCounter(5);
    }

    public void initializePlayerList(){
        players = new Player[maxPlayers];
        for(int i = 0 ; i < maxPlayers; i++)
            players[i] = new Player();
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public int getPORT() {
        return PORT;
    }

    public String getCurrentMap() {
        return currentMap;
    }

    public String getIP() {
        return IP;
    }

    public String getServerName() {
        return serverName;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        int counter = 0;
        for(int i = 0; i < players.length; i++, counter++)
        {
            this.players[i] = players[i];
        }

        for(int i = counter; i < this.players.length; i++){
            this.players[i] = new Player();
        }
        playerCount = counter;
    }
}
