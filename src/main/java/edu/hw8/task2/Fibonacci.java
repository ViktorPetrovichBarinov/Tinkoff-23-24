package edu.hw8.task2;

public class Fibonacci {
    private Fibonacci() {
    }

    public static long fib(int num) {
        if (num == 0) {
            return 0;
        }
        if (num == 1 || num == 2) {
            return 1;
        }
        return fib(num - 1) + fib(num - 2);
    }
}
