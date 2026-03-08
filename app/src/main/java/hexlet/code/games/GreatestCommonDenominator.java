package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

import static hexlet.code.games.consts.Consts.UPPER_BOUND;

public final class GreatestCommonDenominator {
    /**
     * Для генерации случайных чисел.
     */
    private static final Random RANDOM = new Random();

    private GreatestCommonDenominator() { }

    public static void playGame() {
        String[][] questionsAndAnswers = generateQuestionsAndAnswers();
        Engine.playGame(getMainQuestion(), questionsAndAnswers);
    }

    private static String getMainQuestion() {
        return "Find the greatest common divisor of given numbers.";
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
        int lowerBoundGCD = 2;
        int num1 = RANDOM.nextInt(UPPER_BOUND) + lowerBoundGCD;
        int num2 = RANDOM.nextInt(UPPER_BOUND) + lowerBoundGCD;
        String expression = String.format("%d %d", num1, num2);
        int gcd = gcd(num1, num2);

        return new String[] {expression, String.valueOf(gcd)};
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
