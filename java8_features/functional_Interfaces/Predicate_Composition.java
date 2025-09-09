package java8_features.functional_Interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Predicate_Composition {
    public static void main(String[] args) {
        List<String> words = Arrays.asList(
                "Apple", "Banana", "Cherry", "Apricot", "Mango", "Avocado", "ice"
        );

        // Print original list (method reference)
        System.out.println("Original list:");
        //method reference
        words.forEach(System.out::println);
        System.out.println();
        //on length > 5
        Predicate<String> lengthGreaterThan5 = s -> s.length() > 5;

        // Predicate: string contains substring "an" (case-insensitive)
        Predicate<String> subStringContain = s -> s.toLowerCase().contains("an");

        //combining multiple condition
        Predicate<String> multipleCondition = lengthGreaterThan5.and(subStringContain);

        //filterOut based on multiple condition
        List<String> filteredList = words.stream()
                .filter(multipleCondition)
                .collect(Collectors.toList());
        System.out.println("Filtered list (length>5 and contains 'an'):");
        filteredList.forEach(System.out::println);
    }
}
