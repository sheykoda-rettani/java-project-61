package hexlet.code.games;

import hexlet.code.Game;
import hexlet.code.QuestionAndAnswer;

import java.util.Random;

import static hexlet.code.games.consts.Consts.UPPER_BOUND;

public final class GreatestCommonDenominator implements Game {
    /**
     * Для генерации случайных чисел.
     */
    private final Random random = new Random();

    @Override
    public String getDescription() {
        return "Find the greatest common divisor of given numbers.";
    }

    @Override
    public QuestionAndAnswer generateQuestionAndAnswer() {
        int num1 = random.nextInt(UPPER_BOUND) + 1;
        int num2 = random.nextInt(UPPER_BOUND) + 1;
        String expression = String.format("%d %d", num1,  num2);
        int gcd = gcd(num1, num2);

        return new QuestionAndAnswer(expression, String.valueOf(gcd));
    }

    /**
     * Поиск НОД.
     */
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }
}
