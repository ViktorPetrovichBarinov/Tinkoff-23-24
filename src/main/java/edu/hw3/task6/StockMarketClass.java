package edu.hw3.task6;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class StockMarketClass implements StockMarket{

    PriorityQueue<Stock> stockList = new PriorityQueue<>();

    @Override
    public void add(Stock stock) {
        stockList.add(stock);
    }

    @Override
    public void remove(Stock stock) {
        stockList.remove(stock);
    }

    @Override
    public Stock mostValuableStock() {
        return stockList.peek();
    }
}
