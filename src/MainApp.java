import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Scanner;
import java.util.ArrayList;

public class MainApp {
    public static void main(String[] args) throws IOException {
        Dictionary dictionary = new Dictionary();
        HashSet<String> scrabbleDictionary;
        Path dictionaryPath = Paths.get("/Users/ShirleyB/finalProject/ScrabbleTest/words");
        dictionary.setSCRABBLE_DICTIONARY(dictionaryPath);
        scrabbleDictionary = dictionary.SCRABBLE_DICTIONARY;
        int numPlayers = 2;

        //create a new game
        Game game = new Game(numPlayers);

        //Create players and add to game
        Player player1 = new Player(game, 1);
        Player player2 = new Player(game, 2);

        //Create a tile pool //TODO: Check with Shirley to make sure this is how it works
        File letterfreqs = new File("letterFrequencies.txt");
        TilePool tilePool = new TilePool(letterfreqs);

        //Give each player 7 tiles
        TileTray tileTray1 = new TileTray(tilePool);
        player1.setPlayerTray(tileTray1);

        TileTray tileTray2 = new TileTray(tilePool);
        player2.setPlayerTray(tileTray2);

        Board board = new Board();
        System.out.println(board.toString());
        // testing printers
        Scanner scanner = new Scanner(System.in);
        for(int x = 0; x < tilePool.tilePool.size(); x++){
            LetterTile letterTile = tilePool.tilePool.get(x);
            System.out.println(letterTile.toString());
        }
        TileTray player1tray = new TileTray(tilePool);
        System.out.println("Let's start a new game.  Here is your tile tray:");
        System.out.println(player1tray.displayTileTray());
        for(int x = 0; x < tilePool.tilePool.size(); x++){
            LetterTile letterTile = tilePool.tilePool.get(x);
            System.out.println(letterTile.toString());
        }

        ArrayList<LetterTile> playedTiles = new ArrayList<LetterTile>();
        for(int x = 0; x < 4; x++){
            System.out.println("What tile to play?");
            String playLetter = scanner.next();
            playedTiles.add(player1tray.playTile(playLetter));
        }

        Move move = new Move(player1, playedTiles);
        for(int i = 0; i < playedTiles.size(); i++){
            board.setPlacedTiles(i, i, playedTiles.get(i));
        }
        System.out.print(board.toString());
    }
}


//Users sign up
//One user creates a game and becomes player one
//Additional users join and become players
//Each player get 7 tiles
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