package hexlet.code;

import hexlet.code.games.GreetUser;

import java.util.Scanner;

public final class Engine {
    /**
     * Количество раундов игры.
     */
    private static final int ROUNDS_COUNT = 3;

    /**
     * Scanner, чтобы не определять его повторно.
     */
    private final Scanner scanner;

    public Engine(final Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Основной метод запуска игры.
     * @param game Игра, которая запускается
     */
    public void runGame(final Game game) {
        String playerName = GreetUser.playGame(scanner);
        System.out.println(game.getDescription());
        for (int round = 0; round < ROUNDS_COUNT; round++) {
            QuestionAndAnswer questionAndAnswer = game.generateQuestionAndAnswer();
            System.out.println(questionAndAnswer.text());
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine();

            if (!questionAndAnswer.checkAnswer(userAnswer)) {
                System.out.println(
                        "'" + userAnswer + "' is wrong answer ;(. Correct answer was '"
                                + questionAndAnswer.correctAnswer() + "'.");
                System.out.printf("Let's try again, %s!\n", playerName);
                return;
            }
        }
        System.out.printf("Congratulations, %s!\n", playerName);
    }
}
