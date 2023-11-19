package edu.project3;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import static java.time.format.DateTimeFormatter.ISO_DATE;

public class LogAnalyzer {
    private static final Pattern NGINX_PATTERN = Pattern.compile(
        "(\\S+) - - \\[(.*?)\\] \\\"(.*?)\\\" (\\d+) (\\d+) \\\"(.*?)\\\" \\\"(.*?)\\\"");


    public static LogAnalyzerResult analyzer(String allLogs, OffsetDateTime fromDate, OffsetDateTime toDate) {
        String[] logsLines = allLogs.split("\\n");
        BigInteger sumOfServerAnswerSize = BigInteger.ZERO;

        int totalNumberOfRequests = 0;
        HashMap<String, Integer> resourceAndItsNumberOfRequests = new HashMap<>();
        HashMap<Integer, Integer> answerStatusAndItsQuantity = new HashMap<>();

        OffsetDateTime dateOfTheFirstServerAnswer, dateOfTheLastServerAnswer;
        dateOfTheFirstServerAnswer = OffsetDateTime.MAX;
        dateOfTheLastServerAnswer = OffsetDateTime.MIN;

        for (String line : logsLines) {
            NginxLog log = parseNginxLog(line);

            if (log.date().isAfter(toDate) || log.date().isBefore(fromDate)) {
                continue;
            }

            totalNumberOfRequests++;
            sumOfServerAnswerSize = sumOfServerAnswerSize.add(BigInteger.valueOf(log.answerSize()));
            if (!resourceAndItsNumberOfRequests.containsKey(log.requestResource())) {
                resourceAndItsNumberOfRequests.put(log.requestResource(), 1);
            } else {
                Integer numberOfRequestsForCurrentResource = resourceAndItsNumberOfRequests.get(log.requestResource());
                resourceAndItsNumberOfRequests.put(log.requestResource(), numberOfRequestsForCurrentResource + 1);
            }
            if (!answerStatusAndItsQuantity.containsKey(log.answerStatus())) {
                answerStatusAndItsQuantity.put(log.answerStatus(), 1);
            } else {
                Integer numberOfCurrentAnswerStatus = answerStatusAndItsQuantity.get(log.answerStatus());
                answerStatusAndItsQuantity.put(log.answerStatus(), numberOfCurrentAnswerStatus + 1);
            }

            if (dateOfTheFirstServerAnswer.isAfter(log.date())) {
                dateOfTheFirstServerAnswer = log.date();
            }
            if (dateOfTheLastServerAnswer.isBefore(log.date())) {
                dateOfTheLastServerAnswer = log.date();
            }
        }


        List<String> mostFrequentlyRequestedResources = resourceAndItsNumberOfRequests.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .limit(3)
            .map(Map.Entry::getKey)
            .toList();

        List<Integer> mostCommonResponseCodes = answerStatusAndItsQuantity.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .limit(3)
            .map(Map.Entry::getKey)
            .toList();
        BigDecimal averageServersAnswerSize = new BigDecimal(sumOfServerAnswerSize);
        averageServersAnswerSize = averageServersAnswerSize.divide(BigDecimal.valueOf(totalNumberOfRequests),
            RoundingMode.HALF_UP
        );
        return new LogAnalyzerResult(totalNumberOfRequests, mostFrequentlyRequestedResources,
            mostCommonResponseCodes, averageServersAnswerSize,
            dateOfTheFirstServerAnswer, dateOfTheLastServerAnswer);
    }




    private static NginxLog parseNginxLog(String logLine) {

        Matcher matcher = NGINX_PATTERN.matcher(logLine);
        if (!matcher.find()) {
            throw new IllegalArgumentException();
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss Z", Locale.ENGLISH);
            OffsetDateTime currentDate = OffsetDateTime.parse(matcher.group(2), formatter);

            String[] request = matcher.group(3).split(" ");
            NginxLog.RequestType requestType = NginxLog.getType(request[0]);

            Integer answerStatus = Integer.parseInt(matcher.group(4));

            Integer answerSize = Integer.parseInt(matcher.group(5));

            return new NginxLog(matcher.group(1), currentDate, requestType, request[1], answerStatus, answerSize, matcher.group(6), matcher.group(7));
        }
    }

    public static void main(String[] args) {
        String logLine = "93.180.71.3 - - [17/May/2015:08:05:32 +0000] \"GET /downloads/product_1 HTTP/1.1\" 304 0 \"-\" \"Debian APT-HTTP/1.3 (0.8.16~exp12ubuntu10.21)\"";
        Matcher matcher = NGINX_PATTERN.matcher(logLine);
        matcher.find();
        for(int i = 0; i <= matcher.groupCount(); i++) {
            System.out.println(matcher.group(i));
        }
    }

    public record LogAnalyzerResult(Integer totalNumberOfRequests, List<String> mostFrequentlyRequestedResources,
                                    List<Integer> mostCommonResponseCodes, BigDecimal averageServersAnswerSize,
                                    OffsetDateTime dateOfTheFirstServerAnswer, OffsetDateTime dateOfTheLastServerAnswer) {

    }
}
