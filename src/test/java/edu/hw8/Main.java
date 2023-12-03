package edu.hw8;

import edu.hw8.Task2.FixedThreadPool;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.locks.Lock;
import static edu.hw8.Task2.Fibonacci.fib;

public class Main {


    public static void main(String[] args) throws Exception {
        long start, end;
        int lastFibNumber = 45;
        int numberOfThreads = 6;
        FixedThreadPool threadPool = new FixedThreadPool(numberOfThreads);
        threadPool.start();

        start = System.currentTimeMillis();
        for (int i = 0; i < lastFibNumber; i++) {
            for (int j = 0; j < numberOfThreads; j++) {
                long res = fib(i);
            }
            //System.out.println("One thread| [" + i + "] = " + res);
        }
        end = System.currentTimeMillis();
        System.out.println("One thread: " + (end - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < lastFibNumber; i++) {
            for (int j = 0; j < numberOfThreads; j++) {
                int finalI = i;
                Runnable task = new Runnable() {
                    @Override
                    public void run() {
                        long res = fib(finalI);
                        //System.out.println(numberOfThreads + " threads [" + finalI + "] = " + res);
                    }
                };
                threadPool.execute(task);
            }

        }



        threadPool.close();
        end = System.currentTimeMillis();
        System.out.println(numberOfThreads + " threads: " + (end - start));
    }
}
