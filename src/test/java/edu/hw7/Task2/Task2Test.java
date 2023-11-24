package edu.hw7.Task2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.math.BigInteger;
import static edu.hw7.Task2.MultithreadedFactorial.calculateFactorial;
import static edu.hw7.Task2.MultithreadedFactorial.calculateFactorialLineal;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {

    @Test
    @DisplayName("Проверка корректности работы программы")
    void test1() {
        BigInteger answer = calculateFactorial(6);

        assertThat(answer).isEqualTo(new BigInteger(String.valueOf(720)));
    }

    @Test
    @DisplayName("Проверка что многопоточная программы быстрее последовательной на больших числах")
    void test2() {
        long start = System.currentTimeMillis();
        BigInteger parallelResult = calculateFactorial(100000);
        long end = System.currentTimeMillis();
        long parallelTime = end - start;

        start = System.currentTimeMillis();
        BigInteger sequentialResult = calculateFactorialLineal(100000);
        end = System.currentTimeMillis();
        long sequentialTime = end - start;

        assertThat(parallelResult.equals(sequentialResult)).isTrue();
        assertThat(parallelTime < sequentialTime).isTrue();
    }


}
