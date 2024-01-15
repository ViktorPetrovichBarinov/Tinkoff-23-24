package edu.hw11.Task1;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;

public class HelloWorld {
    private HelloWorld() {

    }

    private static final String METHOD_NAME = "toString";
    private static final String WELCOME_PHRASE = "Hello, ByteBuddy!";

    public static Object createClass() {

        try {
            Class<?> dynamicType = new ByteBuddy()
                .subclass(Object.class)
                .method(ElementMatchers.named(METHOD_NAME))
                .intercept(FixedValue.value(WELCOME_PHRASE))
                .make()
                .load(HelloWorld.class.getClassLoader())
                .getLoaded();
            return dynamicType.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
