package org.example.streams.input;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamExample {

    static String leggiTutto(InputStream stream) throws IOException {
        StringBuilder sb = new StringBuilder();
        int result;
        byte[] bytes = new byte[1024];
        do{
            result = stream.read(bytes);
            if(result != -1){
                String s = new String(bytes);
                sb.append(s);
            }
        }while(result != -1);

        return sb.toString();
    }

    public static void main(String[] args){
        byte[] bytes = "Andrea\nMarco\nGiovanni".getBytes();
        ByteArrayInputStream stream = new ByteArrayInputStream(bytes);
        try {
            String s = leggiTutto(stream);
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
