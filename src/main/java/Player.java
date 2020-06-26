public class Player {
    private String playerName;
    private String playerClass;
    private int score;

    public Player(String playerName, String playerClass, int score){
        this.playerName = playerName;
        this.playerClass = playerClass;
        this.score = score;
    }

    public Player(){
        playerName = "Empty slot";
        playerClass = "None";
        score = -1;
    }

    public int getScore(){
        return score;
    }

    @Override
    public String toString() {
        return "Player name: " + playerName;
    }
}
