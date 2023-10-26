package edu.hw2.task3;

import java.util.Random;

public class DefaultConnectionManager implements ConnectionManager {

    @Override
    public Connection getConnection() {
        Random rand = new Random();
        if(rand.nextInt(Integer.MAX_VALUE) < Integer.MAX_VALUE / 2) {
            return new StableConnection();
        }
        return new FaultyConnection();
    }

}
