package edu.hw1;

public final class Task1 {
    private final static int MINUTES_MIN_LENGTH = 2;
    private final static int SECONDS_LENGTH = 2;
    private final static String SEPARATOR = ":";
    private final static int SECONDS_PER_MINUTE = 60;

    private Task1() {
    }

    public static long minutesToSeconds(String time)
        throws NullPointerException, IllegalArgumentException {
        if (time == null) {
            throw new NullPointerException();
        }

        final long nonDigitsCount = time.chars()
            .filter((ch) -> !Character.isDigit(ch))
            .count();
        if (nonDigitsCount != 1) {
            throw new IllegalArgumentException();
        }

        final String[] separatedTime = time.split(SEPARATOR);
        if (separatedTime.length != 2
            || separatedTime[0].length() < MINUTES_MIN_LENGTH
            || separatedTime[1].length() != SECONDS_LENGTH) {
            throw new IllegalArgumentException();
        }

        int minutes;
        int seconds;

        try {
            minutes = Integer.parseInt(separatedTime[0]);
            seconds = Integer.parseInt(separatedTime[1]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        return (seconds < SECONDS_PER_MINUTE)
            ? seconds + (long) minutes * SECONDS_PER_MINUTE
            : -1;
    }
}
