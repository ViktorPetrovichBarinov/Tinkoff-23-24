package edu.project3;

import java.time.OffsetDateTime;

public record NginxLog (String ip, OffsetDateTime date, RequestType requestType, String requestResource,
                        Integer answerStatus, Integer answerSize, String transitionSource, String userAgent){

    public static RequestType getType(String stringType) {
        return switch(stringType) {
            case "GET" -> RequestType.GET;
            case "POST" -> RequestType.POST;
            case "PUT" -> RequestType.PUT;
            case "DELETE" -> RequestType.DELETE;
            case "HEAD" -> RequestType.HEAD;
            case "OPTIONS" -> RequestType.OPTIONS;
            default -> throw new IllegalArgumentException("Incorrect request");
        };
    }

    enum RequestType {
        GET,
        POST,
        PUT,
        DELETE,
        HEAD,
        OPTIONS
    }
}
