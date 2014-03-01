import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;

public class TilePool {
    ArrayList<LetterTile> tilePool = new ArrayList<LetterTile>();

    public TilePool(File letterFreqs){
        try{
            File letterfreqs = new File("letterFrequencies.txt");
            BufferedReader letterReader = new BufferedReader(new FileReader(letterFreqs));
            String line;
            while ((line = letterReader.readLine()) != null) {
                String delims = "[ ]+";
                String [] attrs = line.split(delims);
                System.out.println(Arrays.toString(attrs));
                for(int x = 0; x < Integer.valueOf(attrs[1]); x++){
                    tilePool.add(new LetterTile(attrs[0], Integer.valueOf(attrs[1])));
                 }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        // looped for loops: for each letter, then for each instance of each letter add an instance of LetterTile
        // newBufferedReader(Path path, Charset cs)
        // tilePool = readAllLines(Path path, Charset cs)
    }

    private int tilePoolSize(){
        int numTiles = this.tilePool.size();
        return numTiles;
    }

    public LetterTile getRandomTile(){
        Random random = new Random();
        int randomIndex = random.nextInt(this.tilePool.size() - 1);
        LetterTile newTile = tilePool.get(randomIndex);
        tilePool.remove(newTile);
        return newTile;
    }

    public String toString(){
        String tilePoolText = tilePool.toString();
        return tilePoolText;
    }

    public void removeTile(LetterTile tile){

        for (int i = 0; i < tilePool.size(); i++)
            if (tilePool.get(i) == tile){
                tilePool.remove(i);
                //Does "return" exit out of the loop?  Don't want to keep looping through
                return;
            }
    }


}

// the starting state of the tile pool will be determined by the txt file