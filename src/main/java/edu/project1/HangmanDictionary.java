package edu.project1;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.jetbrains.annotations.NotNull;

public class HangmanDictionary implements Dictionary {
    private final List<String> words = Arrays.asList(
        "Hello",
        "Sword",
        "Art",
        "Online"
    );

    private final Random random = new Random();

    @Override
    public @NotNull String randomWord() {
        return words.get(random.nextInt(0, words.size()));
    }
}
