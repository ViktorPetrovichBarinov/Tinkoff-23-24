package edu.hw7.Task1;

import java.util.concurrent.atomic.AtomicInteger;

public class MultithreadedIncrement {
    private MultithreadedIncrement() {
    }

    public static int twoThreadsIncrement(int value, int increase) {

        AtomicInteger atomicValue = new AtomicInteger(value);
        int increaseForFirstThread = increase / 2;
        int increaseForSecondThread = increase - increaseForFirstThread;

        Thread firstIncrementor = new Thread(() -> {
            for (int i = 0; i < increaseForFirstThread; i++) {
                atomicValue.incrementAndGet();
            }
        });
        Thread secondIncrementor = new Thread(() -> {
            for (int i = 0; i < increaseForSecondThread; i++) {
                atomicValue.incrementAndGet();
            }
        });

        firstIncrementor.start();
        secondIncrementor.start();

        try {
            firstIncrementor.join();
            secondIncrementor.join();
        } catch (InterruptedException e) {
            System.exit(-1);
        }

        return atomicValue.get();
    }
}
