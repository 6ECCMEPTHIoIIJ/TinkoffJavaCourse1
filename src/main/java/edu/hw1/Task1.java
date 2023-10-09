package edu.hw1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Task1 {
    private final static String SEPARATOR = ":";
    private final static int SECONDS_PER_MINUTE = 60;

    private final static String TIME_STRING_REGEX = "\\d{2,}:[0-5][0-9]";
    private final static Pattern TIME_PATTERN = Pattern.compile(TIME_STRING_REGEX);

    private Task1() {
    }

    public static long minutesToSeconds(String timeString)
        throws NullPointerException {
        if (timeString == null) {
            throw new NullPointerException();
        }

        Matcher timeMatcher = TIME_PATTERN.matcher(timeString);
        if (!timeMatcher.matches()) {
            return -1;
        }

        final String[] separatedTimeStrings = timeString.split(SEPARATOR);
        int minutes = Integer.parseInt(separatedTimeStrings[0]);
        int seconds = Integer.parseInt(separatedTimeStrings[1]);

        return seconds + (long) minutes * SECONDS_PER_MINUTE;
    }
}
