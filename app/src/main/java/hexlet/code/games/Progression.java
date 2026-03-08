package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Arrays;
import java.util.Random;

public final class Progression {
    /**
     * Для генерации случайных чисел.
     */
    private static final Random RANDOM = new Random();

    private Progression() { }

    public static void playGame() {
        String[][] questionsAndAnswers = generateQuestionsAndAnswers();
        Engine.playGame(getMainQuestion(), questionsAndAnswers);
    }

    private static String getMainQuestion() {
        return "What number is missing in the progression?";
    }

    /**
     * Генерирует заданное количество пар вопрос-ответ для игры.
     *
     * @return список с парами вопрос-ответ
     * @throws IllegalArgumentException если передано отрицательное или нулевое значение количества раундов
     */
    private static String[][] generateQuestionsAndAnswers() {
        String[][] result = new String[Engine.NUMBER_OF_ROUNDS][];
        for (int i = 0; i < Engine.NUMBER_OF_ROUNDS; i++) {
            result[i] = generateQuestionAndAnswer();
        }
        return result;
    }

    private static String[] generateQuestionAndAnswer() {
        final int numberBound = 10;
        final int progressionStepBound = 10;
        final int minLength = 5;
        final int additionalElementsMax = 5;
        int progressionLength = RANDOM.nextInt(additionalElementsMax) + minLength;
        int hiddenIndex = RANDOM.nextInt(progressionLength);
        final String delimiter = " ";

        int startValue = RANDOM.nextInt(numberBound) + 1;
        int step = RANDOM.nextInt(progressionStepBound) + 1;
        String[] progression = createProgression(startValue, step, progressionLength);

        String question = String.join(delimiter, Arrays.copyOfRange(progression, 0, hiddenIndex))
                + " .. "
                + String.join(delimiter, Arrays.copyOfRange(progression, hiddenIndex + 1, progression.length));

        return new String[] {question.trim(), progression[hiddenIndex]};
    }

    /**
     * Создает последовательность арифметической прогрессии.
     * @param startValue Начальное значение прогрессии.
     * @param step Шаг прогрессии.
     * @param length Длина прогрессии.
     * @return Массив строк с числами прогрессии.
     */
    private static String[] createProgression(final int startValue, final int step, final int length) {
        String[] result = new String[length];
        int currentElement = startValue;
        for (int i = 0; i < length; i++) {
            result[i] = Integer.toString(currentElement);
            currentElement += step;
        }
        return result;
    }
}
