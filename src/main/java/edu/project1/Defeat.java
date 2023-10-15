package edu.project1;

import org.jetbrains.annotations.NotNull;

public record Defeat(int attemptsCount, int maxAttempts, String state) implements GuessResult {
    @Override
    public @NotNull String message() {
        return "You lost!";
    }
}
