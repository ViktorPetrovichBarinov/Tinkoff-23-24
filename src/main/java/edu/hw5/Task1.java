package edu.hw5;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Task1 {
    private Task1() {

    }

    private static final int NUMBER_OF_SECONDS_IN_MINUTES = 60;
    private static final int NUMBER_OF_MINUTES_IN_HOUR = 60;
    private static final int NUMBER_OF_HOURS_IN_DAY = 24;

    public static String calculateAverageTime(List<String> peopleSessions) {
        long totalTime = calculateTotalTime(peopleSessions);
        long averageTime = totalTime / peopleSessions.size();

        //выводим среднее значение сессии с точностью до минут в ввиде строки
        long totalMinutes = averageTime / NUMBER_OF_SECONDS_IN_MINUTES;
        long minutes = totalMinutes % NUMBER_OF_MINUTES_IN_HOUR;
        long totalHours = totalMinutes / NUMBER_OF_MINUTES_IN_HOUR;
        long hours = totalHours % NUMBER_OF_HOURS_IN_DAY;
        long days = totalHours / NUMBER_OF_HOURS_IN_DAY;
        StringBuilder answer = new StringBuilder();
        answer.append(days).append(":")
            .append(hours).append(":")
            .append(minutes);

        return answer.toString();
    }

    private static long calculateTotalTime(List<String> peopleSessions) {
        if (peopleSessions == null) {
            throw new IllegalArgumentException("Список сеансов не может быть null");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm");
        long totalTime = 0;

        for (String session : peopleSessions) {
            String[] dateTimes = session.split(" - ");
            //получаем дату старта и окончания сеанса
            LocalDateTime startDateTime = LocalDateTime.parse(dateTimes[0], formatter);
            LocalDateTime endDateTime = LocalDateTime.parse(dateTimes[1], formatter);

            //высчитываем разницу и представляем её в секундах
            Duration duration = Duration.between(startDateTime, endDateTime);
            totalTime += duration.toSeconds();
        }
        return totalTime;
    }
}
