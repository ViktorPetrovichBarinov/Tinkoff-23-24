package edu.hw11;

import edu.hw11.Task2.ArithmeticUtils;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.implementation.MethodCall;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.implementation.bind.annotation.AllArguments;
import net.bytebuddy.implementation.bind.annotation.SuperCall;
import net.bytebuddy.matcher.ElementMatchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Proxy;
import java.util.concurrent.Callable;

import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {
    private final static String METHOD_NAME = "action";

    @Test
    @DisplayName("Изменил поведение на константное значение")
    void test1() throws InstantiationException, IllegalAccessException {
        int a = 2;
        int b = 3;
        int answer = 1000;


        Class<? extends ArithmeticUtils> dynamicType = new ByteBuddy()
            .subclass(ArithmeticUtils.class)
            .method(ElementMatchers.named(METHOD_NAME))
            .intercept(FixedValue.value(answer))
            .make()
            .load(getClass().getClassLoader())
            .getLoaded();

        ArithmeticUtils test = dynamicType.newInstance();

        assertThat(test.action(a, b)).isEqualTo(answer);
    }

    @Test
    @DisplayName("На умножение")
    void test2() throws InstantiationException, IllegalAccessException {
        int a = 2;
        int b = 3;
        int answer = a * b;
        Class<? extends ArithmeticUtils> dynamicType = new ByteBuddy()
            .subclass(ArithmeticUtils.class)
            .method(ElementMatchers.named(METHOD_NAME))
            .intercept(FixedValue.value(answer))
            .make()
            .load(getClass().getClassLoader())
            .getLoaded();

        ArithmeticUtils test = dynamicType.newInstance();

        
        assertThat(test.action(a, b)).isEqualTo(answer);
    }
}
