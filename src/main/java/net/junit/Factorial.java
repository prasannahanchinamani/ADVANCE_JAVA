package net.junit;

public class Factorial {
    public int factorial(int number){
        if (number < 0) {
            throw new IllegalArgumentException("Negative numbers not allowed");
        }
        if (number == 0 || number == 1) {
            return 1;
        }
        return number*factorial(number-1);
    }
}
