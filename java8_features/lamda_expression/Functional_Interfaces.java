package java8_features.lamda_expression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

@FunctionalInterface
interface Calculator {
    void calculate(int a, int b);
}

public class Functional_Interfaces {
    //operation + - * /
    public static void arthmaticOperation() {
        Calculator addition = (a, b) -> System.out.println("sum:" + (a + b));
        Calculator subtraction = (a, b) -> System.out.println("substraction:" + (a - b));
        Calculator multiplication = (a, b) -> System.out.println("Multiplication:" + (a * b));
        Calculator division = (a, b) -> {
            if (b != 0)
                System.out.println("Division:" + (a / b));
        };
        // test
        addition.calculate(10, 5);
        subtraction.calculate(10, 5);
        multiplication.calculate(10, 5);
        division.calculate(10, 5);
    }

    //Predicate Functional Interface
    public static void checkStringLength(String str) {
        Predicate<String> strlength = s -> s.length() > 5;
        strlength.test(str);//boolean type
    }

    //Function Functional Interface
    public static void convertInttoString(int number) {
        Function<Integer, String> convertedTo = n -> (n % 2 != 0) ? "odd" : "even";
        System.out.println(convertedTo.apply(number));
    }

    // Math Operations
    //Write a program to perform square, cube, and factorial of a number using lambda
    public static void math_operation(int num) {
        Function<Integer, Integer> square = n -> n * n;
        System.out.println("Square:" + square.apply(num));
        Function<Integer, Integer> factorial = n -> {
            int result = 1;
            while (n > 0) {
                result *= n;
                n--;
            }
            return result;
        };
        System.out.println("Factorial:" + factorial.apply(num));
        Function<Integer, Integer> cube = n -> n * n * n;
        System.out.println("Cube:" + cube.apply(num));
    }

    public static void filtering_Numbers(List<Integer> list) {
        Predicate<Integer> isEven = n -> n % 2 == 0;
        // Filter manually without streams
        List<Integer> evens = new ArrayList<>();
        for (Integer num : list) {
            if (isEven.test(num)) {
                evens.add(num);
            }
        }
        System.out.println(evens);

    }

    public static void main(String[] args) {
        //lamda expression on arthmatic operation
        arthmaticOperation();
        //check length with predicate   predicate ->test
        checkStringLength("Prasanna");
        //Function Functional Interface conver to int  function ->apply
        convertInttoString(20);
        //Math Operation
        math_operation(5);
        //filter even numbers only without streams
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        filtering_Numbers(numbers);
    }
}
