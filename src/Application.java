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

        //Setup the game
        int numPlayers = 2;
        Game game = new Game(numPlayers);
        game.setupGame();

        //Create players and add to game
        String[] playerNames = new String[numPlayers];
        Player[] players = new Player[numPlayers];
        String playerName;
        Player player;
        Move move;
        Boolean firstMove = true;
        Boolean validPlay = true;
        Boolean gameOver = false;
        int tilePoolSize;
        int tileTraySize;
        TilePool tilePool = game.getTilePool();

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


        //Play the game
        while (gameOver == false){

            for (int i = 0; i < players.length; i ++){

                while (validPlay == true){
                    player = players[i];
                    ArrayList<LetterTile> playedTiles = new ArrayList<LetterTile>();

                    move = new Move(player, playedTiles, game.getBoard());
                    move.placeTiles(player.getPlayerTray());

                    if (firstMove && game.getBoard().getPlacedTiles(7,7) == null){
                        move.removeTilesFromBoard();
                        firstMove = false;
                        validPlay = false;
                    } else if (firstMove){
                        move.checkInLine();
                        move.findWords();
                        player.setPlayerScore(move.calculate());
                        move.removeAndReplaceTiles(player.getPlayerTray(), game.getTilePool());
                        firstMove = false;
                    }
                    if (!firstMove){
                        move.checkTileIsland();
                        move.checkWordIsland();
                        move.checkInLine();
                        move.findWords();
                        player.setPlayerScore(move.calculate());
                        move.removeAndReplaceTiles(player.getPlayerTray(), game.getTilePool());

                        tilePoolSize = tilePool.tilePool.size();
                        tileTraySize = player.getPlayerTray().tileTray.size();
                        if (tilePoolSize < 1 && tileTraySize < 1){
                            gameOver = true;
                        }

                    }
                }
            }
        }

    }
    //Pass the points to the player
}



