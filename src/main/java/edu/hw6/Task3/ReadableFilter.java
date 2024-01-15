package edu.hw6.Task3;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadableFilter implements DirectoryStream.Filter<Path> {
    private final boolean readable;

    public ReadableFilter(boolean readable) {
        this.readable = readable;
    }

    @Override
    public boolean accept(Path entry) throws IOException {
        return Files.isReadable(entry) == readable;
    }
}
