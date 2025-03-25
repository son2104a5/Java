package B8;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ListProcessor processor = new ListProcessorImpl();
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        ListProcessor.printList(list);

        int sumEven = processor.sumOddNumbers(list);
        System.out.println("Tổng các số lẻ: " + sumEven);
        
        processor.checkOdd(list);
    }
}
