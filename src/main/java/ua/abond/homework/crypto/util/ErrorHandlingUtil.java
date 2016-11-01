package ua.abond.homework.crypto.util;

public final class ErrorHandlingUtil {
    private ErrorHandlingUtil() {
    }

    public static <T> void checkIfNotNull(T arg, String errorMessage) {
        if (arg == null) {
            throw new NullPointerException(errorMessage);
        }
    }
}
