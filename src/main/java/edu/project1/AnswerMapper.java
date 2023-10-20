package edu.project1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import org.jetbrains.annotations.NotNull;

public class AnswerMapper {
    private final Map<Character, List<Integer>> letters = new HashMap<>();

    public AnswerMapper(@NotNull String answer) {
        IntStream.range(0, answer.length()).forEach(
            (i) -> {
                Character ch = Character.toLowerCase(answer.charAt(i));
                if (!letters.containsKey(ch)) {
                    letters.put(ch, new ArrayList<>());
                }

                letters.computeIfPresent(ch, (__, positions) -> {
                    positions.add(i);
                    return positions;
                });
            }
        );
    }

    public Map<Character, List<Integer>> getLetters() {
        return letters;
    }
}
