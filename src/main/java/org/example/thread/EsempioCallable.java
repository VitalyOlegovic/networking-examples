package org.example.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EsempioCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("Messaggio");
        return "Tutto a posto";
    }
    
    public static void main(String[] args){
        EsempioCallable ec = new EsempioCallable();
        ExecutorService executor = Executors.newFixedThreadPool(5);
        Future<String> f = executor.submit(ec);
        
        try {
            String s = f.get();
            System.out.println(s);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } catch (ExecutionException ex) {
            ex.printStackTrace();
        }
    }
    
}
