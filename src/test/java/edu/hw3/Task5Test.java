package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {

    @Test
    @DisplayName("Дефолтный тест 1")
    void test1() {
        String[] input = {"John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"};

        ArrayList<Task5.Person> answer = new ArrayList<>();
        answer.add(new Task5.Person("Thomas", "Aquinas", true));
        answer.add(new Task5.Person("Rene", "Descartes", true));
        answer.add(new Task5.Person("David", "Hume", true));
        answer.add(new Task5.Person("John", "Locke", true));

        assertThat(answer).isEqualTo(Task5.parseContacs(input, Task5.Order.ASC));
    }

    @Test
    @DisplayName("Дефолтный тест 2")
    void test2() {
        String[] input = {"Paul Erdos", "Leonhard Euler", "Carl Gauss"};

        ArrayList<Task5.Person> answer = new ArrayList<>();
        answer.add(new Task5.Person("Carl", "Gauss", true));
        answer.add(new Task5.Person("Leonhard", "Euler", true));
        answer.add(new Task5.Person("Paul", "Erdos", true));

        assertThat(answer).isEqualTo(Task5.parseContacs(input, Task5.Order.DESC));
    }

    @Test
    @DisplayName("Дефолтный тест 3")
    void test3() {
        String[] input = new String[]{};

        ArrayList<Task5.Person> answer = new ArrayList<>();

        assertThat(answer).isEqualTo(Task5.parseContacs(input, Task5.Order.DESC));
    }

    @Test
    @DisplayName("Дефолтный тест 4")
    void test4() {
        String[] input = null;

        ArrayList<Task5.Person> answer = new ArrayList<>();

        assertThat(answer).isEqualTo(Task5.parseContacs(input, Task5.Order.DESC));
    }

    @Test
    @DisplayName("Тест содержащий некорректные записи")
    void test5() {
        String[] input = {"Paul Erdos", "Leonhard Euler", "Carl Gauss", "super incorrect record"};

        try {
            Task5.parseContacs(input, Task5.Order.ASC);
        } catch (IllegalArgumentException exception) {
            String answer = "Incorrect record";
            assertThat(answer).isEqualTo(exception.getMessage());
        }
    }

    @Test
    @DisplayName("Тест содержащий записи из имён (обратный порядок)")
    void test6() {
        String[] input = {"Paul Erdos", "Leonhard Euler", "Carl Gauss", "Ivan", "Aleksander"};

        ArrayList<Task5.Person> answer = new ArrayList<>();
        answer.add(new Task5.Person("Ivan", "NaN", false));
        answer.add(new Task5.Person("Aleksander", "NaN", false));
        answer.add(new Task5.Person("Carl", "Gauss", true));
        answer.add(new Task5.Person("Leonhard", "Euler", true));
        answer.add(new Task5.Person("Paul", "Erdos", true));

        assertThat(answer).isEqualTo(Task5.parseContacs(input, Task5.Order.DESC));
    }


}
