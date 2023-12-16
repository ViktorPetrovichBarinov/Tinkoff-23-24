package edu.hw5;

public class Task5 {
    private Task5() {

    }

    private static final String LICENCE_PLATE_NUMBER_REGEX = "[АВЕКМНОРСТУХ]\\d{3}[АВЕКМНОРСТУХ]{2}\\d{2,3}";

    public static boolean isLicencePlateNumberValid(String plateNumber) {
        return plateNumber.matches(LICENCE_PLATE_NUMBER_REGEX);
    }
}
