package edu.project1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

public class FailedGuessLogger extends Observer<FailedGuessData> {
    private final static Logger LOGGER = LogManager.getLogger();

    @Override
    public void onNotification(@NotNull FailedGuessData info) {
        LOGGER.info("Mistake, attempt {} of {}", info.attemptsCount(), info.maxAttempts());
        LOGGER.info("The word is {}", info.userAnswer());
    }
}
