package com.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WaterStream {
    Water water;

    private void hydrogenStream() throws InterruptedException {
        while(true) {
            water.hydrogen();
        }
    }

    private void oxygenStream() throws InterruptedException {
        while (true) {
            water.oxygen();
        }
    }


    WaterStream(Water water) {
        this.water = water;
    }

    static void main() {
        try {
            WaterStream waterStream = new WaterStream(new Water());
            ExecutorService executorService = Executors.newFixedThreadPool(5);
            executorService.submit(() -> {
                try {
                    waterStream.hydrogenStream();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            executorService.submit(() -> {
                try {
                    waterStream.oxygenStream();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            Thread.sleep(3000);
            executorService.shutdown();
        } catch (InterruptedException exception) {

        }

    }


}
