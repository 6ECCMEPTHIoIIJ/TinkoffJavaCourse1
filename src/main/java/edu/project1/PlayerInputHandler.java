package edu.project1;

import java.io.IOException;
import org.jetbrains.annotations.NotNull;

public class PlayerInputHandler implements AutoCloseable {
    private final PlayerInputReader inputReader = new PlayerInputReader();
    private final PlayerInputChecker inputChecker = new PlayerInputChecker();

    private final Observable<GuessInputInfo> guessInputEvent = new Observable<>();
    private final Observable<GiveUpInputTag> giveUpInputEvent = new Observable<>();
    private final Observable<IncorrectInputInfo> incorrectInputEvent = new Observable<>();
    private final Observable<DuplicatedInputInfo> duplicatedInputEvent = new Observable<>();

    private final Observer<GuessInputInfo> guessInputHandler;
    private final Observer<GiveUpInputTag> giveUpInputHandler;
    private final Observer<IncorrectInputInfo> incorrectInputHandler;

    public PlayerInputHandler() {
        guessInputHandler = new Observer<>(info -> {
            if (inputChecker.isLetterUsed(info.input())) {
                duplicatedInputEvent.sendNotification(new DuplicatedInputInfo(info.input()));
            } else {
                guessInputEvent.sendNotification(info);
                inputChecker.useLetter(info.input());
            }
        });

        giveUpInputHandler = new Observer<>(giveUpInputEvent::sendNotification);

        incorrectInputHandler = new Observer<>(incorrectInputEvent::sendNotification);

        inputReader.addGuessInputHandler(guessInputHandler);
        inputReader.addIncorrectInputHandler(incorrectInputHandler);
        inputReader.addGiveUpInputHandler(giveUpInputHandler);
    }

    public void readInput() throws IOException {
        inputReader.readInput();
    }

    @Override
    public void close() throws Exception {
        guessInputHandler.unsubscribe();
        incorrectInputHandler.unsubscribe();
        giveUpInputHandler.unsubscribe();
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

    public void addDuplicatedInputHandler(@NotNull Observer<DuplicatedInputInfo> handler) {
        handler.subscribe(duplicatedInputEvent);
    }
}
