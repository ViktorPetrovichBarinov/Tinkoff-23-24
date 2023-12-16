package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Optional;
import static edu.hw5.Task3.parseDate;
import static org.assertj.core.api.Assertions.assertThat;

public class Task3Test {
//    public static void main(String[] args) {
//        parseDate("2020-10-10");
//        parseDate("2020-12-2");
//        parseDate("1/3/1976");
//        parseDate("1/3/20");
//        parseDate("tomorrow");
//        parseDate("today");
//        parseDate("yesterday");
//        parseDate("1 day ago");
//        parseDate("2234 days ago");
//
//
//    }

    @Test
    @DisplayName("Тест из примера 1")
    void test1() {
        String test = "2020-10-10";

        Optional<LocalDate> answer;
        answer = Optional.of(LocalDate.of(2020, 10, 10));

        assertThat(answer).isEqualTo(parseDate(test));

        test = "2020-12-2";

        answer= Optional.of(LocalDate.of(2020, 12, 2));

        assertThat(answer).isEqualTo(parseDate(test));
    }

    @Test
    @DisplayName("Тест из примера 2")
    void test2() {
        String test = "1/3/1976";

        Optional<LocalDate> answer;
        answer = Optional.of(LocalDate.of(1976, 3, 1));

        assertThat(answer).isEqualTo(parseDate(test));

        test = "1/3/20";

        answer= Optional.of(LocalDate.of(2020, 3, 1));

        assertThat(answer).isEqualTo(parseDate(test));
    }

    @Test
    @DisplayName("Тест из примера 3")
    void test3() {
        String test = "tomorrow";

        Optional<LocalDate> answer;
        answer = Optional.of(LocalDate.now().plusDays(1));

        assertThat(answer).isEqualTo(parseDate(test));

        test = "today";

        answer = Optional.of(LocalDate.now());

        assertThat(answer).isEqualTo(parseDate(test));

        test = "yesterday";

        answer = Optional.of(LocalDate.now().minusDays(1));

        assertThat(answer).isEqualTo(parseDate(test));
    }

    @Test
    @DisplayName("Тест из примера 4")
    void test4() {
        String test = "1 day ago";

        Optional<LocalDate> answer;
        answer = Optional.of(LocalDate.now().minusDays(1));

        assertThat(answer).isEqualTo(parseDate(test));

        test = "2234 days ago";

        answer = Optional.of(LocalDate.now().minusDays(2234));

        assertThat(answer).isEqualTo(parseDate(test));
    }
}
