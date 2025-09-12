package java8_features.stream_api.employee_performence;

import java.util.*;
import java.util.stream.Collectors;

public class Employee_main {

    public static List<Employee> filteringBySalaryInIT(List<Employee> list) {
        List<Employee> result = list.stream()
                .filter(e -> e.getSalary() > 50000) // salary condition
                .filter(e -> "IT".equalsIgnoreCase(e.getDepartment())) // department condition
                .collect(Collectors.toList());
        if (result.isEmpty()) {
            throw new IllegalArgumentException("No employees found in IT with salary > 50000");
        }
        return result;

    }

    //Count how many employees belong to "HR".
    public static int count_hr(List<Employee> list) {
        long count = list.stream().filter(d -> "HR".equalsIgnoreCase(d.getDepartment())).count();
        return (int) count;
    }

    //     Find the employee with the highest salary using max().
    public static double higesytSalaryEmp(List<Employee> list) {
        OptionalDouble max = list.stream().mapToDouble(Employee::getSalary).max();
        if (max.isPresent()) {
            System.out.println(max.getAsDouble());
        } else {
            throw new IllegalArgumentException("Not find");
        }
        return max.getAsDouble();

    }

    //    Wrap the result in Optional and print using ifPresentOrElse
    public static void printOptional(Optional<Employee> optional) {
        if (optional.isPresent()) {
            System.out.println("Value: " + optional);
        } else {
            System.out.println("No value present");
        }
    }

    public static void main(String[] args) {
        List<Employee> employeeList = Arrays.asList(
                new Employee(1, "Prasanna", "IT", 25000.00),
                new Employee(2, "Prajwal", "HR", 10000.00),
                new Employee(3, "Pramodh", "IT", 55000.00),
                new Employee(3, "Pramodh", "Finance", 56000.00)
        );

        // filtering based on dept and salary
        List<Employee> filteredList = filteringBySalaryInIT(employeeList);
        filteredList.forEach(System.out::println);

        //Count Hr
        int hr = count_hr(employeeList);
        System.out.println(hr);

        //higest salary emp
        higesytSalaryEmp(employeeList);
    }
}
