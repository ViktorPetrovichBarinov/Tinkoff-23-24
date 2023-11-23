package edu.hw6.Task5;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HackerNews {
    private static final String TOP_STORIES_JSON = "https://hacker-news.firebaseio.com/v0/topstories.json";
    private static final String ITEM_FIRST_PART = "https://hacker-news.firebaseio.com/v0/item/";
    private static final String ITEM_SECOND_PART = ".json";
    private static final String REGEX_FOR_TITLE = "\\\"title\\\":\\\"(.+?)\\\"";

    public static long[] hackerNewsTopStories() {

        try {
            HttpClient httpClient = HttpClient.newHttpClient();

            HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(TOP_STORIES_JSON))
                .build();

            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                return new long[0];
            }

            String cleanedString = response.body().replaceFirst("\\[", "").replaceFirst("]", "");
            String[] topStories = cleanedString.split(",");
            int topStoriesLength = topStories.length;
            long[] topStoriesIds = new long[topStoriesLength];
            for (int i = 0; i < topStoriesLength; i++) {
                topStoriesIds[i] = Integer.parseInt(topStories[i]);
            }

            return topStoriesIds;
        } catch (Exception e) {
            return new long[0];
        }

    }

    public static String news(Integer id) {
        try {
            HttpClient httpClient = HttpClient.newHttpClient();


            HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(ITEM_FIRST_PART + id.toString() + ITEM_SECOND_PART))
                .build();

            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                throw new RuntimeException();
            }
            Pattern pattern = Pattern.compile(REGEX_FOR_TITLE);
            Matcher matcher = pattern.matcher(response.body());
            if (matcher.find()) {
                return matcher.group(0).replaceFirst("\\\"title\\\":", "");
            }


            return null;
        } catch (Exception e) {
            return null;
        }

    }

    public static void main(String[] args) {
        news(38394364);

    }
}
