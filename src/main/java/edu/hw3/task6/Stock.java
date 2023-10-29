package edu.hw3.task6;

import org.jetbrains.annotations.NotNull;

public class Stock implements Comparable<Stock> {
    private String name;
    private Integer cost;

    public Stock(String name, Integer cost) {
        this.name = name;
        this.cost = cost;
    }

    public Integer getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(@NotNull Stock o) {
        return o.cost - this.cost;
    }
}
