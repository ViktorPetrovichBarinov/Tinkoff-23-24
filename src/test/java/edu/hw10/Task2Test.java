package edu.hw10;

import edu.hw10.Task2.CacheProxy;
import edu.hw10.Task2.FibCalculator;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {
    FibCalculator realCalculator = new FibCalculator() {
        @Override
        public long fib(int number) {
            if (number <= 1) {
                return number;
            } else {
                return fib(number - 1) + fib(number - 2);
            }
        }
    };

    @Test
        void test1() {
        FibCalculator proxyCalculator = CacheProxy.create(realCalculator, FibCalculator.class, "src/test/java/edu/hw10/tmp/cache");
        long answer = 1134903170;
        int numberOfFibonacci = 45;

        long res;
        long start;
        long end;
        long difference1;
        long difference2;


        start = System.currentTimeMillis();
        res = proxyCalculator.fib(numberOfFibonacci);
        end = System.currentTimeMillis();
        difference1 = end - start;
        assertThat(proxyCalculator.fib(numberOfFibonacci)).isEqualTo(answer);

        start = System.currentTimeMillis();
        res = proxyCalculator.fib(numberOfFibonacci);
        end = System.currentTimeMillis();
        difference2 = end - start;
        assertThat(proxyCalculator.fib(numberOfFibonacci)).isEqualTo(answer);


        assertThat(difference1).isGreaterThan(100);
        assertThat(difference2).isLessThan(10);
    }

}
