package java8_features.functional_Interfaces;

import java.util.Arrays;
import java.util.List;

public class PersonMain {
    public static void main(String[] args) {
        List<Person> list = Arrays.asList(
                new Person("Prasanna", 22, 150),
                new Person("Prajwal", 20, 120),
                new Person("Muttu", 25, 300)
        );
        list.forEach(System.out::println);
        //sort based on sorting
        list.sort((e1, e2) -> (Double.compare(e2.salary, e1.salary)));
        System.out.println("Sorted ");
        list.forEach(System.out::println);
    }
}
