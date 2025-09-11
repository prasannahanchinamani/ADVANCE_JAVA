package java8_features.lamda_expression;

import java.util.UUID;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Function_interface1 {
    //GCD using BIFunctional Interface
    public static void GCD(int a, int b) {
        BiFunction<Integer, Integer, Integer> gcd = (c, d) -> {
            while (d != 0) {
                int temp = d;
                d = c % d;
                c = temp;
            }
            return c;
        };
        System.out.println("gcd of two numbers:" + gcd.apply(a, b));
    }

    //Universally Unique Identifier.
    public static void UUID_id() {
        Supplier<String> idUUID = () -> String.valueOf(UUID.randomUUID());
        System.out.println(idUUID.toString());
    }

    //    UnaryOperator Example
    public static void convertToUpperCase(String str) {
        UnaryOperator<String> convertUpperCase = s -> s.toUpperCase();
        System.out.println(convertUpperCase.apply(str));
    }

    // Use BinaryOperator<Integer> to find the maximum of two integers.
    public static void max_among(int a, int b) {
        BinaryOperator<Integer> maximum = (x, y) -> (x > y) ? x : y;
        System.out.println("Maximum among two:" + maximum.apply(a,b));
    }

    public static void main(String[] args) {
        GCD(54, 24); // Expected output: 6
        GCD(48, 18); // Expected output: 6
        GCD(81, 27); // Expected output: 27
        UUID_id();
        convertToUpperCase("apple");
        max_among(20,60);
    }
}
