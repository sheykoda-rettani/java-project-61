package hexlet.code.games;

import hexlet.code.QuestionAndAnswer;

import java.util.Random;

import static hexlet.code.games.consts.Consts.UPPER_BOUND;

public final class GreatestCommonDenominator {
    /**
     * Для генерации случайных чисел.
     */
    private static final Random RANDOM = new Random();

    private GreatestCommonDenominator() {

    }

    public static String getDescription() {
        return "Find the greatest common divisor of given numbers.";
    }

    public static QuestionAndAnswer generateQuestionAndAnswer() {
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
