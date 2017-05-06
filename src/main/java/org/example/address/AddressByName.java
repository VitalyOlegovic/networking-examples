package org.example.address;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class AddressByName {
   
    public static void main(String[] args){
        try {
            InetAddress ia = InetAddress.getByName("it.wikipedia.org");
            System.out.println(ia.toString());
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        }
    }
    
}
