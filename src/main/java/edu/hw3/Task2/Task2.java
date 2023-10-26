package edu.hw3.Task2;

import java.awt.List;

public class Task2 {

    public static List clusterize(String inputString) {
        List cluster = new List();
        int numberOfOpenParenthesis = 0;
        int numberOfCloseParanthesis = 0;
        StringBuilder currentElementOfList = null;
        for (int i = 0; i < inputString.length(); i++) {
            if (numberOfCloseParanthesis == 0 && numberOfOpenParenthesis == 0) {
                currentElementOfList = new StringBuilder();
            }
            if (inputString.charAt(i) == '(') {
                numberOfOpenParenthesis++;
                currentElementOfList.append('(');
            }
            
            
        }
    }
}
