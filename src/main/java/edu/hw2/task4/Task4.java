package edu.hw2.task4;

public class Task4 {
    private Task4() {
    }

    public static CallingInfo callingInfo() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

        if (stackTrace.length < 2) {
            return null;
        } else {
            return (new CallingInfo(stackTrace[2].getClassName(),
                stackTrace[2].getMethodName()));
        }
    }

    public record CallingInfo(String className, String methodName) {}
}
