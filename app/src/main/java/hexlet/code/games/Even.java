package hexlet.code.games;

import hexlet.code.Game;
import hexlet.code.QuestionAndAnswer;

import java.util.Random;

import static hexlet.code.games.consts.Consts.UPPER_BOUND;

public final class Even implements Game {
    /**
     * Для генерации случайных чисел.
     */
    private final Random random = new Random();

    @Override
    public String getDescription() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    @Override
    public QuestionAndAnswer generateQuestionAndAnswer() {
        int num = random.nextInt(UPPER_BOUND) + 1;
        String answer = (num % 2 == 0) ? "yes" : "no";
        return new QuestionAndAnswer(String.valueOf(num), answer);
    }
}
