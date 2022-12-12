package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static final String SUCCESS_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String NEW_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String INPUT_USER_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";

    public String inputRestart() {
        System.out.println(SUCCESS_MESSAGE);
        System.out.println(NEW_GAME_MESSAGE);
        return Console.readLine();
    }

    public String inputUserNumbers() {
        System.out.print(INPUT_USER_NUMBERS_MESSAGE);
        return Console.readLine();
    }
}
