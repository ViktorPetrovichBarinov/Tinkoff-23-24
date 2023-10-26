package edu.hw2.task3;

import java.util.Random;

public class FaultyConnection implements Connection {

    @Override
    public void execute(String command) {
        Random rand = new Random(Integer.MAX_VALUE);
        if (rand.nextInt() < Integer.MAX_VALUE / 2) {
            throw new ConnectionException("Your connection is faulty");
        }
        return;
    }

    @Override
    public void close() throws Exception {

    }
}
