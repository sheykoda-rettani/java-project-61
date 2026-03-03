package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.QuestionAndAnswer;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static hexlet.code.games.consts.Consts.UPPER_BOUND;

public final class GreatestCommonDenominator {
    /**
     * Для генерации случайных чисел.
     */
    private static final Random RANDOM = new Random();

    private GreatestCommonDenominator() {

    }

    public static void playGame(final String playerName, final int numberOfRounds) {
        List<QuestionAndAnswer> questionsAndAnswers = generateQuestionsAndAnswers(numberOfRounds);
        Engine.playGame(playerName, getMainQuestion(), questionsAndAnswers);
    }

    private static String getMainQuestion() {
        return "Find the greatest common divisor of given numbers.";
    }

    /**
     * Генерирует заданное количество пар вопрос-ответ для игры.
     *
     * @param numberOfRounds количество раундов (должно быть положительным)
     * @return список с парами вопрос-ответ
     * @throws IllegalArgumentException если передано отрицательное или нулевое значение количества раундов
     */
    private static List<QuestionAndAnswer> generateQuestionsAndAnswers(final int numberOfRounds) {
        if (numberOfRounds <= 0) {
            throw new IllegalArgumentException("Количество раундов должно быть больше нуля.");
        }

        return IntStream.range(0, numberOfRounds).
                mapToObj(i -> generateQuestionAndAnswer()).
                collect(Collectors.toList());
    }

    private static QuestionAndAnswer generateQuestionAndAnswer() {
        int lowerBoundGCD = 2;
        int num1 = RANDOM.nextInt(UPPER_BOUND) + lowerBoundGCD;
        int num2 = RANDOM.nextInt(UPPER_BOUND) + lowerBoundGCD;
        String expression = String.format("%d %d", num1, num2);
        int gcd = gcd(num1, num2);

        return new QuestionAndAnswer(expression, String.valueOf(gcd));
    }

    /**
     * Поиск НОД двух чисел.
     * @param a - первое число
     * @param b - второе число
     * @return наименьший общий делитель чисел a и b
     */
    @SuppressWarnings({"checkstyle:ParameterAssignment", "checkstyle:FinalParameters"})
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }
}
