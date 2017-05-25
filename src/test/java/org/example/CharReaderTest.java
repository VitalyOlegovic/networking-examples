package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.streams.input.CharactersReader;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CharReaderTest {

    private final static Logger LOGGER = LogManager.getLogger();

    @Test
    public void byteArray() throws IOException{
        InputStream is = new ByteArrayInputStream("Ciao ciao".getBytes());
        CharactersReader.readCharacters(is,(bytes)->LOGGER.info(new String(bytes)));
    }

}
