package edu.project3;

public class formatOutput {
    public static void markdown(LogAnalyzer.LogAnalyzerResult logResult) {
        System.out.println("#### Результат обработки логов\n\n");

        System.out.printf("|                Метрика                 |                Значение                |\n");
        System.out.printf("|:--------------------------------------:|---------------------------------------:|\n");
        System.out.printf("|           Количество запросов          |%-40s|\n", logResult.totalNumberOfRequests());
        System.out.printf("|         Средней размер запроса         |%-40s|\n", logResult.averageServersAnswerSize());
        System.out.printf("|           Дата первого запроса         |%-40s|\n", logResult.dateOfTheFirstServerAnswer());
        System.out.printf("|         Дата последнего запроса        |%-40s|\n", logResult.dateOfTheLastServerAnswer());
        System.out.printf("|   Самые часто-запрашиваемые ресурсы    |%d)%-38s|\n",1, logResult.mostFrequentlyRequestedResources().get(0));
        System.out.printf("|                                        |%d)%-38s|\n",2, logResult.mostFrequentlyRequestedResources().get(1));
        System.out.printf("|                                        |%d)%-38s|\n",3, logResult.mostFrequentlyRequestedResources().get(2));
        System.out.printf("|       Самые частые коды ответов        |%d)%-38s|\n",1, logResult.mostCommonResponseCodes().get(0));
        System.out.printf("|                                        |%d)%-38s|\n",2, logResult.mostCommonResponseCodes().get(1));
        System.out.printf("|                                        |%d)%-38s|\n",3, logResult.mostCommonResponseCodes().get(2));
    }

    public static void adoc(LogAnalyzer.LogAnalyzerResult logResult) {
        System.out.printf("= Результат обработки логов\n\n");

        System.out.printf("|===\n");
        System.out.printf("|                Метрика                 |                Значение                |\n");
        System.out.printf("|           Количество запросов          |%-40s|\n", logResult.totalNumberOfRequests());
        System.out.printf("|         Средней размер запроса         |%-40s|\n", logResult.averageServersAnswerSize());
        System.out.printf("|           Дата первого запроса         |%-40s|\n", logResult.dateOfTheFirstServerAnswer());
        System.out.printf("|         Дата последнего запроса        |%-40s|\n", logResult.dateOfTheLastServerAnswer());
        System.out.printf("|   Самые часто-запрашиваемые ресурсы    |%d)%-38s|\n",1, logResult.mostFrequentlyRequestedResources().get(0));
        System.out.printf("|                                        |%d)%-38s|\n",2, logResult.mostFrequentlyRequestedResources().get(1));
        System.out.printf("|                                        |%d)%-38s|\n",3, logResult.mostFrequentlyRequestedResources().get(2));
        System.out.printf("|       Самые частые коды ответов        |%d)%-38s|\n",1, logResult.mostCommonResponseCodes().get(0));
        System.out.printf("|                                        |%d)%-38s|\n",2, logResult.mostCommonResponseCodes().get(1));
        System.out.printf("|                                        |%d)%-38s|\n",3, logResult.mostCommonResponseCodes().get(2));
        System.out.printf("|===\n");
    }

    public static void adoc() {

    }
}
