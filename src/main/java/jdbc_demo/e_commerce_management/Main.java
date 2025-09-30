package jdbc_demo.e_commerce_management;


public class Main {
    public static void main(String[] args) {
        ECommerceJDBC jdbc = new ECommerceJDBC();

        System.out.println("=== Orders in Last 30 Days ===");
        jdbc.getRecentOrders();

        System.out.println("\n=== Search Customer by Email ===");
        jdbc.searchCustomerByEmail("aarav@example.com");

        System.out.println("\n=== Products in Electronics Category ===");
        jdbc.getProductsByCategory("Electronics");

        System.out.println("\n=== Orders & Order Details ===");
        jdbc.getOrderDetails();

        System.out.println("\n=== Top 3 Customers (Last 6 Months, >=3 Categories) ===");
        jdbc.getTopCustomers();
    }
}
