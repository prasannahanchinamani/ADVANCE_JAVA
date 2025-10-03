package jdbc_demo.employee_management;


import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDatabase {
    private static final String url = "jdbc:mysql://localhost:3306/employee_management";
    private static final String userName = "root";
    private static final String password = "1234";

    public static Connection getConnection() {
//        load driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, userName, password);
            if (connection != null) {
                System.out.println("Connected to database!..");
            } else {
                System.out.println("Check Connection");
            }
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
