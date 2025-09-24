package java8_features.functional_Interfaces;

import java.util.Arrays;
import java.util.List;

public class SumOfSquares {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int sumSqures = numbers.stream()
                .filter(n -> n % 2 == 0) //lambda implements Predicate's test method
                .map(n -> n * n)      // lambda implements Function's apply method
                .reduce(0, Integer::sum);
            System.out.println("Sum of Square :" + sumSqures);
    }
}
