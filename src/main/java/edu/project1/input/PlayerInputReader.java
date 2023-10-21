package edu.project1.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlayerInputReader {
    private String input;

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void readInput() throws IOException {
        input = reader.readLine();
        if (input != null) {
            input = input.trim().toLowerCase();
        }
    }

    public String getInput() {
        return input;
    }
}
