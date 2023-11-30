package edu.hw6.Task3;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Path;
import java.util.regex.Pattern;

public class NameRegexFilter implements DirectoryStream.Filter<Path> {
    private final Pattern pattern;

    public NameRegexFilter(String regex) {
        this.pattern = Pattern.compile(regex);
    }

    @Override
    public boolean accept(Path entry) throws IOException {
        return pattern.matcher(entry.getFileName().toString()).matches();
    }
}
