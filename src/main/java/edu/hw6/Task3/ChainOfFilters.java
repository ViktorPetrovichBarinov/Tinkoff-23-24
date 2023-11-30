package edu.hw6.Task3;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ChainOfFilters implements DirectoryStream.Filter<Path> {
    private List<DirectoryStream.Filter<Path>> filters;

    public ChainOfFilters() {
        this.filters = new ArrayList<>();
    }

    public ChainOfFilters and(DirectoryStream.Filter<Path> filter) {
        filters.add(filter);
        return this;

    }

    @Override
    public boolean accept(Path entry) throws IOException {
        for (DirectoryStream.Filter<Path> filter : filters) {
            if (!filter.accept(entry)) {
                return false;
            }
        }
        return true;
    }
}
