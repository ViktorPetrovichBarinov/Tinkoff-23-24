package edu.project1;

import java.util.ArrayList;

public class Session {
    private final ArrayList<Letter> answer = new ArrayList<>();
    private final ArrayList<Letter> alphabet = new ArrayList<>();
    private int mistakes;
    private final int maxMistakes = 7;

    public Session(String word) {
        this.mistakes = 0;
        for (int i = 0; i < word.length(); i++) {
            answer.add(new Letter(word.charAt(i)));
        }
        for (char tmpChar = 'a'; tmpChar <= 'z'; tmpChar++) {
            alphabet.add(new Letter(tmpChar));
        }
    }



    public String availableLetters() {
        StringBuilder str = new StringBuilder();
        for (Session.Letter letter : alphabet) {
            if (!letter.tryOnNot) {
                str.append(letter.currChar).append(" ");
            }
        }
        str.deleteCharAt(str.length() - 1);
        return str.toString();
    }

    public String currentUserWord() {
        StringBuilder str = new StringBuilder();
        for (Session.Letter letter : this.answer) {
            if (letter.tryOnNot) {
                str.append(letter.currChar);
            } else {
                str.append("*");
            }
        }
        return str.toString();
    }

    public boolean isCorrectInput(String str) {
        if (str.length() != 1) {
            return false;
        }
        char input = str.charAt(0);
        if (input < 'a' || input > 'z') {
            return  false;
        }
        for (Session.Letter letter : this.alphabet) {
            if (letter.currChar == input && letter.tryOnNot) {
                return false;
            }
        }
        return true;
    }

    public boolean isTryLetter(Character input) {
        for (Session.Letter letter : this.alphabet) {
            if (letter.currChar == input && !letter.tryOnNot) {
                letter.tryOnNot = true;
            }
        }
        int flag = 0;
        for (Session.Letter letter : this.answer) {
            if (letter.currChar == input && !letter.tryOnNot) {
                letter.tryOnNot = true;
                flag = 1;
            }
        }
        if (flag != 0) {
            return true;
        }
        mistakes++;
        return false;
    }

    public boolean isMistakeCheck() {
        return mistakes <= maxMistakes;
    }

    public int getMistakes() {
        return mistakes;

    }

    public int getMaxMistakes() {
        return maxMistakes;
    }

    public boolean isGuessTheWord() {
        for (Session.Letter letter : this.answer) {
            if (!letter.tryOnNot) {
                return false;
            }
        }
        return true;
    }

    @SuppressWarnings("RegexpSinglelineJava")
    public void firstWords() {
        System.out.println("\u001B[35mCurrent word: \u001B[0m" + this.currentUserWord());
        System.out.println("\u001B[35mThese letters are available to you: \u001B[0m"
            + this.availableLetters());
        System.out.println("\u001B[34mNumber mistakes: " + this.getMistakes()
            + " from " + this.getMaxMistakes());
        System.out.println("\u001B[35mEnter only one letter\u001B[0m");
    }

    public static class Letter {
        private final Character currChar;
        private boolean tryOnNot;

        Letter(Character currChar) {
            this.currChar = currChar;
            this.tryOnNot = false;
        }
    }
}
