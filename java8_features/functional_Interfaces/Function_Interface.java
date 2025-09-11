package java8_features.functional_Interfaces;

import java.util.function.Function;

public class Function_Interface {
    public static void main(String[] args) {
        int radius=3;
        //function interfcae apply
        Function<Integer,Double> areaOfCircle=a -> a*a*3.15;
        // Apply the function using the radius variable
        System.out.println("Area of circle: " + areaOfCircle.apply(radius));
    }
}
