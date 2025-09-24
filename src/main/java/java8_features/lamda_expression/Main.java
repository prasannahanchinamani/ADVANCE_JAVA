package java8_features.lamda_expression;

import java.util.Arrays;
import java.util.List;

public class Main {
    //Sort a list of strings
    public static void sortList(List<String> list) {
        list.sort((a, b) -> a.compareTo(b));
        System.out.println();
        System.out.println("After Sorting based on alphanetical order ");
        list.forEach(System.out::println);
    }

    //sort object based on id
    public static void sortList_id(List<Employee> list) {
        list.sort((l1, l2) -> (l1.getId() < l2.getId()) ? -1 : (l1.getId() > l2.getId()) ? 1 : 0);
        System.out.println("After Sorting based on Id order ");
        list.forEach(System.out::println);
    }

    public static void main(String[] args) {

        List<String> list = Arrays.asList("Java", "Python", "Ruby", "Java Script");
        //Sort a list of strings
        sortList(list);

        //Runnable with Lambda
        Runnable runnable = () -> System.out.println("Hello from Lambda Runnable!");
        Thread thread = new Thread(runnable);
        thread.start();

        //sort based on id use comparator
        List<Employee> list_employees = Arrays.asList(
                new Employee(4, "Pari"),
                new Employee(2, "Hari"),
                new Employee(4, "giri"),
                new Employee(1, "mari"),
                new Employee(3, "Nari")

        );
        //sort based on id
        sortList_id(list_employees);
    }

}
