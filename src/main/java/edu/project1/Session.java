package edu.project1;

import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

public class Session {
    private final int maxAttempts;
    private int attemptsCount = 0;
    private int userAnswerHitsCount = 0;
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

            return (userAnswerHitsCount == maxAttempts)
                ? new Win(attemptsCount, maxAttempts, Arrays.toString(userAnswer))
                : new SuccessfulGuess(attemptsCount, maxAttempts, Arrays.toString(userAnswer));
        } else {
            ++attemptsCount;

            return (attemptsCount == maxAttempts)
                ? new Defeat(attemptsCount, maxAttempts, Arrays.toString(userAnswer))
                : new FailedGuess(attemptsCount, maxAttempts, Arrays.toString(userAnswer));
        }
    }

    @NotNull public GuessResult giveUp() {
        return new Defeat(attemptsCount, maxAttempts, Arrays.toString(userAnswer));
    }

    private boolean isAnswerRight(char guess) {
        for (int i = 0; i < maxAttempts; ++i) {
            if (Character.toLowerCase(answer.charAt(i)) == Character.toLowerCase(guess)) {
                return true;
            }
        }

        return false;
    }

    private void updateAnswer(char guess) {
        for (int i = 0; i < maxAttempts; ++i) {
            if (Character.toLowerCase(answer.charAt(i)) == Character.toLowerCase(guess)) {
                userAnswer[i] = answer.charAt(i);
                ++userAnswerHitsCount;
            }
        }
    }
}
