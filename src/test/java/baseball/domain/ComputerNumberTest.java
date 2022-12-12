package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.message.ErrorMessage;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ComputerNumberTest {

    @ParameterizedTest
    @CsvSource({"1,2,3", "1,3,4", "1,5,9", "7,8,9"})
    @DisplayName("컴퓨터 숫자 정의 성공 테스트")
    void randomComputerNumber_generate_success(int first, int second, int third) {
        // given
        List<Integer> numbers = List.of(first, second, third);

        // when
        // then
        assertThatNoException().isThrownBy(() -> new ComputerNumber(numbers));
    }

    @ParameterizedTest
    @CsvSource({"0,2,3", "1,-1,4", "1,5,11", "-20,8,9"})
    @DisplayName("컴퓨터 숫자 정의 성공 테스트")
    void randomComputerNumber_generate_fail(int first, int second, int third) {
        // given
        List<Integer> numbers = List.of(first, second, third);

        // when
        // then
        Assertions.assertAll(() -> {
            assertThatThrownBy(() -> new ComputerNumber(numbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ErrorMessage.OUT_BOUNDS_NUMBERS_SIZE_ERROR);
            assertThatThrownBy(() -> new ComputerNumber(List.of(1, 2)))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ErrorMessage.OUT_BOUNDS_NUMBERS_SIZE_ERROR);
        });

    }

}