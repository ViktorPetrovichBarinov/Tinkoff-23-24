package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {

    @Test
    @DisplayName("Певрый пример")
    void example1() {
        int given = 4666;

        int answer = 4;

        assertThat(answer).isEqualTo(Task2.countDigits(given));
    }

    @Test
    @DisplayName("Второй пример")
    void example2() {
        int given = 544;

        int answer = 3;

        assertThat(answer).isEqualTo(Task2.countDigits(given));
    }

    @Test
    @DisplayName("Третий пример")
    void example3() {
        int given = 0;

        int answer = 1;

        assertThat(answer).isEqualTo(Task2.countDigits(given));
    }

    @Test
    @DisplayName("Отрицательные значения")
    void example4() {
        int given = -100;

        int answer = 3;

        assertThat(answer).isEqualTo(Task2.countDigits(given));
    }

    @Test
    @DisplayName("Положительное краевое значение")
    void example5() {
        int given = Integer.MAX_VALUE;

        int answer = 10;

        assertThat(answer).isEqualTo(Task2.countDigits(given));
    }

    @Test
    @DisplayName("Отрицательное краевое значение")
    void example6() {
        int given = Integer.MIN_VALUE + 1;

        int answer = 10;

        assertThat(answer).isEqualTo(Task2.countDigits(given));
    }

}
