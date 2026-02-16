package hexlet.code;

import hexlet.code.games.GreetUser;

import java.util.Scanner;

public class Engine {
    private static final int ROUNDS_COUNT = 3;

    /**
     * Основной метод запуска игры
     */
    public static void runGame(Game game, Scanner scanner) {
        String playerName = GreetUser.playGame(scanner);
        System.out.println(game.getDescription());
        for (int round = 0; round < ROUNDS_COUNT; round++) {
            QuestionAndAnswer questionAndAnswer = game.generateQuestionAndAnswer();
            System.out.println(questionAndAnswer.text());
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine();

            if (!questionAndAnswer.checkAnswer(userAnswer)) {
                System.out.println(
                        "'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + questionAndAnswer.correctAnswer() + "'.");
                System.out.println("Let's try again, " + playerName + "!");
                return;
            }
        }
        System.out.println("Congratulations, " + playerName + "!");
    }
}
