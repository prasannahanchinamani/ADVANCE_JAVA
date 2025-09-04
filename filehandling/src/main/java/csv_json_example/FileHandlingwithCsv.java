package csv_json_example;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class FileHandlingwithCsv {
    private static final String FILE_PATH = "Employee.csv";
    private static List<Employee> employeeList;

    public static void main(String[] args) {
        List<Employee>employeeList = Arrays.asList(
                new Employee(101, "John", 10000),
                new Employee(102, "Alice", 20000),
                new Employee(103, "Bob", 30000)
        );
        writeToCSV(employeeList,FILE_PATH);
        readCSV(employeeList,FILE_PATH);
    }

    // writing data to csv
    public static void writeToCSV(List<Employee> employeeList, String path) {
        try (FileWriter writer = new FileWriter(path)) {
            StatefulBeanToCsv<Employee> beanToCsv = new StatefulBeanToCsvBuilder<Employee>(writer).build();
            beanToCsv.write(employeeList);
            System.out.println("File is Created ");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvRequiredFieldEmptyException e) {
            throw new RuntimeException(e);
        } catch (CsvDataTypeMismatchException e) {
            throw new RuntimeException(e);
        }
    }
    public  static void readCSV(List<Employee>employeeList,String path){
        try(FileReader reader=new FileReader(path)){
            CsvToBean csvToBean=new CsvToBeanBuilder<Employee>(reader).withType(Employee.class)
                    .withIgnoreLeadingWhiteSpace(true).build();

            employeeList=(csvToBean.parse());
            employeeList.forEach(System.out::println);
            System.out.println("Reading is completed.");
        }catch (IOException exception){
            exception.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}