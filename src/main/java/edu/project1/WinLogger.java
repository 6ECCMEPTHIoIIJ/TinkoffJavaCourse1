package edu.project1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

public class WinLogger extends Observer<WinData> {
    private final static Logger LOGGER = LogManager.getLogger();

    @Override
    public void onNotification(@NotNull WinData info) {
        LOGGER.info("Yoy win!");
        LOGGER.info("Your answer is {}", info.answer());
    }
}
