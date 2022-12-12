package baseball.controller;

import baseball.util.InputValidator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    public static final int RESTART = 1;
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public void start() {
        outputView.printStartingGame();
        do {

        } while (InputValidator.validateRestartInput(inputView.inputRestart()) == RESTART);
    }
}
