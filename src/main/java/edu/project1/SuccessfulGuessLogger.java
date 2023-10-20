package edu.project1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

public class SuccessfulGuessLogger extends edu.project1.Observer<SuccessfulGuessData> {
    private final static Logger LOGGER = LogManager.getLogger();

    @Override
    public void onNotification(@NotNull SuccessfulGuessData info) {
        LOGGER.info("Hit!");
        LOGGER.info("The word is {}", info.userAnswer());
    }
}
