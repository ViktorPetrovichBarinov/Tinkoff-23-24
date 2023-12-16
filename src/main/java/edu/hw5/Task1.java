package edu.hw5;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Task1 {
    private Task1() {

    }

    public static String calculateAverageTime(List<String> peopleSessions) {
        Duration totalTime = calculateTotalTime(peopleSessions);
        Duration averageTime = totalTime.dividedBy(peopleSessions.size());

        long days = averageTime.toDays();
        int hours = averageTime.toHoursPart();
        int minutes = averageTime.toMinutesPart();

        return days + ":" + hours + ":" + minutes;
    }

    private static Duration calculateTotalTime(List<String> peopleSessions) {
        if (peopleSessions == null) {
            throw new IllegalArgumentException("Список сеансов не может быть null");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm");
        Duration totalTime = Duration.ofSeconds(0);

        for (String session : peopleSessions) {
            String[] dateTimes = session.split(" - ");
            //получаем дату старта и окончания сеанса
            LocalDateTime startDateTime = LocalDateTime.parse(dateTimes[0], formatter);
            LocalDateTime endDateTime = LocalDateTime.parse(dateTimes[1], formatter);

            //высчитываем разницу и представляем её в секундах
            Duration difference = Duration.between(startDateTime, endDateTime);
            totalTime = totalTime.plus(difference);
        }
        return totalTime;
    }
}
