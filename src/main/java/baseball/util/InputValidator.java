package baseball.util;

import baseball.message.ErrorMessage;

public class InputValidator {
    private static final String RESTART = "1";
    private static final String END_GAME = "2";

    private InputValidator() {
    }

    public static int validateRestartInput(String userInput) {
        if (!userInput.equals(RESTART) && !userInput.equals(END_GAME)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RESTART_INPUT_ERROR);
        }
        return Integer.parseInt(userInput);
    }
}
