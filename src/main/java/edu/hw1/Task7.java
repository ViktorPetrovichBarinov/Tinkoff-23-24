package edu.hw1;

public class Task7 {

    private Task7() {
    }

    /**
     * Производит битовый сдвиг вправо
     *
     * @param number    - число над который нужно провести махинации
     * @param shift     - на сколько позиций нужно сдвинуть вправо
     * @return          - итоговое число после сдвига
     */
    public static int rotateRight(int number, int shift) {
        int shiftPosition = shift;
        String binaryRepresentation = Integer.toBinaryString(number);
        int numberOfSignificantDigits = binaryRepresentation.length();
        shiftPosition = positiveDivisionByModule(shiftPosition, numberOfSignificantDigits);
        StringBuilder binaryRepresentationAfterRotate = new StringBuilder();
        for (int i = numberOfSignificantDigits - shiftPosition; i < numberOfSignificantDigits; i++) {
            binaryRepresentationAfterRotate.append(binaryRepresentation.charAt(i));
        }
        for (int i = 0; i < numberOfSignificantDigits - shiftPosition; i++) {
            binaryRepresentationAfterRotate.append(binaryRepresentation.charAt(i));
        }
        int result = Integer.parseInt(String.valueOf(binaryRepresentationAfterRotate), 2);
        return result;
    }


    /**
     * Производит битовый сдвиг влево
     *
     * @param number    - число над который нужно провести махинации
     * @param shift     - на сколько позиций нужно сдвинуть вправо
     * @return          - итоговое число после сдвига
     */
    public static int rotateLeft(int number, int shift) {
        int shiftPosition = shift;
        String binaryRepresentation = Integer.toBinaryString(number);
        int numberOfSignificantDigits = binaryRepresentation.length();
        shiftPosition = positiveDivisionByModule(shiftPosition, numberOfSignificantDigits);
         return rotateRight(number, numberOfSignificantDigits - shiftPosition);
    }

    //Вспомогательная функция, производит деление по модулю, но результат положителен
    private static int positiveDivisionByModule(int number, int module) {
        int res = number % module;
        if (res < 0) {
            res += module;
        }
        return res;
    }
}














