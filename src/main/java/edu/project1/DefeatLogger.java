package edu.project1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

public class DefeatLogger extends Observer<DefeatData> {
    private final static Logger LOGGER = LogManager.getLogger();

    @Override
    public void onNotification(@NotNull DefeatData info) {
        LOGGER.info("You lose!");
        LOGGER.info("The word was {}", info.answer());
    }
}
