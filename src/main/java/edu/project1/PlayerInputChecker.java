package edu.project1;

import java.util.HashSet;
import java.util.Set;

public class PlayerInputChecker {
    private final Set<Character> usedLetters = new HashSet<>();

    public void useLetter(char ch) {
        usedLetters.add(Character.toLowerCase(ch));
    }

    public boolean isLetterUsed(char ch) {
        return usedLetters.contains(Character.toLowerCase(ch));
    }
}
