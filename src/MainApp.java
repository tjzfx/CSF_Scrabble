import java.io.File;

public class MainApp {
    public static void main(String[] args){
        File letterfreqs = new File("letterFrequencies.txt");
        TilePool pool = new TilePool(letterfreqs);
    }
}
