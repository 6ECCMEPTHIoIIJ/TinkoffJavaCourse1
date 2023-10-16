package edu.project1;

import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

public class Session {
    private final int maxAttempts;
    private int attemptsCount = 0;
    private final String answer;
    private final char[] userAnswer;

    public Session(int maxAttempts, String answer) {
        this.maxAttempts = maxAttempts;
        this.answer = answer;
        userAnswer = new char[maxAttempts];
        Arrays.fill(userAnswer, '*');

    }

    @NotNull public GuessResult guess(char guess) {
        if (isAnswerRight(guess)) {
            updateAnswer(guess);

            return new SuccessfulGuess(attemptsCount, maxAttempts, answer);
        } else {
            ++attemptsCount;

            return (attemptsCount == maxAttempts)
                ? new Defeat(attemptsCount, maxAttempts, answer)
                : new FailedGuess(attemptsCount, maxAttempts, answer);
        }
    }

    @NotNull public GuessResult giveUp() {
        return new Defeat(attemptsCount, maxAttempts, answer);
    }

    private boolean isAnswerRight(char guess) {
        for (int i = 0; i < maxAttempts; ++i) {
            if (answer.charAt(i) == guess) {
                return true;
            }
        }

        return false;
    }

    private void updateAnswer(char guess) {
        for (int i = 0; i < maxAttempts; ++i) {
            if (answer.charAt(i) == guess) {
                userAnswer[i] = answer.charAt(i);
            }
        }
    }
}
