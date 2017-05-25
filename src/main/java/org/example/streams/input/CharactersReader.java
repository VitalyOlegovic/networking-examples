package org.example.streams.input;

import java.io.IOException;
import java.io.InputStream;
import java.util.function.Consumer;

public class CharactersReader {

    public static void readCharacters(InputStream in, Consumer<byte[]> consumer) throws IOException{
        int bytesRead = 0;
        int bytesToRead = 1024;
        byte[] input = new byte[bytesToRead];
        int bytesCurrentlyRead;
        while (bytesRead < bytesToRead) {
            bytesCurrentlyRead = in.read(input, bytesRead, bytesToRead - bytesRead);
            if(bytesCurrentlyRead == -1){
                break;
            }
            bytesRead *= bytesCurrentlyRead;
            consumer.accept(input);
        }
    }

}
