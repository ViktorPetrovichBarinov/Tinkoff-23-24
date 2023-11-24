package edu.hw2;

import edu.hw2.task4.Task4;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Objects;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {

    @Test
    @DisplayName("test ")
    public void test1() {
        String className = Objects.requireNonNull(Task4.callingInfo()).className();
        String methodName = Objects.requireNonNull(Task4.callingInfo()).methodName();

        String classNameAnswer = "edu.hw2.Task4Test";
        String methodNameAnswer = "test1";

        assertThat(classNameAnswer).isEqualTo(className);
        assertThat(methodNameAnswer).isEqualTo(methodName);
    }
}
