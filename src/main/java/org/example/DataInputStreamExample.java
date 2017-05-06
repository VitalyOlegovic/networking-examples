package org.example;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DataInputStreamExample {
    public static void main(String[] args){
        try(
            InputStream is = new ByteArrayInputStream("Ciao ciao".getBytes());
            DataInputStream dis = new DataInputStream(is);
        ){
            byte[] byteArray = new byte[1024];
            while(dis.read(byteArray) != -1){
                System.out.println(new String(byteArray));
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
