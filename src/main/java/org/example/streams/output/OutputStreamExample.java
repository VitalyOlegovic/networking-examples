package org.example.streams.output;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OutputStreamExample {

    private static void scriviTutto(List<String> lista, OutputStream os) throws IOException {
        // Ciclo for each
        // Nella variabile s avrò le stringhe prelevate dalla lista
        for(String s : lista){
            // Scrivo la stringa corrente
            os.write(s.getBytes());
            // Scrivo un carattere spazio
            os.write(' ');
        }
    }

    private static void scriviTutto(Iterator<String> iteratore, OutputStream os) throws IOException {
        // Finché ho altre stringhe da elaborare
        while(iteratore.hasNext()){
            // IMPORTANTISSIMO: il next va chiamato una volta sola!!!
            String contenuto = iteratore.next();
            // Scrivo il contenuto
            os.write(contenuto.getBytes());
            // Scrivo un carattere spazio
            os.write(' ');
        }
    }

    public static void main(String[] args){
        List<String> lista = new ArrayList<>();
        lista.add("Maria");
        lista.add("Giovanna");
        lista.add("Consuelo");

        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        try {
            scriviTutto(lista.iterator(), stream);
            System.out.println(stream.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
