package hexlet.code.games;

import hexlet.code.Game;
import hexlet.code.QuestionAndAnswer;

import java.util.Random;

public class Calculator implements Game {
    Random random = new Random();

    @Override
    public String getDescription() {
        return "What is the result of the expression?";
    }

    @Override
    public QuestionAndAnswer generateQuestionAndAnswer() {
        int num1 = random.nextInt(100) + 1;
        int num2 = random.nextInt(100) + 1;
        char operator = "+-*".charAt(random.nextInt(3));

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
