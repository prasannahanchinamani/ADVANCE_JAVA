package jdbc_demo.employee_management;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeDAO dao = new EmployeeDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Employee Management Menu ===");
            System.out.println("1. Insert Employee");
            System.out.println("2. Get Employees by Department");
            System.out.println("3. Update Salary");
            System.out.println("4. Delete Employee");
            System.out.println("5. Highest Paid Employees");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Name: ");
                    String name = sc.next();
                    System.out.print("Designation: ");
                    String desig = sc.next();
                    System.out.print("Salary: ");
                    double salary = sc.nextDouble();
                    System.out.print("Dept ID: ");
                    int deptId = sc.nextInt();
                    dao.createEmployee(name, desig, salary, deptId);
                }
                case 2 -> {
                    System.out.print("Department Name: ");
                    String dept = sc.next();
                    dao.getEmployeesByDepartment(dept);
                }
                case 3 -> {
                    System.out.print("Emp ID: ");
                    int empId = sc.nextInt();
                    System.out.print("New Salary: ");
                    double sal = sc.nextDouble();
                    dao.updateSalary(empId, sal);
                }
                case 4 -> {
                    System.out.println("Low dalaru employee");
                    dao.deleteLowSalaryEmployees();
                }
                case 5 -> dao.highestPaidEmployees();
                case 6 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
