package edu.hw2.Task3;

public class ConnectionException extends RuntimeException {
    public ConnectionException() {
        super("Connection Exception");
    }

    public ConnectionException(Throwable th) {
        super("Connection Exeption", th);
    }
}
