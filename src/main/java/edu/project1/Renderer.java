package edu.project1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

public class Renderer {
    private static final Logger LOGGER = LogManager.getLogger();
    private final StringBuilder screenBuffer = new StringBuilder();
    private final StringBuilder warnBuffer = new StringBuilder();

    public void updateScreen() {
        LOGGER.info(screenBuffer.toString());
        screenBuffer.delete(0, screenBuffer.length());
    }

    public void showWarnings() {
        LOGGER.warn(warnBuffer.toString());
        warnBuffer.delete(0, warnBuffer.length());
    }

    public void drawLogo() {
        screenBuffer.append("""

            ///////////////////
            // H A - N - G - //
            // - M - - A - N //
            ///////////////////""");
    }

    public void drawSeparator() {
        screenBuffer.append("\n[===============>\n");
    }

    public void drawSuccessGuessResult(GameSessionStats stats) {
        screenBuffer.append("[ HIT\n");
        drawStats(stats);
    }

    public void drawFailedGuessResult(@NotNull GameSessionStats stats) {
        screenBuffer.append(String.format("[ MISTAKE [%d] of [%d]\n", stats.attemptsCount(), stats.maxAttempts()));
        drawStats(stats);
    }

    public void drawWinResult(@NotNull GameSessionStats stats) {
        screenBuffer.append("[ VICTORY\n");
        screenBuffer.append(String.format(
            "[ You guessed word \"%s\" in [%d] attempts",
            stats.answer(),
            stats.attemptsCount()
        ));
    }

    public void drawLoseResult(@NotNull GameSessionStats stats) {
        screenBuffer.append("[ DEFEAT\n");
        screenBuffer.append(String.format("[ The word was %s", stats.answer()));
    }

    public void drawAskMessage() {
        screenBuffer.append("[ Guess a letter");
    }

    public void drawInvalidInputMessage(String str) {
        warnBuffer.append("\n[---------------/\n");
        warnBuffer.append(String.format("[ Invalid input <%s>", str));
    }

    public void drawDuplicatedInputMessage(Character ch) {
        warnBuffer.append("\n[---------------/\n");
        warnBuffer.append(String.format("[ Character <%c> was already used", ch));
    }

    private void drawStats(@NotNull GameSessionStats stats) {
        screenBuffer.append(String.format("[ The word is %s", stats.userAnswer()));
        screenBuffer.append(String.format("[ Attempts left %d", stats.maxAttempts() - stats.attemptsCount()));
    }

}
