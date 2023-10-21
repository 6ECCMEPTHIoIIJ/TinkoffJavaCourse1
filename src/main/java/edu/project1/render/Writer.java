package edu.project1.render;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

public class Writer {
    private final static Logger LOGGER = LogManager.getLogger();

    private final StringBuilder infoBuffer = new StringBuilder();
    private final StringBuilder warningsBuffer = new StringBuilder();

    public void displayInfo() {
        LOGGER.info("\n" + infoBuffer);
        infoBuffer.delete(0, infoBuffer.length());
    }

    public void displayWarnings() {
        LOGGER.warn("\n" + warningsBuffer);
        warningsBuffer.delete(0, warningsBuffer.length());
    }

    public void askQuestion() {
        info("Guess a letter");
    }

    public void warnIncorrectInput(@NotNull String input) {
        warn(String.format("Incorrect input \"%s\"",input));
    }

    public void warnDuplicatedInput(@NotNull String input) {
        warn(String.format("Duplicated input '%s'", input));
    }

    public void infoTerminatedInput() {
        info("Game terminated");
    }

    private void info(@NotNull String message) {
        infoBuffer.append(message);
    }

    private void warn(@NotNull String message) {
        warningsBuffer.append(message);
    }
}
