package edu.hw2.task3;

import java.util.Random;

public class FaultyConnection implements Connection {

    @Override
    public void execute(String command) {
        Random rand = new Random();
        if (rand.nextInt(Integer.MAX_VALUE) < Integer.MAX_VALUE / 2) {
            throw new ConnectionException("Wrong attempt");
        }
    }

    @Override
    public void close() {

    }
}
