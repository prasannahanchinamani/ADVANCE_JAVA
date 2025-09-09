package java8_features.functional_Interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Consumer_demo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("java", "Apple", "Andra Pradesh", "Karnataka", "New Delhi");
        // Using Consumer with lambda   Consumer -> accept
        Consumer<String> printList = lists -> System.out.println("State: " + lists);
        list.forEach(printList);
    }
}
