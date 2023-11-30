package edu.hw6.Task3Test;


import edu.hw6.Task3.ChainOfFilters;
import edu.hw6.Task3.FileExtensionFilter;
import edu.hw6.Task3.LargerThenFilter;
import edu.hw6.Task3.MagicInitialIdentifiers;
import edu.hw6.Task3.NameRegexFilter;
import edu.hw6.Task3.ReadableFilter;
import edu.hw6.Task3.WritableFilter;
import org.apache.logging.log4j.core.filter.CompositeFilter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class Task3Test {
    @Test
    @DisplayName("Readable")
    void test1() {
        String dirName = "src/test/java/edu/hw6/Task3Test/resources";
        Path dirPath = Path.of(dirName);

        try (DirectoryStream<Path> dirStream = java.nio.file.Files.newDirectoryStream(dirPath, new ReadableFilter(true))) {
            int numberOfDirectories = 0;
            for (Path entry : dirStream) {
                numberOfDirectories++;
            }
            assertThat(numberOfDirectories).isEqualTo(5);
        } catch (IOException e) {

        }
    }

    @Test
    @DisplayName("Writable")
    void test2() {
        String dirName = "src/test/java/edu/hw6/Task3Test/resources";
        Path dirPath = Path.of(dirName);

        try (DirectoryStream<Path> dirStream = java.nio.file.Files.newDirectoryStream(dirPath, new WritableFilter(true))) {
            int numberOfDirectories = 0;
            for (Path entry : dirStream) {
                numberOfDirectories++;
            }
            assertThat(numberOfDirectories).isEqualTo(5);
        } catch (IOException e) {

        }
    }

    @Test
    @DisplayName("LargerThen")
    void test3() {
        String dirName = "src/test/java/edu/hw6/Task3Test/resources";
        Path dirPath = Path.of(dirName);
        List<Path> filteredFiles = new ArrayList<>();

        Path answer1 = Path.of("src/test/java/edu/hw6/Task3Test/resources/prog1.c");
        Path answer2 = Path.of("src/test/java/edu/hw6/Task3Test/resources/prog2.c");

        try (DirectoryStream<Path> dirStream = java.nio.file.Files.newDirectoryStream(dirPath, new LargerThenFilter(10))) {
            int numberOfDirectories = 0;
            for (Path entry : dirStream) {
                numberOfDirectories++;
                filteredFiles.add(entry);
            }
            assertThat(numberOfDirectories).isEqualTo(2);
            assertThat(filteredFiles.contains(answer1)).isTrue();
            assertThat(filteredFiles.contains(answer2)).isTrue();
        } catch (IOException e) {

        }
    }

    @Test
    @DisplayName("File extension")
    void test4() {
        String dirName = "src/test/java/edu/hw6/Task3Test/resources";
        Path dirPath = Path.of(dirName);
        List<Path> filteredFiles = new ArrayList<>();

        Path answer1 = Path.of("src/test/java/edu/hw6/Task3Test/resources/prog1.c");
        Path answer2 = Path.of("src/test/java/edu/hw6/Task3Test/resources/prog2.c");

        try (DirectoryStream<Path> dirStream = java.nio.file.Files.newDirectoryStream(dirPath, new FileExtensionFilter(".c"))) {
            int numberOfDirectories = 0;
            for (Path entry : dirStream) {
                numberOfDirectories++;
                filteredFiles.add(entry);
            }
            assertThat(numberOfDirectories).isEqualTo(2);
            assertThat(filteredFiles.contains(answer1)).isTrue();
            assertThat(filteredFiles.contains(answer2)).isTrue();
        } catch (IOException e) {

        }

        answer1 = Path.of("src/test/java/edu/hw6/Task3Test/resources/text1.txt");
        answer2 = Path.of("src/test/java/edu/hw6/Task3Test/resources/text2.txt");

        try (DirectoryStream<Path> dirStream = java.nio.file.Files.newDirectoryStream(dirPath, new FileExtensionFilter(".txt"))) {
            int numberOfDirectories = 0;
            for (Path entry : dirStream) {
                numberOfDirectories++;
                filteredFiles.add(entry);
            }
            assertThat(numberOfDirectories).isEqualTo(2);
            assertThat(filteredFiles.contains(answer1)).isTrue();
            assertThat(filteredFiles.contains(answer2)).isTrue();
        } catch (IOException e) {

        }
    }

    @Test
    @DisplayName("Regex filter")
    void test5() {
        String dirName = "src/test/java/edu/hw6/Task3Test/resources";
        Path dirPath = Path.of(dirName);
        List<Path> filteredFiles = new ArrayList<>();

        Path answer1 = Path.of("src/test/java/edu/hw6/Task3Test/resources/prog1.c");
        Path answer2 = Path.of("src/test/java/edu/hw6/Task3Test/resources/text1.txt");

        try (DirectoryStream<Path> dirStream = java.nio.file.Files.newDirectoryStream(dirPath, new NameRegexFilter(".*1.*"))) {
            int numberOfDirectories = 0;
            for (Path entry : dirStream) {
                numberOfDirectories++;
                filteredFiles.add(entry);
            }
            assertThat(numberOfDirectories).isEqualTo(2);
            assertThat(filteredFiles.contains(answer1)).isTrue();
            assertThat(filteredFiles.contains(answer2)).isTrue();
        } catch (IOException e) {

        }

        answer1 = Path.of("src/test/java/edu/hw6/Task3Test/resources/text2.txt");
        answer2 = Path.of("src/test/java/edu/hw6/Task3Test/resources/prog2.c");

        try (DirectoryStream<Path> dirStream = java.nio.file.Files.newDirectoryStream(dirPath, new NameRegexFilter(".*2.*"))) {
            int numberOfDirectories = 0;
            for (Path entry : dirStream) {
                numberOfDirectories++;
                filteredFiles.add(entry);
            }
            assertThat(numberOfDirectories).isEqualTo(2);
            assertThat(filteredFiles.contains(answer1)).isTrue();
            assertThat(filteredFiles.contains(answer2)).isTrue();
        } catch (IOException e) {

        }
    }

    @Test
    @DisplayName("Magic initialIdentifiers")
    void test6() {
        String dirName = "src/test/java/edu/hw6/Task3Test/resources";
        Path dirPath = Path.of(dirName);
        byte[] byteArr = new byte[]{(byte) '0', (byte) '1'};
        List<Path> filteredFiles = new ArrayList<>();

        try (DirectoryStream<Path> dirStream = java.nio.file.Files.newDirectoryStream(dirPath, new MagicInitialIdentifiers(byteArr))) {
            int numberOfDirectories = 0;
            for (Path entry : dirStream) {
                numberOfDirectories++;
                filteredFiles.add(entry);
            }

            Path answer = Path.of("src/test/java/edu/hw6/Task3Test/resources/binary.bin");
            assertThat(numberOfDirectories).isEqualTo(1);
            assertThat(filteredFiles.contains(answer)).isTrue();
        } catch (IOException e) {

        }
    }

    @Test
    @DisplayName("Filter chain")
    void test7() {
        String dirName = "src/test/java/edu/hw6/Task3Test/resources";
        Path dirPath = Path.of(dirName);
        byte[] byteArr = new byte[]{(byte) '0', (byte) '1'};
        List<Path> filteredFiles = new ArrayList<>();

        ChainOfFilters compositeFilter = new ChainOfFilters()
            .and(new WritableFilter(true))
            .and(new ReadableFilter(true))
            .and(new MagicInitialIdentifiers(byteArr));

        try (DirectoryStream<Path> dirStream = java.nio.file.Files.newDirectoryStream(dirPath, compositeFilter)) {
            int numberOfDirectories = 0;
            for (Path entry : dirStream) {
                numberOfDirectories++;
                filteredFiles.add(entry);
            }

            Path answer = Path.of("src/test/java/edu/hw6/Task3Test/resources/binary.bin");
            assertThat(numberOfDirectories).isEqualTo(1);
            assertThat(filteredFiles.contains(answer)).isTrue();
        } catch (IOException e) {

        }
    }
}
