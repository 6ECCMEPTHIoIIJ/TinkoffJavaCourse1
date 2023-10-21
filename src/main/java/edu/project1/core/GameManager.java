package edu.project1.core;

import edu.project1.input.InputChecker;
import edu.project1.input.PlayerInputReader;
import edu.project1.render.Writer;
import java.io.IOException;

public class GameManager {
    private final PlayerInputReader inputReader = new PlayerInputReader();
    private final InputChecker inputChecker;
    private final Writer writer = new Writer();

    public GameManager() {
        inputChecker = new InputChecker(inputReader, "abcdefghijklmnopqrstuvwxyz");
    }

    public void run() throws IOException {
        do {
            askQuestion();
            displayGuessInfo();
        } while (!isInputCorrect());
    }

    private boolean isInputCorrect() {
        return inputChecker.isInputCorrect() && !inputChecker.isInputDuplicated();
    }

    private void askQuestion() throws IOException {
        writer.askQuestion();
        writer.displayInfo();
        inputReader.readInput();
        inputChecker.checkInput();
    }

    private void displayGuessInfo() {
        if (!inputChecker.isInputCorrect()) {
            writer.warnIncorrectInput(inputReader.getInput());
            writer.displayWarnings();
        } else if (inputChecker.isInputDuplicated()) {
            writer.warnDuplicatedInput(inputReader.getInput());
            writer.displayWarnings();
        } else if (inputChecker.isTerminationInput()) {
            writer.infoTerminatedInput();
            writer.displayInfo();
        }
    }
}
