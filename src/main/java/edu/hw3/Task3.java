package edu.hw3;

import java.util.HashMap;

public class Task3 {
    private Task3() {

    }

    public static <T> HashMap<T, Integer> freqDict(T[] inputArray) {
        if (inputArray == null) {
            throw new IllegalArgumentException("The input array cannot be null");
        }
        HashMap<T, Integer> dictionary = new HashMap<>();
        for (T elementOfInputArray : inputArray) {
            if (!dictionary.containsKey(elementOfInputArray)) {
                dictionary.put(elementOfInputArray, 1);
            } else {
                dictionary.put(elementOfInputArray, dictionary.get(elementOfInputArray) + 1);
            }
        }
        return dictionary;
    }
}
