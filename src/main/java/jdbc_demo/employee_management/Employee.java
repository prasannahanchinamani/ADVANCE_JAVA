package jdbc_demo.employee_management;

public class Employee {
    private int empId;
    private String name;
    private String designation;
    private double salary;
    private String deptName;

    //construtor
    public Employee(int empId, String name, String designation, double salary, String deptName) {
        this.empId = empId;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
        this.deptName = deptName;
    }

    //gettefr
    public int getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public String getDesignation() {
        return designation;
    }

    public double getSalary() {
        return salary;
    }

    public String getDeptName() {
        return deptName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", name='" + name + '\'' +
                ", designation='" + designation + '\'' +
                ", salary=" + salary +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
