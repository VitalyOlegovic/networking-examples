package org.example.socketclient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.Socket;
import java.util.Scanner;


public class DictClient {
    public static final String SERVER = "dict.org";
    public static final int PORT = 2628;
    public static final int TIMEOUT = 15000;
    
    public static void main(String[] args) {
        Socket socket = null;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Inserire lemma da cercare: ");
            String word = scanner.next();
            String s = define(word, Dictionary.ENGLISH);
            System.out.println(s);
        } catch (IOException ex) {
            System.err.println(ex);
        } finally { // dispose
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException ex) {
                // ignore
            }
        }
        }
    }
    
    public static String define(String word, Dictionary dictionary) throws IOException{
        Socket socket = null;
        socket = new Socket(SERVER, PORT);
        socket.setSoTimeout(TIMEOUT);
        OutputStream out = socket.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(out, "UTF-8");
        BufferedWriter bw = new BufferedWriter(osw);
        InputStream in = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));

        
        String result = define(word, dictionary, bw, reader);

        bw.write("quit\r\n");
        bw.flush();
        
        return result;
    }
    
    public static String define(String word, Dictionary dictionary, Writer writer, BufferedReader reader)
    throws IOException, UnsupportedEncodingException {
        
        writer.write("DEFINE " + dictionary.name + " " + word + "\r\n");
        writer.flush();
        
        StringBuilder sb = new StringBuilder();
        
        for (String line = reader.readLine(); line != null; line = reader.readLine()) {
            if (line.startsWith("250 ")) { // OK
                return sb.toString();
            } else if (line.startsWith("552 ")) { // no match
                return "No definition found for " + word;
            } else{
                sb.append(line.trim());
                sb.append(System.getProperty("line.separator"));
            }
        }
        return sb.toString();
    }
    
    public static enum Dictionary{
        ENGLISH("english"),
        ITALIAN_TO_ENGLISH("fd-ita-eng"),
        ENGLISH_TO_ITALIAN("fd-eng-ita");
        
        private String name;
        
        Dictionary(String name){
            this.name = name;
        }
    }
}