package edu.hw6.Task4Test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import static edu.hw6.Task4.StreamComposition.writeToFile;
import static org.assertj.core.api.Assertions.assertThat;

public class Task4Test {

    private final static String EXCERPT = "Programming is learned by writing programs. ― Brian Kernighan";

    @Test
    void test1() {
        Path pathToFile = Path.of("src/test/java/edu/hw6/Task4Test/test.txt");
        File file = new File(pathToFile.toString());
        writeToFile(pathToFile);
        try(FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);) {
            String result = bufferedReader.readLine();

            assertThat(EXCERPT).isEqualTo(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Test
    @DisplayName("Создаёт файл если такого ещё нету")
    void test2() {
        Path pathToFile = Path.of("src/test/java/edu/hw6/Task4Test/newFile.txt");
        File file = new File(pathToFile.toString());

        if(file.exists()) {
            file.delete();
        }

        writeToFile(pathToFile);
        assertThat(file.exists()).isTrue();
    }
}
