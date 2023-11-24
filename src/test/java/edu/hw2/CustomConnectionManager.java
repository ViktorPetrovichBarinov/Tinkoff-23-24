package edu.hw2;

import edu.hw2.task3.Connection;
import edu.hw2.task3.ConnectionManager;
import edu.hw2.task3.StableConnection;

public class CustomConnectionManager implements ConnectionManager {
    @Override
    public Connection getConnection() {
        return new StableConnection();
    }
}
