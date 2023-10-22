package edu.project1;

import java.util.Scanner;

public final class Main {

    private Main() {
    }

    static Scanner scanner = new Scanner(System.in);
    static Dictionary dic = new Dictionary();

    @SuppressWarnings("RegexpSinglelineJava")
    public static void main(String[] args) {
        System.out.println("""
                \u001B[35mThis is HANGMAN game.
                Your task is to guess letters in the random words.
                "Ctrl + D" = finish the game
                Press "Enter" to continue.\u001B[0m""");
        nextInput();
        while (true) {
            Session session = new Session(dic.getRandomWord());
            while (true) {
                System.out.println("\u001B[35mCurrent word: \u001B[0m" + session.currentUserWord());
                System.out.println("\u001B[35mThese letters are available to you: \u001B[0m"
                    + session.availableLetters());
                System.out.println("\u001B[34mNumber mistakes: " + session.getMistakes()
                    + " from " + session.getMaxMistakes());
                System.out.println("\u001B[35mEnter only one letter\u001B[0m");
                String word = nextInput().toLowerCase();

                if (!session.correctInput(word)) {
                    System.out.println("\u001B[31mIncorrect input, please repeat\u001B[0m");
                    continue;
                }
                if (!session.tryLetter(word.charAt(0))) {
                    if (session.mistakesUp()) {
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
                    if (session.guessTheWord()) {
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































