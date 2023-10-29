package edu.hw3;

import edu.hw3.task8.BackwardIterator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task8Test {
    @Test
    @DisplayName("Дефолтный тест 1")
    void test1() {
        BackwardIterator<Integer> backwardIterator = new BackwardIterator<>(List.of(1, 2, 3));

        for (int i = 3; i > 0; i--) {
            assertThat(backwardIterator.hasNext()).isTrue();
            assertThat(i).isEqualTo(backwardIterator.next());
        }
        assertThat(backwardIterator.hasNext()).isFalse();
    }
}
