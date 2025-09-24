package java8_features.functional_Interfaces;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalHandling {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 7, 8);
        Optional<Integer> maxValue = list.stream().max(Integer::compareTo);
        System.out.println("Maximum Value:"+maxValue.orElse(-1));


    }
}
