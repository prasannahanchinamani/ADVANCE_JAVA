package java8_features.lamda_expression;

import java.util.function.Predicate;

public class MethodReferance {
    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

    public static void main(String[] args) {
        Predicate<Integer> isEvenOrNot = MethodReferance::isEven;
        int num = 5;
        System.out.println(10 + " is Even?+ " + isEvenOrNot.test(10));
        System.out.println(num + " is Even?+ " + isEvenOrNot.test(num));
    }
}
