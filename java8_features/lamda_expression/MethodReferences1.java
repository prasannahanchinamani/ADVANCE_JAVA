package java8_features.lamda_expression;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;


class Multiplication {
    public int multiply(int a, int b) {
        return a * b;
    }
}

class Student {
    private String roll_number;
    private String name;

    public Student(String roll_number, String name) {
        this.roll_number = roll_number;
        this.name = name;
    }

    public Student(String s) {
    }

    @Override
    public String toString() {
        return "Student{" +
                "roll_number='" + roll_number + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

public class MethodReferences1 {
    //Array Sorting
    public static void sortbasedOnLength(List<String> list) {
        list.sort(Comparator.comparingInt(String::length));
        System.out.println(list);
    }

    //    7. Reference to Built-in Method
    public static void convertToInt(String str) {
        Function<String, Integer> convertToInt = Integer::parseInt;
        int result = convertToInt.apply(str);
        System.out.println("Converted:" + str + " to:" + result);
    }


    public static void main(String[] args) {
        List<String> names = Arrays.asList("Prasanna", "Anu", "Ravi", "Krishna", "Teja");
        //sort based on length
        sortbasedOnLength(names);
        //string to int
        convertToInt("20");
        //instance object and refer that method
        Multiplication multiplication = new Multiplication();
        BiFunction<Integer, Integer, Integer> multiplicationObject = multiplication::multiply;
        int result = multiplicationObject.apply(6, 7);
        System.out.println("Multiplication result: " + result);

//    Use constructor reference to convert an array of names into Student objects
//(without using streams).
//        Function<String, Student> studentsCreation = Student::new;

        BiFunction<String, String, Student> studentCreator2 = Student::new;
        Student s1 = studentCreator2.apply("R101", "Prasanna");
        Student s2 = studentCreator2.apply("R102", "Tanush");
        System.out.println(s1 + " " + s2);

    }
}
