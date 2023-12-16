package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw5.Task6.isSubString;
import static org.assertj.core.api.Assertions.assertThat;

public class Task6Test {

    @Test
    @DisplayName("Содержит")
    void test1() {
        String subString = "aa";
        String string = "qwertyuiop[ashjkl;dmzxnmbaa.mfghjkl;bnm,";

        assertThat(isSubString(subString, string)).isTrue();
    }

    @Test
    @DisplayName("Не содержит")
    void test2() {
        String subString = "aa";
        String string = "qwertyuiop[ashjkl;dmzxnmba.mfghjkl;bnm,";

        assertThat(isSubString(subString, string)).isFalse();
    }
}
