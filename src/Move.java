import java.util.ArrayList;
import java.util.LinkedList;

public class Move {
    ArrayList<LetterTile> playedTiles = new ArrayList<LetterTile>();
    private boolean invalidPlay = false;
    Board board;

    //TODO: RM ADDED
    private String tileDirection = "";

    private Move(Player player, ArrayList<LetterTile> playedTiles){
        // check if more than one tile in the arraylist - don't need checks contig and direc
        // if > 1, check direc
    }

    //TODO: RM ADDED
    public void placeTiles(TileTray tileTray, Board board){

        Boolean tileExists;
        int row;
        int col;
        LetterTile tile;
        String bonusValue;

        //Loop through the playedTiles to make sure they exist in player's tile tray
        for (int i = 0; i < playedTiles.size(); i++ ){
            tile = playedTiles.get(i);
            tileExists = tileTray.checkTileExists(tile);
            if (tileExists = false){
                //TODO: Exit out
            }
        }

        //Loop through the playedTiles, place them on the board and set their bonus value
        for (int i = 0; i < playedTiles.size(); i++ ){
            tile = playedTiles.get(i);
            row = tile.getTileRow();
            col = tile.getTileCol();
            board.setPlacedTiles(row, col, tile);
            bonusValue = board.BOARD_VALUES[row][col];
            if (bonusValue != ""){
                tile.setBonusValue(bonusValue);
            }
        }

    }

    //TODO: RM ADDED
    public void removeAndReplaceTiles(TileTray tileTray, TilePool tilePool){

        int row;
        int col;
        LetterTile tile;
        LetterTile newTile;

        //Loop through the playedTiles
        //Remove each played tile from the player's tile tray and replace it with a new random tile from the TilePool
        for (int i = 0; i < playedTiles.size(); i++ ){
            tile = playedTiles.get(i);
            tileTray.removeTile(tile);
            newTile = tilePool.getRandomTile();
            tileTray.addTile(newTile);
        }

    }

    //Shirley
    public boolean checkTileIsland(){
        boolean isIsland = false;
        return isIsland;
    }

    //Shirley
    public boolean checkWordIsland(){

        boolean isIsland = false;
        return isIsland;
    }

    //Rachel
    public boolean checkInLine(){

        boolean isInLine = false;
        int rowOne = -1;
        int colOne = -1;

        for (int i = 0; i < this.playedTiles.size(); i ++){

            LetterTile tile = this.playedTiles.get(i);

            if (tileDirection.equals("")){
                if (rowOne < 0){
                    rowOne = tile.getTileRow();
                    colOne = tile.getTileCol();
                }
                else {
                    if (rowOne == tile.getTileRow()){
                        tileDirection = "Horizontal";
                    } else if (colOne == tile.getTileCol()){
                        tileDirection = "Vertical";
                    } else {
                        isInLine = false;
                        return false;
                    }
                }
            } else if (tileDirection.equals("Horizontal")){
                if (rowOne != tile.getTileRow()){
                    isInLine = false;
                    return false;
                }
            } else if (tileDirection.equals("Vertical")){
                if (colOne != tile.getTileRow()){
                    isInLine = false;
                    return false;
                }
            }
            isInLine = true;
        }

        return isInLine;
    }

    //Shirley
    public ArrayList<LinkedList<LetterTile>> findWords(String direction){
        //StringBuilder sb = new StringBuilder();
        ArrayList<LinkedList<LetterTile>> allWords = new ArrayList<LinkedList<LetterTile>>();
        //ArrayList<String> allWords = new ArrayList<String>();
        LinkedList<LetterTile> word = new LinkedList<LetterTile>();
        String firstTile = "";
        if (tileDirection == "horizontal"){
            for(int i = 0; i < playedTiles.size(); i++){
                LetterTile thisTile = playedTiles.get(i);
                while(firstTile == ""){
                    if(board.getPlacedTiles(thisTile.getTileRow(), thisTile.getTileCol()) == null){
                        firstTile = thisTile.getLetter();
                        while(board.getPlacedTiles(thisTile.getTileRow() + 1, thisTile.getTileCol()) != null){
                            //sb.append(firstTile);
                            word.add(thisTile);
                        }
                        //word = sb.toString();
                        //allWords.add(word);
                        allWords.add(word);
                    }
                    else{
                        thisTile = playedTiles.get(i-1);
                    }
                }
            }
        }
        else if (tileDirection == "vertical"){

        }
        // check direc of tiles
        // sort array to be in smallest (row/col) to largest row/col order
        // starting at smallest, check opposite direction, find words, rinse, repeat
        // get first letter tile in arraylist
        // iterate up/left depending on direc until a null row, col is found
        // starting at that tile (the one before null), iterate down/right until a null row,col is found creating a string

        return allWords;
    }

    //Rachel
    public int calculate(LinkedList<LetterTile>[] words){

        //TODO: findWords should add words to an Array of Linked Lists of LetterTiles
        //        int i; //number of words
        //        LinkedList<LetterTile>[] words = new LinkedList[i];

        LetterTile tile;
        int letterPoints = 0;
        int totalLetterPoints = 0;
        String bonusPoints;
        int wordPoints;
        int movePoints;

        //Loop through each LinkedList (word) in the Array
        for (int i = 0; i < words.length; i++){
            //Traverse through each LinkedList (word) in the Array to get the points value of each letter
            for(int j = 0; j < words[i].size(); j++){
                tile = words[i].get(j);
                letterPoints = tile.getPointValue();

                if (tile.getCommitted() == false){
                    bonusPoints = tile.getBonusValue();


                }

                totalLetterPoints = totalLetterPoints + letterPoints;

            }
        }
        int points = 0;
        return points;
    }

    //while (words[i].iterator().hasNext())
//    tile = words[i].getFirst();


}
