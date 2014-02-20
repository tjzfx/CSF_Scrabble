import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;

/**
 * Created by rachelmann on 2/14/14.
 */
public class Application {

    public static void main(String[] args) throws IOException {

//        Object tile = new Object();
//        //Create a new board which tracks the values of each square
//        Board board = new Board();
        Dictionary dictionary = new Dictionary();
        HashSet<String> scrabbleDictionary;
        dictionary.setSCRABBLE_DICTIONARY();
        scrabbleDictionary = dictionary.SCRABBLE_DICTIONARY;
        String word = "Zyzzogeton";
        word = word.toUpperCase();
        checkWord(dictionary, word);
    }


    public static Boolean checkWord(Dictionary dictionary, String word){

        if(dictionary.SCRABBLE_DICTIONARY.contains(word)){
            System.out.println("True");
            return true;
        } else {
            System.out.println("False");
            return false;
        }

    }

    public static String placeTile(int row, int column, Board board, Object tile){

            String bonusValue = null;

            if (board.squares[row][column] == null){
                board.squares[0][0] = tile;
                bonusValue = board.BOARD_VALUES[row][column];
                return bonusValue;
            }

            return bonusValue;
        }


}
