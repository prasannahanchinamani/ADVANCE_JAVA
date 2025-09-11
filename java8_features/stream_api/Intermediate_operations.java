package java8_features.stream_api;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//import static java.util.stream.Nodes.collect;

public class Intermediate_operations {
    // Filter
    //Given a list of integers, find all numbers greater than 50.
    public static void filterNumber(List<Integer> list) {
        list.stream()
                .filter(n -> n > 50)
                .forEach(num -> System.out.print(num + " "));
    }

    //2. Map
    //Given a list of strings, return a list of their lengths.
    public static void stringLength(List<String> list) {
        list.stream()
                .map(String::length)
                .collect(Collectors.toList())
                .forEach(str -> System.out.print(str + " "));
        System.out.println();
    }

    //Distinct
    //From a list of integers, return only distinct values.
    public static void distinctValues(List<Integer> list) {
        list.stream()
                .distinct()
                .forEach(num -> System.out.print(num + " "));
    }

    // Limit & Skip
    //From a list of numbers, get the first 3 even numbers after skipping the first 2 elements.
    public static void limit_skip(List<Integer> list) {
        List<Integer> limitList = list.stream()
                .filter(n -> n % 2 == 0)
                .skip(2)// skipping the first 2 elements.
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(limitList);
    }

    //6. Peek
    //Debug a stream by printing elements after filtering even numbers.
    public static void peekElemenet(List<Integer> list) {
        List<Integer> listpeek = list.stream()
                .filter(n -> n % 2 == 0)
                .peek(n -> System.out.print(n + " "))//
                //Prints each even number before it reaches the terminal operation.
                //Important: peek does not modify the element; it just observes it.
                .collect(Collectors.toList());
        System.out.println();
    }

    //     3. reduce
//    Find the product of all numbers in a list.
    public static void reduce_product(List<Integer> list) {
        int listproduct = list.stream()
                .reduce(1, (a, b) -> (a * b));
        System.out.println("Product of all:=" + listproduct);
    }

    //    4. count
//    Count how many names in a list start with "A".
    public static void countNames(List<String> list) {
        long countNamesStart_a = list.stream()
                .filter(s -> s.toLowerCase().startsWith("a"))
                .count();
        System.out.println("Names  start with A:" + countNamesStart_a);
    }

    //    5. min & max
//Find the maximum salary from a list of employee objects.
    public static void min_max(List<Employee> employeeList) {
        //min
        Optional<Employee> minsalary = employeeList.stream()
                .min(Comparator.comparingDouble(Employee::getSalary));
        //max
        Optional<Employee> maxsalary = employeeList.stream()
                .max(Comparator.comparingDouble(Employee::getSalary));

        minsalary.ifPresent(e -> System.out.println("Minimum salary:" + minsalary));
        maxsalary.ifPresent(e -> System.out.println("Maximum salary:" + maxsalary));
    }

    //anymatch  noneMatch allMatch
    public static void matching(List<Integer> studentList) {
        Predicate<Integer> excellent = n -> n >= 35;
        Predicate<Integer> pass = n -> n >= 85;
        boolean anyExcellent = studentList.stream()
                .anyMatch(excellent);
        System.out.println("Any excellent student ? " + anyExcellent);
        //all pass
        boolean checkPass = studentList.stream()
                .allMatch(excellent);
        System.out.println("all students are passed:" + checkPass);
        //none match
        boolean greterThan100 = studentList.stream()
                .noneMatch(n -> n > 100);
        System.out.println("Any marks greater Than :" + greterThan100);

    }
//     findFirst / findAny
//Find the first string longer than 5 characters.

    public static void findStr(List<String> list) {
        String first = list.stream()
                .filter(n -> n.length() > 5)
                .findFirst()
                .toString();
        System.out.println("findFirst:" + first);
        System.out.println("find Any" + list.stream().findAny().toString());

    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 2, 55, 3, 1, 90, 3, 50, 55, 66, 77, 8, 88, 90);
        //Filter
        filterNumber(list);
        System.out.println();
        //Map
        List<String> names = Arrays.asList("prasann", "sunny", "bunny", "Vinny");
        stringLength(names);
        //Distinct
        distinctValues(list);
        System.out.println();
        // first 3 even numbers after skipping the first 2 elements.
        limit_skip(list);
        //peek
        peekElemenet(list);
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        //reduce
        reduce_product(list1);
        //count
        List<String> strlist = Arrays.asList("Prasanna", "Avinash", "Anjali", "Muttu");
        countNames(strlist);
        //employee list
        List<Employee> employeeList = Arrays.asList(
                new Employee(1, "Prasanna", 12000),
                new Employee(2, "Prajwal", 15000),
                new Employee(3, "Rohit", 13000)
        );
        min_max(employeeList);
        //
        List<Integer> studentMarks = Arrays.asList(50, 60, 70, 80, 90, 35, 30);
        matching(studentMarks);

        findStr(strlist);

    }
}
