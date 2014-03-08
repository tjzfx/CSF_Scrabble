import java.util.ArrayList;
import java.util.LinkedList;

public class Move {
    private Player player;
    ArrayList<LetterTile> playedTiles = new ArrayList<LetterTile>();
    private boolean validPlay = true;
    Board board;

    public void setTileDirection(String tileDirection) {
        this.tileDirection = tileDirection;
    }

    private String tileDirection = "";
    ArrayList<LinkedList<LetterTile>> words;
    ArrayList<String> strWords = new ArrayList<String>();


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
        boolean isIsland = true;
        for (int x = 0; x < playedTiles.size(); x++){
            LetterTile thisTile = playedTiles.get(x);
            int row = thisTile.getTileRow();
            int col = thisTile.getTileCol();
            //LetterTile adjacentTile = board.getPlacedTiles(thisTile.getTileRow() + 1, )
            if(board.getPlacedTiles(row, col-1) != null || board.getPlacedTiles(row, col+1) != (null)){
                isIsland = false;
                return isIsland;
            }
            else if(board.getPlacedTiles(row-1, col) != null || board.getPlacedTiles(row+1, col) != null){
                isIsland = false;
                return isIsland;
            }
        }
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
    public void findWords(){
        LinkedList<LetterTile> word = new LinkedList<LetterTile>();
        StringBuilder sb = new StringBuilder();

        if (tileDirection == "vertical"){

            //First find the main, vertical word
            int col;
            int smallestRow = 15;
            int largestRow = -1;
            LetterTile tile = playedTiles.get(0);
            col = tile.getTileCol();
            //Find the first tile placed in the column (smallest row)
            for(int i =0; i < playedTiles.size(); i++){
                tile = playedTiles.get(i);
                int currentRow = tile.getTileRow();
                if (currentRow < smallestRow){
                    smallestRow = currentRow;
                }
            }
            //Find the first tile in the column (either the top tile above it or the top tile placed if nothing above it)
            LetterTile firstTile = board.getPlacedTiles(smallestRow, col);
            int firstRow = smallestRow;

            while (firstTile != null && firstRow > -1){
                firstRow = firstRow - 1;
                firstTile = board.getPlacedTiles(firstRow, col);
            }

            //Find the last tile in the column (either the last tile below the largest row, or the
            LetterTile lastTile = board.getPlacedTiles(smallestRow, col);
            int lastRow = largestRow;

            while (lastTile != null && lastRow < 15){
                lastRow = firstRow + 1;
                lastTile = board.getPlacedTiles(lastRow, col);
            }

            //Build the word and add it to the linked list
            for (int i = firstRow; i < lastRow + 1; i++ ){
                tile = board.getPlacedTiles(i, col);
                sb.append(tile.getLetter());
                word.addLast(tile);
            }
            words.add(word);
            strWords.add(sb.toString());

            int firstCol;
            int lastCol;
            LetterTile startTile = board.getPlacedTiles(smallestRow, col);
            firstCol = firstTile.getTileCol();
            firstTile = board.getPlacedTiles(smallestRow, col);
            lastCol = firstTile.getTileCol();
            lastTile = board.getPlacedTiles(smallestRow, col);
            //Check for additional words
            //Start with the smallestRow (first tile placed)

            for (int i = smallestRow; i < lastRow + 1; i++){
                //Find the first tile in that row (firstcol)
                while (firstTile != null && firstCol > -1 ){
                    firstCol = firstCol - 1;
                    firstTile = board.getPlacedTiles(i, firstCol);
                }
                //Find the last tile in that row (lastcol)
                while (lastTile != null && lastCol < 15 ){
                    lastCol = firstCol + 1;
                    firstTile = board.getPlacedTiles(i, lastCol);
                }

                //Build the word and add it to the linked list
                for (int j = firstCol; j < lastCol + 1; i++ ){
                    tile = board.getPlacedTiles(i, j);
                    word.addLast(tile);
                }
                words.add(word);
                strWords.add(sb.toString());
            }

        }

        if (tileDirection == "horizontal"){

            //First find the main, horizontal word
            int smallestCol = 0;
            int largestCol = 14;
            LetterTile tile = playedTiles.get(0);
            int row = tile.getTileRow();
            //Find the first tile placed in the row (smallest col)
            for(int i =0; i < playedTiles.size(); i++){
                tile = playedTiles.get(i);
                int currentCol = tile.getTileCol();
                if (currentCol < smallestCol){
                    smallestCol = currentCol;
                }
            }
            //Find the first tile in the row (either the last tile to the left or the first tile placed if nothing to the left)
            LetterTile firstTile = board.getPlacedTiles(row, smallestCol);
            int firstCol = smallestCol;

            while (firstTile != null && firstCol > -1){
                firstCol = firstCol - 1;
                firstTile = board.getPlacedTiles(row, firstCol);
            }

            //Find the last tile in the row (either the first tile to the right or the last tile placed if nothing to the right)
            LetterTile lastTile = board.getPlacedTiles(row, smallestCol);
            int lastCol = largestCol;

            while (lastTile != null && lastCol < 15){
                lastCol = lastCol + 1;
                lastTile = board.getPlacedTiles(row, lastCol);
            }

            //Build the word and add it to the linked list
            for (int i = firstCol; i > lastCol + 1; i++ ){
                tile = board.getPlacedTiles(row, i);
                sb.append(tile.getLetter());
                word.addLast(tile);
            }
            words.add(word);
            strWords.add(sb.toString());

            int firstRow;
            int lastRow;
            LetterTile startTile = board.getPlacedTiles(row, smallestCol);
            firstRow = firstTile.getTileRow();
            firstTile = board.getPlacedTiles(row, smallestCol);
            lastRow = firstTile.getTileRow();
            lastTile = board.getPlacedTiles(row, smallestCol);
            //Check for additional words
            //Start with the smallestCol (first tile placed)

            for (int i = smallestCol; i < lastCol + 1; i++){
                //Find the first tile in that Col (firstrow)
                while (firstTile != null && firstRow > -1 ){
                    firstRow = firstRow - 1;
                    firstTile = board.getPlacedTiles(firstRow, i);
                }
                //Find the last tile in that Col (lastrow)
                while (lastTile != null && lastRow < 15 ){
                    lastRow = firstRow + 1;
                    firstTile = board.getPlacedTiles(lastRow, i);
                }

                //Build the word and add it to the linked list
                for (int j = firstRow; j < lastRow + 1; i++ ){
                    tile = board.getPlacedTiles(j, i);
                    word.addLast(tile);
                }
                words.add(word);
                strWords.add(sb.toString());
            }

        }

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

        for (int i = 0; i < strWords.size(); i++){
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
