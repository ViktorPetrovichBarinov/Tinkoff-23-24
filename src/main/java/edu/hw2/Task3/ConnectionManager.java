package edu.hw2.Task3;

import java.util.Random;

public interface ConnectionManager {
    Connection getConnection();
}

class DefaultConnectionManager implements ConnectionManager {

    @Override
    public Connection getConnection() {
        return null;
    }

}



class FaultyConnectionManager implements ConnectionManager {
    Random random = new Random();
    @Override
    public Connection getConnection() {
        int randomInt = random.nextInt(Integer.MAX_VALUE);

        if (randomInt < Integer.MAX_VALUE) {
            return new FaultyConnection();
        }
        return new StableConnection();
    }
}
