package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public class GameEven {
    private GameEven() {

    }

    public static void playGame(String playerName, Scanner scanner) {
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            int num = random.nextInt(100) + 1;
            System.out.println("Question: " + num);
            String answer = scanner.next().toLowerCase();

            boolean correctAnswer = ((num % 2 == 0) ? "yes" : "no").equals(answer);

            if (!correctAnswer) {
                System.out.println("\"" + answer + "\" is wrong answer ;(. Correct answer was \"" +
                        (num % 2 == 0 ? "yes" : "no") + "\".\nLet's try again, " + playerName + "!");
                return;
            }
        }
        System.out.println("Congratulations, " + playerName + "!");
    }
}