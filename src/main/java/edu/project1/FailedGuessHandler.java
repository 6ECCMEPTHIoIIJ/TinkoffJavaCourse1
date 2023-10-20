package edu.project1;

import org.jetbrains.annotations.NotNull;

public class FailedGuessHandler extends Observer<FailedGuessData> {
    private final DefeatObservable defeatObservable;

    public FailedGuessHandler(edu.project1.DefeatObservable defeatObservable) {
        this.defeatObservable = defeatObservable;
    }

    @Override
    public void onNotification(@NotNull FailedGuessData info) {
        if (info.attemptsCount() == info.maxAttempts()) {
            defeatObservable.sendNotification(new DefeatData(info.answer()));
        }
    }
}
