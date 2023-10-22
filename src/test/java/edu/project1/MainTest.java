package edu.project1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MainTest {

    @Test
    @DisplayName("test")
    public void test1() {
        String input = "Hello\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String ans = "Hello";
        String result = Main.nextInput();
        assertThat(ans).isEqualTo(result);
    }
}
