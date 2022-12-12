package baseball.domain;

import java.util.List;

public class UserNumber {
    private final List<Integer> numbers;

    public UserNumber(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getResultList(final ComputerNumber computerNumber) {
        return List.of(
                calculateStrike(computerNumber),
                calculateSameNumber(computerNumber) - calculateStrike(computerNumber)
        );
    }

    private int calculateSameNumber(final ComputerNumber computerNumber) {
        int sameNumberCount = 0;
        for (Integer number : numbers) {
            if (computerNumber.isContains(number)) {
                sameNumberCount++;
            }
        }
        return sameNumberCount;
    }

    private int calculateStrike(final ComputerNumber computerNumber) {
        int strikeCount = 0;
        for (int index = 0; index < numbers.size(); index++) {
            if (computerNumber.isStrike(index, numbers.get(index))) {
                strikeCount++;
            }
        }
        return strikeCount;
    }
}
