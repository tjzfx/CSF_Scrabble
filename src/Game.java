import java.security.Timestamp;

/**
 * Created by rachelmann on 2/23/14.
 */
import java.util.Date;

public class Game {
    public int numberPlayers;
    public Date startTime;
    public Date endTime;
    public int winner;


    public Game(int numberPlayers){
        this.numberPlayers = numberPlayers;
        this.startTime = new java.util.Date();
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void setWinner(int winner) {
        this.winner = winner;
    }



}
