package edu.hw1;

public class Task1 {

    private Task1() {
    }


    private static int numberOfSecondsPerMinute = 60;
    private static int calculusSystem = 10;
    /**
     * Метод обрабатывает длинну видео.
     *
     * @param inputString   - длинна видео в формате "mm:ss"
     * @return              - возвращает длинну видео в секундах
     */
    @SuppressWarnings("MagicNumber")
    public static long minutesToSeconds(String inputString) {
        String[] splitInput = inputString.split(":");

        int lengthOfLeftPart = splitInput[0].length();
        int lengthOfRightPart = splitInput[1].length();
        //я считаю, что видео в ~265 лет хватит
        if (lengthOfLeftPart > 10) {
            return -1;
        }
        //проверка ошибки, если в  строке есть что-то помимо букв
        for (int i = 0; i < lengthOfLeftPart; i++) {
            if (splitInput[0].charAt(i) < '0' || splitInput[0].charAt(i) > '9') {
                return -1;
            }
        }

        //проверка ошибки, еслив  строке есть что-то помимо букв
        for (int i = 0; i < lengthOfRightPart; i++) {
            if (splitInput[1].charAt(i) < '0' || splitInput[0].charAt(i) > '9') {
                return -1;
            }
        }
        long minutes = Long.parseLong(splitInput[0], calculusSystem);
        long seconds = Long.parseLong(splitInput[1], calculusSystem);
        if (seconds >= numberOfSecondsPerMinute) {
            return -1;
        }
        return minutes * numberOfSecondsPerMinute + seconds;
    }
}

