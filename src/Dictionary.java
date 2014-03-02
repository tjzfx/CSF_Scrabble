import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.*;

public class Dictionary {

    public HashSet<String> SCRABBLE_DICTIONARY = new HashSet<String>();

    public Dictionary(){
    }

    //TODO: RM UPDATED (ADDED Path to parameters and moved path variable to application class
    public void setSCRABBLE_DICTIONARY(Path path) throws IOException {

        Charset charset = Charset.forName("US-ASCII");

        try {

            BufferedReader reader = Files.newBufferedReader(path, charset);
            String line = null;
            while ((line = reader.readLine()) != null) {
                line = line.toUpperCase();
//                System.out.println(line);
                this.SCRABBLE_DICTIONARY.add(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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


}
