package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task7Test {
    @Test
    @DisplayName("Первый пример")
    void example1() {
        int given_number = 8;
        int given_shift = 1;

        int answer = 4;

        assertThat(answer).isEqualTo(Task7.rotateRight(given_number, given_shift));
    }

    @Test
    @DisplayName("Второй пример")
    void example2() {
        int given_number = 16;
        int given_shift = 1;

        int answer = 1;

        assertThat(answer).isEqualTo(Task7.rotateLeft(given_number, given_shift));
    }

    @Test
    @DisplayName("Третий пример")
    void example3() {
        int given_number = 17;
        int given_shift = 2;

        int answer = 6;

        assertThat(answer).isEqualTo(Task7.rotateLeft(given_number, given_shift));
    }

    @Test
    @DisplayName("Сдвиг на длинну числа вправо")
    void example4() {
        int given_number = 100;
        int given_shift = 7;

        int answer = 100;

        assertThat(answer).isEqualTo(Task7.rotateRight(given_number, given_shift));
    }

    @Test
    @DisplayName("Сдвиг на длинну числа влево")
    void example5() {
        int given_number = 100;
        int given_shift = 7;

        int answer = 100;

        assertThat(answer).isEqualTo(Task7.rotateLeft(given_number, given_shift));
    }

    @Test
    @DisplayName("Сдвиг на длинну большую, чем длинна числа вправо")
    void example6() {
        int given_number = 8;
        int given_shift = 5;

        int answer = 4;

        assertThat(answer).isEqualTo(Task7.rotateRight(given_number, given_shift));
    }

    @Test
    @DisplayName("Сдвиг на длинну большую, чем длинна числа влево")
    void example7() {
        int given_number = 8;
        int given_shift = 7;

        int answer = 4;

        assertThat(answer).isEqualTo(Task7.rotateLeft(given_number, given_shift));
    }

    @Test
    @DisplayName("Сдвиг вправо на отрицательныую позицию")
    void example8() {
        int given_number = 8;
        int given_shift = -1;

        int answer = 1;

        assertThat(answer).isEqualTo(Task7.rotateRight(given_number, given_shift));
    }

    @Test
    @DisplayName("Сдвиг влево на отрицательныую позицию")
    void example9() {
        int given_number = 8;
        int given_shift = -1;

        int answer = 4;

        assertThat(answer).isEqualTo(Task7.rotateLeft(given_number, given_shift));
    }
}
