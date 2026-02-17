package hexlet.code.games;

import hexlet.code.Game;
import hexlet.code.QuestionAndAnswer;

import java.util.Random;

import static hexlet.code.games.consts.Consts.UPPER_BOUND;

public final class Calculator implements Game {
    /**
     * Для генерации случайных чисел.
     */
    private final Random random = new Random();

    /**
     * Допустимые операции.
     */
    private static final String OPERANDS = "+-*";

    @Override
    public String getDescription() {
        return "What is the result of the expression?";
    }

    @Override
    public QuestionAndAnswer generateQuestionAndAnswer() {
        int num1 = random.nextInt(UPPER_BOUND) + 1;
        int num2 = random.nextInt(UPPER_BOUND) + 1;
        char operator = OPERANDS.charAt(random.nextInt(OPERANDS.length()));

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
