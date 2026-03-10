package hexlet.code;

import hexlet.code.games.Calculator;
import hexlet.code.games.Even;
import hexlet.code.games.GreatestCommonDenominator;
import hexlet.code.games.GreetUser;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Scanner;
import java.util.Set;

public final class App {
    /**
     * Для работы с пользовательским вводом.
     */
    private static final Scanner SCANNER = new Scanner(System.in);

    private App() { }

    public static void main(final String[] args) {
        final int exitVal = 0;
        final Set<Integer> validGameNumbers = Set.of(1, 2, 3, 4, 5, 6);
        outputMenu();
        try {
            int choice = Integer.parseInt(SCANNER.nextLine());
            if (exitVal == choice) {
                return;
            }
            if (validGameNumbers.contains(choice)) {
                final GamesEnum chosenGame = GamesEnum.fromValue(choice);
                runGame(chosenGame);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Not a valid game number");
        }
    }

    private static void runGame(final GamesEnum chosenGame) {
        switch (chosenGame) {
            case GREET_USER -> GreetUser.playGame();
            case EVEN -> Even.playGame();
            case CALCULATOR -> Calculator.playGame();
            case GREATEST_COMMON_DENOMINATOR -> GreatestCommonDenominator.playGame();
            case PROGRESSION -> Progression.playGame();
            case PRIME -> Prime.playGame();
            default -> throw new IllegalArgumentException("Game %s doesn't have rounds or description".
                     formatted(chosenGame));
        }
    }

    private static void outputMenu() {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calculator");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
    }
}
