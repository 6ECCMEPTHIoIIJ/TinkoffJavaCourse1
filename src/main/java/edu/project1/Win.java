package edu.project1;

import org.jetbrains.annotations.NotNull;

public record Win(int attemptsCount, int maxAttempts, String state) implements GuessResult {
    @Override
    public @NotNull String message() {
        return "You won!";
    }
}
