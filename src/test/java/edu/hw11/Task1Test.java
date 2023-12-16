package edu.hw11;

import org.junit.jupiter.api.Test;
import static edu.hw11.Task1.HelloWorld.createClass;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1Test {

    @Test
    public void test() {
        String answer = "Hello, ByteBuddy!";

        assertThat(createClass().toString()).isEqualTo(answer);
    }
}
