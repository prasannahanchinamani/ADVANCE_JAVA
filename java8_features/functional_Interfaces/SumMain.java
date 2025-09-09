package java8_features.functional_Interfaces;

public class SumMain {
    public static void main(String[] args) {
        // Lambda expression implements sum method of Operation_Sum
        Operation_Sum sum_of_two = (a, b) -> a + b;

        // Print output to console
        System.out.println("Result: " + sum_of_two.sum(5, 3));
    }
}
