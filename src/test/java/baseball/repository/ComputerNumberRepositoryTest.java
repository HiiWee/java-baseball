package baseball.repository;

import baseball.domain.ComputerNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class ComputerNumberRepositoryTest {
    private final ComputerNumberRepository computerNumberRepository = ComputerNumberRepository.getInstance();

    @BeforeEach
    void clear() {
        computerNumberRepository.delete();
    }

    @RepeatedTest(100)
    @DisplayName("랜덤 컴퓨터 숫자 생성 반복 테스트")
    void generateComputerNumber() {
        // given
        // when
        ComputerNumber generatedComputerNumber = computerNumberRepository.generateComputerNumber();
        ComputerNumber findComputerNumber = computerNumberRepository.find();

        // then
        Assertions.assertThat(generatedComputerNumber).isEqualTo(findComputerNumber);
    }
}