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
    @DisplayName("Проверка параллельного вычисления числа пи")
    void test2() {
        int numberOfPoints = 100000000;
        CalculatePi calculatePi = new CalculatePi();
        double returnValue = calculatePi.calculatePiInParallel(numberOfPoints, 4);

        double epsilon = 0.01;

        assertThat(Math.abs(returnValue - Math.PI) < epsilon).isTrue();
    }
}
