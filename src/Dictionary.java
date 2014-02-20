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

    public void setSCRABBLE_DICTIONARY() throws IOException {

        Path path = Paths.get("/Users/rachelmann/CSF/FinalProject/words");
        Charset charset = Charset.forName("US-ASCII");

        try {

            BufferedReader reader = Files.newBufferedReader(path, charset);
            String line = null;
            while ((line = reader.readLine()) != null) {
                line = line.toUpperCase();
                System.out.println(line);
                this.SCRABBLE_DICTIONARY.add(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }



}
