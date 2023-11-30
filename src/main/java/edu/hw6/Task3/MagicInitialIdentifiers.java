package edu.hw6.Task3;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class MagicInitialIdentifiers implements DirectoryStream.Filter<Path> {
    byte[] magicInitialIdentifiers;

    public MagicInitialIdentifiers(byte[] bytes) {
        this.magicInitialIdentifiers = bytes;
    }

    @Override
    public boolean accept(Path entry) throws IOException {
        byte[] buffer = Files.readAllBytes(entry);

        if (buffer.length < magicInitialIdentifiers.length) {
            return false;
        }
        buffer = Arrays.copyOfRange(buffer, 0, magicInitialIdentifiers.length);
        return Arrays.equals(buffer, magicInitialIdentifiers);
    }
}
