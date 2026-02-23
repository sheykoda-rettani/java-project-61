package hexlet.code.games;

import hexlet.code.QuestionAndAnswer;

import java.util.Random;

import static hexlet.code.games.consts.Consts.LOWER_BOUND;
import static hexlet.code.games.consts.Consts.UPPER_BOUND;

public final class Even {
    /**
     * Для генерации случайных чисел.
     */
    private static final Random RANDOM = new Random();

    private Even() {

    }

    public static String getDescription() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    public static QuestionAndAnswer generateQuestionAndAnswer() {
        int num = RANDOM.nextInt(UPPER_BOUND) + LOWER_BOUND;
        String answer = (num % 2 == 0) ? "yes" : "no";
        return new QuestionAndAnswer(String.valueOf(num), answer);
    }
}
