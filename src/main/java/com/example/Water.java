package com.example;

import java.util.concurrent.Semaphore;

public class Water {
    private Semaphore hSemaphore;
    private Semaphore oSemaphore;

    Water() {
        hSemaphore = new Semaphore(2);
        oSemaphore = new Semaphore(1);
    }

    public void hydrogen() throws InterruptedException {
        oSemaphore.acquire();
        System.out.println("H");
        hSemaphore.release();
    }

    public void oxygen() throws InterruptedException {
        hSemaphore.acquire(2);
        System.out.println("O");
        oSemaphore.release(2);
    }
}
