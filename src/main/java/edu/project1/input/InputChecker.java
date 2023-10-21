package edu.project1.input;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class InputChecker {
    private final PlayerInputReader inputReader;
    private final Set<Character> legalCharacters;

    private final Set<Character> usedCharacters = new HashSet<>();

    private boolean isTerminationInput;
    private boolean isInputCorrect;
    private boolean isInputDuplicated;

    public InputChecker(@NotNull PlayerInputReader inputReader, @NotNull String legalCharacters) {
        this.inputReader = inputReader;
        this.legalCharacters = legalCharacters.chars()
            .mapToObj(e -> Character.toLowerCase((char) e))
            .collect(Collectors.toCollection(HashSet::new));
        this.legalCharacters.add(null);
    }

    public void checkInput() {
        isTerminationInput = inputReader.getInput() == null;
        isInputCorrect = isTerminationInput
            || inputReader.getInput().length() == 1
            && legalCharacters.contains(inputReader.getInput().charAt(0));
        isInputDuplicated = !isTerminationInput
            && isInputCorrect
            && usedCharacters.contains(inputReader.getInput().charAt(0));
    }

    public void useInput() {
        if (!isInputCorrect || isInputDuplicated || isTerminationInput) {
            return;
        }

        usedCharacters.add(inputReader.getInput().charAt(0));
    }

    public boolean isTerminationInput() {
        return isTerminationInput;
    }

    public boolean isInputCorrect() {
        return isInputCorrect;
    }

    public boolean isInputDuplicated() {
        return isInputDuplicated;
    }
}
