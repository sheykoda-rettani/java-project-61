package hexlet.code;


import hexlet.code.games.Calculator;
import hexlet.code.games.Even;
import hexlet.code.games.GreatestCommonDenominator;
import hexlet.code.games.GreetUser;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Scanner;

import static hexlet.code.GamesEnum.GREET_USER;


public final class Engine {
    /**
     * Для работы с пользовательским вводом.
     */
    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * Текст ошибки для случайного выбора не той игры.
     */
    private static final String HAS_NO_ROUNDS_OR_DESCRIPTION = "Game you have chosen doesn't have rounds or description";

    private Engine() {

    }

    public static void run() {
        int exitVal = 0;
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet\n2 - Even\n3 - Calculator\n4 - GCD\n5 - Progression\n6 - Prime\n0 - Exit");
        System.out.print("Your choice: ");
        try {
            int choice = Integer.parseInt(SCANNER.nextLine());
            if (choice > exitVal) {
                chooseAndStartGame(choice);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Not a valid game number");
        }
    }

    private static void chooseAndStartGame(final int choice) throws IllegalArgumentException {
        final int numberOfRounds = 3;
        final GamesEnum chosenGame = GamesEnum.fromValue(choice);
        String playerName = GreetUser.playGame();
        if (GREET_USER == chosenGame) {
            return;
        }
        askMainQuestion(chosenGame);
        for (int i = 0; i < numberOfRounds; i++) {
            QuestionAndAnswer questionAndAnswer = generateQuestionAndAnswer(chosenGame);
            System.out.println(questionAndAnswer.text());
            System.out.print("Your answer: ");
            String userAnswer = SCANNER.nextLine();

            if (!questionAndAnswer.checkAnswer(userAnswer)) {
                System.out.println(
                        "'" + userAnswer + "' is wrong answer ;(. Correct answer was '"
                                + questionAndAnswer.correctAnswer() + "'.");
                System.out.printf("Let's try again, %s!%n", playerName);
                return;
            }
        }
        System.out.printf("Congratulations, %s!%n", playerName);
    }

    private static void askMainQuestion(final GamesEnum chosenGame) throws IllegalArgumentException {
        String mainQuestion = switch (chosenGame) {
            case EVEN -> Even.getDescription();
            case CALCULATOR -> Calculator.getDescription();
            case GREATEST_COMMON_DENOMINATOR -> GreatestCommonDenominator.getDescription();
            case PROGRESSION -> Progression.getDescription();
            case PRIME -> Prime.getDescription();
            default -> throw new IllegalArgumentException(HAS_NO_ROUNDS_OR_DESCRIPTION);
        };
        System.out.println(mainQuestion);
    }

    private static QuestionAndAnswer generateQuestionAndAnswer(final GamesEnum chosenGame) {
        return switch (chosenGame) {
            case EVEN -> Even.generateQuestionAndAnswer();
            case CALCULATOR -> Calculator.generateQuestionAndAnswer();
            case GREATEST_COMMON_DENOMINATOR -> GreatestCommonDenominator.generateQuestionAndAnswer();
            case PROGRESSION -> Progression.generateQuestionAndAnswer();
            case PRIME -> Prime.generateQuestionAndAnswer();
            default -> throw new IllegalArgumentException(HAS_NO_ROUNDS_OR_DESCRIPTION);
        };
    }

}
