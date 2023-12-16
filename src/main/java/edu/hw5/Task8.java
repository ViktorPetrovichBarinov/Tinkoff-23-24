package edu.hw5;

public class Task8 {
    private Task8() {

    }

    private static final String TASK8_ODD_LENGTH_STRING = "^[01]([01]{2})*$";
    private static final String TASK8_OOD_LENGTH_STRING_STARTS_WITH_0_OR_EVEN_LENGTH_STRING_STARTS_WITH_1 =
        "^(0([01]{2})*|1[01]([01]{2})*)$";
    private static final String TASK8_NUMBER_OF_0_IS_MULTIPLE_OF_3 = "^(1*01*01*01*|1*001*01*|1*01*001*|1*0001*)*$";
    private static final String TASK8_ANY_STRING_OTHER_THAN_11_OR_111 = "^(?!11$|111$)[01]*$";

    public static boolean isOddLengthString(String string) {
        return string.matches(TASK8_ODD_LENGTH_STRING);
    }

    public static boolean isOddLengthStartsWith0OrEvenLengthStartsWith1(String string) {
        return string.matches(TASK8_OOD_LENGTH_STRING_STARTS_WITH_0_OR_EVEN_LENGTH_STRING_STARTS_WITH_1);
    }

    public static boolean isNumberOf0IsMultipleOf3(String string) {
        return string.matches(TASK8_NUMBER_OF_0_IS_MULTIPLE_OF_3);
    }

    public static boolean isAnyStringOtherThan11Or111(String string) {
        return string.matches(TASK8_ANY_STRING_OTHER_THAN_11_OR_111);
    }
}
