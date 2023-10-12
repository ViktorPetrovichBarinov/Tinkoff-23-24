package edu.hw1;

public class Task4 {
    private Task4() {
    }

    /**
     * На вход подаётся строка в которой каждая пара символов поменята местами.
     * Метод преобразует строку к изначальному виду.
     * Последний символ в строка с нечетным количеством символом не изменяется.
     *
     * @param inputString   - входная строка
     * @return              - обработанная строка
     */
    public static String fixString(String inputString) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < inputString.length() - 1; i += 2) {
            answer.append(inputString.charAt(i + 1));
            answer.append(inputString.charAt(i));
        }
        if (inputString.length() % 2 == 1) {
            answer.append(inputString.charAt(inputString.length() - 1));
        }
        return answer.toString();
    }
}

