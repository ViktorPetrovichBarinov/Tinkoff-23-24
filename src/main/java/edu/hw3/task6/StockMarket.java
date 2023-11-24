package edu.hw3.task6;

import java.util.PriorityQueue;

public class StockMarket {
    private final PriorityQueue<Stock> priorityQueue = new PriorityQueue<>();

    public void add(Stock stock) {
        priorityQueue.add(stock);
    }

    public void remove(Stock stock) {
        priorityQueue.remove(stock);
    }

    public Stock mostValuableStock() {
        return priorityQueue.peek();
    }
}
