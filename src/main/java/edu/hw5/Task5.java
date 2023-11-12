package edu.hw5;

public class Task5 {
    private Task5() {

    }

    private static final String LICENCE_PLATE_NUMBER_REGEX = "[А-Я]\\d{3}[А-Я]{2}\\d{3}";

    public static boolean isLicencePlateNumberValid(String plateNumber) {
        return plateNumber.matches(LICENCE_PLATE_NUMBER_REGEX);
    }
}
