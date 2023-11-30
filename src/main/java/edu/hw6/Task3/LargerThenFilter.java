package edu.hw6.Task3;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Path;

public class LargerThenFilter implements DirectoryStream.Filter<Path> {
    private final long size;

    public LargerThenFilter(long size) {
        this.size = size;
    }

    @Override
    public boolean accept(Path entry) throws IOException {
        return entry.toFile().length() > size;
    }
}
