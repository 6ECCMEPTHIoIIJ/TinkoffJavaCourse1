package edu.project1;

public class HangmanConsole {
    private final FailedGuessLogger failedGuessLogger = new edu.project1.FailedGuessLogger();
    private final SuccessfulGuessLogger successfulGuessLogger = new edu.project1.SuccessfulGuessLogger();
    private final WinLogger winLogger = new edu.project1.WinLogger();
    private final DefeatLogger defeatLogger = new edu.project1.DefeatLogger();

    public void run() throws Exception {
        try (Session session = new edu.project1.Session("Aboba")) {
            failedGuessLogger.subscribe(session.getFailedGuessObservable());
            successfulGuessLogger.subscribe(session.getSuccessfulGuessObservable());

            winLogger.subscribe(session.getWinObservable());
            defeatLogger.subscribe(session.getDefeatObservable());

            session.guess('a');
            session.guess('o');
            session.guess('b');

            failedGuessLogger.unsubscribe();
            successfulGuessLogger.unsubscribe();
            winLogger.unsubscribe();
            defeatLogger.unsubscribe();
        }
    }
}
