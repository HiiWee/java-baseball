package baseball.domain;

import java.util.List;

public class GameResult {
    private static final int STRIKE_INDEX = 0;
    private static final int BALL_INDEX = 0;
    private final int strike;
    private final int ball;

    public GameResult(final List<Integer> compare) {
        strike = compare.get(STRIKE_INDEX);
        ball = compare.get(BALL_INDEX);
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
