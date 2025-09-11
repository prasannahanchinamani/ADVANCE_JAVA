package java8_features.functional_Interfaces;

import java.util.function.BiFunction;

public class BiFunction_Concat {
    public static void main(String[] args) {
//          R apply(T t, U u);
        BiFunction<String, String, String> concat = (s1, s2) -> s1 + " " + s2;
        System.out.println("Concatination\n"+concat.apply("Java","is Good"));
    }
}
