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
import java.util.ArrayList;
import java.util.HashSet;
import java.sql.*;

public class Application {


        public static void main(String[] args) throws IOException {

            Boolean gameOver = false;

            //Setup the game
            int numPlayers = 2;
            Game game = new Game(numPlayers);
            game.setupGame();

            //Create players and add to game
            String[] playerNames = new String[numPlayers];
            Player[] players = new Player[numPlayers];
            String playerName;
            Player player;

            for (int i = 0; i < numPlayers; i++){
                //Add each player to the game
                playerName = playerNames[i];
                player = new Player(game, playerName, i);
                //Give each player a tile tray
                TileTray tileTray = new TileTray(game.getTilePool());
                player.setPlayerTray(tileTray);
                //Loop through each tile in the tile tray and remove the tile from the tilePool
                for (int j = 0; j < tileTray.getTileTray().size(); j++){
                    game.getTilePool().removeTile(tileTray.getTileTray().get(j));
                }
            }

            Move move;

            //Play the game
            while (gameOver == false){
                for (int i = 0; i < players.length; i ++){
                    player = players[i];
                    //TODO: WHERE DOES THIS GET SET?
                    ArrayList<LetterTile> playedTiles = new ArrayList<LetterTile>();
                    move = new Move(player, playedTiles, game.getBoard());
                    move.placeTiles(player.getPlayerTray());
                    move.removeAndReplaceTiles(player.getPlayerTray(), game.getTilePool());
                    move.checkTileIsland();
                    move.checkWordIsland();
                    move.checkInLine();
                    move.findWords();
                    move.calculate();
                    //Check at end of each move if game is over?
                }


            }


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


    }


