import java.util.ArrayList;
import java.util.Collections;

public class TileTray {
    private static int NUM_TILES = 7;
    ArrayList<LetterTile> tileTray = new ArrayList<LetterTile>();

    public ArrayList<LetterTile> getTileTray() {
        return tileTray;
    }

    public void setTileTray(ArrayList<LetterTile> tileTray) {
        this.tileTray = tileTray;
    }

    // constructor
    public TileTray(TilePool tilePool){
        for (int i = 0; i < 7; i++){
            LetterTile newTile = tilePool.getRandomTile();
            //tilePool.remove();
            tileTray.add(newTile);
        }
    }

    public LetterTile getNewTile(TilePool tilePool){
        LetterTile newTile = tilePool.getRandomTile();
        tileTray.add(newTile);
        return newTile;
    }

    public ArrayList<LetterTile> shuffleTiles(ArrayList<LetterTile> tileTray){
        Collections.shuffle(tileTray);
        return tileTray;
    }

    public String displayTileTray(){
        String tileTrayText = tileTray.toString();
        return tileTrayText;
    }

    //TODO: RM Added
    public void addTile(LetterTile newTile){
        tileTray.add(newTile);
    }

    //TODO: RM Added
    public void removeTile(LetterTile tile){

        for (int i = 0; i < tileTray.size(); i++)
            if (tileTray.get(i) == tile){
                tileTray.remove(i);
                //Does "return" exit out of the loop?  Don't want to keep looping through
                return;
            }
    }

    //TODO: RM Added
    public Boolean checkTileExists(String s){
        for (int i = 0; i < 7; i++){
            if (tileTray.get(i).getLetter().equals(s)){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }

    public LetterTile getTileFromLetter(String s, ArrayList<LetterTile> tileTray){
        for(int i = 0; i < tileTray.size(); i++){
            if (tileTray.get(i).getLetter().equals(s)){
                return tileTray.get(i);
            }
        }
        return null;
    }

    public LetterTile playTile(String s){
        for (int i = 0; i < tileTray.size(); i++){
            if(tileTray.get(i).getLetter() == s){
                return tileTray.get(i);
            }
        }
        return tileTray.get(0);
    }

}



