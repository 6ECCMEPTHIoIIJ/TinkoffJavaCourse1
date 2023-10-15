package edu.project1;

import org.jetbrains.annotations.NotNull;

public interface GuessResult {
    int attemptsCount();

    int maxAttempts();

    @NotNull String state();

    @NotNull String message();
}
