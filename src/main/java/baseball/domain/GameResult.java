package baseball.domain;

import java.util.List;

public class GameResult {
    private static final int STRIKE_INDEX = 0;
    private static final int BALL_INDEX = 1;
    private final int strike;
    private final int ball;

    public GameResult(final List<Integer> gameResults) {
        strike = gameResults.get(STRIKE_INDEX);
        ball = gameResults.get(BALL_INDEX);
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }

    public boolean hasBall() {
        return ball > 0;
    }

    public boolean hasStrike() {
        return strike > 0;
    }

    public boolean isWinning() {
        return strike == 3;
    }
}
