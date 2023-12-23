package edu.hw8;

import edu.hw8.task2.FixedThreadPool;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static edu.hw8.task2.Fibonacci.fib;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {

    @Test
    @DisplayName("Проверка первых 3 чисел Фибоначчи")
    void test1() {
        assertThat(fib(0)).isEqualTo(0);
        assertThat(fib(1)).isEqualTo(1);
        assertThat(fib(2)).isEqualTo(1);
    }

    @Test
    @DisplayName("Проверка первых каких-то рандомных чисел")
    void test2() {
        assertThat(fib(29)).isEqualTo(514229);
        assertThat(fib(43)).isEqualTo(433494437);
        assertThat(fib(45)).isEqualTo(1134903170);
    }

    @Test
    @DisplayName("Проверка что многопоточная программа работает")
    void test3() {
        try {
            FixedThreadPool threadPool = new FixedThreadPool(6);
            threadPool.start();
            PrintStream originalOut = System.out;

            try {

                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                PrintStream customOut = new PrintStream(outputStream);
                System.setOut(customOut);



                for (int j = 0; j < 6; j++) {
                    int finalI = 45;
                    Runnable task = new Runnable() {
                        long res;
                        @Override
                        public void run() {
                            res = fib(finalI);
                            //System.out.println(numberOfThreads + " threads [" + finalI + "] = " + res);
                            System.out.print(res + "\n");
                        }
                    };
                    threadPool.execute(task);
                }

                threadPool.close();
                String capturedOutput = outputStream.toString();
                String answer = "1134903170\n1134903170\n1134903170\n1134903170\n1134903170\n1134903170\n";
                assertThat(capturedOutput).isEqualTo(answer);



                if (capturedOutput.contains("Hello, world!")) {
                    System.out.println("Выведено: Hello, world!");
                } else {
                    System.out.println("Что-то другое было выведено.");
                }
            } finally {
                System.setOut(originalOut);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
