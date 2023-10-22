package edu.project1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DictionaryTest {

    @Test
    @DisplayName("Проверка на то что все слова строчными буквами")
    void test1() {
        Dictionary dic = new Dictionary();
        for (int i = 0; i < 100; i++) {
            assertThat(dic.getRandomWord()).isLowerCase();
        }
    }
}
