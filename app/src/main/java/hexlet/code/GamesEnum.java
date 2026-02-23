package hexlet.code;

public enum GamesEnum {
    GREET_USER(1),
    EVEN(2),
    CALCULATOR(3),
    GREATEST_COMMON_DENOMINATOR(4),
    PROGRESSION(5),
    PRIME(6);

    /**
     * Числовое значение ("код" игры).
     */
    private final int gameCode;

    GamesEnum(final int gameCode) {
        this.gameCode = gameCode;
    }

    public int getGameCode() {
        return gameCode;
    }

    public static GamesEnum fromValue(final int value) {
        for (GamesEnum game : values()) {
            if (game.getGameCode() == value) {
                return game;
            }
        }
        throw new IllegalArgumentException("Invalid game number: " + value);
    }
}
