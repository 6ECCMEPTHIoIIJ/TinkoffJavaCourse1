package edu.project1;

import java.util.Scanner;

public class ConsoleHangman {
    private final HangmanDictionary dictionary = new HangmanDictionary();
    private final Scanner scanner = new Scanner(System.in);

    public void run() {
        String answer = dictionary.randomWord();
        Session session = new Session(answer.length(), answer);
        GuessResult guessResult;
        do {
            String input;
            do {
                System.out.println("Guess a letter: ");
                input = scanner.nextLine();
            } while (input != null && input.length() != 1);

            guessResult = (input == null)
                ? session.giveUp()
                : session.guess(input.charAt(0));
            System.out.println(guessResult.message());
            System.out.printf("The word: %s\n", guessResult.state());
        } while (!(guessResult instanceof Defeat || guessResult instanceof Win));
    }
}
