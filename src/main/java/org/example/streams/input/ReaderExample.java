package org.example.streams.input;

import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;

public class ReaderExample {

    static String leggiTutto(Reader reader) throws IOException {
        CharBuffer cb = CharBuffer.allocate(1024);
        StringBuilder sb = new StringBuilder();
        int c;
        do {
            c = reader.read(cb);
            if(c != -1){
                sb.append(cb.toString());
            }
        }while(c != -1);
        return sb.toString();
    }

}
