package jdbc_demo.employee_management;

import java.sql.*;

public class EmployeeDAO {

    // CREATE: Insert new employee
    public void createEmployee(String name, String designation, double salary, int deptId) {
        String query = "INSERT INTO Employee(name, designation, salary, dept_id) VALUES(?, ?, ?, ?)";
        try (Connection con = ConnectionDatabase.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, name);
            ps.setString(2, designation);
            ps.setDouble(3, salary);
            ps.setInt(4, deptId);
            int rows = ps.executeUpdate();
            System.out.println(rows + " employee inserted.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ: Get employees by department
    public void getEmployeesByDepartment(String deptName) {
        String query = """
                    SELECT e.emp_id, e.name, e.designation, e.salary, d.dept_name
                    FROM Employee e
                    JOIN Department d ON e.dept_id = d.dept_id
                    WHERE d.dept_name = ?
                """;
        try (Connection con = ConnectionDatabase.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, deptName);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    System.out.println(
                            rs.getInt("emp_id") + "  " +
                                    rs.getString("name") + "  " +
                                    rs.getString("designation") + "  " +
                                    rs.getDouble("salary") + "  " +
                                    rs.getString("dept_name")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // UPDATE: Salary update
    public void updateSalary(int empId, double newSalary) {
        String query = "UPDATE Employee SET salary = ? WHERE emp_id = ?";
        try (Connection con = ConnectionDatabase.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setDouble(1, newSalary);
            ps.setInt(2, empId);
            int rows = ps.executeUpdate();
            System.out.println(rows + " employee updated.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE: Remove employee salary <300000
    public void deleteLowSalaryEmployees() {
        String query = "DELETE FROM Employee WHERE salary < 30000";
        try (Connection con = ConnectionDatabase.getConnection();
             Statement st = con.createStatement()) {
            int rows = st.executeUpdate(query);  // use executeUpdate for DELETE
            System.out.println(rows + " employee(s) with salary < 30000 deleted.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //Highest-paid employee per department
    public void highestPaidEmployees() {
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
                System.out.println(
                        rs.getString("dept_name") + "  " +
                                rs.getString("name") + "  " +
                                rs.getDouble("salary")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
