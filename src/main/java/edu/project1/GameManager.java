package edu.project1;

import java.io.IOException;

public class GameManager implements AutoCloseable {
    private final Renderer renderer = new Renderer();
    private final PlayerInputHandler inputHandler = new PlayerInputHandler();

    private Session session;

    private final Observer<GuessInputInfo> guessInputHandler;
    private final Observer<GiveUpInputTag> giveUpInputHandler;
    private final Observer<IncorrectInputInfo> incorrectInputHandler;
    private final Observer<DuplicatedInputInfo> duplicatedInputHandler;

    public GameManager() {
        guessInputHandler = new Observer<>(info -> session.guess(info.input()));

        giveUpInputHandler = new Observer<>(__ -> session.giveUp());

        incorrectInputHandler = new Observer<>(info -> {
            renderer.drawInvalidInputMessage(info.input());
            renderer.showWarnings();
            try {
                ask();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        duplicatedInputHandler = new Observer<>(info -> {
            renderer.drawDuplicatedInputMessage(info.input());
            renderer.showWarnings();
            try {
                ask();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        inputHandler.addGuessInputHandler(guessInputHandler);
        inputHandler.addIncorrectInputHandler(incorrectInputHandler);
        inputHandler.addGiveUpInputHandler(giveUpInputHandler);
        inputHandler.addDuplicatedInputHandler(duplicatedInputHandler);
    }

    @Override
    public void close() throws Exception {
        guessInputHandler.unsubscribe();
        incorrectInputHandler.unsubscribe();
        giveUpInputHandler.unsubscribe();
        duplicatedInputHandler.unsubscribe();
    }

    public void run() throws IOException {
        initializeSession();

        showLogo();
        while (true) {
            ask();
        }
    }

    private void initializeSession() {
        session = new Session("Aboba");
    }

    private void showLogo() {
        renderer.drawLogo();
        renderer.updateScreen();
    }

    private void ask() throws IOException {
        renderer.drawSeparator();
        renderer.drawAskMessage();
        renderer.updateScreen();

        inputHandler.readInput();
    }
}
