package baseball.service;

import baseball.controller.dto.UserNumberInputDto;
import baseball.domain.UserNumber;
import baseball.repository.ComputerNumberRepository;

public class GameService {
    private final ComputerNumberRepository computerNumberRepository = ComputerNumberRepository.getInstance();

    public void createCompareResult(final UserNumberInputDto userNumberInputDto) {
        UserNumber userNumber = new UserNumber(userNumberInputDto.getNumbersList());
    }

    public void initializeComputerNumber() {
        computerNumberRepository.generateComputerNumber();
    }
}
