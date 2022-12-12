package baseball.repository;

import baseball.domain.ComputerNumber;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerNumberRepository {
    public static final int COMPUTER_NUMBER = 0;
    public static final int MAX_SIZE = 3;
    private static final ComputerNumberRepository instance = new ComputerNumberRepository();
    private static final List<ComputerNumber> store = new ArrayList<>();

    private ComputerNumberRepository() {
    }

    public static ComputerNumberRepository getInstance() {
        return instance;
    }

    public void delete() {
        store.clear();
    }

    public ComputerNumber find() {
        return store.get(COMPUTER_NUMBER);
    }

    public ComputerNumber generateComputerNumber() {
        delete();
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < MAX_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        store.add(new ComputerNumber(numbers));
        return store.get(COMPUTER_NUMBER);
    }
}
