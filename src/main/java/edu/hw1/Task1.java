package edu.hw1;

public class Task1 {

    private Task1() {
    }

    /**
     * Метод обрабатывает длинну видео.
     *
     * @param inputString   - длинна видео в формате "mm:ss"
     * @return              - возвращает длинну видео в секундах
     */
    @SuppressWarnings("MagicNumber")
    public static int minutesToSeconds(String inputString) {
        String[] splitInput = inputString.split(":");
        int minutes = Integer.parseInt(splitInput[0], 10);
        int seconds = Integer.parseInt(splitInput[1], 10);
        if (seconds >= 60) {
            return -1;
        }
        return minutes * 60 + seconds;
    }
}

