package edu.hw2.task3;

import java.util.Random;

final public class FaultyConnectionManager implements ConnectionManager {
    @Override
    public Connection getConnection() {
        return new FaultyConnection();
    }

}
