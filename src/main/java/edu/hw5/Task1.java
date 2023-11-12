package edu.hw5;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        LocalTime start = LocalTime.of(9, 0, 0);
        LocalTime end = LocalTime.of(12, 30, 0);

        Duration duration = Duration.between(start, end);
        System.out.println("Продолжительность: " + duration);
    }

    public static String calculateAverageTime(List<String> peopleSessions) {
        
    }


}
