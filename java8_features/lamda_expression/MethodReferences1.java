package java8_features.lamda_expression;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MethodReferences1 {
    //Array Sorting
    public static void sortbasedOnLength(List<String> list) {
        list.sort(Comparator.comparingInt(String::length));
        System.out.println(list);
    }
//    Instance Reference with Different Object


    public static void main(String[] args) {
        List<String> names = Arrays.asList("Prasanna", "Anu", "Ravi", "Krishna", "Teja");
        sortbasedOnLength(names);

    }
}
