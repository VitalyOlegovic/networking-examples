package org.example;

import java.io.IOException;
import java.io.OutputStream;

public class CharactersGenerator {

    public static void generateCharacters(OutputStream out)
            throws IOException {
        int firstPrintableCharacter
                = 33;
        int numberOfPrintableCharacters = 94;
        int numberOfCharactersPerLine
                = 72;
        int start = firstPrintableCharacter;

        int j = 0;

        while (j < 100) { /* infinite loop */
            for (int i = start; i < start + numberOfCharactersPerLine; i++) {
                out.write((
                        (i - firstPrintableCharacter) % numberOfPrintableCharacters)
                        + firstPrintableCharacter);
            }
            out.write('\r'); // carriage return
            out.write('\n'); // linefeed
            start = ((start + 1) - firstPrintableCharacter)
                    % numberOfPrintableCharacters + firstPrintableCharacter;

            j++;
        }
    }

}
