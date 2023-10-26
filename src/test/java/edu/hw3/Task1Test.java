package edu.hw3;

import edu.hw3.Task1.Task1;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class Task1Test {
    @Test
    @DisplayName("English alphabet. General letters.")
    void test1() {
        String input = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        String answer = "ZYXWVUTSRQPONMLKJIHGFEDCBA";
        assertThat(answer).isEqualTo(Task1.atbash(input));
    }

    @Test
    @DisplayName("English alphabet. Lowercase letters.")
    void test2() {
        String input = "abcdefghijklmnopqrstuvwxyz";

        String answer = "zyxwvutsrqponmlkjihgfedcba";
        assertThat(answer).isEqualTo(Task1.atbash(input));
    }

    @Test
    @DisplayName("null")
    void test3() {
        String input = null;

        String errorMessage = "The input string cannot be null";
        String errorCause = "IllegalArgumentException";
        try {
            Task1.atbash(input);
        } catch(IllegalArgumentException e) {
            assertThat(errorMessage).isEqualTo(e.getMessage());
        }
    }

    @Test
    @DisplayName("Other symbols")
    void test4() {
        String input = "Hello! My name is Ruslan. I'm 19 y.o.";

        String answer = "Svool! Nb mznv rh Ifhozm. R'n 19 b.l.";
        assertThat(answer).isEqualTo(Task1.atbash(input));
    }
}
