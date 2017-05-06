package org.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OutputStreamWriterExample {
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
