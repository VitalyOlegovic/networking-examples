package org.example.socketclient;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class DaytimeClientDataISR {

    public static void main(String[] args) {
        String hostname = "time-c.nist.gov";
        int port = 13;
        Socket socket = null;
        try {
            socket = new Socket(hostname, port);
            socket.setSoTimeout(15000);
            InputStream in = socket.getInputStream();
            DataInputStream dis = new DataInputStream(in);
            byte[] byteArray = new byte[1024];
            while(dis.read(byteArray) != -1){
                System.out.println(new String(byteArray));
            }
        } catch (IOException ex) {
            System.err.println(ex);
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException ex) {
                    // ignore
                }
            }
        }
    }

}
