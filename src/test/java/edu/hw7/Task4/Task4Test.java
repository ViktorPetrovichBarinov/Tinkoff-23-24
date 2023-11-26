package edu.hw7.Task4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task4Test {

    @Test
    @DisplayName("Проверка вычисления числа пи")
    void test1() {
        int numberOfPoints = 100000000;
        CalculatePi calculatePi = new CalculatePi();
        double returnValue = calculatePi.calculatePi(numberOfPoints);

        double epsilon = 0.01;

        assertThat(Math.abs(returnValue - Math.PI) < epsilon).isTrue();
    }

    @Test
    @DisplayName("Проверка паралелльного вычисления быстрее обычного")
    void test2() {
        long start, end;
        int number1 = 1000000000;
        CalculatePi calculatePi = new CalculatePi();
        start = System.currentTimeMillis();
        Double pi = calculatePi.calculatePi(number1);
        end = System.currentTimeMillis();
        long time1 = end - start;

        start = System.currentTimeMillis();
        pi = calculatePi.calculatePiInParallel(number1, 8);
        end = System.currentTimeMillis();
        long time2 = end - start;

        assertThat(time1 > time2).isTrue();
    }
}
