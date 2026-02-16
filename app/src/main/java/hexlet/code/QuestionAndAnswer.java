package hexlet.code;

public record QuestionAndAnswer(String text, String correctAnswer) {

    public boolean checkAnswer(String userAnswer) {
        return userAnswer.equalsIgnoreCase(correctAnswer);
    }

    public String text() {
        return String.format("Question: %s", text);
    }
}
