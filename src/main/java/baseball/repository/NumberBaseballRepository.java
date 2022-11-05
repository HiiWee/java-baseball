package baseball.repository;

import baseball.domain.ComputerNumber;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberBaseballRepository {
    private static final int LIMIT_NUMBER = 10;
    private static final int START_NUMBER = 1;
    private static final int PICK_NUMBER_COUNT = 3;

    private static final NumberBaseballRepository instance = new NumberBaseballRepository();
    private static final List<ComputerNumber> numberStore = new ArrayList<>();

    public static NumberBaseballRepository getInstance() {
        return instance;
    }

    public void generateNumber() {
        clearNumberStore();
        List<Integer> positiveIntegerList = createPositiveIntegerList();
        List<Integer> pickNumberList = new ArrayList<>();
        for (int currentIndex = 0; currentIndex < PICK_NUMBER_COUNT; currentIndex++) {
            pickNumberList.add(Randoms.pickNumberInList(positiveIntegerList));
            positiveIntegerList.remove(pickNumberList.get(currentIndex));
        }
        numberStore.add(new ComputerNumber(pickNumberList));
    }


    public List<Integer> createPositiveIntegerList() {
        return IntStream.range(START_NUMBER, LIMIT_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

    public void clearNumberStore() {
        numberStore.clear();
    }
}
