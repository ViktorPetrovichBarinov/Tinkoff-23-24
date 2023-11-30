package edu.hw6.Task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public class DiskMap implements Map<String, String> {
    private final String fileName;
    private final Map<String, String> memoryMap;

    public DiskMap(String fileName) {
        this.fileName = fileName;
        this.memoryMap = new HashMap<>();
        loadFromDisk();
    }


    private void loadFromDisk() {
        try (FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String buffer;
            while ((buffer = bufferedReader.readLine()) != null) {
                String[] split = buffer.split(":");
                if (split.length == 2) {
                    memoryMap.put(split[0], split[1]);
                } else {
                    throw new IllegalArgumentException("Incorrect file content");
                }
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void saveToDisk() {
        try (FileWriter fileWriter = new FileWriter(fileName);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (Map.Entry<String, String> entry : memoryMap.entrySet()) {
                String writeString = entry.getKey() + ":" + entry.getValue() + "\n";
                bufferedWriter.write(writeString);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }


    @Override
    public int size() {
        return memoryMap.size();
    }

    @Override
    public boolean isEmpty() {
        return memoryMap.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return memoryMap.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return memoryMap.containsValue(value);
    }

    @Override
    public String get(Object key) {
        return memoryMap.get(key);
    }

    @Nullable
    @Override
    public String put(String key, String value) {
        String previousValue = memoryMap.put(key, value);
        saveToDisk();
        return previousValue;
    }

    @Override
    public String remove(Object key) {
        String removeValue = memoryMap.remove(key);
        saveToDisk();
        return removeValue;
    }

    @Override
    public void putAll(@NotNull Map<? extends String, ? extends String> m) {
        memoryMap.putAll(m);
        saveToDisk();
    }

    @Override
    public void clear() {
        memoryMap.clear();
        saveToDisk();
    }

    @NotNull
    @Override
    public Set<String> keySet() {
        return memoryMap.keySet();
    }

    @NotNull
    @Override
    public Collection<String> values() {
        return memoryMap.values();
    }

    @NotNull
    @Override
    public Set<Entry<String, String>> entrySet() {
        return memoryMap.entrySet();
    }
}
