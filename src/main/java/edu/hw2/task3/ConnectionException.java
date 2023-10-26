package edu.hw2.task3;

public class ConnectionException extends RuntimeException {
    public ConnectionException(String errorDescription) {
        super(errorDescription);
    }

    public ConnectionException(String errorDescription, Throwable cause) {
        super(errorDescription, cause);
    }
}
