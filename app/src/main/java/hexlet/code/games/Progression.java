package hexlet.code.games;

import hexlet.code.QuestionAndAnswer;

import java.util.Random;

import static hexlet.code.games.consts.Consts.LOWER_BOUND;

public final class Progression {
    /**
     * Для генерации случайных чисел.
     */
    private static final Random RANDOM = new Random();

    private Progression () {

    }

    public static String getDescription() {
        return "What number is missing in the progression?";
    }

    public static QuestionAndAnswer generateQuestionAndAnswer() {
        final int minLength = 5;
        final int additionalElementsMax = 5;
        final int numberBound = 10;
        final int progressionStepBound = 10;
        final int firstNumber = RANDOM.nextInt(numberBound) + LOWER_BOUND;
        final int progressionStep = RANDOM.nextInt(progressionStepBound) + LOWER_BOUND;

        int progressionLength = RANDOM.nextInt(additionalElementsMax) + minLength;
        int hiddenIndex = RANDOM.nextInt(progressionLength);
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
