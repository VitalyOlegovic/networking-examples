package org.example.thread;

import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class IntervalliRegolari {
    
    public IntervalliRegolari(){
        ScheduledThreadPoolExecutor stpe = new ScheduledThreadPoolExecutor(1);
        stpe.scheduleAtFixedRate(this::scriviOrario, 1, 1, TimeUnit.SECONDS);
    }
    
    public void scriviOrario(){
        Date date = new Date();
        System.out.println(date.toString());
    }
    
    public static void main(String[] args){
        IntervalliRegolari ir = new IntervalliRegolari();
    }
}
