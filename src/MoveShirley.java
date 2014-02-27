import java.util.ArrayList;

public class MoveShirley {
    ArrayList<LetterTile> playedTiles = new ArrayList<LetterTile>();
    private boolean invalidPlay = false;

    private MoveShirley(Player player, ArrayList<LetterTile> playedTiles){
        // check if more than one tile in the arraylist - don't need checks contig and direc
        // if > 1, check direc
    }

    public void placeTiles(){
        //tileTray.check();
        //board.setPlacedTiles();
        //LetterTile.setBonusValue();
        // tileTray.remove();
    }

    public boolean checkIsland(){
        boolean isIsland = false;
        return isIsland;
    }

    public boolean checkInLine(){
        boolean isInLine = false;
        return isInLine;
    }

    public String getDirection(){
        String direction = "";
        return direction;
    }

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

    public int calculate(){
        int points = 0;
        return points;
    }

}
