package edu.project1;

import org.jetbrains.annotations.NotNull;

public class SuccessfulGuessHandler extends Observer<SuccessfulGuessData> {
    private final WinObservable winObservable;

    public SuccessfulGuessHandler(edu.project1.WinObservable winObservable) {
        this.winObservable = winObservable;
    }

    @Override
    public void onNotification(@NotNull SuccessfulGuessData info) {
        if (info.hitsCount() == info.maxHits()) {
            winObservable.sendNotification(new WinData(info.userAnswer()));
        }
    }
}
