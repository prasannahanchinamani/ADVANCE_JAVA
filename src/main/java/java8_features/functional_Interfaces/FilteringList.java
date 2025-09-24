package java8_features.functional_Interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// filter out the strings starting with the letter "A"
public class FilteringList {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("java", "Apple", "Andra Pradesh", "Karnataka", "New Delhi");
        //steram api +lambda
        List<String> filteredList = list.stream().
                filter(lists -> !lists.startsWith("A"))
                .collect(Collectors.toUnmodifiableList());
        System.out.println(filteredList);

    }
    //filter --> predicate boolean test
    //collect --> supplier
}
