package org.example.streams.output;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;

public class OutputStreamWriterExample {

    static void scriviTutto(
            List<String> list, Writer w)
            throws IOException {
        for(String s : list){
            w.write(s);
        }
        w.flush();
    }

    static void scriviTutto(
            Iterator<String> iterator, Writer w)
            throws IOException {
        while(iterator.hasNext()){
            String s = iterator.next();
            w.write(s);
        }
        w.flush();
    }

    public static void main(String[] args){
        try(
            OutputStreamWriter w = new OutputStreamWriter(new FileOutputStream("OdysseyB.txt"), "Cp1253");
        ){
            w.write("ἦμος δ ́ ἠριγένεια φάνη ῥοδοδάκτυλος Ἠώς");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
