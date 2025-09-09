package net.junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {
Factorial factorial=new Factorial();

    @Test
    void factorial() {
        assertEquals(120,factorial.factorial(5));
    }
}