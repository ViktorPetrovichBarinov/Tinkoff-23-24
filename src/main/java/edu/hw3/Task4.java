package edu.hw3;

public class Task4 {
    private Task4() {

    }

    @SuppressWarnings("MagicNumber")
    public static RomanData romanData = new RomanData(
        new int[] {1000, 500, 100, 50, 10, 5, 1},
        new char[] {'M', 'D', 'C', 'L', 'X', 'V', 'I'}
    );

    public static final int MAX_ROMAN_NUMBER = 3999;

    @SuppressWarnings("MagicNumber")
    public  static String convertToRoman(int arabianNumber) {
        if (arabianNumber > MAX_ROMAN_NUMBER  || arabianNumber < 1) {
            throw new IllegalArgumentException("Incorrect input number.");
        }
        StringBuilder romanNumber = new StringBuilder();
        int rest = arabianNumber;


        for (int i = 0; i < romanData.values.length; i += 2) {
            int numberOfCurrentFigure = rest / romanData.values[i];
            rest = rest % romanData.values[i];
            if (numberOfCurrentFigure == 9) {
                romanNumber.append(romanData.romanFigures[i]);
                romanNumber.append(romanData.romanFigures[i - 2]);
            } else if (numberOfCurrentFigure == 4) {
                romanNumber.append(romanData.romanFigures[i]);
                romanNumber.append(romanData.romanFigures[i - 1]);
            } else {
                if (numberOfCurrentFigure / 5 == 1) {
                    romanNumber.append(romanData.romanFigures[i - 1]);
                }
                for (int j = 0; j < numberOfCurrentFigure % 5; j++) {
                    romanNumber.append(romanData.romanFigures[i]);
                }
            }
        }
        return romanNumber.toString();
    }

    public record RomanData(int[] values, char[] romanFigures) {}

}
