package org.example.streams.input;

import java.io.*;

public class DataInputStreamExample {

    public String leggiTutto(DataInputStream stream) {
        StringBuilder sb = new StringBuilder();
        try {
            String s = stream.readUTF();
            sb.append(s);
        } catch(EOFException eofe){
            return sb.toString();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

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
