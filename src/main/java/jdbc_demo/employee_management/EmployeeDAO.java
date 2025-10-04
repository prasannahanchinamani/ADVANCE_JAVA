package jdbc_demo.employee_management;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    //create employe
    public boolean createEmployee(String name, String designation, double salary, int deptId) {
        String query = "INSERT INTO Employee(name, designation, salary, dept_id) VALUES(?, ?, ?, ?)";
        try (Connection con = ConnectionDatabase.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, name);
            ps.setString(2, designation);
            ps.setDouble(3, salary);
            ps.setInt(4, deptId);
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //getEmployee by department
    public List<Employee> getEmployeesByDepartment(String deptName) {
        List<Employee> employees = new ArrayList<>();
        String query = """
                SELECT e.emp_id, e.name, e.designation, e.salary, d.dept_name
                FROM Employee e
                JOIN Department d ON e.dept_id = d.dept_id
                WHERE d.dept_name = ?
                """;
        try (Connection con = ConnectionDatabase.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, deptName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                employees.add(new Employee(
                        rs.getInt("emp_id"),
                        rs.getString("name"),
                        rs.getString("designation"),
                        rs.getDouble("salary"),
                        rs.getString("dept_name")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }

    //upadte salary by id
    public boolean updateSalary(int empId, double newSalary) {
        String query = "UPDATE Employee SET salary = ? WHERE emp_id = ?";
        try (Connection con = ConnectionDatabase.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setDouble(1, newSalary);
            ps.setInt(2, empId);
            int rows = ps.executeUpdate();
            if (rows == 0) {
                throw new RuntimeException("Not update");
            }
            return rows > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//low salary employee cut
    public int deleteLowSalaryEmployees() {
        String query = "DELETE FROM Employee WHERE salary < 30000";
        try (Connection con = ConnectionDatabase.getConnection();
             Statement st = con.createStatement()) {
            return st.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Employee> highestPaidEmployees() {
        List<Employee> employees = new ArrayList<>();
        String query = """
                SELECT d.dept_name, e.name, e.salary
                FROM Employee e
                JOIN Department d ON e.dept_id = d.dept_id
                WHERE e.salary = (
                    SELECT MAX(salary) FROM Employee WHERE dept_id = e.dept_id
                )
                """;
        try (Connection con = ConnectionDatabase.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                employees.add(new Employee(
                        0, // emp_id not fetched here
                        rs.getString("name"),
                        "", // designation not fetched
                        rs.getDouble("salary"),
                        rs.getString("dept_name")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }
}
