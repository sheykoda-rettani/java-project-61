package hexlet.code;

import hexlet.code.games.Calculator;
import hexlet.code.games.Even;
import hexlet.code.games.GreetUser;

import java.util.Scanner;

public final class App {
    static Scanner scanner = new Scanner(System.in);

    private App() {

    }

    public static void chooseAndStartGame(int gameNumber) throws IllegalArgumentException {
        switch(gameNumber) {
            case 1:
                GreetUser.playGame(scanner);
                break;
            case 2:
                Engine.runGame(new Even(), scanner);
                break;
            case 3:
                Engine.runGame(new Calculator(), scanner);
                break;
            case 0:
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    public static void main(final String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet\n2 - Even\n3 - Calculator\n0 - Exit");
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
