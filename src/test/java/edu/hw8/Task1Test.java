package edu.hw8;

import edu.hw8.Task1.QuoteBook;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.assertj.core.api.Assertions.assertThat;



public class Task1Test {

    @Test
    @DisplayName("Тест словаря на возврат null, если он ничего не нашел")
    void test1() {
        QuoteBook quoteBook = new QuoteBook();

        assertThat(quoteBook.quoteFinderByKeyWord("123")).isNull();
    }

    @Test
    @DisplayName("Тест словаря на некоторое ключевое слово")
    void test2() {
        QuoteBook quoteBook = new QuoteBook();

        ArrayList<String> answer = new ArrayList<>();
        answer.add("Сходят с ума только те, у кого он есть.");
        answer.add(
            "Что я сделал, чтобы у тебя сложилось впечатление, что меня действительно волнует то, что ты думаешь?");
        answer.add("Зеркала не умеют говорить, к счастью для тебя, они также не умеют смеяться.");

        assertThat(quoteBook.quoteFinderByKeyWord("ум")).isEqualTo(answer);
    }
}
