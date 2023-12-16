package edu.hw5;

import java.time.LocalDate;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task3 {
    private Task3() {

    }

    private static final Pattern DATE_PATTERN = Pattern.compile(
        "(\\d{4}-\\d{2}-\\d{1,2})|(\\d{1,2}/\\d{1,2}/(?:\\d{4}|\\d{2}))"
            + "|(tomorrow)|(today)|(yesterday)|(\\d+ day.? +ago)");

    @SuppressWarnings("MagicNumber")
    public static Optional<LocalDate> parseDate(String string) {
        if (string == null || string.isEmpty()) {
            return Optional.empty();
        }

        Optional<LocalDate> answer = Optional.empty();
        Matcher matcher = DATE_PATTERN.matcher(string);
        if (matcher.matches()) {
            if (matcher.group(1) != null) {
                // Соответствует формату "yyyy-MM-dd" "yyyy-MM-d"
                String[] parseString = matcher.group(1).split("-");
                int years = Integer.parseInt(parseString[0]);
                int months = Integer.parseInt(parseString[1]);
                int days = Integer.parseInt(parseString[2]);
                LocalDate isoDate = LocalDate.of(years, months, days);
                answer = Optional.of(isoDate);
            } else if (matcher.group(2) != null) {
                // Соответствует формату "MM/dd/yyyy" или "MM/dd/yy" или "M/dd/yyyy" или "M/dd/yy"
                String[] parseString = matcher.group(2).split("/");
                int days = Integer.parseInt(parseString[0]);
                int months = Integer.parseInt(parseString[1]);
                int years = Integer.parseInt(parseString[2]);
                if (years < 100) {
                    years += 2000;
                }
                LocalDate isoDate = LocalDate.of(years, months, days);
                answer = Optional.of(isoDate);
            } else if (matcher.group(3) != null) {
                LocalDate today = LocalDate.now();
                LocalDate tomorrow = today.plusDays(1);
                // Соответствует формату "tomorrow"
                answer = Optional.of(tomorrow);
            } else if (matcher.group(4) != null) {
                LocalDate today = LocalDate.now();
                // Соответствует "today"
                answer = Optional.of(today);
            } else if (matcher.group(5) != null) {
                LocalDate today = LocalDate.now();
                LocalDate yesterday = today.minusDays(1);
                answer = Optional.of(yesterday);
            } else if (matcher.group(6) != null) {
                LocalDate today = LocalDate.now();
                // Соответствует "n days ago"
                String specialCase = matcher.group(6);
                int n = Integer.parseInt(specialCase.split(" ")[0]);
                LocalDate retrunDate = today.minusDays(n);
                answer = Optional.of(retrunDate);
            }
            return answer;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
