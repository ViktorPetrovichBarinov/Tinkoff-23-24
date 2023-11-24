package edu.project1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DictionaryTest {

    @Test
    @DisplayName("Проверка на то что все слова строчными буквами")
    void test1() {
        ArrayList<String> words = new ArrayList<>();
        words.add("Programming");
        words.add("Computer");
        words.add("Development");
        words.add("Game");
        words.add("Algorithm");
        words.add("hello1");
        words.add("cat");
        Dictionary dic = new Dictionary(words);
        for (int i = 0; i < 100; i++) {
            assertThat(dic.getRandomWord()).isLowerCase();
        }
    }
}
