package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {

    @Test
    @DisplayName("null")
    void test1() {
        String[] input = null;

        try {
            Task3.freqDict(input);
        } catch (IllegalArgumentException error){
            String errorMessage = "The input array cannot be null";
            assertThat(errorMessage).isEqualTo(error.getMessage());
        }
    }

    @Test
    @DisplayName("Дефолтный тест 1")
    void test2() {
        String[] input = new String[] {"a", "bb", "a", "bb"};

        HashMap<String, Integer> answer = new HashMap<>();
        answer.put("a", 2);
        answer.put("bb", 2);

        assertThat(answer).isEqualTo(Task3.freqDict(input));
    }

    @Test
    @DisplayName("Дефолтный тест 2")
    void test3() {
        String[] input = new String[] {"this", "and", "that", "and"};

        HashMap<String, Integer> answer = new HashMap<>();
        answer.put("this", 1);
        answer.put("and", 2);
        answer.put("that", 1);

        assertThat(answer).isEqualTo(Task3.freqDict(input));
    }

    @Test
    @DisplayName("Дефолтный тест 3")
    void test4() {
        String[] input = new String[] {"код", "код", "код", "bug"};

        HashMap<String, Integer> answer = new HashMap<>();
        answer.put("код", 3);
        answer.put("bug", 1);

        assertThat(answer).isEqualTo(Task3.freqDict(input));
    }

    @Test
    @DisplayName("Дефолтный тест 4")
    void test5() {
        Integer[] input = new Integer[] {1, 1, 2, 2};

        HashMap<Integer, Integer> answer = new HashMap<>();
        answer.put(1, 2);
        answer.put(2, 2);

        assertThat(answer).isEqualTo(Task3.freqDict(input));
    }
}
