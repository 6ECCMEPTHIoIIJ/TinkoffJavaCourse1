package edu.project1;

import org.jetbrains.annotations.NotNull;

public class Defeat implements GuessResult {
    @Override
    public @NotNull String message() {
        return "You lost!";
    }
}
