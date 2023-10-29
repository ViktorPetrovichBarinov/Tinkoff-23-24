package edu.hw3;

import java.util.ArrayList;

public class Task2 {

    private Task2() {

    }

    public static ArrayList<String> clusterize(String inputString) {
        if (inputString == null) {
            throw new IllegalArgumentException("The input string cannot be null");
        }

        ArrayList<String> cluster = new ArrayList<>();
        int numberOfOpenParenthesis = 0;
        int numberOfCloseParenthesis = 0;
        StringBuilder currentElementOfList = null;
        for (int i = 0; i < inputString.length(); i++) {
            if (numberOfCloseParenthesis == 0 && numberOfOpenParenthesis == 0) {
                currentElementOfList = new StringBuilder();
            }
            if (inputString.charAt(i) == '(') {
                numberOfOpenParenthesis++;
                currentElementOfList.append('(');
            }
            if (inputString.charAt(i) == ')') {
                if (numberOfOpenParenthesis == 0) {
                    continue;
                }
                numberOfCloseParenthesis++;
                currentElementOfList.append(')');
            }
            if (numberOfOpenParenthesis == numberOfCloseParenthesis) {
                cluster.add(currentElementOfList.toString());
                numberOfCloseParenthesis = 0;
                numberOfOpenParenthesis = 0;
            }
        }
        return cluster;
    }
}
