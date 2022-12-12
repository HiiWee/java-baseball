package baseball.domain;

import baseball.message.ErrorMessage;
import java.util.List;
import java.util.Objects;

public class ComputerNumber {
    public static final int MAX_LENGTH = 3;
    List<Integer> numbers;

    public ComputerNumber(final List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(final List<Integer> numbers) {
        if (numbers.size() != MAX_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.OUT_BOUNDS_NUMBERS_SIZE_ERROR);
        }
        if (isDuplicated(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBER_ERROR);
        }
        if (isOutBound(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.OUT_BOUNDS_NUMBERS_SIZE_ERROR);
        }
    }

    private boolean isDuplicated(final List<Integer> numbers) {
        return numbers.size() != numbers.stream()
                .distinct()
                .count();
    }

    private boolean isOutBound(final List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> number < 1 || number > 9);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ComputerNumber that = (ComputerNumber) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
