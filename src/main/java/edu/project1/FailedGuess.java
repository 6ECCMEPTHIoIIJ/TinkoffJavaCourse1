package edu.project1;

import org.jetbrains.annotations.NotNull;

public record FailedGuess(int attemptsCount, int maxAttempts, String state) implements GuessResult {
    @Override
    public @NotNull String message() {
        return String.format("Missed, mistake %d out of %d", attemptsCount, maxAttempts);
    }
}
