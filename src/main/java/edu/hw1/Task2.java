package edu.hw1;

public class Task2 {

    private Task2() {
    }

    /**
     * Метод обрабатывает число и возвращает количество цифр в числе.
     *
     * @param number    - число которое требуется обработать
     * @return          - количество цифр в числе
     */
    @SuppressWarnings("MagicNumber")
    public static int countDigits(int number) {
        int helpNumber = Math.abs(number);
        int numberOfDigits = 0;
        do {
            numberOfDigits++;
            helpNumber /= 10;
        } while (helpNumber > 0);
        return numberOfDigits;
    }

}

