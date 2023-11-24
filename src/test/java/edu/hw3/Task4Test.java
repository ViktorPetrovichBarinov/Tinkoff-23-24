package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    @Test
    @DisplayName("Дефолтный тест 1")
    void test1() {
        int input = 2;

        String answer = "II";

        assertThat(answer).isEqualTo(Task4.convertToRoman(input));
    }

    @Test
    @DisplayName("Дефолтный тест 2")
    void test2() {
        int input = 12;

        String answer = "XII";

        assertThat(answer).isEqualTo(Task4.convertToRoman(input));
    }

    @Test
    @DisplayName("Дефолтный тест 3")
    void test3() {
        int input = 16;

        String answer = "XVI";

        assertThat(answer).isEqualTo(Task4.convertToRoman(input));
    }

    @Test
    @DisplayName("Выход за пределы римских чисел сверху")
    void test4() {
        int input = 4000;

        try {
            Task4.convertToRoman(input);
        } catch (IllegalArgumentException exception) {
            String answer = "Incorrect input number.";
            assertThat(answer).isEqualTo(exception.getMessage());
        }
    }

    @Test
    @DisplayName("Выход за пределы римских чисел снизу")
    void test5() {
        int input = 0;
        try {
            Task4.convertToRoman(input);
        } catch (IllegalArgumentException exception) {
            String answer = "Incorrect input number.";
            assertThat(answer).isEqualTo(exception.getMessage());
        }
    }

    @Test
    @DisplayName("Максимальное представляемое число")
    void test6() {
        int input = 3999;

        String answer = "MMMCMXCIX";

        assertThat(answer).isEqualTo(Task4.convertToRoman(input));
    }
}
