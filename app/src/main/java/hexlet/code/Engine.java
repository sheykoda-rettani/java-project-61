package hexlet.code;

import java.util.List;
import java.util.Scanner;

public final class Engine {
    /**
     * Для работы с пользовательским вводом.
     */
    private static final Scanner SCANNER = new Scanner(System.in);

    private Engine() {

    }

    /**
     * Запуск игры.
     * @param playerName имя игрока
     * @param mainQuestion основной вопрос игры, например "вычислите значение выражения"
     * @param questionsAndAnswers список вопросов и ответов для игры
     */
    public static void playGame(final String playerName,
                                final String mainQuestion,
                                final List<QuestionAndAnswer> questionsAndAnswers) {
        System.out.println(mainQuestion);
        for (QuestionAndAnswer questionAndAnswer : questionsAndAnswers) {
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
}
