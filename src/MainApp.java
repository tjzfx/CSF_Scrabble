import java.io.File;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        File letterfreqs = new File("letterFrequencies.txt");
        TilePool allpool = new TilePool(letterfreqs);
        for(int x = 0; x < allpool.tilePool.size(); x++){
            LetterTile letterTile = allpool.tilePool.get(x);
            System.out.println(letterTile.toString());
        }
        TileTray player1tray = new TileTray(allpool);
        System.out.println("Let's start a new game.  Here is your tile tray:");
        player1tray.displayTileTray();
    }
}
