package org.example;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class DataOutputStreamExample {
    public static void main(String[] args){
        OutputStream os = System.out;
        try(
            DataOutputStream dos = new DataOutputStream(os);
        ){
            Double d = Math.PI;
            dos.writeDouble(d);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
