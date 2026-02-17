package hexlet.code.games;

import hexlet.code.Game;
import hexlet.code.QuestionAndAnswer;

import java.util.Random;

public class Prime implements Game {
    /**
     * Для генерации случайных чисел.
     */
    private final Random random = new Random();

    @Override
    public String getDescription() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }

    @Override
    public QuestionAndAnswer generateQuestionAndAnswer() {
        final int primeCandidate = random.nextInt(99) + 2;

        boolean isPrime = checkIfPrime(primeCandidate);
        String correctAnswer = isPrime ? "yes" : "no";

        return new QuestionAndAnswer(String.valueOf(primeCandidate), correctAnswer);
    }


    /**
     * Вспомогательная функция для проверки простоты числа.
     */
    private boolean checkIfPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
