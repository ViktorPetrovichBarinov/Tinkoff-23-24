package edu.hw6.Task3;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class WritableFilter implements DirectoryStream.Filter<Path> {
    private final boolean writable;

    public WritableFilter(boolean readable) {
        this.writable = readable;
    }

    @Override
    public boolean accept(Path entry) throws IOException {
        return Files.isWritable(entry) == writable;
    }
}
