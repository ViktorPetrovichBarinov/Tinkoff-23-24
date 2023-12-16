package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw5.Task4.isPasswordValid;
import static org.assertj.core.api.Assertions.assertThat;

public class Task4Test {
    @Test
    @DisplayName("не содержит нужный символ")
    void test1() {
        String test = """
            sdlkfjlashknvbzcxvyuqrtweuyq[wpeo]fdlsl;lcv/znxcm,v x,nx bc zx,
             xckzbkabsld ca,m cajslijf swbenf;vsndv;hslihcqme;fm""";

        assertThat(isPasswordValid(test)).isFalse();
    }

    @Test
    @DisplayName("содержит")
    void test2() {
        String test = "~";

        assertThat(isPasswordValid(test)).isTrue();

        test = "!";

        assertThat(isPasswordValid(test)).isTrue();

        test = "@";

        assertThat(isPasswordValid(test)).isTrue();

        test = "#";

        assertThat(isPasswordValid(test)).isTrue();

        test = "$";

        assertThat(isPasswordValid(test)).isTrue();

        test = "%";

        assertThat(isPasswordValid(test)).isTrue();

        test = "^";

        assertThat(isPasswordValid(test)).isTrue();

        test = "&";

        assertThat(isPasswordValid(test)).isTrue();

        test = "*";

        assertThat(isPasswordValid(test)).isTrue();

        test = "|";

        assertThat(isPasswordValid(test)).isTrue();
    }
}
