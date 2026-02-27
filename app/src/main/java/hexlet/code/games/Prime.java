package hexlet.code.games;

import hexlet.code.QuestionAndAnswer;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static hexlet.code.games.consts.Consts.UPPER_BOUND;

public final class Prime {
    /**
     * Для генерации случайных чисел.
     */
    private static final Random RANDOM = new Random();

    private Prime() {

    }

    public static String getMainQuestion() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
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
        int lowerBoundPrime = 2;
        final int primeCandidate = RANDOM.nextInt(UPPER_BOUND) + lowerBoundPrime;

        boolean isPrime = isNumberPrime(primeCandidate);
        String correctAnswer = isPrime ? "yes" : "no";

        return new QuestionAndAnswer(String.valueOf(primeCandidate), correctAnswer);
    }

    /**
     * Вспомогательная функция для проверки простоты числа.
     * @param num число для проверки
     * @return "yes" - когдда число простое и "no" - иначе
     */
    private static boolean isNumberPrime(final int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
