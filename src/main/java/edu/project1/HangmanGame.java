package edu.project1;

import java.util.ArrayList;
import java.util.Scanner;

public class HangmanGame {
    private HangmanGame() {
    }

    static Scanner scanner = new Scanner(System.in);
    private static final ArrayList<String> WORDS = new ArrayList<>();


    @SuppressWarnings("RegexpSinglelineJava")
    public static void hangmanGameRun() {
        WORDS.add("Programming");
        WORDS.add("Computer");
        WORDS.add("Development");
        WORDS.add("Game");
        WORDS.add("Algorithm");
        WORDS.add("hello1");
        WORDS.add("cat");
        Dictionary dic = new Dictionary(WORDS);

        System.out.println("""
                \u001B[35mThis is HANGMAN game.
                Your task is to guess letters in the random words.
                "Ctrl + D" = finish the game
                Press "Enter" to continue.\u001B[0m""");
        nextInput();

        while (true) {
            Session session = new Session(dic.getRandomWord());
            while (true) {
                session.firstWords();
                String word = nextInput().toLowerCase();

                if (!session.isCorrectInput(word)) {
                    System.out.println("\u001B[31mIncorrect input, please repeat\u001B[0m");
                    continue;
                }
                if (!session.isTryLetter(word.charAt(0))) {
                    if (session.isMistakeCheck()) {
                        System.out.println("\u001B[31mYou didn't guess the letter.");
                    } else {
                        System.out.println("""
                            \u001B[31mYou lose
                            \u001B[32mPress enter to next round
                            \u001B[32mOr "Ctrl+D" to exit \u001B[0m
                                                """);
                        nextInput();
                        break;
                    }
                } else {
                    System.out.println("\u001B[32mYou geuss the letter!");
                    if (session.isGuessTheWord()) {
                        System.out.println("\u001B[29 mYou guess the word!");
                        System.out.println("Word: \u001B[0m" + session.currentUserWord());
                        System.out.println("CONGRATULATION!");
                        System.out.println("\u001B[32mPress enter to next round");
                        System.out.println("\u001B[32mOr \"Ctrl+D\" to exit");
                        nextInput();
                        break;
                    }
                }
            }
        }
    }

    @SuppressWarnings("RegexpSinglelineJava")
    public static String nextInput() {
        if (scanner.hasNextLine()) {
            return scanner.nextLine();
        }
        System.out.println("The end.");
        System.exit(0);
        return null;
    }
}
