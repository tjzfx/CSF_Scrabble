import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Scanner;
import java.util.ArrayList;

// TODO: Make it so that playedTiles adds more than just the last tile to the board.

public class MainApp {
    public static void main(String[] args) throws IOException {
        int numPlayers = 2;
        Game game = new Game(numPlayers);
        game.setupGame();
//
//      //Create players and add to game
        ArrayList<String> playerNames = new ArrayList<String>();
        ArrayList<Player> players = new ArrayList<Player>();
        String playerName;
        Player player;

        //Create a tile pool //TODO: Check with Shirley to make sure this is how it works
        File letterfreqs = new File("letterFrequencies.txt");
        TilePool tilePool = new TilePool(letterfreqs);

        Boolean firstMove = true;
        Boolean validPlay = true;
        //Boolean ValidFirstMove = false;
        Boolean gameOver = false;
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < numPlayers; i++){
            //Add each player to the game
            System.out.println("What's your name?");
            playerName = scanner.next();
            //playerNames.add(playerName);
            player = new Player(game, playerName, i);
            players.add(player);
            //Give each player a tile tray
            TileTray tileTray = new TileTray(game.getTilePool());
            player.setPlayerTray(tileTray);
            //Loop through each tile in the tile tray and remove the tile from the tilePool
            for (int j = 0; j < tileTray.getTileTray().size(); j++){
                game.getTilePool().removeTile(tileTray.getTileTray().get(j));
            }
        }

        // setting up dictionary
        Dictionary dictionary = new Dictionary();
        HashSet<String> scrabbleDictionary;
        Path dictionaryPath = Paths.get("/Users/ShirleyB/finalProject/ScrabbleTest/words");
        dictionary.setSCRABBLE_DICTIONARY(dictionaryPath);
        scrabbleDictionary = dictionary.SCRABBLE_DICTIONARY;

        Board board = game.getBoard();
        //System.out.println(board.toString());
        // testing printers

        // print out the tile pool
//        for(int x = 0; x < tilePool.tilePool.size(); x++){
//            LetterTile letterTile = tilePool.tilePool.get(x);
//            System.out.println(letterTile.toString());
//        }

