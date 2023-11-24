package edu.hw3;

import edu.hw3.task7.NullHandlingComparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.TreeMap;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {

    @Test
    @DisplayName("Дефолтный тест")
    void test1() {
        TreeMap<String, String> tree = new TreeMap<>(new NullHandlingComparator<>());
        tree.put(null, "test");

        assertThat(tree.containsKey(null)).isTrue();
    }

    @Test
    @DisplayName("Null значение")
    void test2() {
        TreeMap<String, String> tree = new TreeMap<>(new NullHandlingComparator<>());
        tree.put("test", null);

        assertThat(tree.containsKey("test")).isTrue();
        assertThat(tree.containsValue(null)).isTrue();
    }

    @Test
    @DisplayName("Null значение и ключ")
    void test3() {
        TreeMap<String, String> tree = new TreeMap<>(new NullHandlingComparator<>());
        tree.put(null, null);

        assertThat(tree.containsKey(null)).isTrue();
        assertThat(tree.containsValue(null)).isTrue();
    }
}
