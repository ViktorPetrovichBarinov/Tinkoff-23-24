package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task3Test {

    @Test
    @DisplayName("Певрый пример")
    void example1() {
        int[] givenArray1 = new int[]{1, 2, 3, 4};
        int[] givenArray2 = new int[]{0, 6};

        boolean answer = true;

        assertThat(answer).isEqualTo(Task3.isNestable(givenArray1, givenArray2));
    }

    @Test
    @DisplayName("Второй пример")
    void example2() {
        int[] givenArray1 = new int[]{3, 1};
        int[] givenArray2 = new int[]{4, 0};

        boolean answer = true;

        assertThat(answer).isEqualTo(Task3.isNestable(givenArray1, givenArray2));
    }

    @Test
    @DisplayName("Третий пример")
    void example3() {
        int[] givenArray1 = new int[]{9, 9, 8};
        int[] givenArray2 = new int[]{8, 9};

        boolean answer = false;

        assertThat(answer).isEqualTo(Task3.isNestable(givenArray1, givenArray2));
    }

    @Test
    @DisplayName("Четвёртый пример")
    void example4() {
        int[] givenArray1 = new int[]{1, 2, 3, 4};
        int[] givenArray2 = new int[]{2, 3};

        boolean answer = false;

        assertThat(answer).isEqualTo(Task3.isNestable(givenArray1, givenArray2));
    }

    @Test
    @DisplayName("Краевые значения")
    void example5() {
        int[] givenArray1 = new int[]{-100, -50, 0, 50, 100, 123};
        int[] givenArray2 = new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE};

        boolean answer = true;

        assertThat(answer).isEqualTo(Task3.isNestable(givenArray1, givenArray2));
    }

    @Test
    @DisplayName("Одинаковые края")
    void example6() {
        int[] givenArray1 = new int[]{123, 321, 123, 321, 100, 1000, -1000};
        int[] givenArray2 = new int[]{1000, -1000};

        boolean answer = false;

        assertThat(answer).isEqualTo(Task3.isNestable(givenArray1, givenArray2));
    }


}
