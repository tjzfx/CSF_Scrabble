/**
 * Created by rachelmann on 2/23/14.
 */
public class Player {


    private int playerScore;
    private int playerNumber;
    private String playerName;
    private TileTray playerTray;

    public Player(Game game, String playerName, int playerNumber){
        this.playerNumber = playerNumber;
        this.playerName = playerName;
        this.playerScore = 0;
    }

    // getters and setters
    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int points) {
        this.playerScore = playerScore + points;
    }

    public TileTray getPlayerTray() {
        return playerTray;
    }

    public void setPlayerTray(TileTray playerTray) {
        this.playerTray = playerTray;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public String getPlayerName() {
        return playerName;
    }


}
