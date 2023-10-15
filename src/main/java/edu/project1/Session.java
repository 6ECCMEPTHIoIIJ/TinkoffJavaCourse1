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
            return null;
        } else {
            ++attemptsCount;
            return null;
        }
    }

    @NotNull public GuessResult giveUp() {
        return null;
    }

    private boolean isAnswerRight(char guess) {
        boolean isAnswerRight = false;
        for (int i = 0; i < maxAttempts; ++i) {
            if (answer.charAt(i) == guess) {
                userAnswer[i] = guess;
                isAnswerRight = true;
            }
        }

        return isAnswerRight;
    }
}
