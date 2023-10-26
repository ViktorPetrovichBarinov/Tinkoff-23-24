package edu.hw2.task3;

import java.util.Random;

public class FaultyConnectionManager implements ConnectionManager {
    private final Random random = new Random();

    @Override
    public Connection getConnection() {
        int randomInt = random.nextInt(Integer.MAX_VALUE);

        if (randomInt < Integer.MAX_VALUE / 2) {
            return new FaultyConnection();
        }
        return new StableConnection();
    }
}
