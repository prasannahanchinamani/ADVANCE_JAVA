package jdbc_demo.online_orderDb;

import java.sql.*;

public class OnlineOrderOp {
    // 1. Insert new order
    public void insertOrder(int customerId, double amount) {
        String query = "INSERT INTO Orders(customer_id, amount) VALUES(?, ?)";
        try (Connection con = ConnectionDatabase.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, customerId);
            ps.setDouble(2, amount);
            int rows = ps.executeUpdate();
            System.out.println(rows + " order inserted for customer ID " + customerId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //
    // 2. Fetch order history of a customer
    public void fetctchHistroy(int customer_id) {
        String query = """ 
                SELECT o.order_id, o.order_date, o.amount, c.customer_name, c.email
                FROM Orders o
                JOIN Customer c ON o.customer_id = c.customer_id
                WHERE c.customer_id =?
                """;
        try (Connection connection = ConnectionDatabase.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, customer_id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    System.out.println(
                            rs.getInt("order_id") + "  " +
                                    rs.getTimestamp("order_date") + "  " +
                                    rs.getDouble("amount") + "  " +
                                    rs.getString("customer_name") + "  " +
                                    rs.getString("email")
                    );
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //    Show top 3 customers by purchase amount
    public void topThre() {
        String query = """
                       SELECT
                         c.customer_id,
                        c.customer_name,
                        c.email,
                        sum(o.amount) TotalPurchase
                FROM Orders o
                JOIN Customer c ON o.customer_id = c.customer_id
                group by c.customer_id,c.customer_name,c.email
                limit 3
                """;
        try (Connection connection = ConnectionDatabase.getConnection();
             Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                System.out.println(
                        rs.getInt("customer_id") + "  " +
                                rs.getString("customer_name") + "  " +
                                rs.getString("email") + "  " +
                                rs.getDouble("TotalPurchase")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
