package edu.project1.core;

import java.util.List;
import java.util.Random;

public class Dictionary {
    private final List<String> words;

    public Dictionary(List<String> words) {
        this.words = words;
    }

    public String getRandomWord() {
        return words.get(Random.from(() -> {}).nextInt())
    }
}
