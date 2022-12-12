package baseball.domain.enums;

import baseball.domain.GameResult;

public enum GameResultStatus {
    STRIKE("%d스트라이크"),
    BALL("%d볼"),
    NOTHING("낫싱");

    public static final String EMPTY = " ";
    private final String value;

    GameResultStatus(final String value) {
        this.value = value;
    }

    public static String createResultMessage(final GameResult gameResult) {
        if (gameResult.isNothing()) {
            return NOTHING.value;
        }
        return createStrikeAndBallMessage(gameResult);
    }

    private static String createStrikeAndBallMessage(final GameResult gameResult) {
        if (gameResult.hasBall() && gameResult.hasStrike()) {
            return String.format(BALL.value, gameResult.getBall()) + EMPTY + String.format(STRIKE.value,
                    gameResult.getStrike());
        }
        if (gameResult.hasStrike()) {
            return String.format(STRIKE.value, gameResult.getStrike());
        }
        return String.format(BALL.value, gameResult.getBall());
    }
}
