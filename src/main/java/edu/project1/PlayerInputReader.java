package edu.project1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.jetbrains.annotations.NotNull;

public class PlayerInputReader {
    private final Observable<GuessInputInfo> guessInputEvent = new Observable<>();
    private final Observable<GiveUpInputTag> giveUpInputEvent = new Observable<>();
    private final Observable<IncorrectInputInfo> incorrectInputEvent = new Observable<>();

    private final BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));

    public void readInput() throws IOException {
        String rawInput = scanner.readLine();
        if (rawInput == null) {
            giveUpInputEvent.sendNotification(new GiveUpInputTag());
        } else if (rawInput.length() == 1 && Character.isLetter(rawInput.charAt(0))) {
            guessInputEvent.sendNotification(new GuessInputInfo(rawInput.charAt(0)));
        } else {
            incorrectInputEvent.sendNotification(new IncorrectInputInfo(rawInput));
        }
    }

    public void addGuessInputHandler(@NotNull Observer<GuessInputInfo> handler) {
        handler.subscribe(guessInputEvent);
    }

    public void addIncorrectInputHandler(@NotNull Observer<IncorrectInputInfo> handler) {
        handler.subscribe(incorrectInputEvent);
    }

    public void addGiveUpInputHandler(@NotNull Observer<GiveUpInputTag> handler) {
        handler.subscribe(giveUpInputEvent);
    }
}
