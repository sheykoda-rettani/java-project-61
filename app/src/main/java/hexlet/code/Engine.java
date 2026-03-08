package hexlet.code;

import java.util.Scanner;

public final class Engine {
    /**
     * Для работы с пользовательским вводом.
     */
    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * Количество раундов, которые будут использованы.
     */
    public static final int NUMBER_OF_ROUNDS = 3;

    private Engine() {

    }

    /**
     * Запуск игры.
     * @param mainQuestion основной вопрос игры, например "вычислите значение выражения"
     * @param questionsAndAnswers список вопросов и ответов для игры
     */
    public static void playGame(final String mainQuestion,
                                final String[][] questionsAndAnswers) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String playerName = SCANNER.nextLine();
        System.out.printf("Hello, %s!%n", playerName);
        System.out.println(mainQuestion);
        for (String[] qaPair : questionsAndAnswers) {
            System.out.printf("Question: %s%n", qaPair[0]);
            System.out.print("Your answer: ");
            String userAnswer = SCANNER.nextLine();

            if (!userAnswer.equalsIgnoreCase(qaPair[1])) {
                System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.%n", userAnswer, qaPair[1]);
                System.out.printf("Let's try again, %s!%n", playerName);
                return;
            }
        }
        System.out.printf("Congratulations, %s!%n", playerName);
    }
}
