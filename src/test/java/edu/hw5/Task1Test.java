package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1Test {

    @Test
    @DisplayName("Тест из примера")
    void test1() {
        ArrayList<String> test = new ArrayList<>();
        test.add("2022-03-12, 20:20 - 2022-03-12, 23:50");
        test.add("2022-04-01, 21:30 - 2022-04-02, 01:20");

        String answer = "0:3:40";

        assertThat(answer).isEqualTo(Task1.calculateAverageTime(test));
    }

    @Test
    @DisplayName("Сессия 0 секунд")
    void test2() {
        ArrayList<String> test = new ArrayList<>();
        test.add("2022-03-12, 20:20 - 2022-03-12, 20:20");

        String answer = "0:0:0";
        assertThat(answer).isEqualTo(Task1.calculateAverageTime(test));
    }

    @Test
    @DisplayName(".")
    void test3() {
        ArrayList<String> test = new ArrayList<>();
        test.add("2022-03-12, 20:20 - 2022-03-12, 20:20");
        test.add("2022-03-12, 20:20 - 2022-03-12, 23:20");
        test.add("2022-03-12, 20:20 - 2022-03-13, 20:20");

        String answer = "0:9:0";
        assertThat(answer).isEqualTo(Task1.calculateAverageTime(test));
    }
}
