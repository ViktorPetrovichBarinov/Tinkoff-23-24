package edu.hw5;

public class Task6 {

    private Task6() {

    }

    public static boolean isSubString(String subString, String string) {
        return string.matches(".*" + subString + ".*");
    }
}
