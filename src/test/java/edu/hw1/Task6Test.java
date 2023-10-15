package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task6Test {
    @Test
    @DisplayName("Певрый пример")
    void example1() {
        int given = 3524;

        int answer = 3;

        assertThat(answer).isEqualTo(Task6.kaprekarFunction(given));
    }

    @Test
    @DisplayName("Второй пример")
    void example2() {
        int given = 6621;

        int answer = 5;

        assertThat(answer).isEqualTo(Task6.kaprekarFunction(given));
    }

    @Test
    @DisplayName("Третий пример")
    void example3() {
        int given = 6554;

        int answer = 4;

        assertThat(answer).isEqualTo(Task6.kaprekarFunction(given));
    }

    @Test
    @DisplayName("Четвёртый пример")
    void example4() {
        int given = 1234;

        int answer = 3;

        assertThat(answer).isEqualTo(Task6.kaprekarFunction(given));
    }

    @Test
    @DisplayName("6174")
    void example5() {
        int given = 6174;

        int answer = 1;

        assertThat(answer).isGreaterThanOrEqualTo(Task6.kaprekarFunction(given));
    }

    @Test
    @DisplayName("Проверка всех четырёхзначных чисел на свойство Капрекара")
    void example6() {

        int answer = 7;

        for(int i = 1000; i <= 9999; i++) {
            if(i == 1111 || i == 2222 || i == 3333 || i == 4444
            || i == 5555 || i == 6666 || i == 7777 || i == 8888 || i == 9999) {
                continue;
            }
            assertThat(answer).isGreaterThanOrEqualTo(Task6.kaprekarFunction(i));
        }

    }

    @Test
    @DisplayName("0")
    void example7() {
        int given = 0;

        int answer = -1;

        assertThat(answer).isGreaterThanOrEqualTo(Task6.kaprekarFunction(given));
    }

    @Test
    @DisplayName("Четырёхзначеные числа с одинаковыми цифрами")
    void example8() {
        int answer = -1;

        for (int given = 1111; given < 10000; given += 1111) {
            assertThat(answer).isEqualTo(Task6.kaprekarFunction(given));
        }
    }
}

