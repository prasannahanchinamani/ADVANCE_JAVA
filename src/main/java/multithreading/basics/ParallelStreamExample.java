package multithreading.basics;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ParallelStreamExample {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Apple", "B", "Cat", "Doggy");
        System.out.println("Sequential Stream");
        list.stream().sorted(Comparator.comparingInt(String::length))
                .forEach(System.out::println);


        System.out.println("\n Parallel Stream");

        list.parallelStream().filter(name -> name.length() > 2)
                .forEach(System.out::println);
    }
}
