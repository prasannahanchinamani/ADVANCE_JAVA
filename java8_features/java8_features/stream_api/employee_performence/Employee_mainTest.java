package java8_features.stream_api.employee_performence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Employee_mainTest {
    private List<Employee> employeeList;

    @BeforeEach
    public void set() {
        employeeList = Arrays.asList(
                new Employee(1, "Prasanna", "IT", 25000.00),
                new Employee(2, "Prajwal", "HR", 10000.00),
                new Employee(3, "Pramodh", "IT", 55000.00)
        );
    }

    @DisplayName("Get all employees in IT with salary > 50k.")
    @Test
    public void testFilter() {
        List<Employee> emplist = Employee_main.filteringBySalaryInIT(employeeList);
        assertEquals(1, emplist.size());
        // case where no match exists
        List<Employee> testList = Arrays.asList(
                new Employee(4, "Muttu", "IT", 25000.00) // salary < 50k
        );

        assertThrows(IllegalArgumentException.class,
                () -> Employee_main.filteringBySalaryInIT(testList));
    }

    @DisplayName("Count Hr")
    @Test
    public void testCounthr() {
        int count = Employee_main.count_hr(employeeList);
        assertEquals(1, count);
    }

    @DisplayName("higest Salary emp")
    @Test
    public void testHigestSalary() {
        double maximumsalary = Employee_main.higesytSalaryEmp(employeeList);
        assertEquals(55000, maximumsalary);
    }
}