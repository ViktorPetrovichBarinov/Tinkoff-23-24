package edu.hw1;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task1Test {
    @Test
    @DisplayName("Певрый пример")
    void example1() {
        // given
        String given = "01:00";

        //when
        int answer = 60;

        // then
        assertThat(answer).isEqualTo(Task1.minutesToSeconds(given));
    }

    @Test
    @DisplayName("Второй пример")
    void example2() {
        // given
        String given = "13:56";

        //when
        int answer = 836;

        // then
        assertThat(answer).isEqualTo(Task1.minutesToSeconds(given));
    }

    @Test
    @DisplayName("Третий пример")
    void example3() {
        // given
        String given = "10:60";

        //when
        int answer = -1;

        // then
        assertThat(answer).isEqualTo(Task1.minutesToSeconds(given));
    }

    @Test
    @DisplayName("Некорректное значение")
    void example4() {
        // given
        String given = "13:99";

        //when
        int answer = -1;

        // then
        assertThat(answer).isEqualTo(Task1.minutesToSeconds(given));
    }


    @Test
    @DisplayName("Видео длинны 0")
    void example5() {
        // given
        String given = "00:00";

        //when
        int answer = 0;

        // then
        assertThat(answer).isEqualTo(Task1.minutesToSeconds(given));
    }

    @Test
    @DisplayName("Максимально обрабатываемое значение")
    void example6() {
        // given
        String given = "35791394:7";

        //when
        int answer = Integer.MAX_VALUE;

        // then
        assertThat(answer).isEqualTo(Task1.minutesToSeconds(given));
    }
}
