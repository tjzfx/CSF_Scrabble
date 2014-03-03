import java.util.ArrayList;
import java.util.LinkedList;

public class Move {
    private Player player;
    ArrayList<LetterTile> playedTiles = new ArrayList<LetterTile>();
    private boolean validPlay = true;
    Board board;
    private String tileDirection = "";
    ArrayList<LinkedList<LetterTile>> words;

    public Move(Player player, ArrayList<LetterTile> playedTiles, Board board){
        this.board = board;
        this.playedTiles = playedTiles;
        this.player = player;
    }


    public void placeTiles(TileTray tileTray){

        Boolean tileExists;
        int row;
        int col;
        LetterTile tile;
        String bonusValue;

        //Loop through the playedTiles to make sure they exist in player's tile tray
        for (int i = 0; i < playedTiles.size(); i++ ){
            String tileLetter = playedTiles.get(i).getLetter();
            tileExists = tileTray.checkTileExists(tileLetter);
            if (tileExists = false){
                //TODO: Exit out
                System.out.println("You don't have that tile.");
                break;
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

    public void removeTilesFromBoard(){
        for (int i = 0; i < playedTiles.size(); i++){
            int row = playedTiles.get(i).getTileRow();
            int col = playedTiles.get(i).getTileCol();
            board.placedTiles[row][col] = null;
        }
    }

    public void commitTilesToBoard(){
        for (int i = 0; i < playedTiles.size(); i++){
            int row = playedTiles.get(i).getTileRow();
            int col = playedTiles.get(i).getTileCol();
            board.placedTiles[row][col] = playedTiles.get(i);
        }
    }

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

    public boolean checkInLine(){

        boolean isInLine = false;
        int rowOne = -1;
        int colOne = -1;

        for (int i = 0; i < playedTiles.size(); i ++){

            LetterTile tile = playedTiles.get(i);

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
    public ArrayList<String> findWords(){
        //StringBuilder sb = new StringBuilder();
        //ArrayList<LinkedList<LetterTile>> allWords = new ArrayList<LinkedList<LetterTile>>();
        ArrayList<String> allWords = new ArrayList<String>();
        LinkedList<LetterTile> word = new LinkedList<LetterTile>();
        String firstTile = "";
        if (tileDirection == "r"){
            for(int i = 0; i < playedTiles.size(); i++){
                LetterTile thisTile = playedTiles.get(i);
                while(firstTile == ""){
                    if(board.getPlacedTiles(thisTile.getTileRow(), thisTile.getTileCol()) == null){
                        firstTile = thisTile.getLetter();
                        while(board.getPlacedTiles(thisTile.getTileRow() + 1, thisTile.getTileCol()) != null){
                            //sb.append(firstTile);
                            word.add(thisTile);
                            //System.out.println(word.toString());
                        }
                        //word = sb.toString();
                        //allWords.add(word);
                        //allWords.add(word);
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
    public int calculate(){

        LetterTile tile;
        int tilePoints = 0;
        int totalLetterPoints = 0;
        String bonusValue;
        int wordPoints;
        int movePoints = 0;
        Boolean committed;
        int wordMultiplier;

        for (int i = 0; i < words.size(); i++){
            LinkedList<LetterTile> word = words.get(i);
            wordMultiplier = 0;
            for(int j = 0; j < word.size(); j++){
                tile = word.get(j);
                tilePoints = tile.getPointValue();
                bonusValue = tile.getBonusValue();
                committed = tile.getCommitted();

                if (committed == false){
                    if (bonusValue.equals("Triple Word")){
                        wordMultiplier = wordMultiplier + 3;
                    } else if (bonusValue.equals("Double Word")){
                        wordMultiplier = wordMultiplier + 2;
                    } else if (bonusValue.equals("Triple Letter")){
                        tilePoints = tilePoints * 3;
                    } else if (bonusValue.equals("Double Letter")){
                        tilePoints = tilePoints * 2;
                    }
                }
                totalLetterPoints = totalLetterPoints + tilePoints;
            }

            if (wordMultiplier > 0){
                wordPoints = totalLetterPoints * wordMultiplier;
            } else {
                wordPoints = totalLetterPoints;
            }

            movePoints = movePoints + wordPoints;
        }

        return movePoints;
    }

}