        while (gameOver==false){
            for (int i = 0; i < numPlayers; i++){
                player = players.get(i);
                TileTray tileTray = player.getPlayerTray();

                ArrayList<LetterTile> playedTiles = new ArrayList<LetterTile>();
                    //for(int x = 0; x < 1; x++){
                    while(validPlay == true){
                        if(firstMove == true){
                            System.out.println("Let's start a new game.  Here is your tile tray:");
                            System.out.println(tileTray.displayTileTray());
                            System.out.println("Okay, " + player.getPlayerName() + ",what tile to play first?");
                            String playLetter = scanner.next();
                            LetterTile firstTile = tileTray.getTileFromLetter(playLetter, tileTray.tileTray);
                            if(firstTile != null){
                                boolean endPlacements = false;
                                System.out.println("Playing tile " +  firstTile);
                                System.out.println("What row?");
                                int row = scanner.nextInt();
                                firstTile.setTileRow(row);
                                System.out.println("What column?");
                                int col = scanner.nextInt();
                                firstTile.setTileCol(col);
                                playedTiles.add(firstTile);
                                tileTray.removeTile(firstTile);
                                System.out.println("What direction, right (r) or down (d)?");
                                String direct = scanner.next();
                                do {
                                    System.out.println("What tile would you like to play next?  Type end when you're finished placing tiles.");
                                    String nextLetter = scanner.next();
                                    System.out.println(nextLetter);
                                    if (nextLetter.equals("end")){
                                        break;
                                    }
                                    else if (direct.equals("r")){
                                        System.out.println("Okay, placing horizontally");
                                        LetterTile nextTile = tileTray.getTileFromLetter(nextLetter, tileTray.tileTray);
                                        System.out.println("Playing tile " +  nextTile + " previous tile was" + firstTile);
                                        nextTile.setTileRow(firstTile.getTileRow());
                                        nextTile.setTileCol(firstTile.getTileCol() + 1);
                                        playedTiles.add(nextTile);
                                        //tileTray.removeTile(nextTile);
                                        firstTile = nextTile;
                                    }
                                    else if (direct.equals("d")){
                                        System.out.println("Okay, placing vertically");
                                        LetterTile nextTile = tileTray.getTileFromLetter(nextLetter, tileTray.tileTray);
                                        System.out.println("Playing tile " +  nextTile.toString());
                                        nextTile.setTileRow(firstTile.getTileRow() + 1);
                                        nextTile.setTileCol(firstTile.getTileCol());
                                        playedTiles.add(nextTile);
                                        //tileTray.removeTile(nextTile);
                                        firstTile = nextTile;
                                    }
                                }
                                while (!endPlacements);
                            }
                            else {
                                System.out.println("Sorry, you don't have that tile.");
                                break;
                            }
//                            if(board.getPlacedTiles(7, 7).equals(null)){
//                                System.out.println("Sorry, your first tile has to hit the middle square.");
//                                validPlay = false;
//                                break;
//                            }
                            firstMove = false;
                            break;
                        }
                        else{
                            System.out.println();
                            System.out.println("Your turn, " + player.getPlayerName() + ", here are your tiles.");
                            System.out.println(tileTray.displayTileTray());
                            System.out.println("Okay, " + player.getPlayerName() + ",what tile would you like to start your word with?");
                            String playLetter = scanner.next();
                            LetterTile firstTile = tileTray.getTileFromLetter(playLetter, tileTray.tileTray);
                            if(firstTile != null){
                                boolean endPlacements = false;
                                System.out.println("Playing tile " +  firstTile);
                                System.out.println("What row?");
                                int row = scanner.nextInt();
                                firstTile.setTileRow(row);
                                System.out.println("What column?");
                                int col = scanner.nextInt();
                                firstTile.setTileCol(col);
                                playedTiles.add(firstTile);
                                System.out.println("What direction, right (r) or down (d)?");
                                String direct = scanner.next();
                                do {
                                    System.out.println("What tile would you like to play next?  Type end when you're finished placing tiles.");
                                    String nextLetter = scanner.next();
                                    System.out.println(nextLetter);
                                    if (nextLetter.equals("end")){
                                        endPlacements = true;
                                        break;
                                    }
                                    else if (direct.equals("r")){
                                        System.out.println("Okay, placing horizontally");
                                        LetterTile nextTile = tileTray.getTileFromLetter(nextLetter, tileTray.tileTray);
                                        System.out.println("Playing tile " +  nextTile + " previous tile was" + firstTile);
                                        if(board.getPlacedTiles(firstTile.getTileRow(), firstTile.getTileCol() + 1) != null){
                                            nextTile.setTileRow(firstTile.getTileRow());
                                            nextTile.setTileCol(firstTile.getTileCol() + 2);
                                        }
                                        else{
                                            nextTile.setTileRow(firstTile.getTileRow());
                                            nextTile.setTileCol(firstTile.getTileCol() + 1);
                                        }
                                        playedTiles.add(nextTile);
                                        firstTile = nextTile;
                                    }
                                    else if (direct.equals("d")){
                                        System.out.println("Okay, placing vertically");
                                        LetterTile nextTile = tileTray.getTileFromLetter(nextLetter, tileTray.tileTray);
                                        System.out.println("Playing tile " +  nextTile.toString());
                                        if(board.getPlacedTiles(firstTile.getTileRow() + 1, firstTile.getTileCol()) != null){
                                            nextTile.setTileRow(firstTile.getTileRow() + 2);
                                            nextTile.setTileCol(firstTile.getTileCol());
                                        }
                                        else{
                                            nextTile.setTileRow(firstTile.getTileRow() + 1);
                                            nextTile.setTileCol(firstTile.getTileCol());
                                        }
                                        playedTiles.add(nextTile);
                                        firstTile = nextTile;
                                    }
                                }
                                while (!endPlacements);
                            }
                            else {
                                System.out.println("Sorry, you don't have that tile.");
                                break;
                            }
                            break;
                        }
            //          // have player select what letter to play and where to start it DONE
                        // have player select next letters (one at a time?) DONE
                        // place those letters on the board DONE
                        // if they encounter a space that isn't null, place it on col/row + 2 DONE
                        // validate word played, starting from first tile
                        // validate words encountered, starting from first tile, checking left/right
                        // if valid, remove those tiles from player's tile tray
                    }
                Move move = new Move(player, playedTiles, board);
                for(int j = 0; j < playedTiles.size(); j++){
                    move.placeTiles(tileTray);
                    //move.findWords();
                }
                if(board.getPlacedTiles(7, 7) == null){
                    System.out.println("Sorry, the first tile of the game has to hit the middle square.  Seriously, everyone knows that.");
//                    validPlay = false;
                    break;
                }
                move.removeAndReplaceTiles(player.getPlayerTray(), game.getTilePool());
                System.out.print(board.toString());
            }
        }
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