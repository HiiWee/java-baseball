package baseball.controller.dto;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.message.ErrorMessage;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class UserNumberInputDtoTest {

    private static Stream<Arguments> generateExceptionMessage() {
        return Stream.of(
                Arguments.of("120", ErrorMessage.INVALID_USER_NUMBER),
                Arguments.of("-234", ErrorMessage.OUT_BOUNDS_NUMBERS_SIZE_ERROR),
                Arguments.of("4 56", ErrorMessage.INVALID_NUMERIC_ERROR),
                Arguments.of("7899", ErrorMessage.OUT_BOUNDS_NUMBERS_SIZE_ERROR),
                Arguments.of("122", ErrorMessage.INVALID_USER_NUMBER)
        );
    }

    @ParameterizedTest
    @CsvSource({"123", "234", "456", "789", "153"})
    @DisplayName("사용자가 입력한 숫자 DTO 생성 통과 테스트")
    void userNumberInput_success(String userInput) {
        // when
        // then
        assertThatNoException().isThrownBy(() -> new UserNumberInputDto(userInput));
    }

    @ParameterizedTest
    @MethodSource("generateExceptionMessage")
    @DisplayName("사용자가 입력한 숫자 DTO 생성 실패 테스트")
    void userNumberInput_fail(String userInput, String errorMessage) {
        // when
        // then
        assertThatThrownBy(() -> new UserNumberInputDto(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorMessage);
    }
}