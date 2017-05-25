package org.example.streams.output;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BuffOutExample {

    public static void main(String ... args) {
        try(
            FileOutputStream fos = new FileOutputStream("data.txt");
            BufferedOutputStream bos = new BufferedOutputStream(fos);
        ){
            bos.write("47".getBytes());
            bos.close();
            fos.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
