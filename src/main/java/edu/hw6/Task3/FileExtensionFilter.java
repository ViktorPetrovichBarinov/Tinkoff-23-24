package edu.hw6.Task3;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Path;

public class FileExtensionFilter implements DirectoryStream.Filter<Path> {
    private final String extension;

    public FileExtensionFilter(String extension) {
        this.extension = extension;
    }

    @Override
    public boolean accept(Path entry) throws IOException {
        return entry.toString().endsWith(extension);
    }
}
