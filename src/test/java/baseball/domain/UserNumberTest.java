package baseball.domain;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class UserNumberTest {

    private static Stream<Arguments> generateNumbers() {
        return Stream.of(
                Arguments.of(List.of(4, 5, 6), List.of(0, 0)),
                Arguments.of(List.of(7, 8, 9), List.of(0, 0)),
                Arguments.of(List.of(1, 4, 5), List.of(1, 0)),
                Arguments.of(List.of(1, 3, 4), List.of(1, 1)),
                Arguments.of(List.of(3, 2, 1), List.of(1 ,2)),
                Arguments.of(List.of(4, 2, 3), List.of(2, 0)),
                Arguments.of(List.of(1, 2, 3), List.of(3, 0))
        );
    }

    @ParameterizedTest
    @MethodSource("generateNumbers")
    @DisplayName("사용자가 입력한 값과 컴퓨터가 생성한 값의 정상 비교 테스트")
    void compareBaseballNumber_success(List<Integer> userNumbers, List<Integer> expectedResult) {
        // given
        ComputerNumber computerNumber = new ComputerNumber(List.of(1, 2, 3));

        // when
        UserNumber userNumber = new UserNumber(userNumbers);
        List<Integer> actualResult = userNumber.compare(computerNumber);

        // then
        Assertions.assertThat(actualResult.equals(expectedResult)).isTrue();
    }

}