package edu.hw7.Task2;

import java.math.BigInteger;
import java.util.stream.LongStream;

public class MultithreadedFactorial {
    private MultithreadedFactorial() {
    }

    public static BigInteger calculateFactorial(long n) {
        return LongStream.rangeClosed(1, n)
            .parallel()  //метод для параллельного вычисления
            .mapToObj(BigInteger::valueOf)  // каждое число в BigInt
            .reduce(BigInteger.ONE, BigInteger::multiply); // редукция аккумулятор 1
    }

    public static BigInteger calculateFactorialLineal(long n) {
        return LongStream.rangeClosed(1, n)
            .mapToObj(BigInteger::valueOf)  // каждое число в BigInt
            .reduce(BigInteger.ONE, BigInteger::multiply); // редукция аккумулятор 1
    }
}
