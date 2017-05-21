package org.example.socketclient;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class DaytimeClientDataISR {

    public static String readFromSocket(String hostname, int port){
        StringBuilder sb = new StringBuilder();
        
        try (
            Socket socket = new Socket(hostname, port);
        ){
            
            socket.setSoTimeout(15000);
            InputStream in = socket.getInputStream();
            DataInputStream dis = new DataInputStream(in);
            byte[] byteArray = new byte[1024];
            while(dis.read(byteArray) != -1){
                sb.append(new String(byteArray));
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        String hostname = "time-c.nist.gov";
        int port = 13;
        String s = readFromSocket(hostname, port);
        System.out.println(s);
    }

}
