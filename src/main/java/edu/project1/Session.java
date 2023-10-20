package edu.project1;

public class Session implements AutoCloseable {

    private final String answer;
    private final char[] userAnswer;
    private final int maxAttempts;
    private int attemptsCount = 0;
    private int hitsCount = 0;

    private final SuccessfulGuessObservable successfulGuessObservable = new SuccessfulGuessObservable();
    private final FailedGuessObservable failedGuessObservable = new FailedGuessObservable();
    private final DefeatObservable defeatObservable = new DefeatObservable();
    private final WinObservable winObservable = new WinObservable();
    private final FailedGuessHandler failedGuessHandler;
    private final SuccessfulGuessHandler successfulGuessHandler;

    public Session(String answer) {
        this.answer = answer;
        this.maxAttempts = answer.length();

        userAnswer = new char[maxAttempts];
        java.util.Arrays.fill(userAnswer, '*');

        failedGuessHandler = new FailedGuessHandler(defeatObservable);
        successfulGuessHandler = new SuccessfulGuessHandler(winObservable);

        failedGuessHandler.subscribe(failedGuessObservable);
        successfulGuessHandler.subscribe(successfulGuessObservable);
    }

    public void guess(char guess) {
        if (updateAnswer(guess)) {
            successfulGuessObservable.sendNotification(new SuccessfulGuessData(
                new String(userAnswer), hitsCount, maxAttempts));
        } else {
            failedGuessObservable.sendNotification(new FailedGuessData(
                answer, new String(userAnswer), attemptsCount, maxAttempts));
        }
    }

    public void giveUp() {
        defeatObservable.sendNotification(new edu.project1.DefeatData(answer));
    }

    public DefeatObservable getDefeatObservable() {
        return defeatObservable;
    }

    public WinObservable getWinObservable() {
        return winObservable;
    }

    public SuccessfulGuessObservable getSuccessfulGuessObservable() {
        return successfulGuessObservable;
    }

    public FailedGuessObservable getFailedGuessObservable() {
        return failedGuessObservable;
    }

    @Override
    public void close() throws Exception {
        failedGuessHandler.unsubscribe();
        successfulGuessHandler.unsubscribe();
    }

    private boolean updateAnswer(char guess) {
        boolean isAnswerCorrect = java.util.stream.IntStream.range(0, maxAttempts).filter((i) -> {
            boolean isHit = false;
            if (Character.toLowerCase(answer.charAt(i)) == Character.toLowerCase(guess)) {
                ++hitsCount;
                userAnswer[i] = answer.charAt(i);
                isHit = true;
            }

            return isHit;
        }).count() > 0;

        if (!isAnswerCorrect) {
            ++attemptsCount;
        }

        return isAnswerCorrect;
    }
}
