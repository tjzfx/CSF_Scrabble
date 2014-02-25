import javax.management.remote.rmi._RMIConnection_Stub;
import javax.swing.*;
import javax.xml.transform.Result;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.sql.*;

/**
 * Created by rachelmann on 2/14/14.
 */
public class Application {

        public static void main(String[] args) throws IOException {

            Connection db = null;
            String url = "jdbc:postgresql://mycsf-scrabble.c7mrgwzg9grn.us-west-2.rds.amazonaws.com:5432/dbCSF_Scrabble";
            String username = "userTRS";
            String password = "12345678";

            GameDatabase gameDB =  new GameDatabase(url, username, password);
            db = gameDB.connectToDb();

//        Object tile = new Object();
//        //Create a new board which tracks the values of each square
//        Board board = new Board();

//        Dictionary dictionary = new Dictionary();
//        HashSet<String> scrabbleDictionary;
//        dictionary.setSCRABBLE_DICTIONARY();
//        scrabbleDictionary = dictionary.SCRABBLE_DICTIONARY;
//        String word = "wordx";
//        word = word.toUpperCase();
//        dictionary.checkWord(dictionary, word);

//        User user = new User("rachelkm2", "rachelkm2@gmail.com");
//        user.userExists(user, db);
//        user.saveUser(user, db);
//        user.printAllUsers(db);
        }

    }


