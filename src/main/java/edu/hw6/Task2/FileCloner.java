package edu.hw6.Task2;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileCloner {
    private FileCloner() {

    }

    public static void cloneFile(Path path) {
        try {
            String fileName = path.toString();
            String mainPartOfFileName = fileName.substring(0, fileName.lastIndexOf('.'));
            String fileExtension = fileName.substring(fileName.lastIndexOf('.'));

            String newFile = fileName;

            int numberOfCopy = 1;

            while (Files.exists(Paths.get(newFile))) {
                if (numberOfCopy == 1) {
                    newFile = mainPartOfFileName + " - копия"  + fileExtension;
                } else {
                    newFile = mainPartOfFileName + " - копия (" + numberOfCopy + ")" + fileExtension;
                }
                numberOfCopy++;
            }

            Files.copy(path, Paths.get(newFile));
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
