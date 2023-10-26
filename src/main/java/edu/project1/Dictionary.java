package edu.project1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dictionary {
    private final List<String> dictionary;
    private static final int MIN_LENGTH = 4;
    private static final int MAX_LENGTH = 15;
    private final Random rand;

    public Dictionary(ArrayList<String> dictionary) {
        this.dictionary = dictionary;
        this.rand = new Random();
    }

    public String getRandomWord() {
        while (!dictionary.isEmpty()) {
            int randIndex = rand.nextInt(this.dictionary.size());
            String word = dictionary.get(randIndex).toLowerCase();
            int wordLength = word.length();
            if (wordLength >= MIN_LENGTH && wordLength <= MAX_LENGTH && onlyLetterCheck(word)) {
                return word;
            }
            dictionary.remove(dictionary.get(randIndex));
        }
        return null;
    }

    //предикат возвращает true - если в слове только буквы
    //возвращает false - если в слове не только буквы
    private boolean onlyLetterCheck(String word) {
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!(currentChar >= 'a' && currentChar <= 'z')) {
                return false;
            }
        }
        return true;
    }
}
