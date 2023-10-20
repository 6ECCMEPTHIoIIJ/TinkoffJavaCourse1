package edu.project1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HangmanConsole {
    private static final Logger LOGGER = LogManager.getLogger();

    public void run() throws Exception {
        Session session = new Session("Aboba");
        Observer<SuccessfulGuessInfo> successfulGuessHandler = new Observer<>(s -> {
            LOGGER.info("Hit!");
            LOGGER.info("The word is {}", s.userAnswer());
        });

        Observer<FailedGuessInfo> failedGuessHandler = new Observer<>(s -> {
            LOGGER.info("Mistake {} of {}!", s.attemptsCount(), s.maxAttempts());
            LOGGER.info("The word is {}", s.userAnswer());
        });
        Observer<WinInfo> winHandler = new Observer<>(s -> {
            LOGGER.info("You win!");
            LOGGER.info("You guessed word {}", s.answer());
        });

        Observer<DefeatInfo> defeatHandler = new Observer<>(s -> {
            LOGGER.info("You lose!");
            LOGGER.info("The word was {}", s.answer());
        });

        session.addSuccessfulGuessHandler(successfulGuessHandler);
        session.addFailedGuessHandler(failedGuessHandler);
        session.addWinHandler(winHandler);
        session.addDefeatHandler(defeatHandler);

        session.guess('a');
        session.guess('c');
        session.guess('c');
        session.guess('c');
        session.guess('c');
        session.guess('c');

        successfulGuessHandler.unsubscribe();
        failedGuessHandler.unsubscribe();
        winHandler.unsubscribe();
        defeatHandler.unsubscribe();
    }
}
