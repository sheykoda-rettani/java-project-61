package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

import static hexlet.code.games.consts.Consts.UPPER_BOUND;

public final class Even {
    /**
     * Для генерации случайных чисел.
     */
    private static final Random RANDOM = new Random();

    private Even() { }

    public static void playGame() {
        String[][] questionsAndAnswers = generateQuestionsAndAnswers();
        Engine.playGame(getMainQuestion(), questionsAndAnswers);
    }

    private static String getMainQuestion() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    /**
     * Генерирует заданное количество пар вопрос-ответ для игры.
     *
     * @return список с парами вопрос-ответ
     * @throws IllegalArgumentException если передано отрицательное или нулевое значение количества раундов
     */
    private static String[][] generateQuestionsAndAnswers() {
        String[][] result = new String[Engine.NUMBER_OF_ROUNDS][];
        for (int i = 0; i < Engine.NUMBER_OF_ROUNDS; i++) {
            result[i] = generateQuestionAndAnswer();
        }
        return result;
    }

    private static String[] generateQuestionAndAnswer() {
        int num = RANDOM.nextInt(UPPER_BOUND) + 1;
        String answer = (num % 2 == 0) ? "yes" : "no";
        return new String[] {Integer.toString(num), answer};
    }
}
