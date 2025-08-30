package net.junit;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JUnitDemo {
    //life cycle
    @BeforeAll
    public static void beforeAll(){
        System.out.println("Always executed First.!");
    }
    @BeforeEach
    public  void beforeeach(){
        System.out.println("Always exeuted before Test case..");
    }
    @Test
    public void testMethod(){
        System.out.println("Test cases:");
       int res=10+20;
        assertEquals(30,res);
    }
    @AfterEach
    public  void aftereach(){
        System.out.println("Always exeuted after Test case..");
    }
    @AfterAll
    public static  void afterall(){
        System.out.println("after all test cases execute..");
    }
    @Test
    public void testMethod2(){
        System.out.println("Test cases:");
        int res=20+20;
        assertEquals(40,res);
    }
}
