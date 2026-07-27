package com.example;

import java.sql.Time;
import java.util.concurrent.*;

public class CounterExperiments {

    static void main() throws InterruptedException {
        CounterUnsafe counterUnsafe = new CounterUnsafe();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for(int i = 0; i < 10000 ; i++) {
            executorService.submit(counterUnsafe::increment);
        }
        System.out.println(counterUnsafe.getCount());


        CounterReentract counterReentract = new CounterReentract();
        for(int i = 0; i < 10000 ; i++) {
            executorService.submit(counterReentract::increment);
        }
        executorService.awaitTermination(1, TimeUnit.SECONDS);
        System.out.println(counterReentract.getCount());

    }
}
