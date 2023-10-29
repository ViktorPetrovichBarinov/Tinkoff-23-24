package edu.hw3;

public class Task1 {
    private Task1() {

    }

    public static String atbash(String inputString) {
        if (inputString == null) {
            throw new IllegalArgumentException("The input string cannot be null");
        }
        StringBuilder answerString = new StringBuilder();
        for (int i = 0; i < inputString.length(); i++) {
            answerString.append(oppositeLetter(inputString.charAt(i)));
        }
        return answerString.toString();
    }

    public static char oppositeLetter(char inputChar) {
        if (inputChar >= 'A' && inputChar <= 'Z') {
            return (char) ('Z' - (inputChar - 'A'));
        }
        if (inputChar >= 'a' && inputChar <= 'z') {
            return (char) ('z' - (inputChar - 'a'));
        }
        return inputChar;
    }
}
