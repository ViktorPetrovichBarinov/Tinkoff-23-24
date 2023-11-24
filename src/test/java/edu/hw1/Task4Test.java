package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task4Test {

    @Test
    @DisplayName("Певрый пример")
    void example1() {
        String givenString = "123456";

        String answer = "214365";

        assertThat(answer).isEqualTo(Task4.fixString(givenString));
    }

    @Test
    @DisplayName("Второй пример")
    void example2() {
        String givenString = "hTsii  s aimex dpus rtni.g";

        String answer = "This is a mixed up string.";

        assertThat(answer).isEqualTo(Task4.fixString(givenString));
    }

    @Test
    @DisplayName("Третий пример")
    void example3() {
        String givenString = "badce";

        String answer = "abcde" ;

        assertThat(answer).isEqualTo(Task4.fixString(givenString));
    }

    @Test
    @DisplayName("Пустая строка")
    void example4() {
        String givenString = "";

        String answer = "" ;

        assertThat(answer).isEqualTo(Task4.fixString(givenString));
    }

    @Test
    @DisplayName("Один символ")
    void example5() {
        String givenString = "?";

        String answer = "?" ;

        assertThat(answer).isEqualTo(Task4.fixString(givenString));
    }

    @Test
    @DisplayName("Длинная строка")
    void example6() {
        String givenString = "192380739847hflajsvlnzbxvlnlaoihdflianlva892983479whdqhwd9283ueydhasjhcn082u109uxjoakslnx018uydqhsx";

        String answer = "913208378974fhalsjlvznxblvlnoahifdilnavl8a29894397hwqdwh9d82u3yehdsahjnc80u201u9jxaosknl0x81yuqdshx" ;

        assertThat(answer).isEqualTo(Task4.fixString(givenString));
    }
}
