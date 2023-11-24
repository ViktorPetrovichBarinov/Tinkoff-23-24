package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {

    @Test
    @DisplayName("Стандартный тест 1")
    void test1() {
        String input = "()()()";

        ArrayList<String> answer = new ArrayList<>();
        answer.add("()");
        answer.add("()");
        answer.add("()");

        assertThat(answer).isEqualTo(Task2.clusterize(input));
    }

    @Test
    @DisplayName("Стандартный тест 2")
    void test2() {
        String input = "((()))";

        ArrayList<String> answer = new ArrayList<>();
        answer.add("((()))");

        assertThat(answer).isEqualTo(Task2.clusterize(input));
    }

    @Test
    @DisplayName("Стандартный тест 3")
    void test3() {
        String input = "((()))(())()()(()())";

        ArrayList<String> answer = new ArrayList<>();
        answer.add("((()))");
        answer.add("(())");
        answer.add("()");
        answer.add("()");
        answer.add("(()())");

        assertThat(answer).isEqualTo(Task2.clusterize(input));
    }

    @Test
    @DisplayName("Стандартный тест 4")
    void test4() {
        String input = "((())())(()(()()))";

        ArrayList<String> answer = new ArrayList<>();
        answer.add("((())())");
        answer.add("(()(()()))");

        assertThat(answer).isEqualTo(Task2.clusterize(input));
    }

    @Test
    @DisplayName("null")
    void test5() {
        String input = null;

        try {
            Task2.clusterize(input);
        } catch (IllegalArgumentException error){
            String errorMessage = "The input string cannot be null";
            assertThat(errorMessage).isEqualTo(error.getMessage());
        }
    }

    @Test
    @DisplayName("Не сбалансированный кластер")
    void test6() {
        String input = "(())((()())(()()))(((())";

        ArrayList<String> answer = new ArrayList<>();
        answer.add("(())");
        answer.add("((()())(()()))");

        assertThat(answer).isEqualTo(Task2.clusterize(input));
    }

    @Test
    @DisplayName("Закрывающая скобка перед открывающей")
    void test7() {
        String input = "))))(())((((";

        ArrayList<String> answer = new ArrayList<>();
        answer.add("(())");

        assertThat(answer).isEqualTo(Task2.clusterize(input));
    }
}
