package hexlet.code.games;

import hexlet.code.QuestionAndAnswer;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static hexlet.code.games.consts.Consts.LOWER_BOUND;
import static hexlet.code.games.consts.Consts.UPPER_BOUND;

public final class Even {
    /**
     * Для генерации случайных чисел.
     */
    private static final Random RANDOM = new Random();

    private Even() {

    }

    public static String getMainQuestion() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    /**
     * Генерирует заданное количество пар вопрос-ответ для игры.
     *
     * @param numberOfRounds количество раундов (должно быть положительным)
     * @return список с парами вопрос-ответ
     * @throws IllegalArgumentException если передано отрицательное или нулевое значение количества раундов
     */
    public static List<QuestionAndAnswer> generateQuestionsAndAnswers(final int numberOfRounds) {
        if (numberOfRounds <= 0) {
            throw new IllegalArgumentException("Количество раундов должно быть больше нуля.");
        }

        return IntStream.range(0, numberOfRounds).
                mapToObj(i -> generateQuestionAndAnswer()).
                collect(Collectors.toList());
    }

    public static QuestionAndAnswer generateQuestionAndAnswer() {
        int num = RANDOM.nextInt(UPPER_BOUND) + LOWER_BOUND;
        String answer = (num % 2 == 0) ? "yes" : "no";
        return new QuestionAndAnswer(String.valueOf(num), answer);
    }
}
