package edu.hw2.task4;

import org.jetbrains.annotations.NotNull;

public class Utility {
    private Utility() {

    }

    public static @NotNull CallingInfo callingInfo() {
        StackTraceElement caller = new Throwable().getStackTrace()[1];

        return new CallingInfo(caller.getClassName(), caller.getMethodName());
    }

    public record CallingInfo(String className, String methodName) {

    }
}
