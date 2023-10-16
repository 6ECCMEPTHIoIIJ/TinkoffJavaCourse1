package edu.project1;

import org.jetbrains.annotations.NotNull;

public class FailedGuess implements GuessResult {
    private final int attemptsCount;
    private final int maxAttempts;

    public FailedGuess(int attemptsCount, int maxAttempts) {
        this.attemptsCount = attemptsCount;
        this.maxAttempts = maxAttempts;
    }

    @Override
    public @NotNull String message() {
        return String.format("Missed, mistake %d out of %d", attemptsCount, maxAttempts);
    }
}
