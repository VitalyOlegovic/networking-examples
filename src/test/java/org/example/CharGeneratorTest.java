package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.streams.output.CharactersGenerator;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class CharGeneratorTest {

    private static final Logger LOGGER = LogManager.getLogger();

    @Test
    public void systemOutput() throws IOException {
        OutputStream os = System.out;
        CharactersGenerator.generateCharacters(os);
    }

    @Test
    public void byteArray() throws IOException{
        OutputStream os = new ByteArrayOutputStream();
        CharactersGenerator.generateCharacters(os);
        System.out.println(os.toString());
    }

    @Test
    public void file() throws IOException{
        try(
            OutputStream os = new FileOutputStream("src/test/resources/outputStream.txt");
        ) {
            CharactersGenerator.generateCharacters(os);
        }
    }

}
