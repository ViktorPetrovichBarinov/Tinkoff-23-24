package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {

    @Test
    @DisplayName("Тест из примера 1")
    void test1() {
        ArrayList<LocalDate> answer = new ArrayList<>();
        answer.add(LocalDate.of(1925, 2, 13));
        answer.add(LocalDate.of(1925, 3, 13));
        answer.add(LocalDate.of(1925, 11, 13));

        assertThat(answer).isEqualTo(Task2.findFridaysThe13th(1925));
    }

    @Test
    @DisplayName("Тест из примера 2")
    void test2() {
        ArrayList<LocalDate> answer = new ArrayList<>();
        answer.add(LocalDate.of(2024, 9, 13));
        answer.add(LocalDate.of(2024, 12, 13));

        assertThat(answer).isEqualTo(Task2.findFridaysThe13th(2024));
    }

    @Test
    @DisplayName("3 пятницы 13 в году")
    void test3() {
        ArrayList<LocalDate> answer = new ArrayList<>();
        answer.add(LocalDate.of(1981, 2, 13));
        answer.add(LocalDate.of(1981, 3, 13));
        answer.add(LocalDate.of(1981, 11, 13));
        assertThat(answer).isEqualTo(Task2.findFridaysThe13th(1981));
    }

    @Test
    @DisplayName("1 пятница 13 в году")
    void test4() {
        ArrayList<LocalDate> answer = new ArrayList<>();
        answer.add(LocalDate.of(2021, 8, 13));

        assertThat(answer).isEqualTo(Task2.findFridaysThe13th(2021));
    }


    @Test
    @DisplayName("Передаём дату, которая уже пятница 13")
    void test5() {
        LocalDate answer = LocalDate.of(2021, 8, 13);
        assertThat(answer).isEqualTo(Task2.findNextFridayThe13(LocalDate.of(2021, 8, 13)));
    }

    @Test
    @DisplayName("Переход через год")
    void test6() {
        LocalDate answer = LocalDate.of(2022, 5, 13);
        assertThat(answer).isEqualTo(Task2.findNextFridayThe13(LocalDate.of(2021, 8, 14)));
    }
}
