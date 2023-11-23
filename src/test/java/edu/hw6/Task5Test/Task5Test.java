package edu.hw6.Task5Test;

import net.bytebuddy.matcher.ElementMatchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.regex.Matcher;
import static edu.hw6.Task5.HackerNews.hackerNewsTopStories;
import static edu.hw6.Task5.HackerNews.news;
import static org.assertj.core.api.Assertions.assertThat;

public class Task5Test {

    @Test
    @DisplayName("hackerNewsTopStories - проверка некоторых значений возвращаемого масива")
    void test1() {
        long[] array = hackerNewsTopStories();

        for (long element : array) {
            assertThat(element).isGreaterThan(30000000L);
            assertThat(element).isLessThan(100000000L);

        }

    }

    @Test
    @DisplayName("news - проверка некоторых значений возвращаемого названия")
    void test2() {
        assertThat(news(38394364)).isEqualTo("\"Developer account removed by Apple – $108,878 frozen\"");
        assertThat(news(37571340)).isNull();
        assertThat(news(38396345)).isEqualTo("\"Shellcheck finds bugs in your shell scripts\"");
    }
}
