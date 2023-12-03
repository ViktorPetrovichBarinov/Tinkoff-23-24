package edu.hw8.Task2;

import static edu.hw8.Task2.Fibonacci.fib;

@SuppressWarnings("RegexpSinglelineJava")
public class Main {
    private Main() {
    }

    private final static int LAST_FIBONACCI_NUMBER = 45;
    private final static int NUMBER_OF_THREADS = 6;

    public static void main(String[] args) throws Exception {
        long start;
        long end;



        start = System.currentTimeMillis();
        for (int i = 0; i < LAST_FIBONACCI_NUMBER; i++) {
            for (int j = 0; j < NUMBER_OF_THREADS; j++) {
                long res = fib(i);
            }
        }
        end = System.currentTimeMillis();
        System.out.println("One thread: " + (end - start));

        FixedThreadPool threadPool = new FixedThreadPool(NUMBER_OF_THREADS);
        threadPool.start();
        start = System.currentTimeMillis();
        for (int i = 0; i < LAST_FIBONACCI_NUMBER; i++) {
            for (int j = 0; j < NUMBER_OF_THREADS; j++) {
                int finalI = i;
                Runnable task = new Runnable() {
                    @Override
                    public void run() {
                        long res = fib(finalI);
                    }
                };
                threadPool.execute(task);
            }
        }

        threadPool.close();
        end = System.currentTimeMillis();
        System.out.println(NUMBER_OF_THREADS + " threads: " + (end - start));
    }
}
