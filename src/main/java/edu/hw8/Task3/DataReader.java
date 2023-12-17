package edu.hw8.Task3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

public class DataReader {
    private DataReader() {

    }

    public static HashMap<String, String> readFromFile(String filePath) {
        HashMap<String, String> dataMap = new HashMap<>();

        try {
            Path path = Paths.get(filePath);

            // Читаем все строки из файла
            List<String> lines = Files.readAllLines(path);

            // Разбираем каждую строку и добавляем данные в HashMap
            for (String line : lines) {
                String[] parts = line.split("\\s+");
                if (parts.length == 2) {
                    dataMap.put(parts[1], parts[0]);
                }
            }
        } catch (IOException e) {

        }
        return dataMap;
    }

}
