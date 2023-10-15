package edu.hw1;

public class Task1 {

    private Task1() {
    }


    private static final int NUMBER_OF_SECOND_PER_MINUTE = 60;
    private static final int CALCULUS_SYSTEM = 10;
    private static final int MAX_LENGTH_OF_LEFT_PART = 10;
    /**
     * Метод обрабатывает длинну видео.
     *
     * @param inputString   - длинна видео в формате "mm:ss"
     * @return              - возвращает длинну видео в секундах
     */

    public static long minutesToSeconds(String inputString) {
        String[] splitInput = inputString.split(":");

        if (isErrorsBeforeParse(splitInput)) {
            return -1;
        }

        long minutes = Long.parseLong(splitInput[0], CALCULUS_SYSTEM);
        long seconds = Long.parseLong(splitInput[1], CALCULUS_SYSTEM);
        if (seconds >= NUMBER_OF_SECOND_PER_MINUTE) {
            return -1;
        }
        return minutes * NUMBER_OF_SECOND_PER_MINUTE + seconds;
    }

    private static boolean isErrorsBeforeParse(String[] splitInput) {
        int lengthOfLeftPart = splitInput[0].length();
        int lengthOfRightPart = splitInput[1].length();
        //я считаю, что видео в ~265 лет хватит
        if (lengthOfLeftPart > MAX_LENGTH_OF_LEFT_PART) {
            return true;
        }
        //проверка ошибки, если в  строке есть что-то помимо букв
        for (int i = 0; i < lengthOfLeftPart; i++) {
            if (splitInput[0].charAt(i) < '0' || splitInput[0].charAt(i) > '9') {
                return true;
            }
        }

        //проверка ошибки, если в строке есть что-то помимо букв
        for (int i = 0; i < lengthOfRightPart; i++) {
            if (splitInput[1].charAt(i) < '0' || splitInput[0].charAt(i) > '9') {
                return true;
            }
        }
        return false;
    }
}

