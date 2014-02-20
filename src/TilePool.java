import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class TilePool {
    ArrayList<LetterTile> tilePool = new ArrayList<LetterTile>();

    public TilePool(File letterFreqs){
        try{
            //File letterfreqs = new File("letterFrequencies.txt");
            BufferedReader letterReader = new BufferedReader(new FileReader(letterFreqs));
            String line;
            while ((line = letterReader.readLine()) != null) {
                String delims = "[ ]+";
                //ArrayList<String> attributes = new ArrayList<String>();
                String [] attrs = line.split(delims);
                for(int i = 0; i < 3; i++){

                    System.out.print(attrs[i] + ", ");
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

    public LetterTile getRandomTile(){
        Random random = new Random();
        int randomIndex = random.nextInt();
        LetterTile newTile = tilePool.get(randomIndex);
        tilePool.remove(newTile);
        return newTile;
    }
}

// the starting state of the tile pool will be determined by the txt file