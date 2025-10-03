package jdbc_demo.e_commerce_management;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;

public class ECommerceJDBC {

    public List<OrderSummary> getRecentOrders() {
        List<OrderSummary> recentOrders = new ArrayList<>();
        String query = """
                        SELECT c.customer_id, c.fullName, SUM(od.quantity * od.price) AS total_spent,
                               COUNT(DISTINCT p.categoryID) AS categories_bought
                        FROM Customers c
                        JOIN Orders o ON c.customer_id = o.customerID
                        JOIN OrderDetails od ON o.orderID = od.orderID
                        JOIN Products p ON od.productID = p.productID
                        WHERE o.orderDate >= DATE_SUB(CURDATE(), INTERVAL 6 MONTH)
                        GROUP BY c.customer_id, c.fullName
                        HAVING COUNT(DISTINCT p.categoryID) >= 3
                        ORDER BY total_spent DESC
                        LIMIT 3
                """;

        try (Connection con = ConnectionDatabase.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                recentOrders.add(new OrderSummary(
                        rs.getInt("customer_id"),
                        rs.getString("fullName"),
                        rs.getDouble("total_spent"),
                        rs.getInt("categories_bought")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recentOrders;
    }

    public List<Customer> searchCustomerByEmail(String email) {
        List<Customer> customers = new ArrayList<>();
        String query = "SELECT * FROM Customers WHERE Email = ?";
        try (Connection con = ConnectionDatabase.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    customers.add(new Customer(
                            rs.getInt("customer_id"),
                            rs.getString("fullName"),
                            rs.getString("Email"),
                            rs.getString("Phone"),
                            rs.getTimestamp("CreatedAt")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public List<Product> getProductsByCategory(String categoryName) {
        List<Product> products = new ArrayList<>();
        String query = """
                        SELECT p.productID, p.productName, p.price, p.stock, c.categoryName
                        FROM Products p
                        JOIN Categories c ON p.categoryID = c.categoryID
                        WHERE c.categoryName = ?
                """;
        try (Connection con = ConnectionDatabase.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, categoryName);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    products.add(new Product(
                            rs.getInt("productID"),
                            rs.getString("productName"),
                            rs.getDouble("price"),
                            rs.getInt("stock"),
                            rs.getString("categoryName")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public List<OrderDetail> getOrderDetails() {
        List<OrderDetail> details = new ArrayList<>();
        String query = """
                        SELECT o.orderID, c.fullName AS customer_name, o.orderDate,
                               p.productName, od.quantity, od.price, (od.quantity * od.price) AS total
                        FROM Orders o
                        JOIN Customers c ON o.customerID = c.customer_id
                        JOIN OrderDetails od ON o.orderID = od.orderID
                        JOIN Products p ON od.productID = p.productID
                        ORDER BY o.orderID
                """;
        try (Connection con = ConnectionDatabase.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                details.add(new OrderDetail(
                        rs.getInt("orderID"),
                        rs.getString("customer_name"),
                        rs.getTimestamp("orderDate"),
                        rs.getString("productName"),
                        rs.getInt("quantity"),
                        rs.getDouble("price"),
                        rs.getDouble("total")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return details;
    }

    public List<OrderSummary> getTopCustomers() {
        List<OrderSummary> topCustomers = new ArrayList<>();
        String query = """
                        SELECT c.customer_id, c.fullName, SUM(od.quantity * od.price) AS total_spent,
                               COUNT(DISTINCT p.categoryID) AS categories_bought
                        FROM Customers c
                        JOIN Orders o ON c.customer_id = o.customerID
                        JOIN OrderDetails od ON o.orderID = od.orderID
                        JOIN Products p ON od.productID = p.productID
                        WHERE o.orderDate >= DATE_SUB(CURDATE(), INTERVAL 6 MONTH)
                        GROUP BY c.customer_id, c.fullName
                        HAVING COUNT(DISTINCT p.categoryID) >= 3
                        ORDER BY total_spent DESC
                        LIMIT 3
                """;
        try (Connection con = ConnectionDatabase.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                topCustomers.add(new OrderSummary(
                        rs.getInt("customer_id"),
                        rs.getString("fullName"),
                        rs.getDouble("total_spent"),
                        rs.getInt("categories_bought")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return topCustomers;
    }
}
