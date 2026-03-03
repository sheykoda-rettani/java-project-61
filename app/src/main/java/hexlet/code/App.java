package hexlet.code;

import hexlet.code.games.Calculator;
import hexlet.code.games.Even;
import hexlet.code.games.GreatestCommonDenominator;
import hexlet.code.games.GreetUser;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Scanner;
import java.util.Set;

import static hexlet.code.GamesEnum.GREET_USER;

public final class App {
    /**
     * Для работы с пользовательским вводом.
     */
    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * Текст ошибки для случайного выбора не той игры.
     */
    private static final String HAS_NO_ROUNDS_OR_DESCRIPTION =
            "Game you have chosen doesn't have rounds or description";

    private App() {

    }

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
                final String playerName = GreetUser.playGame();
                if (GREET_USER == chosenGame) {
                    return;
                }
                runGame(playerName, chosenGame);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Not a valid game number");
        }
    }

    private static void runGame(final String playerName, final GamesEnum chosenGame) {
        final int numberOfRounds = 3;
        switch (chosenGame) {
            case EVEN -> Even.playGame(playerName, numberOfRounds);
            case CALCULATOR -> Calculator.playGame(playerName, numberOfRounds);
            case GREATEST_COMMON_DENOMINATOR -> GreatestCommonDenominator.playGame(playerName, numberOfRounds);
            case PROGRESSION -> Progression.playGame(playerName, numberOfRounds);
            case PRIME -> Prime.playGame(playerName, numberOfRounds);
            default -> throw new IllegalArgumentException(HAS_NO_ROUNDS_OR_DESCRIPTION);
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
