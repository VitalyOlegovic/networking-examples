package org.example.streams.output;

import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CharactersGenerator {

    public static void generateCharacters(OutputStream out) throws IOException {
        int firstPrintableCharacter = 33;
        int numberOfPrintableCharacters = 94;
        int numberOfCharactersPerLine = 72;
        int start = firstPrintableCharacter;

        int j = 0;

        while (j < 100) {
            for (int i = start; i < start + numberOfCharactersPerLine; i++) {
                int charToPrint = (
                        (i - firstPrintableCharacter) % numberOfPrintableCharacters)
                        + firstPrintableCharacter;
                out.write(charToPrint);
            }
            out.write('\r');
            out.write('\n');
            start = ((start + 1) - firstPrintableCharacter) % numberOfPrintableCharacters + firstPrintableCharacter;

            j++;
        }
    }

    public static void main(String[] args){
        try {
            OutputStream os = System.out;
            CharactersGenerator.generateCharacters(os);
        } catch (IOException ex) {
            Logger.getLogger(CharactersGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
