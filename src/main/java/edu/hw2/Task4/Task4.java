package edu.hw2.Task4;

public class Task4 {
    private Task4() {
    }

    public static void main(String[] args) {
        System.out.println(callingInfo());
    }
    @SuppressWarnings("RegexpSinglelineJava")
    public static CallingInfo callingInfo() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

        if (stackTrace.length == 0) {
            return null;
        }
        int stackLength = stackTrace.length;
        return (new CallingInfo(stackTrace[stackLength - 1].getClassName(),
            stackTrace[stackLength - 1].getMethodName()));
    }

    public record CallingInfo(String className, String methodName) {}
}
