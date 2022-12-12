package baseball.message;

public class ErrorMessage {

    public static final String INVALID_RESTART_INPUT_ERROR = "[ERROR] 잘못된 게임 재시작 여부 입력입니다.";
    public static final String OUT_BOUNDS_NUMBERS_SIZE_ERROR = "[ERROR] 컴퓨터 숫자의 개수는 3개여야 합니다.";
    public static final String DUPLICATED_NUMBER_ERROR = "[ERROR] 컴퓨터 숫자는 동일한 숫자가 존재하면 안됩니다.";

    private ErrorMessage() {
    }
}
