package hexlet.code.games;

import hexlet.code.QuestionAndAnswer;

import java.util.Random;

import static hexlet.code.games.consts.Consts.UPPER_BOUND;

public final class Prime {
    /**
     * Для генерации случайных чисел.
     */
    private static final Random RANDOM = new Random();

    private Prime() {

    }

    public static String getDescription() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }

    public static QuestionAndAnswer generateQuestionAndAnswer() {
        int lowerBoundPrime = 2;
        final int primeCandidate = RANDOM.nextInt(UPPER_BOUND) + lowerBoundPrime;

        boolean isPrime = checkIfPrime(primeCandidate);
        String correctAnswer = isPrime ? "yes" : "no";

        return new QuestionAndAnswer(String.valueOf(primeCandidate), correctAnswer);
    }

    /**
     * Вспомогательная функция для проверки простоты числа.
     * @param num число для проверки
     * @return "yes" - когдда число простое и "no" - иначе
     */
    private static boolean checkIfPrime(final int num) {
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
