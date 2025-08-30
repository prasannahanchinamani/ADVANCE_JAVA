package net.junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class CalculatorTest {
    Calculator calculator;
    @BeforeEach
    public void setUp(){
        calculator=new Calculator();
    }
    @Test
    public void addTest(){
        int actual=calculator.add(10,20);
      assertEquals(30,actual);
    }
    @Test
    void testSubtract() {
        assertEquals(10, calculator.subtract(30, 20));
    }

}