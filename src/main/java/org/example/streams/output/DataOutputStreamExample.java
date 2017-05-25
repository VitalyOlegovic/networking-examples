package org.example.streams.output;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class DataOutputStreamExample {

    static void scriviTutto(
            DataOutputStream dos, List<String> list)
            throws IOException {
        // Per ogni elemento della lista
        for(String s : list){
            // Scrivi l'elemento
            dos.writeUTF(s);
        }
    }

    public static void main(String[] args){
        OutputStream os = System.out;
        List<String> list = new ArrayList<>();
        list.add("Oceania");
        list.add("Africa");
        list.add("Asia");
        try(
            DataOutputStream dos = new DataOutputStream(os);
        ){
            scriviTutto(dos, list);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
