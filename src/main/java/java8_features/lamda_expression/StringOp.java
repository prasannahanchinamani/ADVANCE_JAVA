package java8_features.lamda_expression;

import java.util.function.Function;

public class StringOp {
    public static void main(String[] args) {
        //■ Lambda → reverse string
        Function<String, String> reversed = (s) -> new StringBuilder(s).reverse().toString();
        String reverse = reversed.apply("Madam");
        System.out.println(reverse);
        //Method Reference → String::toUpperCase
        StringOperation upperCase = String::toUpperCase;
        String upperCaseLetter = upperCase.apply("Prasanna");
        System.out.println(upperCaseLetter);
    }
}
