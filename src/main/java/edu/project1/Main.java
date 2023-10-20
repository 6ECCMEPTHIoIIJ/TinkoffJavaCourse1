package edu.project1;

public class Main {
    private Main() {

    }

    public static void main(String[] args) throws Exception {
        try (GameManager gameManager = new GameManager()) {
            gameManager.run();
        }
    }
}
