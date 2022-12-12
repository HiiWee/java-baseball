package baseball.repository;

import baseball.domain.ComputerNumber;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerNumberRepository {
    public static final int COMPUTER_NUMBER = 0;
    private static final List<ComputerNumber> instance = new ArrayList<>();
    public static final int MAX_SIZE = 3;

    private ComputerNumberRepository() {
    }

    public static ComputerNumber getInstance() {
        return instance.get(COMPUTER_NUMBER);
    }

    public void generateComputerNumber() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < MAX_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        instance.add(new ComputerNumber(numbers));
    }
}
