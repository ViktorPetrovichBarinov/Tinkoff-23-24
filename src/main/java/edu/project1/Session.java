package edu.project1;

import java.util.ArrayList;

public class Session {
    private ArrayList<letter> answer = new ArrayList<>();
    private ArrayList<letter> alphabet = new ArrayList<>();
    private int mistakes;
    private final int maxMistakes = 7;
    public Session(String word) {
        this.mistakes = 0;
        for (int i = 0; i < word.length(); i++) {
            answer.add(new letter(word.charAt(i)));
        }
        for (char tmpChar = 'a'; tmpChar <= 'z'; tmpChar++) {
            alphabet.add(new letter(tmpChar));
        }
    }

    public static class letter{
        private final Character currChar;
        private boolean tryOnNot;

        letter(Character currChar){
            this.currChar = currChar;
            this.tryOnNot = false;
        }
    }
    public String availableLetters(){
        StringBuilder str = new StringBuilder();
        for (Session.letter letter : alphabet) {
            if (!letter.tryOnNot) {
                str.append(letter.currChar).append(" ");
            }
        }
        str.deleteCharAt(str.length() - 1);
        return str.toString();
    }
    public String currentUserWord() {
        StringBuilder str = new StringBuilder();
        for (Session.letter letter : this.answer) {
            if (letter.tryOnNot) {
                str.append(letter.currChar);
            } else {
                str.append("*");
            }
        }
        return str.toString();
    }

    public boolean correctInput(String str) {
        if (str.length() != 1) {
            return false;
        }
        char input = str.charAt(0);
        if (input < 'a' || input > 'z'){
            return  false;
        }
        for (Session.letter letter : this.alphabet) {
            if (letter.currChar == input && letter.tryOnNot) {
                return false;
            }
        }
        return true;
    }

    public boolean tryLetter(Character input){
        for (Session.letter letter : this.alphabet) {
            if (letter.currChar == input && !letter.tryOnNot) {
                letter.tryOnNot = true;
            }
        }
        int flag = 0;
        for (Session.letter letter : this.answer) {
            if (letter.currChar == input && !letter.tryOnNot) {
                letter.tryOnNot = true;
                flag = 1;
            }
        }
        return flag != 0;
    }

    public boolean mistakesUp() {
        this.mistakes++;
        return this.mistakes <= maxMistakes;
    }

    public int getMistakes() {
        return mistakes;
    }
    public int getMaxMistakes() {
        return maxMistakes;
    }

    public boolean guessTheWord() {
        for (Session.letter letter : this.answer) {
            if (!letter.tryOnNot) {
                return false;
            }
        }
        return true;
    }
}
