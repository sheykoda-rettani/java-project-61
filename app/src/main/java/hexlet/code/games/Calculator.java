package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.QuestionAndAnswer;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public static void playGame(String playerName, int numberOfRounds) {
        List<QuestionAndAnswer> questionsAndAnswers = generateQuestionsAndAnswers(numberOfRounds);
        Engine.playGame(playerName, getMainQuestion(), questionsAndAnswers);
    }

    private static String getMainQuestion() {
        return "What is the result of the expression?";
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
        int num1 = RANDOM.nextInt(UPPER_BOUND) + LOWER_BOUND;
        int num2 = RANDOM.nextInt(UPPER_BOUND) + LOWER_BOUND;
        char operator = OPERANDS.charAt(RANDOM.nextInt(OPERANDS.length()));

        String expression = String.format("%d %s %d", num1, operator, num2);
        int result = calculateExpression(operator, num1, num2);

        return new QuestionAndAnswer(expression, String.valueOf(result));
    }

    /**
     * Вычисление результата арифметического выражения.
     *
     * @param operator символ операции ('+', '-', '*')
     * @param num1 первое число
     * @param num2 второе число
     * @return результат вычисления
     * @throws IllegalArgumentException если операция неизвестна
     */
    private static int calculateExpression(final char operator, final int num1, final int num2) {
        return switch (operator) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            default -> throw new IllegalArgumentException(String.
                    format("Can not compute expression %d %s %d. Operator %s not defined",
                            num1, operator, num2, operator));
        };
    }
}
