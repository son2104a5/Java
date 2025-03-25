package B8;

import java.util.List;

public class ListProcessorImpl implements ListProcessor {
    @Override
    public int sumOddNumbers(List<Integer> list) {
        int sum = 0;
        for (int num : list) {
            if (num % 2 != 0) {
                sum += num;
            }
        }
        return sum;
    }
}
