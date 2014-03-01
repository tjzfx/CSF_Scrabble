import javax.management.remote.rmi._RMIConnection_Stub;
import javax.swing.*;
import javax.xml.transform.Result;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.sql.*;

/**
 * Created by rachelmann on 2/14/14.
 */
public class Application {

        public static void main(String[] args) throws IOException {

            setupGame();

            //Player 1 submits a word
            //Check to make sure word covers middle square
            //Call the move class (pass player and array of inputs)
            // if we ever come to an invalid boolean, return false and end player turn and remove tiles from board; place back in their tray
            // place the new tiles onto the board according to row, col
            // as we place, set the bonus value of that tile to the corresponding one on board_values
            // remove them from the tile tray
            //move class checks the tile tray to make sure letter placement is valid
            // check islands; then check inLine; then check direction
            //Detects what words were formed
            // if the word is vertical, iterate row - 1 until null, then back down row + 1 until null;
            // as it iterates down, create a string
            // ditto / vice versa for horizontal
            // then, for each new tile that was placed, check the tiles to the right and the left (for vertical original word) of it
            // check the tiles to the above and below (for horizontal original word) of it
            // if there are tiles to the right/left, detect word again; if not, move to next placed tile
            //
            //Validates each word (dictionary)
            //Calculates the points of each word
            //Places the words on the board (using setter)
            // reset the bonus_value of all letterTiles back to null
            //Remove tiles from tile tray
            //Pass the points to the player
            //Replenish the user's tile tray
            //Confirm that the move is good
            //Go to the next player


//        String word = "wordx";
//        word = word.toUpperCase();
//        dictionary.checkWord(dictionary, word);

//        User user = new User("rachelkm2", "rachelkm2@gmail.com");
//        user.userExists(user, db);
//        user.saveUser(user, db);
//        user.printAllUsers(db);
        }

    public static void setupGame() throws IOException {

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
        Board board = new Board();

        //Create a new dictionary
        Dictionary dictionary = new Dictionary();
        HashSet<String> scrabbleDictionary;
        dictionary.setSCRABBLE_DICTIONARY(dictionaryPath);
        scrabbleDictionary = dictionary.SCRABBLE_DICTIONARY;

        //Create and save new users (somewhere)
        User user1 = new User("RachelKM2", "rachelkm2@gmail.com");
        User user2 = new User("ShirleyB", "shirleylberry@gmail.com");
        user1.saveUser(user1, db);
        user2.saveUser(user2, db);

        //Add # players (somewhere)
        int numPlayers = 2;

        //create a new game
        Game game = new Game(numPlayers);

        //Create players and add to game
        Player player1 = new Player(game, user1, 1);
        Player player2 = new Player(game, user2, 2);

        //Create a tile pool //TODO: Check with Shirley to make sure this is how it works
        File letterfreqs = new File("letterFrequencies.txt");
        TilePool tilePool = new TilePool(letterfreqs);

        //Give each player 7 tiles
        TileTray tileTray1 = new TileTray(tilePool);
        player1.setPlayerTray(tileTray1);

        TileTray tileTray2 = new TileTray(tilePool);
        player2.setPlayerTray(tileTray2);


    }

    }


