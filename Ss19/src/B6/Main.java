package B6;

import java.util.*;

public class Main implements StringProcessor{
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("java", "programming", "lambda", "expression");

        StringProcessor processor = input -> input.toUpperCase() + " - TECHNICAL";

        List<String> processedStrings = new ArrayList<>();
        for (String str : strings) {
            processedStrings.add(processor.processString(str));
        }

        processor.printList(processedStrings);
    }

    @Override
    public String processString(String input) {
        return input;
    }

    @Override
    public void printList(List<String> list) {
        StringProcessor.super.printList(list);
    }
}
