package edu.hw6.Task2Test;

import edu.hw6.Task2.FileCloner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Path;
import static edu.hw6.Task2.FileCloner.cloneFile;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {

    @Test
    @DisplayName("Дефолтный тест")
    void test1() {
        String fileName = "src/test/java/edu/hw6/Task2Test/Tinkoff Bank Biggest Secret.txt";
        String testFileName1 = "src/test/java/edu/hw6/Task2Test/Tinkoff Bank Biggest Secret - копия.txt";
        String testFileName2 = "src/test/java/edu/hw6/Task2Test/Tinkoff Bank Biggest Secret - копия (2).txt";
        String testFileName3 = "src/test/java/edu/hw6/Task2Test/Tinkoff Bank Biggest Secret - копия (3).txt";
        String testFileName4 = "src/test/java/edu/hw6/Task2Test/Tinkoff Bank Biggest Secret - копия (4).txt";

        Path path = Path.of(fileName);

        cloneFile(path);
        cloneFile(path);
        cloneFile(path);

        assertThat(Files.exists(Path.of(testFileName1))).isTrue();
        assertThat(Files.exists(Path.of(testFileName2))).isTrue();
        assertThat(Files.exists(Path.of(testFileName3))).isTrue();
        assertThat(Files.exists(Path.of(testFileName4))).isFalse();

        try {
            Files.delete(Path.of(testFileName1));
            Files.delete(Path.of(testFileName2));
            Files.delete(Path.of(testFileName3));
        } catch (Exception ignored) {

        }

    }
}
