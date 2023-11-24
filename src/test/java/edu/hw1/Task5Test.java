package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task5Test {

    @Test
    @DisplayName("Певрый пример")
    void example1() {
        int given = 11211230;

        boolean answer = true;

        assertThat(answer).isEqualTo(Task5.isPalindromeDescendant(given));
    }

    @Test
    @DisplayName("Второй пример")
    void example2() {
        int given = 13001120;

        boolean answer = true;

        assertThat(answer).isEqualTo(Task5.isPalindromeDescendant(given));
    }

    @Test
    @DisplayName("Третий пример")
    void example3() {
        int given = 23336014;

        boolean answer = true;

        assertThat(answer).isEqualTo(Task5.isPalindromeDescendant(given));
    }

    @Test
    @DisplayName("Четвёртый пример")
    void example4() {
        int given = 11;

        boolean answer = true;

        assertThat(answer).isEqualTo(Task5.isPalindromeDescendant(given));
    }

    @Test
    @DisplayName("Не полином")
    void example5() {
        int given = 123456789;

        boolean answer = false;

        assertThat(answer).isEqualTo(Task5.isPalindromeDescendant(given));
    }

    @Test
    @DisplayName("И ещё не полином")
    void example6() {
        int given = 999998;

        boolean answer = false;

        assertThat(answer).isEqualTo(Task5.isPalindromeDescendant(given));
    }

    @Test
    @DisplayName("Цифры")
    void example7() {
        boolean answer = true;

        for (int given = 0; given < 10; given++) {
            assertThat(answer).isEqualTo(Task5.isPalindromeDescendant(given));
        }
    }
}
