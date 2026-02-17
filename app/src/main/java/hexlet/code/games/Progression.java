package hexlet.code.games;

import hexlet.code.Game;
import hexlet.code.QuestionAndAnswer;

import java.util.Random;

public final class Progression implements Game {
    /**
     * Для генерации случайных чисел.
     */
    private final Random random = new Random();

    @Override
    public String getDescription() {
        return "What number is missing in the progression?";
    }

    @Override
    public QuestionAndAnswer generateQuestionAndAnswer() {
        final int minLength = 5;
        final int additionalElementsMax = 5;
        final int firstNumber = random.nextInt(10) + 1;
        final int progressionStep = random.nextInt(10) + 1;

        int progressionLength = random.nextInt(additionalElementsMax) + minLength;
        int hiddenIndex = random.nextInt(progressionLength);
        Integer hiddenElem = null;

        StringBuilder sequenceString = new StringBuilder();
        int currentElem = firstNumber;
        for (int i = 0; i < progressionLength; i++) {
            if (i == hiddenIndex) {
                hiddenElem = currentElem;
                sequenceString.append(".. ");
            } else {
                sequenceString.append(currentElem).append(" ");
            }
            currentElem += progressionStep;
        }

        return new QuestionAndAnswer(sequenceString.toString().trim(), String.valueOf(hiddenElem));
    }
}
