package baseball.domain;

import baseball.message.ErrorMessage;
import java.util.List;

public class ComputerNumber {
    public static final int MAX_LENGTH = 3;
    List<Integer> numbers;

    public ComputerNumber(final List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(final List<Integer> numbers) {
        if (numbers.size() == MAX_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.OUT_BOUNDS_NUMBERS_SIZE_ERROR);
        }
        if (!isValidNumbers(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBER_ERROR);
        }
    }

    private boolean isValidNumbers(final List<Integer> numbers) {
        return numbers.size() == numbers.stream()
                .distinct()
                .count();
    }
}
