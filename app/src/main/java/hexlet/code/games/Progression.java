package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.QuestionAndAnswer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class Progression {
    /**
     * Для генерации случайных чисел.
     */
     
    private static final Random RANDOM = new Random();

    private Progression() { }

    public static void playGame(final String playerName, final int numberOfRounds) {
        List<QuestionAndAnswer> questionsAndAnswers = generateQuestionsAndAnswers(numberOfRounds);
        Engine.playGame(playerName, getMainQuestion(), questionsAndAnswers);
    }

    private static String getMainQuestion() {
        return "What number is missing in the progression?";
    }

    /**
     * Генерирует заданное количество пар вопрос-ответ для игры.
     *
     * @param numberOfRounds количество раундов (должно быть положительным)
     * @return список с парами вопрос-ответ
     * @throws IllegalArgumentException если передано отрицательное или нулевое значение количества раундов
     */
    private static List<QuestionAndAnswer> generateQuestionsAndAnswers(final int numberOfRounds) {
        if (numberOfRounds <= 0) {
            throw new IllegalArgumentException("Количество раундов должно быть больше нуля.");
        }

        List<QuestionAndAnswer> result = new ArrayList<>();
        for (int i = 0; i < numberOfRounds; i++) {
            result.add(generateQuestionAndAnswer());
        }
        return result;
    }

    /**
     * Генерирует одну пару вопрос-ответ.
     *
     * @return объект QuestionAndAnswer с вопросом и правильным ответом
     */
    private static QuestionAndAnswer generateQuestionAndAnswer() {
        final int numberBound = 10;
        final int progressionStepBound = 10;
        final int minLength = 5;
        final int additionalElementsMax = 5;
        int progressionLength = RANDOM.nextInt(additionalElementsMax) + minLength;
        int hiddenIndex = RANDOM.nextInt(progressionLength);

        int startValue = RANDOM.nextInt(numberBound) + 1;
        int step = RANDOM.nextInt(progressionStepBound) + 1;
        String[] progression = createProgression(startValue, step, progressionLength);

        StringBuilder questionBuilder = new StringBuilder();
        for (int i = 0; i < progression.length; i++) {
            if (i == hiddenIndex) {
                questionBuilder.append("..");
            } else {
                questionBuilder.append(progression[i]);
            }
            if (i != progression.length - 1) {
                questionBuilder.append(" ");
            }
        }
        String question = questionBuilder.toString().trim();

        return new QuestionAndAnswer(question, progression[hiddenIndex]);
    }

    /**
     * Создаёт арифметическую прогрессию как массив строк.
     *
     * @param startValue первое число прогрессии
     * @param step шаг прогрессии
     * @param length длина прогрессии
     * @return массив строк с элементами прогрессии
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
