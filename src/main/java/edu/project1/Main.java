package edu.project1;

import edu.project1.core.GameManager;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        GameManager manager = new GameManager();
        manager.run();
    }
}
