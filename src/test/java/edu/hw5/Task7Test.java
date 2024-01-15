package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw5.Task7.*;
import static org.assertj.core.api.Assertions.assertThat;

public class Task7Test {

    @Test
    @DisplayName("что-то помимо 0 и 1")
    void test1() {
        assertThat(task1("12021")).isFalse();
        assertThat(task2("12021")).isFalse();
        assertThat(task3("12021")).isFalse();
    }

    @Test
    @DisplayName("task1: третий 0")
    void test2() {
        assertThat(task1("11001011")).isTrue();
    }

    @Test
    @DisplayName("task1: тест проверяющего")
    void test7() {
        assertThat(task3(".101")).isFalse();
    }

    @Test
    @DisplayName("task2:не подходящее по условию")
    void test3() {
        assertThat(task2("001101")).isFalse();
    }

    @Test
    @DisplayName("task2:подходящее по условию")
    void test4() {
        assertThat(task2("0011010")).isTrue();
    }

    @Test
    @DisplayName("task3:не подходящее по условию")
    void test5() {
        assertThat(task3("0011010")).isFalse();
    }

    @Test
    @DisplayName("task3:подходящее по условию")
    void test6() {
        assertThat(task3("001")).isTrue();
    }
}
