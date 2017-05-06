package org.example.address;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MyAddress {
    public static void main(String[] args){
        try {
            InetAddress ia = InetAddress.getLocalHost();
            System.out.println(ia.toString());
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        }
    }
}
