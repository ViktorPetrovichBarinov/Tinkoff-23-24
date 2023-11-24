package edu.hw3;

import edu.hw3.task6.Stock;
import edu.hw3.task6.StockMarket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {
    @Test
    @DisplayName("Конструктор тест")
    void test1() {
        Stock stock = new Stock("Tinkoff", 10);


        String answerName = "Tinkoff";
        Integer answerPrice = 10;
        assertThat(answerName).isEqualTo(stock.getName());
        assertThat(answerPrice).isEqualTo(stock.getCost());
    }

    @Test
    @DisplayName("Компаратор тест")
    void test2() {
        Stock stock1 = new Stock("Tinkoff", 10);
        Stock stock2 = new Stock("Sber", 11);
        Stock stock3 = new Stock("Alpha", 9);
        Stock stock4 = new Stock("Sovkom", 10);

        assertThat(-1).isEqualTo(stock2.compareTo(stock1));
        assertThat(1).isEqualTo(stock3.compareTo(stock1));
        assertThat(0).isEqualTo(stock4.compareTo(stock1));
    }

    @Test
    @DisplayName("Проверка работы очереди")
    void test3() {
        Stock stock1 = new Stock("Tinkoff", 10);
        StockMarket market = new StockMarket();
        market.add(stock1);

        assertThat(0).isEqualTo(stock1.compareTo(market.mostValuableStock()));
    }


    @Test
    @DisplayName("Проверка приоритетности")
    void test4() {
        Stock stock1 = new Stock("Tinkoff", 10);
        Stock stock2 = new Stock("Sber", 11);
        Stock stock3 = new Stock("Alpha", 9);
        Stock stock4 = new Stock("Sovkom", 10);
        StockMarket market = new StockMarket();
        market.add(stock4);
        market.add(stock3);
        market.add(stock2);
        market.add(stock1);

        assertThat(11).isEqualTo(market.mostValuableStock().getCost());
        assertThat("Sber").isEqualTo(market.mostValuableStock().getName());

        market.remove(stock2);

        assertThat(10).isEqualTo(market.mostValuableStock().getCost());
    }

}
