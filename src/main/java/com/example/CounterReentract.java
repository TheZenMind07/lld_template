package com.example;

import java.util.concurrent.locks.ReentrantLock;

public class CounterReentract {
    private static int count = 0;
    private ReentrantLock reentrantLock;
    public void increment() {
        reentrantLock.lock();
        try {
            count++;
        } finally {
            reentrantLock.unlock();
        }
    }

    public int getCount() {
        return count;
    }

    CounterReentract() {
        reentrantLock = new ReentrantLock();
    }
}
