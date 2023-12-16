package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw5.Task8.isOddLengthStartsWith0OrEvenLengthStartsWith1;
import static edu.hw5.Task8.isOddLengthString;
import static edu.hw5.Task8.isNumberOf0IsMultipleOf3;
import static edu.hw5.Task8.isAnyStringOtherThan11Or111;
import static org.assertj.core.api.Assertions.assertThat;

public class Task8Test {

    @Test
    @DisplayName("isOddLengthString - передаём строку нечетной длинны")
    void test1() {
        String testString = "100110011";

        assertThat(testString.length() % 2 == 1).isTrue();
        assertThat(isOddLengthString(testString)).isTrue();
    }

    @Test
    @DisplayName("isOddLengthString - передаём пустую строку")
    void test2() {
        String testString = "";

        assertThat(isOddLengthString(testString)).isFalse();
    }

    @Test
    @DisplayName("isOddLengthString - передаём строку четной длинны")
    void test3() {
        String testString = "10011001";

        assertThat(testString.length() % 2 == 0).isTrue();
        assertThat(isOddLengthString(testString)).isFalse();
    }

    @Test
    @DisplayName("isOddLengthStartsWith0OrEvenLengthStartsWith1 - передаём строку нечетной длинны, которая начинается с 0")
    void test4() {
        String testString = "011011001";

        assertThat(testString.length() % 2 == 1).isTrue();
        assertThat(isOddLengthStartsWith0OrEvenLengthStartsWith1(testString)).isTrue();
    }

    @Test
    @DisplayName("isOddLengthStartsWith0OrEvenLengthStartsWith1 - передаём строку чётной длинны, которая начинается с 1")
    void test5() {
        String testString = "1001100111";

        assertThat(testString.length() % 2 == 0).isTrue();
        assertThat(isOddLengthStartsWith0OrEvenLengthStartsWith1(testString)).isTrue();
    }

    @Test
    @DisplayName("isOddLengthStartsWith0OrEvenLengthStartsWith1 - передаём строку четной длинны, которая начинается с 0")
    void test6() {
        String testString = "011010100110";

        assertThat(testString.length() % 2 == 0).isTrue();
        assertThat(isOddLengthStartsWith0OrEvenLengthStartsWith1(testString)).isFalse();
    }

    @Test
    @DisplayName("isOddLengthStartsWith0OrEvenLengthStartsWith1 - передаём строку нечетной длинны, которая начинается с 1")
    void test7() {
        String testString = "110011010";

        assertThat(testString.length() % 2 == 1).isTrue();
        assertThat(isOddLengthStartsWith0OrEvenLengthStartsWith1(testString)).isFalse();
    }

    @Test
    @DisplayName("isNumberOf0IsMultipleOf3 - передаём строку с количеством 0 кратным 3")
    void test8() {
        String testString = "0001000100101010100110011001010001010010010000";

        assertThat(isNumberOf0IsMultipleOf3(testString)).isTrue();
    }

    @Test
    @DisplayName("isNumberOf0IsMultipleOf3 - передаём строку с количеством 0 не кратным 3")
    void test9() {
        String testString = "00010001001010101001100110010100010100100100000000";

        assertThat(isNumberOf0IsMultipleOf3(testString)).isFalse();
    }

    @Test
    @DisplayName("isAnyStringOtherThan11Or111 - передаём строку удовлетворяющую условию")
    void test10() {
        String testString = "1010101011011011010101010110111010101010010010100010101111110110010101";

        assertThat(isAnyStringOtherThan11Or111(testString)).isTrue();
    }

    @Test
    @DisplayName("isAnyStringOtherThan11Or111 - передаём строку не удовлетворяющую условию")
    void test11() {
        String testString = "11";

        assertThat(isAnyStringOtherThan11Or111(testString)).isFalse();


        testString = "111";

        assertThat(isAnyStringOtherThan11Or111(testString)).isFalse();
    }



}
