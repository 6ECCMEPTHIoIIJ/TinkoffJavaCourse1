package edu.project1;

import org.jetbrains.annotations.NotNull;

public class SuccessfulGuess implements GuessResult {
    @Override
    public @NotNull String message() {
        return "Hit!";
    }
}
