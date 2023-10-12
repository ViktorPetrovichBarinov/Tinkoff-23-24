package edu.hw1;

public class Task5 {
    private Task5() {
    }

    /**
     * Проверяем число на полиндром и его потомков тоже.
     * Если длинна числа меньше 2, то у него нет потомков
     * Если число имеет нечетную длинну, то у него нет потомков
     *
     * @param number    - данное число проверяется на то что, оно есть палиндром
     * @return          - true - в случае, если полиндром или любой из детей полиндром
     *                  - false - в ином случае
     */
    public static boolean isPalindromeDescendant(int number) {
        if (Task2.countDigits(number) < 2) {
            return false;
        } else if (Task2.countDigits(number) % 2 == 1) {
            return isPalindrome(number);
        } else if (isPalindrome(number)) {
            return true;
        } else {
            return isPalindromeDescendant(descendant(number));
        }
    }


    //Вспомогательный метод, проверяет конкретное число на полиндром
    private static boolean isPalindrome(int number) {
        String numberString = Integer.toString(number);
        for (int i = 0; i < numberString.length() / 2; i++) {
            if (!(numberString.charAt(i) == numberString.charAt(numberString.length() - 1 - i))) {
                return false;
            }
        }
        return true;
    }

    //Вспомогательный метод, выдаёт потомка текущего числа
    //При условии, что потомок существует
    @SuppressWarnings("MagicNumber")
    private static int descendant(int number) {
        String numberString = Integer.toString(number);
        StringBuilder newNumberString = new StringBuilder();
        for (int i = 0; i < numberString.length(); i += 2) {
            char fstChar = numberString.charAt(i);
            char sndChar = numberString.charAt(i + 1);
            int fstCharValue = Character.getNumericValue(fstChar);
            int sndCharValue = Character.getNumericValue(sndChar);
            int res = fstCharValue + sndCharValue;
            newNumberString.append(res);
        }
        return Integer.parseInt(newNumberString.toString(), 10);
    }
}
