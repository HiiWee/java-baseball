package baseball.domain.enums;

import baseball.domain.GameResult;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class GameResultStatusTest {

    private static Stream<Arguments> generateGameResult() {
        return Stream.of(
                Arguments.of(List.of(1, 0), "1스트라이크"),
                Arguments.of(List.of(2, 0), "2스트라이크"),
                Arguments.of(List.of(3, 0), "3스트라이크"),
                Arguments.of(List.of(2, 1), "1볼 2스트라이크"),
                Arguments.of(List.of(0, 1), "1볼"),
                Arguments.of(List.of(0, 3), "3볼"),
                Arguments.of(List.of(1, 2), "2볼 1스트라이크")
        );
    }

    @ParameterizedTest
    @MethodSource("generateGameResult")
    @DisplayName("올바른 결과 메시지 정상 출력 테스트")
    void rightMessage(List<Integer> results, String expectedMessage) {
        // given
        // when
        GameResult gameResult = new GameResult(results);
        String actualMessage = GameResultStatus.createResultMessage(gameResult);

        // then
        Assertions.assertThat(actualMessage).isEqualTo(expectedMessage);
    }

}