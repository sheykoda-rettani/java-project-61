package hexlet.code;

import hexlet.code.games.*;

import java.util.Scanner;

public final class App {
    /**
     * Для работы с пользовательским вводом.
     */
    private static final Scanner SCANNER = new Scanner(System.in);

    private App() {

    }

    private static void chooseAndStartGame(final int gameNumber) throws IllegalArgumentException {
        GamesEnum selectedGame = GamesEnum.fromValue(gameNumber);
        Engine engine = new Engine(SCANNER);
        switch (selectedGame) {
            case GREET_USER:
                GreetUser.playGame(SCANNER);
                break;
            case EVEN_GAME:
                engine.runGame(new Even());
                break;
            case CALCULATOR_GAME:
                engine.runGame(new Calculator());
                break;
            case GREATEST_COMMON_DENOMINATOR:
                engine.runGame(new GreatestCommonDenominator());
                break;
            case PROGRESSION:
                engine.runGame(new Progression());
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    public static void main(final String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet\n2 - Even\n3 - Calculator\n4 - GCD\n5 - Progression\n0 - Exit");
        System.out.print("Your choice: ");
        try {
            int val = Integer.parseInt(SCANNER.nextLine());
            chooseAndStartGame(val);
        } catch (IllegalArgumentException e) {
            System.out.println("Not a valid game number");
        }
    }
}
