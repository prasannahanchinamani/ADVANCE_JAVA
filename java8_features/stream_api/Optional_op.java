package java8_features.stream_api;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Optional_op {
    public static Optional<String> getUser(String userName) {
        return Optional.ofNullable(userName);
    }

    //    Use Optional.orElse() to provide a default value if email is null.
    public static void getEmail(String email) {
        String safeemail = Optional.ofNullable(email).orElse("must email is Requied");
        System.out.println(safeemail);
    }

    //Use Optional.orElseThrow() to throw an exception if value is missing.
    public static void getEmailOrThrow(String email) {
        String mandatory = Optional.of(email)
                .orElseThrow(() -> new IllegalArgumentException("must be email"));
        System.out.println(mandatory);

    }

    //     Use Optional.map() to convert a string to uppercase safely.
    public static void convertUpperCase(String name) {
        String upperName = Optional.ofNullable(name)
                .map(String::toUpperCase)
                .orElse("Empty");
        System.out.println(upperName);
    }

    //. Given an Optional<Integer>, multiply the value by 2 if present, otherwise return -1.
    public static void multiplication(int n) {

        int product = Optional.of(n).map(i -> i * 2).orElse(-1);
        System.out.println("Product:" + product);
    }

    // find by id
    public static Optional<Student> students(List<Student> list, int id) {
        return list.stream().
                filter(n -> n.getId() == id)
                .findAny();


    }

    public static void main(String[] args) {
        Optional<String> userName1 = getUser("Prasanna");
        Optional<String> userName2 = getUser("");
        System.out.println(userName1);
        System.out.println(userName2);

        getEmail("email@gmail.com");

        getEmail(null);// prints: Email is required

        getEmail(null);
        convertUpperCase("Prasanna");
        //multiplication
        multiplication(2);

        //student objects
        List<Student> studentslist = Arrays.asList(new Student(1, "Prasanna"),
                new Student(2, "Pramodh"),
                new Student(3, "Karthik"));

//find by id
        Optional<Student> student1 = students(studentslist, 1);
        student1.ifPresent(n -> System.out.println("is prsesnt :" + n.getId() + " " + n.getName()));

        Optional<Student> student2 = students(studentslist, 4);
        student2.ifPresentOrElse((n) ->
                        System.out.println(n.getId() + n.getName()),
                () -> System.out.println("Empty"));

    }
}
