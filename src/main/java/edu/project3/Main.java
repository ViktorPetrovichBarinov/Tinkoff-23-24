package edu.project3;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import static edu.project3.LogAnalyzer.analyzer;
import static edu.project3.formatOutput.adoc;
import static edu.project3.formatOutput.markdown;

public class Main {

    public static void main(String[] args) {
        String whereLogs = "https://raw.githubusercontent.com/elastic/examples/master/Common%20Data%20Formats/nginx_logs/nginx_logs";
        OffsetDateTime fromDate = OffsetDateTime.MIN;
        OffsetDateTime toDate = OffsetDateTime.MAX;
        String format = "markdown";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);

        try {
            for (int i = 0; i < args.length; i += 2) {
                switch (args[i]) {
                    case "--path":
                        whereLogs = args[i + 1];
                        break;
                    case "--from":
                        fromDate = LocalDate.parse(args[i + 1], formatter).atStartOfDay().atOffset(ZoneOffset.UTC);
                        break;
                    case "--to":
                        toDate = LocalDate.parse(args[i + 1], formatter).atStartOfDay().atOffset(ZoneOffset.UTC);
                        break;
                    case "markdown":
                        format = "markdown";
                        break;
                    case "adoc":
                        format = "adoc";
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
            }
            String logContent = null;
            if (whereLogs.contains("http")) {
                logContent = readLogFileURL(whereLogs);
            } else {

            }

            LogAnalyzer.LogAnalyzerResult ResultOfTheAnalyser = analyzer(logContent, fromDate, toDate);
            if (format.equals("markdown")) {
                markdown(ResultOfTheAnalyser);
            }
            if (format.equals("adoc")) {
                adoc(ResultOfTheAnalyser);
            }




        } catch (Exception e) {
            System.out.println("123");
        }

        readLogFileFS("");
    }

    private static String readLogFileURL(String logFileUrl) throws IOException {
        StringBuilder content = new StringBuilder();

        URL url = new URL(logFileUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } finally {
            connection.disconnect();
        }

        return content.toString();
    }

    private static String readLogFileFS(String globPattern) {
        String currentDirectoryPath = ".";

        // Создаем объект File для представления текущей директории
        File currentDirectory = new File(currentDirectoryPath);

        // Получаем список файлов в текущей директории
        File[] files = currentDirectory.listFiles();

        // Печатаем пути к файлам
        if (files != null) {
            for (File file : files) {
                System.out.println(file.getAbsolutePath());
            }
        } else {
            System.out.println("Не удалось получить список файлов.");
        }
        return null;
    }
}
