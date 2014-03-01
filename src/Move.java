import java.util.ArrayList;

public class Move {
    ArrayList<LetterTile> playedTiles = new ArrayList<LetterTile>();
    private boolean invalidPlay = false;

    private Move(Player player, ArrayList<LetterTile> playedTiles){
        // check if more than one tile in the arraylist - don't need checks contig and direc
        // if > 1, check direc
    }
    // Rachel
    public void placeTiles(){
        //tileTray.check();
        //board.setPlacedTiles();
        //LetterTile.setBonusValue();
        // tileTray.remove();
    }

    // Shirley
    public boolean checkIsland(){
        boolean isIsland = false;
        return isIsland;
    }

    // Shirley
    public boolean checkWordIsland(){
        // check to make sure at least one placed tile is next to at least one committed tile
        boolean isIsland = false;
        return isIsland;
    }

    // Rachel
    public boolean checkInLine(){
        boolean isInLine = false;
        return isInLine;
    }

    //Shirley
    public String findWords(String direction){
        String word = "";
        // check direc of tiles
        // sort array to be in smallest (row/col) to largest row/col order
        // starting at smallest, check opposite direction, find words, rinse, repeat
        // get first letter tile in arraylist
        // iterate up/left depending on direc until a null row, col is found
        // starting at that tile (the one before null), iterate down/right until a null row,col is found creating a string

        return word;
    }
    // Rachel
    public int calculate(){
        int points = 0;
        return points;
    }

}
