package hexlet.code;

import hexlet.code.games.GameEven;
import hexlet.code.games.GreetUser;

import java.util.Scanner;

public final class App {
    static Scanner scanner = new Scanner(System.in);
    static String userName;

    private App() {

    }

    public static void chooseAndStartGame(int gameNumber) throws IllegalArgumentException {
        String playerName;
        switch(gameNumber) {
            case 1:
                GreetUser.playGame(scanner);
                break;
            case 2:
                playerName = GreetUser.playGame(scanner);
                GameEven.playGame(playerName, scanner);
                break;
            case 0:
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    public static void main(final String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet\n2 - Even\n0 - Exit");
        System.out.print("Your choice: ");
        try {
            int val = Integer.parseInt(scanner.nextLine());
            chooseAndStartGame(val);
        }
        catch (IllegalArgumentException e) {
            System.out.println("Not a valid game number");
        }
    }
}
