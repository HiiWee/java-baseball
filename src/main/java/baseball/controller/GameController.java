package baseball.controller;

import baseball.controller.dto.UserNumberInputDto;
import baseball.domain.GameResult;
import baseball.domain.enums.GameResultStatus;
import baseball.service.GameService;
import baseball.util.InputValidator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    public static final int RESTART = 1;
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final GameService gameService = new GameService();

    public void start() {
        outputView.printStartingGame();
        do {
            initializeGame();
            requestUserNumbers();
        } while (InputValidator.validateRestartInput(inputView.inputRestart()) == RESTART);
    }

    private void requestUserNumbers() {
        GameResult gameResult;
        do {
            gameResult = gameService.createCompareResult(new UserNumberInputDto(inputView.inputUserNumbers()));
            OutputView.printResult(GameResultStatus.createResultMessage(gameResult));
        } while (!gameResult.isWinning());
    }

    private void initializeGame() {
        gameService.initializeComputerNumber();
    }
}
