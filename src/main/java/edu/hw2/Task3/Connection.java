package edu.hw2.Task3;
import java.util.Random;

public interface Connection extends AutoCloseable {
    void execute(String command);
}

class StableConnection implements Connection {

    @Override
    public void execute(String command) {

    }

    @Override
    public void close() throws Exception {

    }
}

class FaultyConnection implements Connection {
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

