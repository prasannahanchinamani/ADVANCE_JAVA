package csv_json_example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class FileHandlingWithJSON {
    private static final String FILE_PATH = "Employee.json";

    public static void main(String[] args) {
        List<Employee> employeeList = Arrays.asList(
                new Employee(101, "John", 10000),
                new Employee(102, "Alice", 20000),
                new Employee(103, "Bob", 30000)
        );

        writeToJSON(employeeList, FILE_PATH);
        List<Employee> readList = readFromJSON(FILE_PATH);
        System.out.println("JSON read result: " + readList);
    }

    public static void writeToJSON(List<Employee> employeeList, String path) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(path), employeeList);
            System.out.println("JSON file created: " + path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Employee> readFromJSON(String path) {
        ObjectMapper mapper = new ObjectMapper();
        List<Employee> employeeList = null;
        try {
            employeeList = mapper.readValue(new File(path),
                    mapper.getTypeFactory().constructCollectionType(List.class, Employee.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employeeList;
    }
}