package edu.hw5;

public class Task7 {
    private Task7() {

    }

    private static final String TASK7_REGEX1 = "^[0,1]{2}0[0,1]*$";
    private static final String TASK7_REGEX2 = "^([0,1])[0,1]*\\1$";
    private static final String TASK7_REGEX3 = "^[0,1]{1,3}$";

    public static boolean task1(String string) {
        return string.matches(TASK7_REGEX1);
    }

    public static boolean task2(String string) {
        return string.matches(TASK7_REGEX2);
    }

    public static boolean task3(String string) {
        return string.matches(TASK7_REGEX3);
    }


}
