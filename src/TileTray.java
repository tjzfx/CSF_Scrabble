import java.util.ArrayList;

public class TileTray {
    private static int NUM_TILES = 7;

    ArrayList<LetterTile> tileTray = new ArrayList<LetterTile>();

    // constructor
    public TileTray(TilePool tilePool){
        for (int i = 0; i < 7; i++){
            LetterTile newTile = tilePool.getRandomTile();
            tileTray.add(newTile);
        }
    }

    public LetterTile getNewTile(TilePool tilePool){
        LetterTile newTile = tilePool.getRandomTile();
        tileTray.add(newTile);
        return newTile;
    }
}

