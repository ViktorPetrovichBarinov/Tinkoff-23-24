package edu.hw1;

import java.util.Arrays;


public class Task6 {

    private Task6() {
    }

    private static final int KAPREKAN_CONST = 6174;
    /**
     * Любое четырёхзначное число, у которого не все цифры одинаковы, можно привести к 6174
     * не более чем за 7 шагов, используя функцию Капрекара.
     *
     * @param number    - проверяет это число на процесс Капрекара
     * @return          - количество шагов до 6174, либо -1 в случае некорректного ввода
     */

    @SuppressWarnings("MagicNumber")
    public static int kaprekarFunction(int number) {
        if (number < 1000 || number > 9999) {
            return -1;
        }
        for (int i = 1111; i < 10000; i += 1111) {
            if (number == i) {
                return -1;
            }
        }
        int difference = getMax(number) - getMin(number);
        if (difference == KAPREKAN_CONST) {
            return 1;
        } else {
            return 1 + kaprekarFunction(difference);
        }
    }

    //Вспомогательный метод возвращает число, которое соответствует
    //расположенным в порядке возрастания цифрам
    @SuppressWarnings("MagicNumber")
    private static int getMin(int number) {
        int[] array = new int[4];
        for (int i = 0; i < array.length; i++) {
            array[i] = getIthNumber(number, i);
        }
        Arrays.sort(array);
        for (int i = 0; i < array.length / 2; i++) {
            int cmp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = cmp;
        }
        return fromArrayToInt(array);
    }


    //Вспомогательный метод возвращает число, которое соответствует
    //расположенным в порядке убывания цифрам
    @SuppressWarnings("MagicNumber")
    private static int getMax(int number) {
        int[] array = new int[4];
        for (int i = 0; i < array.length; i++) {
            array[i] = getIthNumber(number, i);
        }
        Arrays.sort(array);
        return fromArrayToInt(array);
    }

    //Вспомогательный метод, переводит число представленное массивом в int
    @SuppressWarnings("MagicNumber")
    private static int fromArrayToInt(int[] arr) {
        int tenDegree = 1;
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result += arr[i] * tenDegree;
            tenDegree *= 10;
        }
        return result;
    }

    //Вспомогательная функция выдаёт i-ую цифру в числе
    @SuppressWarnings("MagicNumber")
    private static int getIthNumber(int number, int index) {
        int helpNumber = number;
        int helpIndex = index;
        while (helpIndex > 0) {
            helpNumber /= 10;
            helpIndex--;
        }
        return helpNumber % 10;
    }

}

