package edu.hw3.task6;

import java.util.Comparator;

public class Stock implements Comparator {
    String name;
    double price;

    Stock(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compare(Object o1, Object o2) {
        if(o1 == null || o2 == null || !(o1 instanceof Stock && o2 instanceof Stock)) {
            throw new IllegalArgumentException("Incorrect arguments");
        }
        Stock stock1 = (Stock) o1;
        Stock stock2 = (Stock) o2;

        return (int) (stock1.price - stock2.price);
    }
}
