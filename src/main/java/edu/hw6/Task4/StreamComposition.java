package edu.hw6.Task4;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.zip.Adler32;
import java.util.zip.CheckedOutputStream;

public class StreamComposition {
    private StreamComposition() {
    }

    private final static String EXCERPT = "Programming is learned by writing programs. ― Brian Kernighan";

    public static void writeToFile(Path filePath) {
        File file = new File(filePath.toString());
        try (
            OutputStream defaultOutputStream = new FileOutputStream(file);
            CheckedOutputStream checkedOutputStreamStream = new CheckedOutputStream(defaultOutputStream, new Adler32());
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(checkedOutputStreamStream);
            OutputStreamWriter outputStreamWriter =
                new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);
            PrintWriter printWriter = new PrintWriter(outputStreamWriter);
            ) {
            printWriter.println(EXCERPT);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
