package baseball.view;

public class OutputView {
    public static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";

    public static void printResult(final String resultMessage) {
        System.out.println(resultMessage);
    }

    public void printStartingGame() {
        System.out.println(START_MESSAGE);
    }
}
