package org.example.thread;

public class ThreadExample implements Runnable {
    
    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println( "Nome del thread attuale: " + t.getName() );
    }
    
    public static void main(String[] args){
        Thread t = Thread.currentThread();
        System.out.println( "Nome del thread attuale: " + t.getName() );
        
        ThreadExample pe = new ThreadExample();
        Thread t1 = new Thread(pe);
        Thread t2 = new Thread(pe);
        
        t1.start();
        t2.start();
    }
    
}
