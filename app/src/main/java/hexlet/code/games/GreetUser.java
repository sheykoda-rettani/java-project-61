package hexlet.code.games;

import java.util.Scanner;

public class GreetUser {
    private GreetUser() {

    }

    public static String playGame(Scanner scanner) {
        System.out.println("Welcome to the Brain Games! ");

        System.out.print("May I have your name? ");
        String userName = scanner.nextLine();

        System.out.printf("Hello, %s!\n", userName);
        return userName;
    }
}
