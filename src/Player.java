/**
 * Created by rachelmann on 2/23/14.
 */
public class Player {

    public int playerScore;
    public int playerNumber;
    public TileTray playerTray;

    public Player(Game game, User user, int playerNumber){
        this.playerNumber = playerNumber;
        this.playerScore = 0;
    }

    // getters and setters
    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int points, int playerScore) {
        this.playerScore = playerScore + points;
    }

    public TileTray getPlayerTray() {
        return playerTray;
    }

    public void setPlayerTray(TileTray playerTray) {
        this.playerTray = playerTray;
    }


}
