package hexlet.code.games;

import hexlet.code.QuestionAndAnswer;

import java.util.Random;

import static hexlet.code.games.consts.Consts.LOWER_BOUND;
import static hexlet.code.games.consts.Consts.UPPER_BOUND;

public final class Calculator {
    /**
     * Для генерации случайных чисел.
     */
    private static final Random RANDOM = new Random();

    /**
     * Допустимые операции.
     */
    private static final String OPERANDS = "+-*";

    private Calculator() {

    }

    public static String getDescription() {
        return "What is the result of the expression?";
    }

    public static QuestionAndAnswer generateQuestionAndAnswer() {
        int num1 = RANDOM.nextInt(UPPER_BOUND) + LOWER_BOUND;
        int num2 = RANDOM.nextInt(UPPER_BOUND) + LOWER_BOUND;
        char operator = OPERANDS.charAt(RANDOM.nextInt(OPERANDS.length()));

        String expression = String.format("%d %s %d", num1, operator, num2);
        int result = switch (operator) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            default -> 0;
        };

        return new QuestionAndAnswer(expression, String.valueOf(result));
    }
}
