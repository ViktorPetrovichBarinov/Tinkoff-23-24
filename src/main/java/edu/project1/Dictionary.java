package edu.project1;

import java.util.ArrayList;
import java.util.Random;

public class Dictionary {



    private final ArrayList<String> dictionary;
    private final int minLength = 4;
    private final int maxLength = 15;
    private final Random rand;

    public Dictionary() {
        dictionary = new ArrayList<>();
        dictionary.add("Programming");
        dictionary.add("Computer");
        dictionary.add("Development");
        dictionary.add("Game");
        dictionary.add("Algorithm");
        dictionary.add("hello1");
        dictionary.add("cat");
        this.rand = new Random();
    }

    public String getRandomWord() {
        while (!dictionary.isEmpty()) {
            int randIndex = this.rand.nextInt(this.dictionary.size());
            String word = dictionary.get(randIndex).toLowerCase();
            int wordLength = word.length();
            if (wordLength >= minLength && wordLength <= maxLength && onlyLetterCheck(word)) {
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
