/**
 * Created by rachelmann on 2/23/14.
 */
public class Player {

    public int playerScore;
    public int playerNumber;

    public Player(Game game, User user, int playerNumber){
        this.playerNumber = playerNumber;
        this.playerScore = 0;
    }

    public void updateScore(User user, int points){
        playerScore = playerScore + points;
    }



}
