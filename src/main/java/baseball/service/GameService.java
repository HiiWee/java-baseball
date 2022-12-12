package baseball.service;

import baseball.controller.dto.UserNumberInputDto;
import baseball.domain.GameResult;
import baseball.domain.UserNumber;
import baseball.repository.ComputerNumberRepository;

public class GameService {
    private final ComputerNumberRepository computerNumberRepository = ComputerNumberRepository.getInstance();

    public GameResult createCompareResult(final UserNumberInputDto userNumberInputDto) {
        UserNumber userNumber = new UserNumber(userNumberInputDto.getNumbersList());
        return new GameResult(userNumber.getResultList(computerNumberRepository.find()));
    }

    public void initializeComputerNumber() {
        computerNumberRepository.generateComputerNumber();
    }
}
