package edu.project1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class Session {
    private final SessionInfo sessionInfo;
    private final Observable<SuccessfulGuessInfo> successfulGuessEvent = new Observable<>();
    private final Observable<FailedGuessInfo> failedGuessEvent = new Observable<>();
    private final Observable<WinInfo> winEvent = new Observable<>();
    private final Observable<DefeatInfo> defeatEvent = new Observable<>();

    private int hitsCount = 0;
    private int attemptsCount = 0;

    private final Set<Character> letters = new HashSet<>();

    public Session(String answer) {
        this.sessionInfo = new SessionInfo(answer);
    }

    public void guess(char ch) {
        if (sessionInfo.containsCharacter(ch)) {
            ++hitsCount;
            letters.add(ch);
            sendSuccessNotification();
            if (hitsCount == sessionInfo.getMaxHits()) {
                sendWinNotification();
            }
        } else {
            ++attemptsCount;
            sendFailNotification();
            if (attemptsCount == sessionInfo.getMaxAttempts()) {
                sendDefeatNotification();
            }
        }
    }

    public void giveUp() {
        sendDefeatNotification();
    }

    public void addSuccessfulGuessHandler(@NotNull Observer<SuccessfulGuessInfo> handler) {
        handler.subscribe(successfulGuessEvent);
    }

    public void addFailedGuessHandler(@NotNull Observer<FailedGuessInfo> handler) {
        handler.subscribe(failedGuessEvent);
    }

    public void addWinHandler(@NotNull Observer<WinInfo> handler) {
        handler.subscribe(winEvent);
    }

    public void addDefeatHandler(@NotNull Observer<DefeatInfo> handler) {
        handler.subscribe(defeatEvent);
    }

    private void sendSuccessNotification() {
        successfulGuessEvent.sendNotification(new SuccessfulGuessInfo(getUserAnswer()));
    }

    private void sendFailNotification() {
        failedGuessEvent.sendNotification(new FailedGuessInfo(
            getUserAnswer(),
            attemptsCount,
            sessionInfo.getMaxAttempts()
        ));
    }

    private void sendWinNotification() {
        winEvent.sendNotification(new WinInfo(sessionInfo.getAnswer()));
    }

    private void sendDefeatNotification() {
        defeatEvent.sendNotification(new DefeatInfo(sessionInfo.getAnswer()));
    }

    @Contract(" -> new") private @NotNull String getUserAnswer() {
        char[] rawAnswer = new char[sessionInfo.getMaxAttempts()];
        Arrays.fill(rawAnswer, '-');

        for (Character ch : letters) {
            for (Integer i : sessionInfo.getPositionsOfCharacter(ch)) {
                rawAnswer[i] = sessionInfo.getAnswer().charAt(i);
            }
        }

        return new String(rawAnswer);
    }
}


