package com.example;

import java.util.concurrent.locks.ReentrantLock;

public class CounterUnsafe {
    private static int counter = 0;
    public void increment() {
        counter++;
    }

    public int getCount() {
        return counter;
    }
}
