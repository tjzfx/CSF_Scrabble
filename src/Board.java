/**
 * Created by rachelmann on 2/16/14.
 */
public class Board {
    public static String[][] BOARD_VALUES = new String[15][15];
    public Object [][] squares = new Object[15][15];

    public Board(){
        createAndPlaceValues();

    }

    public static void createAndPlaceValues(){

        String tripleWord = "Triple Word";
        String doubleWord = "Double Word";
        String tripleLetter = "Triple Letter";
        String doubleLetter = "Double Letter";

        BOARD_VALUES[0][0] = tripleWord;
        BOARD_VALUES[0][3] = doubleLetter;
        BOARD_VALUES[0][7] = tripleWord;
        BOARD_VALUES[0][11] = doubleLetter;
        BOARD_VALUES[0][14] = tripleWord;
        BOARD_VALUES[1][1] = doubleWord;
        BOARD_VALUES[1][5] = tripleLetter;
        BOARD_VALUES[1][9] = tripleLetter;
        BOARD_VALUES[1][13] = doubleWord;
        BOARD_VALUES[2][2] = doubleWord;
        BOARD_VALUES[2][6] = doubleLetter;
        BOARD_VALUES[2][8] = doubleLetter;
        BOARD_VALUES[2][12] = doubleWord;
        BOARD_VALUES[3][1] = doubleLetter;
        BOARD_VALUES[3][3] = doubleWord;
        BOARD_VALUES[3][7] = doubleLetter;
        BOARD_VALUES[3][11] = doubleWord;
        BOARD_VALUES[3][14] = doubleLetter;
        BOARD_VALUES[4][4] = doubleWord;
        BOARD_VALUES[4][10] = doubleWord;
        BOARD_VALUES[5][1] = tripleLetter;
        BOARD_VALUES[5][5] = tripleLetter;
        BOARD_VALUES[5][9] = tripleLetter;
        BOARD_VALUES[5][13] = tripleLetter;
        BOARD_VALUES[6][2] = doubleLetter;
        BOARD_VALUES[6][6] = doubleLetter;
        BOARD_VALUES[6][8] = doubleLetter;
        BOARD_VALUES[6][12] = doubleLetter;
        BOARD_VALUES[7][0] = tripleWord;
        BOARD_VALUES[7][3] = doubleLetter;
        BOARD_VALUES[7][7] = doubleWord;
        BOARD_VALUES[7][11] = doubleLetter;
        BOARD_VALUES[7][14] = tripleWord;
        BOARD_VALUES[8][2] = doubleLetter;
        BOARD_VALUES[8][6] = doubleLetter;
        BOARD_VALUES[8][8] = doubleLetter;
        BOARD_VALUES[8][12] = doubleLetter;
        BOARD_VALUES[9][2] = tripleLetter;
        BOARD_VALUES[9][5] = tripleLetter;
        BOARD_VALUES[9][9] = tripleLetter;
        BOARD_VALUES[9][13] = tripleLetter;
        BOARD_VALUES[10][4] = doubleWord;
        BOARD_VALUES[10][10] = doubleWord;
        BOARD_VALUES[11][0] = doubleLetter;
        BOARD_VALUES[11][3] = doubleWord;
        BOARD_VALUES[11][7] = doubleLetter;
        BOARD_VALUES[11][11] = doubleWord;
        BOARD_VALUES[11][14] = doubleLetter;
        BOARD_VALUES[12][2] = doubleWord;
        BOARD_VALUES[12][6] = doubleLetter;
        BOARD_VALUES[12][8] = doubleLetter;
        BOARD_VALUES[12][12] = doubleWord;
        BOARD_VALUES[13][1] = doubleWord;
        BOARD_VALUES[13][5] = tripleLetter;
        BOARD_VALUES[13][9] = tripleLetter;
        BOARD_VALUES[13][13] = doubleWord;
        BOARD_VALUES[14][0] = tripleWord;
        BOARD_VALUES[14][3] = doubleLetter;
        BOARD_VALUES[14][7] = tripleWord;
        BOARD_VALUES[14][11] = doubleLetter;
        BOARD_VALUES[14][14] = tripleWord;
    }
    

}
