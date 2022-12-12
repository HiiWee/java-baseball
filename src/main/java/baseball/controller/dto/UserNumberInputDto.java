package baseball.controller.dto;

import baseball.message.ErrorMessage;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserNumberInputDto {
    private static final int NUMBER_SIZE = 3;

    private final String numbers;

    public UserNumberInputDto(final String numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbersList() {
        return Arrays.stream(numbers.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void validate(final String userInput) {
        if (!isNumeric(userInput)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMERIC_ERROR);
        }
        if (isInvalidSize(userInput)) {
            throw new IllegalArgumentException(ErrorMessage.OUT_BOUNDS_NUMBERS_SIZE_ERROR);
        }
        if (isInvalidNumber(userInput)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_USER_NUMBER);
        }
    }

    private boolean isInvalidSize(final String userInput) {
        return userInput.length() != NUMBER_SIZE;
    }

    private boolean isNumeric(final String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException exception) {
            return false;
        }
        return true;
    }

    private boolean isInvalidNumber(final String userInput) {
        return isDuplicated(userInput) || isOutBound(userInput);
    }

    private boolean isOutBound(final String userInput) {
        return Arrays.stream(userInput.split(""))
                .map(Integer::parseInt)
                .anyMatch(number -> number < 1 || number > 9);
    }

    private boolean isDuplicated(final String userInput) {
        return NUMBER_SIZE != Arrays.stream(userInput.split(""))
                .distinct()
                .count();
    }
}
