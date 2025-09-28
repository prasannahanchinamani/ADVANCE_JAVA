package jdbc_demo;

import java.sql.*;

public class Crud_operation {
    Connection con = ConnectionDatabase.getConnection();

    //create
    public void createTable() {
        String query = "CREATE TABLE IF NOT EXISTS EMPLOYEE (" +
                "id INT PRIMARY KEY, " +
                "name VARCHAR(100), " +
                "salary INT)";
        try (Connection con = ConnectionDatabase.getConnection();
             Statement stmt = con.createStatement()) {

            stmt.executeUpdate(query);
            System.out.println(" EMPLOYEE table created (if not exists).");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //insert query
    public void insertUser(int id, String name, int salaray) {
        String query = "INSERT INTO EMPLOYEE (id,name,salary)VALUES(?,?,?)";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, salaray);
            int rows = ps.executeUpdate();
            System.out.println(rows + " row(s) inserted ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //read
    public void readUsers() {
        String query = "SELECT * FROM EMPLOYEE";
        try (
                Statement stmt = con.createStatement();
                ResultSet res = stmt.executeQuery(query)) {
            while (res.next()) {
                System.out.println(res.getInt("id") + " " + res.getString("name") + " " + res.getInt("salary"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //update
    public void update(int id, String name, int salary) {
        String query = "UPDATE EMPLOYEE SET NAME=?,salary=? WHERE ID=?";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(3, id);
            stmt.setString(1, name);
            stmt.setInt(2, salary);
            int rows = stmt.executeUpdate();
            System.out.println(rows + " " + "get affected");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //delete
    public void delete(int id) {
        String query = "delete from employee where id=?";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            System.out.println(rows + " " + " get affected");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
