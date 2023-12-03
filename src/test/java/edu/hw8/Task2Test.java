package edu.hw8;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw8.Task2.Fibonacci.fib;
import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {

    @Test
    @DisplayName("Проверка первых 3 чисел Фибоначчи")
    void test1() {
        assertThat(fib(0)).isEqualTo(0);
        assertThat(fib(1)).isEqualTo(1);
        assertThat(fib(2)).isEqualTo(1);
    }

    @Test
    @DisplayName("Проверка первых каких-то рандомных чисел")
    void test2() {
        assertThat(fib(29)).isEqualTo(514229);
        assertThat(fib(43)).isEqualTo(433494437);
        assertThat(fib(45)).isEqualTo(1134903170);
    }
}
