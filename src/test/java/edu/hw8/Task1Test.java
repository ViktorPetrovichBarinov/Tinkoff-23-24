package edu.hw8;

import edu.hw8.task1.Client;
import edu.hw8.task1.QuoteBook;
import edu.hw8.task1.Server;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
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

    @Test
    @DisplayName("happy-path тест")
    void test3() throws InterruptedException {
        Server server = new Server(8080, 2);
        Thread serverThread = new Thread(() -> {
            server.start();
        });


        Client client = new Client(8080);
        AtomicReference<ArrayList<String>> list = new AtomicReference<>(new ArrayList<>());


        Thread clientThread = new Thread(() -> {
            list.set((ArrayList<String>) client.userStartUseTest("переходи"));
        });

        serverThread.start();
        clientThread.start();


        clientThread.join();
        serverThread.interrupt();

        ArrayList<String> resultList = list.get();
        if (resultList != null) {
            assertThat(resultList.size()).isEqualTo(1);
            assertThat(resultList.contains("Не переходи на личности там, где их нет.")).isTrue();
        } else {
            System.out.println("Список пуст");
        }
    }
}
