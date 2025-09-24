package java8_features.stream_api.basics;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Terminal_operations {
    //    2. collect
//Convert a list of integers into a set
    public static void list_set(List<Integer> list) {
        Set<Integer> listToset = list.stream()
                .collect(Collectors.toSet());
        System.out.println();
        System.out.println(listToset);
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 12, 1, 3, 4, 6, 7);
        // forEach
        //Print all elements of a list of strings.
        list.forEach(list1 -> System.out.print(list1 + " "));

        //list to set
        list_set(list);
    }
}
