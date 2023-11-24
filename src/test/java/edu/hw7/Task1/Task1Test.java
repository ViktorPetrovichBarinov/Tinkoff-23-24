package edu.hw7.Task1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw7.Task1.MultithreadedIncrement.twoThreadsIncrement;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1Test {

    @Test
    @DisplayName("Простой тест демонстрирующий работоспособность пограммы")
    void test1() {
        int counter = 0;
        int increase = 10;

        int returnValue = twoThreadsIncrement(0, 10);

        assertThat(10).isEqualTo(returnValue);
    }

    @Test
    @DisplayName("Проверка на больших числах + проверка стабильности работы программы")
    void test2() {
        for (int i = 0; i < 10; i++) {
            int counter = -100000000;
            int increase = 200000000;

            int returnValue = twoThreadsIncrement(counter, increase);
            assertThat(100000000).isEqualTo(returnValue);
        }
    }
}
