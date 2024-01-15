package edu.hw10.Task1;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Random;

//Класс, для генерации методов на основе рефлексии
public class RandomObjectGenerator {
    private final static int NUMBER_OF_ENGLISH_LETTERS = 26;
    private final static int MAX_RANDOM_STRING_LENGTH = 100;
    private final static int MIN_RANDOM_STRING_LENGTH = 10;
    private final static double MAX_LIMIT_FOR_DOUBLE_GENERATOR = 100.0;
    private final static double HALF_OF_ONE = 0.5;
    private final static String ERROR_CREATING_INSTANCE_OF = "Error creating instance of ";
    private final Random random;

    public RandomObjectGenerator(Random random) {
        this.random = random;
    }

    public <T> T nextObject(Class<T> randomClass) {
        try {
            Constructor<?> randomConstructor = getRandomConstructor(randomClass);
            randomConstructor.setAccessible(true);

            Class<?>[] argTypes = randomConstructor.getParameterTypes();

            Parameter[] parameters = randomConstructor.getParameters();


            Object[] args = generateArgs(argTypes, parameters);

            Object instance = randomConstructor.newInstance(args);
            return randomClass.cast(instance);

        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(ERROR_CREATING_INSTANCE_OF + randomClass.getSimpleName(), e);
        }
    }

    public <T> T nextObject(Class<T> randomClass, String method) {
        try {
            Method fabricMethod = getRandomFabricMethod(randomClass, method);
            fabricMethod.setAccessible(true);

            Class<?>[] argTypes = fabricMethod.getParameterTypes();

            Parameter[] parameters = fabricMethod.getParameters();

            Object[] args = generateArgs(argTypes, parameters);

            Object instance = fabricMethod.invoke(null, args);
            return  randomClass.cast(instance);
        } catch (InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(ERROR_CREATING_INSTANCE_OF + randomClass.getSimpleName(), e);
        }
    }

    private Method getRandomFabricMethod(Class<?> randomClass, String methodName) {
        //Получаем все методы
        Method[] methods = randomClass.getDeclaredMethods();

        ArrayList<Method> fabricMethods = new ArrayList<>();
        for (Method currentMethod : methods) {
            if (currentMethod.getName().equals(methodName)) {
                fabricMethods.add(currentMethod);
            }
        }

        if (fabricMethods.isEmpty()) {
            throw new IllegalArgumentException("Class has no fabric method");
        }

        int randomFabricMethodMethodIndex = random.nextInt(fabricMethods.size());

        return fabricMethods.get(randomFabricMethodMethodIndex);
    }

    private Constructor<?> getRandomConstructor(Class<?> randomClass) {
        Constructor<?>[] constructors = randomClass.getDeclaredConstructors();

        //Если конструкторов не найдено, то экземпляр не создать
        if (constructors.length == 0) {
            throw new IllegalArgumentException("Class has no constructors");
        }

        //выбираем любой конструктор из предастваленных
        int constructorIndex = random.nextInt(constructors.length);
        return constructors[constructorIndex];
    }

    //генерирует массив аргументов
    private Object[] generateArgs(Class<?>[] argTypes, Parameter[] parameters) {





        //создаём массив объектов - это будующие аргументы для конструктора класса
        int numberOfArguments = argTypes.length;
        Object[] args = new Object[numberOfArguments];

        for (int i = 0; i < numberOfArguments; i++) {
            Annotation[] annotations = parameters[i].getAnnotations();
            args[i] = generateRandomObject(argTypes[i], annotations);
        }

        return args;
    }

    //В зависимости от типа поля, генерирует свой объект
    //Для поддержки новых типов надо добавить case по названию типа
    //И метод генерации, который будет вызываться в case-блоке
    @SuppressWarnings("ReturnCount")
    private Object generateRandomObject(Class<?> type, Annotation[] annotations) {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;

        for (int i = 0; i < annotations.length; i++) {
            if (annotations[i] instanceof  Max) {
                max = ((Max) annotations[i]).value();
            } else if (annotations[i] instanceof Min) {
                min = ((Min) annotations[i]).value();
            }
        }

        switch (type.getSimpleName()) {
            case "int":
            case "Integer":
                return generateRandomInteger(min, max);
            case "double":
            case "Double":
                return generateRandomDouble();
            case "boolean":
            case "Boolean":
                return random.nextBoolean();
            case "char":
            case "Character":
                return generateRandomChar();
            case "String":
                return generateRandomString();
            default:
                throw new IllegalArgumentException(type.getSimpleName() + " not implemented yet");
        }
    }

    private int generateRandomInteger(int min, int max) {
        int ret = random.nextInt();
        if (ret >= 0) {
            return ret % max;
        } else {
            return -(Math.abs(ret) % Math.abs(min));
        }
    }

    private double generateRandomDouble() {
        return (random.nextDouble() - HALF_OF_ONE) * 2 * MAX_LIMIT_FOR_DOUBLE_GENERATOR;
    }

    private char generateRandomChar() {
        int randInt = random.nextInt();
        int randomIndexEnglishLetter = random.nextInt(NUMBER_OF_ENGLISH_LETTERS);
        if (randInt % 2 == 0) {
            return (char) ('a' + randomIndexEnglishLetter);
        } else {
            return (char) ('A' + randomIndexEnglishLetter);
        }
    }

    private String generateRandomString() {
        int randLength = random.nextInt(MAX_RANDOM_STRING_LENGTH - MIN_RANDOM_STRING_LENGTH) + MIN_RANDOM_STRING_LENGTH;
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < randLength; i++) {
            answer.append(generateRandomChar());
        }
        return answer.toString();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.PARAMETER)
    public @interface Min {
        int value() default Integer.MIN_VALUE;
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.PARAMETER})
    public @interface Max {
        int value() default Integer.MAX_VALUE;
    }
}
