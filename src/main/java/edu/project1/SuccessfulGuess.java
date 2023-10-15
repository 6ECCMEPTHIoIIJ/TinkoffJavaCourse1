package edu.project1;

import org.jetbrains.annotations.NotNull;

public record SuccessfulGuess(int attemptsCount, int maxAttempts, String state) implements GuessResult {
    @Override
    public @NotNull String message() {
        return "Hit!";
    }
}
