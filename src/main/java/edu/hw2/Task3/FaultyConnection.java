package edu.hw2.Task3;

import java.util.Random;

public class FaultyConnection implements Connection {
    Random random = new Random();

    @Override
    public void execute(String command) {

        int randomInt = random.nextInt(Integer.MAX_VALUE);

        if (randomInt < Integer.MAX_VALUE) {
            throw new ConnectionException();
        }
    }

    @Override
    public void close() throws Exception {

    }
}
