package hexlet.code.games;

import hexlet.code.QuestionAndAnswer;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static hexlet.code.games.consts.Consts.LOWER_BOUND;

public final class Progression {
    /**
     * Для генерации случайных чисел.
     */
    private static final Random RANDOM = new Random();

    private Progression() {

    }

    public static String getMainQuestion() {
        return "What number is missing in the progression?";
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
        final int minLength = 5;
        final int additionalElementsMax = 5;
        int progressionLength = RANDOM.nextInt(additionalElementsMax) + minLength;
        int hiddenIndex = RANDOM.nextInt(progressionLength);

        int[] progression = createProgression(progressionLength);
        String question = IntStream.range(0, progressionLength).
                mapToObj(i -> i == hiddenIndex ? ".." : String.valueOf(progression[i])).
                collect(Collectors.joining(" "));

        return new QuestionAndAnswer(question, String.valueOf(progression[hiddenIndex]));
    }

    /**
     * Вспомогательная функция для построения арифметической прогрессии.
     *
     * @param progressionLength длинна прогрессии
     * @return массив с элементами прогрессии
     */
    private static int[] createProgression(final int progressionLength) {
        final int numberBound = 10;
        final int progressionStepBound = 10;
        final int firstNumber = RANDOM.nextInt(numberBound) + LOWER_BOUND;
        final int progressionStep = RANDOM.nextInt(progressionStepBound) + LOWER_BOUND;

        int currentElem = firstNumber;
        int[] result = new int[progressionLength];
        for (int i = 0; i < progressionLength; i++) {
            result[i] = currentElem;
            currentElem += progressionStep;
        }

        return result;
    }
}
