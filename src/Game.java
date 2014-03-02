import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Timestamp;

/**
 * Created by rachelmann on 2/23/14.
 */
import java.sql.Connection;
import java.util.Date;
import java.util.HashSet;

public class Game {
    private int numberPlayers;
    private Date startTime;
    private Date endTime;
    private int winner;
    private Board board;
    private HashSet<String> scrabbleDictionary;
    private TilePool tilePool;


    public Game(int numberPlayers){
        this.numberPlayers = numberPlayers;
        this.startTime = new java.util.Date();
    }

    public void setupGame() throws IOException {

        //Users sign up
        //One user creates a game and becomes player one
        //Additional users join and become players

        //TODO: RM Updated
        Connection db = null;
        String url = "jdbc:postgresql://mycsf-scrabble.c7mrgwzg9grn.us-west-2.rds.amazonaws.com:5432/dbCSF_Scrabble";
        String username = "userTRS";
        String password = "12345678";
        Path dictionaryPath = Paths.get("/Users/rachelmann/CSF/FinalProject/words");

        GameDatabase gameDB =  new GameDatabase(url, username, password);
        db = gameDB.connectToDb();

        //Create a new board which tracks the values of each square
        board = new Board();

        //Create a new dictionary
        Dictionary dictionary = new Dictionary();
        dictionary.setSCRABBLE_DICTIONARY(dictionaryPath);
        scrabbleDictionary = dictionary.SCRABBLE_DICTIONARY;

        //Create a tile pool //TODO: Check with Shirley to make sure this is how it works
        File letterfreqs = new File("letterFrequencies.txt");
        tilePool = new TilePool(letterfreqs);

    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void setWinner(int winner) {
        this.winner = winner;
    }


    public Board getBoard() {
        return board;
    }

    public HashSet<String> getScrabbleDictionary() {
        return scrabbleDictionary;
    }

    public TilePool getTilePool() {
        return tilePool;
    }

    public int getNumberPlayers() {
        return numberPlayers;
    }

}
